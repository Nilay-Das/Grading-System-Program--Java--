import java.util.Arrays;
import java.util.Scanner;

/**
 * This program reads the assessment scores of multiple students and calculates their final grade
 * This program also calculates the class averages and medians of each assessment
 *
 * @author Nilay Das
 */
public class Problem3 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int numberOfStudents = in.nextInt();


//        Arrays for storing the average of particular assessments of each student
        double testAverages[] = new double[numberOfStudents];
        double assignmentAverages[] = new double[numberOfStudents];
        double practicumAverages[] = new double[numberOfStudents];
        double podAverages[] = new double[numberOfStudents];


        for (int i = 0; i < numberOfStudents; i++) {

            String bannerNumber = in.next();

//          Weight of marks for each assessment
            double testWeight = 0.25;
            double assignmentWeight = 0.3;
            double practicumWeight = 0.35;
            double podWeight = 0.1;

//          Average of the assessments
            double testAverage = readAssessmentScores(3, false, in) * testWeight;
            double assignmentAverage = readAssessmentScores(5, true, in) * assignmentWeight;
            double practicumAverage = readAssessmentScores(4, false, in) * practicumWeight;
            double podAverage = readAssessmentScores(1, false, in) * podWeight;

//          Storing the average of particular assessments of each student into the array
            testAverages[i] = testAverage / testWeight;
            assignmentAverages[i] = assignmentAverage / assignmentWeight;
            practicumAverages[i] = practicumAverage / practicumWeight;
            podAverages[i] = podAverage / podWeight;

//        Sum of the averages of all the assessments
            double sumOfAssessments = testAverage + assignmentAverage + practicumAverage + podAverage;

//        Calling the method to convert the average into letter grade
            String letterGrade = scoreToLetterGrade(sumOfAssessments);

//        Printing the result of the student
            System.out.println("Student: " + bannerNumber + " - " + letterGrade);
        }

//        Variables for class averages
        String tests = String.format("%.2f", classAverageTest(testAverages));
        String assignments = String.format("%.2f", classAverageAssignment(assignmentAverages));
        String practicums = String.format("%.2f", classAveragePracticum(practicumAverages));
        String pods = String.format("%.2f", classAveragePod(podAverages));

