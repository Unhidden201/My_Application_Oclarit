package com.example.myapplication;

import android.content.Intent;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;

public class MainActivity2 extends AppCompatActivity {
    private static final Pattern PASSWORD_PATTERN = //regex in Password
            Pattern.compile("^" +
            //"(?=.*[0-9])" +         //at least 1 digit
            //"(?=.*[a-z])" +         //at least 1 lower case letter
            //"(?=.*[A-Z])" +         //at least 1 upper case letter
            "(?=.*[a-zA-Z])" +      //any letter
            "(?=.*[@#$_%^&+=])" +    //at least 1 special character
            "(?=\\S+$)" +           //no white spaces
            ".{6,}" +               //at least 6 characters
            "$");

    private static final Pattern USER_PATTERN = //regex in Username
            Pattern.compile("^" +


                    "(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[a-zA-Z])" +      //any letter
                    ".{6,}" +               //at least 6 characters
                    "$");




    private TextInputLayout textInputEmail;
    private TextInputLayout textInputUsername;
    private TextInputLayout textInputPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textInputEmail = findViewById(R.id.text_input_email);
        textInputUsername = findViewById(R.id.text_input_username);
        textInputPassword = findViewById(R.id.text_input_password);
    }

    private boolean validateEmail() {
        String emailInput = textInputEmail.getEditText().getText().toString().trim();

        if (emailInput.isEmpty()) {
            textInputEmail.setError("Field can't be empty");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            textInputEmail.setError("Please enter a valid email address");
            return false;
        } else {
            textInputEmail.setError(null);
            return true;
        }
    }

    private boolean validateUsername() {
        String usernameInput = textInputUsername.getEditText().getText().toString().trim();

        if (usernameInput.isEmpty()) {
            textInputUsername.setError("Field can't be empty");
            return false;
        }
        else if (!USER_PATTERN.matcher(usernameInput).matches()) {
            textInputUsername.setError("Username too weak");
            textInputUsername.setError("Username atleast 6 characters");

            return false;
        }
        else {
            textInputUsername.setError(null);
            return true;
        }
    }

    private boolean validatePassword() {
        String passwordInput = textInputPassword.getEditText().getText().toString().trim();

        if (passwordInput.isEmpty()) {
            textInputPassword.setError("Field can't be empty");
            return false;
        } else if (!PASSWORD_PATTERN.matcher(passwordInput).matches()) {
            textInputPassword.setError("Password too weak");
            textInputPassword.setError("Password atleast 6 characters");

            textInputPassword.setError(null);
            return false;
        }

        else {
            textInputPassword.setError(null);
            return true;
        }
    }

    public void confirmforgot(View v){

        Toast.makeText(this,"Forgot Password", Toast.LENGTH_SHORT).show();
    }
    public void confirmcreate(View v){
        Intent intent = new Intent(this,MainActivity3.class);
        startActivity(intent);
    }

    public void confirmlogin(View v) {
        if (!validateEmail() | !validateUsername() | !validatePassword()) {
            return;
        }
        Intent intent = new Intent(this,Main5Activity.class);

        String input = "Welcome " + textInputUsername.getEditText().getText().toString();


        Toast.makeText(this, input, Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }
}