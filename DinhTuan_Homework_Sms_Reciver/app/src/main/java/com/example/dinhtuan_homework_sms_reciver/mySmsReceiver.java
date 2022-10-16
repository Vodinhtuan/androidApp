package com.example.dinhtuan_homework_sms_reciver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class mySmsReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        //throw new UnsupportedOperationException("Not yet implemented");
        processSms(context, intent);
    }

    private void processSms(Context context, Intent intent) {
        Bundle myBundle = intent.getExtras();
        String messgage ="";
        String body = "";
        String address = "";
        if (myBundle != null){
            Object[] mySms = (Object[]) myBundle.get("pdus");
            for (int i = 0; i<mySms.length; i++){
                SmsMessage sms = SmsMessage.createFromPdu((byte[]) mySms[i]);
                body += sms.getMessageBody();   // lay noi dung tin nhan
                address = sms.getOriginatingAddress();   // lay so dien thoai
            }
            messgage = "Co mot tin nhan den tu " + address + "\n" + body + " vua gui den";
            Toast.makeText(context, messgage,Toast.LENGTH_LONG).show();
        }
    }
}