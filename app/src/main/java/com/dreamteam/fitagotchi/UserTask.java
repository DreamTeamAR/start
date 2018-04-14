package com.dreamteam.fitagotchi;


import android.os.AsyncTask;


public abstract class UserTask extends AsyncTask<Void, Void, Boolean> {

    protected final String mEmail;
    protected final String mPassword;
    protected final LoginActivity mActivity;

    UserTask(String email, String password, LoginActivity activity) {
        mEmail = email;
        mPassword = password;
        mActivity = activity;
    }

    @Override
    protected void onPostExecute(final Boolean success) {
        mActivity.setmAuthTask(null);

        if (success) {
            mActivity.finish();
        } else {
            mActivity.getmPasswordView().setError(mActivity.getString(R.string.error_incorrect_password));
            mActivity.getmPasswordView().requestFocus();
        }
    }

    @Override
    protected void onCancelled() {
        mActivity.setmAuthTask(null);
    }

}
