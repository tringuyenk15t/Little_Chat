package com.app.tringuyen.littlechat.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.app.tringuyen.littlechat.R;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

/**
 * Created by Tri Nguyen on 8/11/2016.
 */
public class LoginFragment extends Fragment{
    private CallbackManager callbackManager;
    private AccessTokenTracker tkTracker;
    private ProfileTracker pfTracker;
    private LoginButton loginButton;
    public static final String PARCEL_KEY = "parcel_key";

    private FacebookCallback<LoginResult> callback = new FacebookCallback<LoginResult>() {
        @Override
        public void onSuccess(LoginResult loginResult) {
            Profile profile = Profile.getCurrentProfile();
            handleProfile(profile);
        }

        @Override
        public void onCancel() {

        }

        @Override
        public void onError(FacebookException error) {

        }
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        callbackManager = CallbackManager.Factory.create();
        tkTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {
                //TODO handle access token
            }
        };
        pfTracker = new ProfileTracker() {
            @Override
            protected void onCurrentProfileChanged(Profile oldProfile, Profile currentProfile) {
                handleProfile(currentProfile);
            }
        };
        tkTracker.startTracking();
        pfTracker.startTracking();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_login,container,false);
        loginButton = (LoginButton) v.findViewById(R.id.login_button);
        //loginButton.setReadPermissions("user");
        // If using in a fragment
        loginButton.setFragment(this);
        loginButton.registerCallback(callbackManager, callback);
        return v;
    }

    private void handleProfile(Profile profile)
    {
        if(profile != null)
        {
            Bundle bundle = new Bundle();
            bundle.putParcelable(PARCEL_KEY,profile);
            Toast.makeText(getContext(), profile.getName(),Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onStop() {
        tkTracker.stopTracking();
        pfTracker.stopTracking();
        super.onStop();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode,resultCode,data);
    }
}