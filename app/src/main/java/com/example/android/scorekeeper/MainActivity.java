package com.example.android.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /* Initialized global variables for both player 1 and player 2 */
    int pointsPlayer1 = 0;
    int setPlayer1 = 0;
    int setCounter1 = 0;
    int pointsPlayer2 = 0;
    int setPlayer2 = 0;
    int setCounter2 = 0;

    /* The "main" method */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /* This method adds points to player 1 when Add Points button is clicked */
    public void addPointsToPlayerOne(View v) {
        pointsPlayer1 = pointsPlayer1 + 1;
        pointsConversionPlayer1(pointsPlayer1);
    }

    /* This method adds points to player 2 when Add Points button is clicked */
    public void addPointsToPlayerTwo(View v) {
        pointsPlayer2 = pointsPlayer2 + 1;
        pointsConversionPlayer2(pointsPlayer2);
    }

    /* This method adds points to player one set when + button is clicked */
    public void addSetToPlayerOne(View v) {
        setPlayer1 = setPlayer1 + 1;
        checkSetPlayer1(setPlayer1);
    }

    /* This method adds points to player two set when + button is clicked */
    public void addSetToPlayerTwo(View v) {
        setPlayer2 = setPlayer2 + 1;
        checkSetPlayer2(setPlayer2);
    }

    /* This method converts traditional numbers to tennis scores for player 1,
     * it also compares points to determine who has one the game, or whether there is a
      * tie or an advantage for player 1*/
    public void pointsConversionPlayer1(int pointsPlayer1) {

        if (pointsPlayer1 == 1) {
            gameStatusText("Game Currently In Progress");
            displayPtsForPlayer1(15);
        }

        if (pointsPlayer1 == 2) {
            displayPtsForPlayer1(30);
        }

        if (pointsPlayer1 == 3) {
            displayPtsForPlayer1(40);
        }

        if (pointsPlayer1 >= 4 && pointsPlayer2 <= (pointsPlayer1 - 2)) {
            gameStatusText("Player 1 Wins the Game");
            Button playerOnePts = (Button) findViewById(R.id.player_one_points);
            playerOnePts.setEnabled(false);
            Button playerTwoPts = (Button) findViewById(R.id.player_two_points);
            playerTwoPts.setEnabled(false);
        } else if (pointsPlayer1 >= 4 && pointsPlayer2 <= (pointsPlayer1 - 1)) {
            gameStatusText("Advantage Player 1");
        } else if (pointsPlayer1 >= 3 && pointsPlayer2 == pointsPlayer1) {
            gameStatusText("Deuce");
        }
    }

    /* This method converts traditional numbers to tennis scores for player 2,
     * it also compares points to determine who has one the game, or whether there is a
      * tie or an advantage for player 2*/
    public void pointsConversionPlayer2(int pointsPlayer2) {

        if (pointsPlayer2 == 1) {
            gameStatusText("Game Currently In Progress");
            displayPtsForPlayer2(15);
        }

        if (pointsPlayer2 == 2) {
            displayPtsForPlayer2(30);
        }

        if (pointsPlayer2 == 3) {
            displayPtsForPlayer2(40);
        }

        if (pointsPlayer1 == 4 && pointsPlayer2 == 4) {
            gameStatusText("Deuce");
        }

        if (pointsPlayer2 >= 4 && pointsPlayer1 <= (pointsPlayer2 - 2)) {
            gameStatusText("Player 2 Wins the Game");
            Button playerOnePts = (Button) findViewById(R.id.player_one_points);
            playerOnePts.setEnabled(false);
            Button playerTwoPts = (Button) findViewById(R.id.player_two_points);
            playerTwoPts.setEnabled(false);
        } else if (pointsPlayer2 >= 4 && pointsPlayer1 <= (pointsPlayer2 - 1)) {
            gameStatusText("Advantage Player 2");
        } else if (pointsPlayer2 >= 3 && pointsPlayer1 == pointsPlayer2) {
            gameStatusText("Deuce");
        }
    }

    /* This method checks to see how many sets are won by player 1, and whether they have
    * won the entire match*/
    public void checkSetPlayer1(int setCounter1) {

        if (setCounter1 >= 7 && setCounter1 > (setCounter2 + 2)) {
            gameStatusText("Player 1 Wins the Match");
            Button playerOnePts = (Button) findViewById(R.id.player_one_points);
            playerOnePts.setEnabled(false);
            Button playerTwoPts = (Button) findViewById(R.id.player_two_points);
            playerTwoPts.setEnabled(false);
            Button playerOneSet = (Button) findViewById(R.id.player_one_setScore);
            playerOneSet.setEnabled(false);
            Button playerTwoSet = (Button) findViewById(R.id.player_two_setScore);
            playerTwoSet.setEnabled(false);
        } else {
            displaySetForPlayer1(setPlayer1);
        }
    }

    /* This method checks to see how many sets are won by player 2, and whether they have
    * won the entire match*/
    public void checkSetPlayer2(int setCounter2) {

        if (setCounter2 >= 7 && setCounter2 > (setCounter1 + 2)) {
            gameStatusText("Player 2 Wins the Match");
            Button playerOnePts = (Button) findViewById(R.id.player_one_points);
            playerOnePts.setEnabled(false);
            Button playerTwoPts = (Button) findViewById(R.id.player_two_points);
            playerTwoPts.setEnabled(false);
            Button playerOneSet = (Button) findViewById(R.id.player_one_setScore);
            playerOneSet.setEnabled(false);
            Button playerTwoSet = (Button) findViewById(R.id.player_two_setScore);
            playerTwoSet.setEnabled(false);
        } else {
            displaySetForPlayer2(setPlayer2);
        }
    }

    /* This method is used to provide a display for the game status*/
    public void gameStatusText(String gameStat) {
        TextView gameStatView = (TextView) findViewById(R.id.gameStatus);
        gameStatView.setText(String.valueOf(gameStat));
    }

    /* This method check displays the points for each game for player 1*/
    public void displayPtsForPlayer1(int points) {
        TextView pointsView = (TextView) findViewById(R.id.player_one_score);
        pointsView.setText(String.valueOf(points));
    }

    /* This method check displays the points for each game for player 2*/
    public void displayPtsForPlayer2(int points) {
        TextView pointsView = (TextView) findViewById(R.id.player_two_score);
        pointsView.setText(String.valueOf(points));
    }

    /* This method check displays the set points for each game for player 1*/
    public void displaySetForPlayer1(int set) {
        TextView pointsView = (TextView) findViewById(R.id.player_one_set);
        pointsView.setText(String.valueOf(set));
    }

    /* This method check displays the set points for each game for player 2*/
    public void displaySetForPlayer2(int set) {
        TextView pointsView = (TextView) findViewById(R.id.player_two_set);
        pointsView.setText(String.valueOf(set));
    }

    /* This method resets each game after a player has won a single game*/
    public void resetGame(View v) {
        pointsPlayer1 = 0;
        pointsPlayer2 = 0;
        gameStatusText("");
        Button playerOnePts = (Button) findViewById(R.id.player_one_points);
        playerOnePts.setEnabled(true);
        Button playerTwoPts = (Button) findViewById(R.id.player_two_points);
        playerTwoPts.setEnabled(true);
        displayPtsForPlayer1(pointsPlayer1);
        displayPtsForPlayer2(pointsPlayer1);
    }

    /* This method resets an entire match after a player has won an entire match*/
    public void resetMatch(View v) {
        pointsPlayer1 = 0;
        pointsPlayer2 = 0;
        setPlayer1 = 0;
        setPlayer2 = 0;
        gameStatusText("");
        Button playerOnePts = (Button) findViewById(R.id.player_one_points);
        playerOnePts.setEnabled(true);
        Button playerTwoPts = (Button) findViewById(R.id.player_two_points);
        playerTwoPts.setEnabled(true);
        Button playerOneSet = (Button) findViewById(R.id.player_one_setScore);
        playerOneSet.setEnabled(true);
        Button playerTwoSet = (Button) findViewById(R.id.player_two_setScore);
        playerTwoSet.setEnabled(true);
        displayPtsForPlayer1(pointsPlayer1);
        displayPtsForPlayer2(pointsPlayer2);
        displaySetForPlayer1(pointsPlayer1);
        displaySetForPlayer2(pointsPlayer2);
    }
}