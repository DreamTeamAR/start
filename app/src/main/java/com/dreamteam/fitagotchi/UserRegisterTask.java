package com.dreamteam.fitagotchi;


import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRegisterTask extends UserTask {

    UserRegisterTask(String email, String password, LoginActivity activity) {
        super(email, password, activity);

    }

    @Override
    protected Boolean doInBackground(Void... params) {
        // TODO: attempt authentication against a network service.


        FirebaseApp.initializeApp(mActivity.getApplicationContext());
        Task<QuerySnapshot> future =
                FirebaseFirestore.getInstance().collection("users").whereEqualTo("email", mEmail).get();
        while (!future.isComplete()) ;

        List<DocumentSnapshot> documents = future.getResult().getDocuments();
        for (DocumentSnapshot document : documents) {
            return false;

        }
        DocumentReference db = FirebaseFirestore.getInstance().collection("users").document(mEmail);

        Map<String, Object> data = new HashMap<>();
        data.put("email", mEmail);

        data.put("password", mPassword.hashCode());
//asynchronously write data
        db.set(data).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Log.d("LoL", "Document has been saved!");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d("LoL", "Failure!");
            }
        });

        return true;
    }
}
