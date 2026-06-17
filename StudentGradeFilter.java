// Practice 2: Student Grade Filter
// Uses an ArrayList and simple if-else logic to classify scores.

import java.util.ArrayList;
import java.util.Arrays;

public class StudentGradeFilter {
    public static void main(String[] args) {
        // Sample scores instead of typing 100 values manually.
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(
                95, 82, 39, 40, 76, 90, 12, 67, 88, 100
        ));

        for (int score : scores) {
            // Highest condition first, otherwise 90+ would also count as Pass.
            if (score >= 90) {
                System.out.println(score + " -> Distinction");
            } else if (score >= 40) {
                System.out.println(score + " -> Pass");
            } else {
                System.out.println(score + " -> Fail");
            }
        }
    }
}
