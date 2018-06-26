package com.manngachan.dietarysupplements;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score = 0;

    boolean firstAnswer;
    boolean secondAnswer;
    boolean thirdAnswer;
    boolean fourthAnswer;
    boolean isSubmitted;

    RadioGroup radioGroupOne;
    RadioButton right;
    RadioButton wrong;

    RadioGroup radioGroupTwo;
    RadioButton ibuprofen;
    RadioButton glucosamine;
    RadioButton ginseng;

    RadioGroup radioGroupThree;
    RadioButton yes;
    RadioButton no;

    CheckBox vitamins;
    CheckBox minerals;
    CheckBox fruits;
    CheckBox herbs;

    EditText doctor;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        radioGroupOne = findViewById(R.id.radio_group_one);
        right = findViewById(R.id.true_radio_button);
        wrong = findViewById(R.id.false_radio_button);

        radioGroupTwo = findViewById(R.id.radio_group_two);
        ibuprofen = findViewById(R.id.ibuprofen_radio_button);
        glucosamine = findViewById(R.id.glucosamine_radio_button);
        ginseng = findViewById(R.id.ginseng_radio_button);

        radioGroupThree = findViewById(R.id.radio_group_three);
        yes = findViewById(R.id.yes_radio_button);
        no = findViewById(R.id.no_radio_button);

        vitamins = findViewById(R.id.vitamins_check_box);
        minerals = findViewById(R.id.minerals_check_box);
        fruits = findViewById(R.id.fruits_check_box);
        herbs = findViewById(R.id.herbs_check_box);

        doctor = findViewById(R.id.edit_text_answer);


        firstAnswer = false;
        secondAnswer = false;
        thirdAnswer = false;
        fourthAnswer = false;
        isSubmitted = false;
    }

    /**
     * Saves score data when screen is rotated.
     */


    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("scoreData", score);

        outState.putBoolean("firstAnswer", firstAnswer);
        outState.putBoolean("secondAnswer", secondAnswer);
        outState.putBoolean("thirdAnswer", thirdAnswer);
        outState.putBoolean("fourthAnswer", fourthAnswer);
        outState.putBoolean("submit", isSubmitted);
    }


    /**
     * Question 1: Radio Button - Correct answer is "wrong"
     **/
    public void onFirstQuestionClicked(View view) {

        if (wrong.isChecked()) {
            firstAnswer = true;

        }

    }

    /**
     * Question 2: Radio Button - Correct answer is "ibuprofen"
     **/

    public void onSecondQuestionClicked(View view) {
        if (ibuprofen.isChecked()) {
            secondAnswer = true;
        }

    }

    /**
     * Question 3: Radio Button - Correct answer is "no"
     **/

    public void onThirdQuestionClicked(View view) {

        if (no.isChecked()) {
            thirdAnswer = true;

        }

    }

    /**
     * Question 4: CheckBox - Correct answers are #1, 2, and 4 (Vitamins, minerals, and herbs)
     **/

    public void onCheckBoxClicked(View view) {
        if (vitamins.isChecked() && minerals.isChecked() && fruits.isChecked() && !herbs.isChecked()) {
            fourthAnswer = true;
        }
    }


    public void submitScore(View view) {

        if (firstAnswer) {
            score++;
        }

        if (secondAnswer) {
            score++;
        }

        if (thirdAnswer) {
            score++;
        }

        if (fourthAnswer) {
            score++;

        }
        if (isSubmitted) {
            Toast.makeText(getApplicationContext(), getString(R.string.submitted), Toast.LENGTH_LONG).show();

        } else {

            if (doctor.getText().toString().trim().equalsIgnoreCase(getString(R.string.edit_text_answer))) {
                score++;
            }

            Toast.makeText(getApplicationContext(), getString(R.string.score) + score + getString(R.string.max_score), Toast.LENGTH_LONG).show();
            isSubmitted = true;

        }
    }

    public void resetScore(View view) {

        score = 0;

        firstAnswer = false;
        secondAnswer = false;
        thirdAnswer = false;
        fourthAnswer = false;
        isSubmitted = false;

        radioGroupOne.clearCheck();
        radioGroupTwo.clearCheck();
        radioGroupThree.clearCheck();

        vitamins.setChecked(false);
        minerals.setChecked(false);
        fruits.setChecked(false);
        herbs.setChecked(false);

        doctor.getText().clear();

    }

    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        score = savedInstanceState.getInt("scoreData");

        firstAnswer = savedInstanceState.getBoolean("firstAnswer");
        secondAnswer = savedInstanceState.getBoolean("secondAnswer");
        thirdAnswer = savedInstanceState.getBoolean("thirdAnswer");
        fourthAnswer = savedInstanceState.getBoolean("fourthAnswer");
        isSubmitted = savedInstanceState.getBoolean("submit");
    }
}