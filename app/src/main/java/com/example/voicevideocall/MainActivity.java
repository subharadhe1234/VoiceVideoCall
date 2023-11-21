package com.example.voicevideocall;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.zegocloud.uikit.prebuilt.call.config.ZegoNotificationConfig;
import com.zegocloud.uikit.prebuilt.call.invite.ZegoUIKitPrebuiltCallInvitationConfig;
import com.zegocloud.uikit.prebuilt.call.invite.ZegoUIKitPrebuiltCallInvitationService;


public class MainActivity extends AppCompatActivity {
EditText userIdEdit;
Button startBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userIdEdit=findViewById(R.id.User_id_edit_text);
        startBtn=findViewById(R.id.start_btn);
        startBtn.setOnClickListener(v -> {
            String UserId=userIdEdit.getText().toString().trim();
            if (UserId.isEmpty()){
                return;
            }
        startService(UserId);
        });
    }
    void startService(String UserId){
        Application application =getApplication() ; // Android's application context
        long appID = 1611539622;   // yourAppID
        String appSign ="31f656bc8995ecfd38aa2ad62a40e533d2b14214a9329930512ef9dce350f58e";  // yourAppSign
      // yourUserID, userID should only contain numbers, English characters, and '_'.
        String userName =UserId;   // yourUserName

        ZegoUIKitPrebuiltCallInvitationConfig callInvitationConfig = new ZegoUIKitPrebuiltCallInvitationConfig();
        callInvitationConfig.notifyWhenAppRunningInBackgroundOrQuit = true;
        ZegoNotificationConfig notificationConfig = new ZegoNotificationConfig();
        notificationConfig.sound = "zego_uikit_sound_call";
        notificationConfig.channelID = "CallInvitation";
        notificationConfig.channelName = "CallInvitation";
        ZegoUIKitPrebuiltCallInvitationService.init(getApplication(), appID, appSign, UserId, userName,callInvitationConfig);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    ZegoUIKitPrebuiltCallInvitationService.unInit();
    }
}