/**
 * Created by Mateusz on 07.03.2017.
 */
public class Score {

    private static int score = 0;

    //So that this class can't be instantiated
    private Score () {
    }

    //Return current score
    public static int getScore() {
        return score;
    }

    //Increment score
    public static void increaseScoreByOne() {
        score = score++;
    }

    //Decrement score
    public static void decreaseScoreByOne() {
        score = score--;
    }

    //Reset score back to 0
    public static void resetScore() {
        score = 0;
    }
}