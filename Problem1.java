import java.util.*;

/**
 * This problem calculates the final grade of a student by calculating the scores of particular assessments
 *
 * @author Nilay Das
 */
public class Problem1 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String bannerNumber = in.next();

//      Weight of marks for each assessment
        double testWeight = 0.25;
        double assignmentWeight = 0.3;
        double practicumWeight = 0.35;
        double podWeight = 0.1;

//      Average of the assessments
        double testAverage = readAssessmentScores(3, false, in) * testWeight;
        double assignmentAverage = readAssessmentScores(5, true, in) * assignmentWeight;
        double practicumAverage = readAssessmentScores(4, false, in) * practicumWeight;
        double podAverage = readAssessmentScores(1, false, in) * podWeight;

//        Sum of the averages of all the assessments
        double sumOfAssessments = testAverage + assignmentAverage + practicumAverage + podAverage;

//        Calling the method to convert the average into letter grade
        String letterGrade = scoreToLetterGrade(sumOfAssessments);

//        Printing the result of the student
        System.out.println("Student: " + bannerNumber + " - " + letterGrade);
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

//          Sorting the array to drop the last score
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

//        Calculating the average of the practicum scores
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
}
