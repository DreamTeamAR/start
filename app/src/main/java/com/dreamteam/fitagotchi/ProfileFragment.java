package com.dreamteam.fitagotchi;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProfileFragment extends Fragment {


    String name;
    String age;
    String gender;
    String activityLevel;
    String height;
    String weight;
    public void setProfileFragment(String email) {
        DocumentReference db = FirebaseFirestore.getInstance().document("users/" + email + "/data/personal");
        Task<DocumentSnapshot> doc = db.get();
        while (!doc.isComplete()) ;
        DocumentSnapshot result = doc.getResult();
        PersonalModel model = result.toObject(PersonalModel.class);

        name = model.getName();
        age = model.getAge();
        gender = model.getGender();
        activityLevel = model.getActivityLevel();
        height = model.getHeight();
        weight = model.getWeight();

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.profile_fragment, container, false);

        ((TextView)rootView.findViewById(R.id.user_name)).setText(name);
        ((TextView)rootView.findViewById(R.id.user_age)).setText(age);
        ((TextView)rootView.findViewById(R.id.user_gender)).setText(gender);
        ((TextView)rootView.findViewById(R.id.user_activity)).setText(activityLevel);
        ((TextView)rootView.findViewById(R.id.user_height)).setText(height);
        ((TextView)rootView.findViewById(R.id.user_weight)).setText(weight);
        Double BMI = (double)Integer.parseInt(weight)/(((double)Integer.parseInt(height)/100.0)*(((double)Integer.parseInt(height)/100.0)));
        BMI = (BMI*100);
        BMI = (BMI.intValue())/100.0;
        ((TextView)rootView.findViewById(R.id.user_bmi)).setText(BMI.toString());
        Double BMR;
        if(gender.equals("Female"))
        {
            BMR = 655.1 + (9.563)*Integer.parseInt(weight)+1.85*Integer.parseInt(height)-4.676*Integer.parseInt(age);
        }
        else
        {
            BMR = 66.5 + (13.75)*Integer.parseInt(weight)+5.003*Integer.parseInt(height)-6.775*Integer.parseInt(age);
        }
        BMR = BMR *100;
        BMR = (BMR.intValue())/100.0;
        ((TextView)rootView.findViewById(R.id.user_bmr)).setText(BMR.toString());

        return rootView;
    }
}
