package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button submit;
    int correctAnswers = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submit = (Button) findViewById(R.id.submitButton);
        submit.setOnClickListener(submitButtonOnClickListener);
    }

    private void checkQuestionOneAnswers() {
        RadioButton radioButton = (RadioButton) findViewById(R.id.radioButton2);
        boolean isQChecked = radioButton.isChecked();
        if (isQChecked) {
            correctAnswers += 1;
        }
    }

    private void checkQuestionTwoAnswers() {
        CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkbox1);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkbox3);
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.checkbox2);
        CheckBox checkBox4 = (CheckBox) findViewById(R.id.checkbox4);
        boolean ischeckBox1Checked = checkBox1.isChecked();
        boolean ischeckBox2Checked = checkBox2.isChecked();
        boolean ischeckBox3Checked = !checkBox3.isChecked();
        boolean ischeckBox4Checked = !checkBox4.isChecked();

        if (ischeckBox1Checked && ischeckBox2Checked && ischeckBox3Checked && ischeckBox4Checked) {
            correctAnswers += 1;
        }
    }

    private void checkQuestionThreeAnswers() {
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.checkbox5);
        CheckBox checkBox4 = (CheckBox) findViewById(R.id.checkbox6);
        CheckBox checkBox5 = (CheckBox) findViewById(R.id.checkbox7);
        CheckBox checkBox6 = (CheckBox) findViewById(R.id.checkbox8);

        boolean ischeckBox3Checked = checkBox3.isChecked();
        boolean ischeckBox4Checked = checkBox4.isChecked();
        boolean ischeckBox5Checked = checkBox5.isChecked();
        boolean ischeckBox6Checked = !checkBox6.isChecked();
        if (ischeckBox3Checked && ischeckBox4Checked && ischeckBox5Checked && ischeckBox6Checked) {
            correctAnswers += 1;
        }
    }

    private void checkQuestionFourAnswers() {
        RadioButton radioButton = (RadioButton) findViewById(R.id.radioButton6);
        boolean isQChecked = radioButton.isChecked();
        if (isQChecked) {
            correctAnswers += 1;
        }
    }

    /**
     * Constructs a new string by converting the specified array
     *
     * @return
     */
    private String getQuestionFiveUserInput() {
        EditText userInput = (EditText) findViewById(R.id.answerInputUser);
        String nine = userInput.getText().toString();
        return nine;
    }

    private void checkQuestionFiveAnswers() {
        String nine = getQuestionFiveUserInput();
        if (nine.trim().equalsIgnoreCase("Nine")) {
            correctAnswers += 1;
        }
    }

    private void checkAllQuestions() {
        checkQuestionOneAnswers();
        checkQuestionTwoAnswers();
        checkQuestionThreeAnswers();
        checkQuestionFourAnswers();
        checkQuestionFiveAnswers();
    }

    private void resetCounterCorrectAnswers() {
        correctAnswers = 0;
    }

    final View.OnClickListener submitButtonOnClickListener = new View.OnClickListener() {
        public void onClick(final View v) {
            checkAllQuestions();
            if (correctAnswers == 0) {
                Toast.makeText(MainActivity.this, "POOR PLAYED SCORED = 0", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Correct Answers: " + correctAnswers + "/5",
                        Toast.LENGTH_LONG).show();
                resetCounterCorrectAnswers();
            }
        }
    };
}