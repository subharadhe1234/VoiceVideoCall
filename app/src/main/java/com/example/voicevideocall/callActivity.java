package com.example.voicevideocall;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import com.zegocloud.uikit.prebuilt.call.invite.widget.ZegoSendCallInvitationButton;
import com.zegocloud.uikit.service.defines.ZegoUIKitUser;

import java.util.Collection;
import java.util.Collections;

public class callActivity extends AppCompatActivity {
EditText userIdEditText;
TextView hayUserTextView;
ZegoSendCallInvitationButton voiceCallBtn,videoCallBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);
        userIdEditText=findViewById(R.id.User_id_edit_text);
        hayUserTextView=findViewById(R.id.hay_user_text_view);
        voiceCallBtn=findViewById(R.id.voice_call_button);
        videoCallBtn=findViewById(R.id.vedio_call_button);
        String UserId=getIntent().getStringExtra("UserId");
        hayUserTextView.setText("hey "+UserId);
        userIdEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String tergetUserid=userIdEditText.getText().toString();
                setVideoCall(tergetUserid);
                setVoiceCall(tergetUserid);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    void  setVoiceCall(String targetUserId){
        voiceCallBtn.setIsVideoCall(false);
        voiceCallBtn.setResourceID("zego_uikit_call");
        voiceCallBtn.setInvitees(Collections.singletonList(new ZegoUIKitUser(targetUserId)));
    }
    void  setVideoCall(String targetUserId){
        videoCallBtn.setIsVideoCall(true);
        videoCallBtn.setResourceID("zego_uikit_call");
        videoCallBtn.setInvitees(Collections.singletonList(new ZegoUIKitUser(targetUserId)));

    }
}