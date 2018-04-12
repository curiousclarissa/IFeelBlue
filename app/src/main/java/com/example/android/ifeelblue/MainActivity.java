package com.example.android.ifeelblue;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //all students start with a score of 1 for participating
    int needsScore = 0;
    String userColor = "";
    String indicationText;
    //user gets a star score for participating each question and one to start
    int starsScore = 1;
    String userFeeling = "";
    /**
     * This method is called when the submit button is clicked.
     */
    public String submit(View view) {
        final int needsScoreFinal = checkedScore();
        EditText feelingField = (EditText) findViewById(R.id.feeling_sentence);
        String feeling = feelingField.getText().toString();
        String studentMessage = indicationText;
        studentMessage = studentMessage + " " + userFeeling;
        //validate student's color description of feeling
        studentMessage = studentMessage + "\n and you are feeling like the color " + userColor;
        //remind user they said they need
        studentMessage = studentMessage + "\n You said you need " + feeling;
        //report user's need for help or needsScore
        studentMessage = studentMessage + "\n " + "You have a need for " + needsScoreFinal + " tools.";
        //report star score
        studentMessage = studentMessage + "\n " + "You've earned " + starsScore + " stars.";
        Log.v("message", studentMessage);
        TextView quizSummaryTextView;
        quizSummaryTextView = findViewById(R.id.quiz_summary);
        quizSummaryTextView.setText(studentMessage);
        Toast.makeText(this, "Your score is " + starsScore + " stars.", Toast.LENGTH_SHORT).show();
        return studentMessage;

    }
    private int checkedScore(){
        //handle user checked boxes
        CheckBox checkBoxHunger =  findViewById(R.id.checkbox_hunger);
        CheckBox checkBoxHug =  findViewById(R.id.checkbox_hug);
        CheckBox checkBoxSqueeze =  findViewById(R.id.checkbox_squeeze);
        CheckBox checkBoxExpression =  findViewById(R.id.checkbox_expression);
        CheckBox checkBoxRest =  findViewById(R.id.checkbox_rest);

        boolean needsFood = checkBoxHunger.isChecked();
        boolean needsHug = checkBoxHug.isChecked();
        boolean needsToSqueeze = checkBoxSqueeze.isChecked();
        boolean needsRest = checkBoxRest.isChecked();
        boolean needsToExpress = checkBoxExpression.isChecked();

        if (needsFood == true){
            needsScore += 1;
        }
        else if (needsHug == true){
            needsScore += 1;
        }
       else if (needsToSqueeze == true){
            needsScore += 1;
        }
        else if (needsToExpress == true){
            needsScore += 1;
        }
        else if (needsRest == true){
            needsScore += 1;
        }
        starsScore += 1;
        return needsScore;
    }
    // let user report feeling word with radio button
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_angry:
                if (checked)
                    userFeeling = "angry";
                    break;
            case R.id.radio_active:
                if (checked)
                    userFeeling= "active";
                    break;
            case R.id.radio_sad:
                if (checked)
                    userFeeling= "@string/sad";
                break;
            case R.id.radio_happy:
                if (checked)
                    userFeeling = "happy";
                break;

            case R.id.radio_hungry:
                if (checked)
                    userFeeling= "hungry";
                break;
        }
        starsScore += 1;
    }

    public void onYellow(View v) {
        userColor = "yellow";
        starsScore += 1;
    }
    public void onBlue(View v) {
        userColor = "blue";
        starsScore += 1;
    }
    public void onRed(View v) {
        userColor = "red";
        starsScore += 1;
    }
    public void onGreen(View v) {
        userColor = "green";
        starsScore += 1;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        indicationText = getString(R.string.indication);
    }
}
