package com.dreamteam.fitagotchi;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public class ExcerciseFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.excercise_fragment, container, false);
        Task<QuerySnapshot> future =
                FirebaseFirestore.getInstance().collection("excercises").whereEqualTo("activityLevel", "None").get();
        while (!future.isComplete()) ;
        CheckBox[] checkBox = new CheckBox[3];
        checkBox[0] = rootView.findViewById(R.id.excercise0);
        checkBox[1] = rootView.findViewById(R.id.excercise1);
        checkBox[2] = rootView.findViewById(R.id.excercise2);
        List<DocumentSnapshot> documents = future.getResult().getDocuments();
        int i = 0;
        for (DocumentSnapshot document : documents) {
            ExcerciseModel data = document.toObject(ExcerciseModel.class);
            checkBox[i].setText(data.getName());
            i++;
        }
        return rootView;
    }
}
