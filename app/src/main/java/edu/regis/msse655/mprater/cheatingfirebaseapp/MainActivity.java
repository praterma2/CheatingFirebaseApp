package edu.regis.msse655.mprater.cheatingfirebaseapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private Button sendData;

    private Button recData;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendData = (Button) findViewById(R.id.button);

        sendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Write a message to the database
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("message");
                myRef.setValue("Goodbye, World!");
                

            }
        });

        recData = (Button) findViewById(R.id.btn2);


        recData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int val = 9;
                long val2 = 10;
                long crtTime= System.currentTimeMillis();
                String sttCrtTime = String.valueOf(crtTime) + "t";
                String stbCrtTime =  String.valueOf(crtTime) + "b";
                // Write a tone message to the database
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference(sttCrtTime);
                myRef.setValue(val);

                //now for the beat
                DatabaseReference myRef2 = database.getReference(stbCrtTime);
                myRef2.setValue(val2);




            }
        });
    }


}

