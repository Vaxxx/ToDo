package com.example.todo;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.todo.model.JavaConnect;
import com.example.todo.model.User;
import com.example.todo.model.UserAdapter;

import java.util.ArrayList;

public class DashboardActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    UserAdapter adapter;
    ArrayList<User>allUsers = new ArrayList<>();
    JavaConnect connect;
    Cursor cursor;

    //initialize values
    EditText txtEmail, txtFullName, txtPassword, txtId;
    Button btnUpdate, btnDelete, btnLogin ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        recyclerView = (RecyclerView)findViewById(R.id.recylerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        connect = new JavaConnect(this);
        cursor = connect.viewAllUser();
        while(cursor.moveToNext()){
            allUsers.add(new User(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3)));
        }
          adapter = new UserAdapter(allUsers);
         recyclerView.setAdapter(adapter);

         btnUpdate = (Button)findViewById(R.id.btnUpdate);
         btnDelete = (Button)findViewById(R.id.btnDelete);
         btnLogin = (Button)findViewById(R.id.btnLogin);

         txtEmail = (EditText)findViewById(R.id.txtEmail);
         txtFullName = (EditText)findViewById(R.id.txtFullName);
         txtPassword = (EditText)findViewById(R.id.txtPassword);
         txtId = (EditText)findViewById(R.id.txtId);
    }

        public void btnUpdateAction(View view){

            String email = txtEmail.getText().toString().trim();
            String password = txtPassword.getText().toString().trim();
            String fullname = txtFullName.getText().toString().trim();
            String id = txtId.getText().toString().trim();

            if(email.isEmpty() || password.isEmpty() || id.isEmpty() || fullname.isEmpty()){
                Toast.makeText(this, "YOU MUST FILL IN ALL THE FIELDS", Toast.LENGTH_SHORT).show();
            }else{
                boolean insert =connect.updateUser(id, fullname,email, fullname);

                if(insert == true){
                    Toast.makeText(this, "RECORD SUCCESSFULLY UPDATED!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(this, "RECORD FAILED TO UPDATE!", Toast.LENGTH_SHORT).show();
                }
            }

//            boolean insert = connect.loginUser(email,password);
//            if(insert == true){
//                Intent intent = new Intent(this, DashboardActivity.class);
//                startActivity(intent);
//            }
//            else{
//                Toast.makeText(this, "RECORD FAILED TO INSERT!", Toast.LENGTH_SHORT).show();
//            }
        }
        public void btnDeleteAction(View view){

        }
        public void btnLoginAction(View view){

        }
}
