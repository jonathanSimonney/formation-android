package com.example.androidformation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText toastInput;
    private boolean shouldOpenNextActivity;
    private ArrayList<String> listUserInput;

    public static final String KEY_MUST_REDIRECT_ON_CLICK = "mustRedirectToNextClick";
    public static final String KEY_USER_INPUT_LIST = "listUserInput";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.toastInput = findViewById(R.id.toastInput);
        this.shouldOpenNextActivity = false;
        this.listUserInput = new ArrayList<>();
    }

    public void click(View view) {
        String toastContent = toastInput.getText().toString();
        this.listUserInput.add(toastContent);
        if (this.shouldOpenNextActivity) {
            IntentActivity.startActivity(getApplicationContext(), toastContent, this.listUserInput);
        }else{
            if (toastContent.equals("intent")) {
                this.shouldOpenNextActivity = true;
            } else {
                showToast(toastContent);
            }
        }
    }

    private void showToast(String toastContent) {
        Toast toast = Toast.makeText(getApplicationContext(), toastContent, Toast.LENGTH_LONG);
        toast.show();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putBoolean(KEY_MUST_REDIRECT_ON_CLICK, this.shouldOpenNextActivity);
        outState.putStringArrayList(KEY_USER_INPUT_LIST, this.listUserInput);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle inState){
        this.shouldOpenNextActivity = inState.getBoolean(KEY_MUST_REDIRECT_ON_CLICK);
        this.listUserInput = inState.getStringArrayList(KEY_USER_INPUT_LIST);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        this.listUserInput = new ArrayList<>();
    }
}
