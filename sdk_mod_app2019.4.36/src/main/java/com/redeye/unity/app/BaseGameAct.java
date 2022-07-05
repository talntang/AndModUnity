package com.redeye.unity.app;

import android.os.Bundle;
import com.unity3d.player.UnityPlayer;
import com.unity3d.player.UnityPlayerActivity;

public abstract class BaseGameAct extends UnityPlayerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RedEyeBridge.OnCreate(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        BaseApp.instance().sdk.OnResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        BaseApp.instance().sdk.OnPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        BaseApp.instance().sdk.OnStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        BaseApp.instance().sdk.OnRestart();
    }

    public void SendMsgToUnity(final String method, final String obj) {
        UnityPlayer.UnitySendMessage("RedEye", method, obj == null ? "" : obj);
    }


}
