package com.dreamteam.fitagotchi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProfileInformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_information);
        Button confirm = findViewById(R.id.confirm_edit);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = ((TextView) findViewById(R.id.edit_name)).getText().toString();
                String age = ((TextView) findViewById(R.id.edit_age)).getText().toString();
                String height = ((TextView) findViewById(R.id.edit_height)).getText().toString();
                String weight = ((TextView) findViewById(R.id.edit_weight)).getText().toString();
                String email = getIntent().getStringExtra("email");
                String password = getIntent().getStringExtra("password");


                Task<QuerySnapshot> future =
                        FirebaseFirestore.getInstance().collection("users").whereEqualTo("email", email).get();
                while (!future.isComplete()) ;
                DocumentReference db = FirebaseFirestore.getInstance().document("users/" + email + "/data/personal");
                Map<String, Object> data = new HashMap<>();
                data.put("name", name);
                data.put("age", age);
                data.put("height", height);
                data.put("weight", weight);
                db.set(data);


            }
        });
    }
}
