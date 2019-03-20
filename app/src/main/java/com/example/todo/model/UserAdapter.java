package com.example.todo.model;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.todo.R;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {

    private ArrayList<User> allUserList = new ArrayList<>();

    public UserAdapter(ArrayList<User> allUserList) {
        this.allUserList = allUserList;
    }

    @NonNull
    @Override

    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.txtFullName.setText(allUserList.get(i).getFullName());
        myViewHolder.txtPassword.setText(allUserList.get(i).getPassword());
        myViewHolder.txtEmail.setText(allUserList.get(i).getEmail());
    }


    @Override
    public int getItemCount() {
        return allUserList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView txtFullName, txtPassword, txtEmail;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtFullName = (TextView)itemView.findViewById(R.id.txtFullName);
            txtPassword = (TextView)itemView.findViewById(R.id.txtPassword);
            txtEmail = (TextView)itemView.findViewById(R.id.txtEmail);
        }
    }
}
