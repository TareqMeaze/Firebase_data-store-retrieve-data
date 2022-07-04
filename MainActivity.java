package com.meaze.database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText edName,edAge;
    Button Savebutton,Loadbutton;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseReference=FirebaseDatabase.getInstance().getReference("All Data");

       edName=findViewById(R.id.edName);
       edAge=findViewById(R.id.edAge);
       Savebutton=findViewById(R.id.Savebutton);
       Loadbutton=findViewById(R.id.Loadbutton);

       Savebutton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

             dataBase();

             edName.setText("");
             edAge.setText("");
           }
       });

  //===============LoadData=======================

        Loadbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),Details.class);
                startActivity(intent);

            }
        });

    }

    public void dataBase(){

        String name=edName.getText().toString();
        String age=edAge.getText().toString();

        if (name.length()>0 && age.length()>0){

            String key= databaseReference.push().getKey();

            Student student = new Student(name,age);

            databaseReference.child(key).setValue(student);
            Toast.makeText(getApplicationContext(),"Your Information Uploaded",Toast.LENGTH_LONG).show();

        }else {
            Toast.makeText(getApplicationContext(),"Plesse Input a number",Toast.LENGTH_LONG).show();
        }

    }
}