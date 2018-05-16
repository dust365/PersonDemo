package com.example.dust.persondemo.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dust.persondemo.R;

/**
 * Created by dust on 2017/10/27.
 */

public class VoiceDialog extends Dialog {

    private  Context mContext;


    private static final String TAG = VoiceDialog.class.getSimpleName();
    private TextView testView;


    public VoiceDialog(@NonNull Context context) {

        super(context);
        this.mContext=context;
    }

    public VoiceDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected VoiceDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }



    @Override
    public void create() {
        super.create();
        Log.e(TAG, "create: " );
    }

    @Override
    public void show() {
        super.show();

        Log.e(TAG, "show: " );
    }

    @Override
    public void hide() {
        super.hide();

        Log.e(TAG, "hide: " );
    }

    @Override
    public void dismiss() {
        super.dismiss();

        Log.e(TAG, "dismiss: " );
    }

    public void  setMessage(String msg){

        if (testView!=null){

            testView.setText(msg);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_voice_dialog);
         testView = findViewById(R.id.tv_test);

        testView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Toast.makeText(mContext, "fsfsfsd", Toast.LENGTH_SHORT).show();

            }
        });


        Log.e(TAG, "onCreate: " );
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.e(TAG, "onStart: " );
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.e(TAG, "onStop: " );
    }

    @NonNull
    @Override
    public Bundle onSaveInstanceState() {
        Log.e(TAG, "onSaveInstanceState: ");
        return super.onSaveInstanceState();

    }

    @Override
    public void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        Log.e(TAG, "onRestoreInstanceState: " );
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public boolean onKeyDown(int keyCode, @NonNull KeyEvent event) {
        Log.e(TAG, "onKeyDown: " );
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyLongPress(int keyCode, @NonNull KeyEvent event) {
        Log.e(TAG, "onKeyLongPress: " );
        return super.onKeyLongPress(keyCode, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, @NonNull KeyEvent event) {
        Log.e(TAG, "onKeyUp: " );
        return super.onKeyUp(keyCode, event);
    }

    @Override
    public boolean onKeyMultiple(int keyCode, int repeatCount, @NonNull KeyEvent event) {
        return super.onKeyMultiple(keyCode, repeatCount, event);
    }

    @Override
    public void onBackPressed() {
        Log.e(TAG, "onBackPressed: " );
        super.onBackPressed();
    }

    @Override
    public void onContentChanged() {
        Log.e(TAG, "onContentChanged: " );
        super.onContentChanged();
    }

    @Override
    public void cancel() {
        super.cancel();

        Log.e(TAG, "cancel: " );
    }


    //
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//
//        setContentView(R.layout.activity_voice_dialog);
//
//
//
//    }
}