//        Converting the median scores into two decimal places
        String testMedianString = String.format("%.2f", getMedian(testAverages));
        String assignmentMedianString = String.format("%.2f", getMedian(assignmentAverages));
        String practicumMedianString = String.format("%.2f", getMedian(practicumAverages));
        String podMedianString = String.format("%.2f", getMedian(podAverages));

        System.out.println("Class Averages:");
        System.out.println("Tests: " + tests + " - " + "Assignments: " + assignments + " - " + "Practicums: " + practicums + " - " + "PoDs: " + pods);
        System.out.println("Class Medians:");
        System.out.println("Tests: " + testMedianString + " - " + "Assignments: " + assignmentMedianString + " - " + "Practicums: " + practicumMedianString + " - " + "PoDs: " + podMedianString);
    }

    /**
     * Method for reading assessment scores and calculating the average
     *
     * @param numberOfMarks indicates the number of assessment marks of a certain category
     * @param drop          indicates whether the lowest score would be dropped
     * @param kb            is the scanner object
     * @return the average score of each assessment
     */
    public static double readAssessmentScores(int numberOfMarks, boolean drop, Scanner kb) {
//        Calculating the average of the test scores
        if (numberOfMarks == 3 && drop == false) {
            double sum = 0;

            double tests[] = new double[numberOfMarks];

            for (int i = 0; i < tests.length; i++) {
                tests[i] = kb.nextDouble();
            }

            for (int i = 0; i < tests.length; i++) {
                sum = sum + tests[i];
            }

            double result = sum / numberOfMarks;

            return result;
        }

//        Calculating the average of the assignment scores
        else if (numberOfMarks == 5 && drop == true) {
            double sum = 0;

            double assignments[] = new double[numberOfMarks];

            for (int i = 0; i < assignments.length; i++) {
                assignments[i] = kb.nextDouble();
            }

//            Sorting the array to drop the last score
            Arrays.sort(assignments);

            for (int i = 1; i < assignments.length; i++) {
                sum = sum + assignments[i];
            }
//            numberOfMarks-1 because the lowest assignment score is dropped
            double result = sum / (numberOfMarks - 1);

            return result;
        }

//        Calculating the average of the practicum scores
        else if (numberOfMarks == 4 && drop == false) {
            double sum = 0;

            double practicums[] = new double[numberOfMarks];

            for (int i = 0; i < practicums.length; i++) {
                practicums[i] = kb.nextDouble();
            }

            for (int i = 0; i < practicums.length; i++) {
                sum = sum + practicums[i];
            }

            double result = sum / numberOfMarks;

            return result;
        }

//        Calculating the average of the pod scores
        else if (numberOfMarks == 1 && drop == false) {
            double sum = 0;

            double pods[] = new double[numberOfMarks];

            for (int i = 0; i < pods.length; i++) {
                pods[i] = kb.nextDouble();
            }

            for (int i = 0; i < pods.length; i++) {
                sum = sum + pods[i];
            }

            double result = sum / numberOfMarks;

            return result;
        } else {
            return 0;
        }
    }

    /**
     * Method for converting the scores into letter grades
     *
     * @param score is the total score of the student
     * @return the letter grade according to the total score
     */
    public static String scoreToLetterGrade(double score) {
        String letterGrade = "";
        double marks = Math.ceil(score);

        if (marks >= 90 && marks <= 100) {
            letterGrade = "A+";
        } else if (marks >= 85 && marks <= 89) {
            letterGrade = "A";
        } else if (marks >= 80 && marks <= 84) {
            letterGrade = "A-";
        } else if (marks >= 77 && marks <= 79) {
            letterGrade = "B+";
        } else if (marks >= 73 && marks <= 76) {
            letterGrade = "B";
        } else if (marks >= 70 && marks <= 72) {
            letterGrade = "B-";
        } else if (marks >= 65 && marks <= 69) {
            letterGrade = "C+";
        } else if (marks >= 60 && marks <= 64) {
            letterGrade = "C";
        } else if (marks >= 55 && marks <= 59) {
            letterGrade = "C-";
        } else if (marks >= 50 && marks <= 54) {
            letterGrade = "D";
        } else {
            letterGrade = "F";
        }

        return letterGrade;
    }

    /**
     * Method for calculating the class average for tests
     *
     * @param testAverages is the array that holds the test averages of every student in the class
     * @return the class average of tests
     */
    public static double classAverageTest(double[] testAverages) {
        double sum = 0;

        for (int i = 0; i < testAverages.length; i++) {
            sum = sum + testAverages[i];
        }

        double average = sum / testAverages.length;

        return average;
    }

    /**
     * Method for calculating the class average for assignments
     *
     * @param assignmentAverages is the array that holds the assignment averages of every student in the class
     * @return the class average of assignments
     */
    public static double classAverageAssignment(double[] assignmentAverages) {
        double sum = 0;

        for (int i = 0; i < assignmentAverages.length; i++) {
            sum = sum + assignmentAverages[i];
        }

        double average = sum / assignmentAverages.length;

        return average;
    }

    /**
     * Method for calculating the class average for practicums
     *
     * @param practicumAverages is the array that holds the practicum averages of every student in the class
     * @return the class average of practicums
     */
    public static double classAveragePracticum(double[] practicumAverages) {
        double sum = 0;

        for (int i = 0; i < practicumAverages.length; i++) {
            sum = sum + practicumAverages[i];
        }

        double average = sum / practicumAverages.length;

        return average;
    }

    /**
     * Method for calculating the class average for pods
     *
     * @param podAverages is the array that holds the pod averages of every student in the class
     * @return the class average of pods
     */
    public static double classAveragePod(double[] podAverages) {
        double sum = 0;

        for (int i = 0; i < podAverages.length; i++) {
            sum = sum + podAverages[i];
        }

        double average = sum / podAverages.length;

        return average;
    }

    /**
     * Method for calculating the median
     *
     * @param array is the array that holds the average of particular assessments of each student
     * @return the median score of particular assessment of each student
     */
    public static double getMedian(double array[]) {
//        Creating a copy array
        double copyArray[] = new double[array.length];

//        Copying values of the received array into the copy array
        for (int i = 0; i < array.length; i++) {
            copyArray[i] = array[i];
        }

//        Sorting the copy array
        Arrays.sort(copyArray);

//        Calculating the median
        double median;

        int totalElements = copyArray.length;
        if (totalElements % 2 == 0) {
            double sumOfMiddleElements = copyArray[totalElements / 2] +
                    copyArray[(totalElements / 2) + 1];
            median = sumOfMiddleElements / 2;
        } else {
            median = copyArray[totalElements / 2];
        }

        return median;
    }
}


