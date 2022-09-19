package com.hifly.paasdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceView;

import com.hst.fsp.FspEngine;
import com.hst.fsp.IFspEngineEventHandler;

public class MainActivity extends AppCompatActivity {
    private FspEngine fspEngine = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paas);
        final SurfaceView surfaceView = findViewById(R.id.surfaceview);

        fspEngine = FspEngine.create(this, "116ed6e8e832da31d867d00a3f5073f9", null, new IFspEngineEventHandler() {
            @Override
            public void onLoginResult(int i) {
                Log.e("PaasDemo", "onLoginResult " + i);
                fspEngine.joinGroup("g_123456");
            }

            @Override
            public void onJoinGroupResult(int i) {
                Log.e("PaasDemo", "onJoinGroupResult " + i);
                fspEngine.startPreviewVideo(surfaceView);
            }

            @Override
            public void onLeaveGroupResult(int i) {

            }

            @Override
            public void onFspEvent(int i, int i1) {
            }

            @Override
            public void onRemoteVideoEvent(String s, String s1, int i) {

            }

            @Override
            public void onRemoteAudioEvent(String s, String s1, int i) {

            }

            @Override
            public void onGroupUsersRefreshed(String[] strings) {

            }

            @Override
            public void onRemoteUserEvent(String s, int i) {

            }
        });

        FspToken tokenBuilder = new FspToken();
        tokenBuilder.setAppId("116ed6e8e832da31d867d00a3f5073f9");
        tokenBuilder.setSecretKey("f5277fff568047aa");
        tokenBuilder.setGroupId("g_123456");
        tokenBuilder.setUserId("u_123456");
        String token = tokenBuilder.build();

        fspEngine.init();
        fspEngine.login(token, "u_123456", true, "zhoubing");
    }
}