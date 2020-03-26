package com.example.ali.testapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddAsset extends AppCompatActivity {

    DatabaseHelper assetsDb;
    EditText editItem, editCategory, editSerial, editUser, editLocation;
    Button buttonSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_asset);
        assetsDb = new DatabaseHelper(this);

        editItem = (EditText)findViewById(R.id.editText_Item);
        editCategory = (EditText) findViewById(R.id.editText_Category);
        editSerial = (EditText) findViewById(R.id.editText_Serial);
        editUser = (EditText) findViewById(R.id.editText_User);
        editLocation = (EditText) findViewById(R.id.editText_Location);
        buttonSave = (Button) findViewById(R.id.buttonAdd);

        addItem();

    }

    public void addItem(){
        buttonSave.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){

                        boolean isInserted = assetsDb.insertData(editItem.getText().toString(),
                        editCategory.getText().toString(),
                        editSerial.getText().toString(),
                        editUser.getText().toString(),
                        editLocation.getText().toString());

                        if(isInserted = true)
                            Toast.makeText(AddAsset.this, "Saved", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(AddAsset.this, "Save failed", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}
