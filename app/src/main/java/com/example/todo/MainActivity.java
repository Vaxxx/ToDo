package com.example.todo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.todo.model.JavaConnect;

public class MainActivity extends AppCompatActivity {

    EditText txtEmail,txtPassword;
    Button btnLogin, btnRegister;
    JavaConnect connect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtEmail = (EditText)findViewById(R.id.txtEmail);
        txtPassword = (EditText)findViewById(R.id.txtPassword);

        btnLogin = (Button)findViewById(R.id.btnLogin);
        btnRegister = (Button)findViewById(R.id.btnRegister);

        connect = new JavaConnect(this);
    }

    public void btnRegisterAction(View view){
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    public void btnLoginAction(View view){
        String email = txtEmail.getText().toString().trim();
        String password = txtPassword.getText().toString().trim();


        boolean insert = connect.loginUser(email,password);
        if(insert == true){
            Intent intent = new Intent(this, DashboardActivity.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(this, "RECORD FAILED TO INSERT!", Toast.LENGTH_SHORT).show();
        }
    }
}
