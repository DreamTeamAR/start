package com.dreamteam.fitagotchi;

import android.animation.ObjectAnimator;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class PetFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.pet_fragment, container, false);



        ImageView view = rootView.findViewById(R.id.petImage);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ScaleAnimation scaleDownX = new ScaleAnimation(
                        1f, 0.5f, // Start and end values for the X axis scaling
                        1.0f, 0.5f, // Start and end values for the Y axis scaling
                        Animation.RELATIVE_TO_SELF, 0.5f, // Pivot point of X scaling
                        Animation.RELATIVE_TO_SELF, 0.5f); // Pivot point of Y scaling
                ScaleAnimation scaleUp = new ScaleAnimation(
                        1.0f, 2.0f, // Start and end values for the X axis scaling
                        1.0f, 2.0f, // Start and end values for the Y axis scaling
                        Animation.RELATIVE_TO_SELF, 0.5f, // Pivot point of X scaling
                        Animation.RELATIVE_TO_SELF, 0.5f); // Pivot point of Y scaling
                ObjectAnimator scaleDownY = ObjectAnimator.ofFloat(view, "scaleY", 0.5f);
                scaleDownY.setDuration(1000);
                scaleUp.setRepeatCount(4);
                AnimationSet scaleDown = new AnimationSet(true);
                scaleDownX.setRepeatCount(4);
                scaleDown.addAnimation(scaleDownX);
                scaleDown.addAnimation(scaleUp);
                scaleDown.setDuration(500);
                view.startAnimation(scaleDown);
            }
        });
        Button waterAdd = rootView.findViewById(R.id.waterAdd);
        ProgressBar bar = rootView.findViewById(R.id.waterProgress);


        return rootView;
    }



}
