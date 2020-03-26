package com.example.ali.testapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddUser extends AppCompatActivity {

    DatabaseHelper usersDb;
    EditText editName, editPosition;
    Button buttonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        usersDb = new DatabaseHelper(this);

        editName = (EditText) findViewById(R.id.edit_UserName);
        editPosition = (EditText) findViewById(R.id.edit_UserPos);
        addUser();

    }
    public void addUser(){
        buttonSave.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){

                        boolean isInserted = usersDb.insertUserData(editName.getText().toString(),
                                editPosition.getText().toString());

                        if(isInserted = true)
                            Toast.makeText(AddUser.this, "Saved", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(AddUser.this, "Save failed", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}
