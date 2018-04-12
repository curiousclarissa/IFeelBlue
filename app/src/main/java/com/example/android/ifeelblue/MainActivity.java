package com.example.android.ifeelblue;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.NumberFormat;
public class MainActivity extends AppCompatActivity {
    //all students start with a score of 1 for participating
    int needsScore = 0;
    //user gets a star score for participating each question and one to start
    int starsScore = 1;
    String userColor = "";
    /**
     * This method is called when the submit button is clicked.
     */
    public void submit(View view) {
        final int needsScoreFinal = checkedScore();
        displayMessage();


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
        if (needsHug == true){
            needsScore += 1;
        }
        if (needsToSqueeze == true){
            needsScore += 1;
        }
        if (needsToExpress == true){
            needsScore += 1;
        }
        if (needsRest == true){
            needsScore += 1;
        }
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
                    userColor = "@string/angry";
                    break;
            case R.id.radio_active:
                if (checked)
                    userColor= "@string/active";
                    break;
            case R.id.radio_sad:
                if (checked)
                    userColor= "@string/sad";
                break;
            case R.id.radio_happy:
                if (checked)
                    userColor= "@string/happy";
                break;
            case R.id.radio_worried:
                if (checked)
                    userColor= "@string/worried";
                break;
            case R.id.radio_excited:
                if (checked)
                    userColor= "@string/excited";
                break;
            case R.id.radio_tired:
                if (checked)
                    userColor= "@string/tired";
                break;
            case R.id.radio_hungry:
                if (checked)
                    userColor= "@string/hungry";
                break;
        }
        starsScore += 1;
    }
    private void displayMessage(String message){
        //validate student's color description of feeling
        String studentMessage = "@string/indication";
        studentMessage += " " + userColor;
        //valid feeling word user used to describe self
        //remind user they said they need
        //remind user of which tools they will use
        //tell user to say, "I see myself as___" 5 times.
        //report user's color score
        //report user's need for help or needsScore
        Log.v("message", studentMessage);
        TextView quizSummaryTextView;
        quizSummaryTextView = findViewById(R.id.quiz_summary);
        quizSummaryTextView.setText(studentMessage);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
