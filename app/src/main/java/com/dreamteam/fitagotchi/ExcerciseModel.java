package com.dreamteam.fitagotchi;

public class ExcerciseModel
{
    public String getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel(String activityLevel) {
        this.activityLevel = activityLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String activityLevel;
    String name;
    public ExcerciseModel(){}
}
