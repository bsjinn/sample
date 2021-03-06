//MINKYEONG
package org.androidtown.wall;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class MainActivity extends AppCompatActivity {

    CallbackManager callbackManager;
    @Override
    protected void onCreate(Bundle savedInstanceState)
{
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_main);

        callbackManager = CallbackManager.Factory.create();
        LoginButton facebookLoginButton = (LoginButton) findViewById(R.id.facebook_login_button);
        facebookLoginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>(){
            @Override
            public void onSuccess(LoginResult loginResult){
                Toast.makeText(getApplicationContext(),"로그인 성공", Toast.LENGTH_LONG).show();
            }
            @Override
            public void onCancel(){
                Toast.makeText(getApplicationContext(),"로그인 취소",Toast.LENGTH_LONG).show();
            }
            @Override
            public void onError(FacebookException error){
                Toast.makeText(getApplicationContext(),"로그인 에러", Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

}