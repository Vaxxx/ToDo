package com.example.todo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.todo.model.JavaConnect;

public class RegisterActivity extends AppCompatActivity {


    EditText txtFullName, txtPassword, txtEmail;
    Button btnRegister ;
    JavaConnect connect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        txtFullName = (EditText) findViewById(R.id.txtFullName);
        txtPassword = (EditText)findViewById(R.id.txtPassword);
        txtEmail = (EditText)findViewById(R.id.txtEmail);
        btnRegister =(Button)findViewById(R.id.btnRegister);

        connect = new JavaConnect(this);
    }

    public void btnBackAction(View view){
         Intent intent = new Intent(this, MainActivity.class);
         startActivity(intent);
    }

    public void btnRegisterAction(View view){
        String fullname = txtFullName.getText().toString().trim();
        String email = txtEmail.getText().toString().trim();
        String password = txtPassword.getText().toString().trim();

        boolean insert = connect.addUser(fullname,email,password);
        if(insert == true){
            Toast.makeText(this, "RECORD SUCCESSFULLY INSERTED!", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "RECORD FAILED TO INSERT!", Toast.LENGTH_SHORT).show();
        }
    }
}
