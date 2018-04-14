package com.dreamteam.fitagotchi;




import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public class UserSignInTask extends UserTask {

    UserSignInTask(String email, String password, LoginActivity activity) {
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
            LoginData data = document.toObject(LoginData.class);
            if (data.getPassword() == (mPassword.hashCode())) return true;
            else
                return false;

        }


        return false;
    }
}
