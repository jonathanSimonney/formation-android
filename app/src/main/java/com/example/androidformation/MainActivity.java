package com.example.androidformation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText toastInput;
    private boolean shouldOpenNextActivity;

    public static final String KEY_MUST_REDIRECT_ON_CLICK = "mustRedirectToNextClick";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.toastInput = findViewById(R.id.toastInput);
        this.shouldOpenNextActivity = false;
        if (savedInstanceState != null){
            this.shouldOpenNextActivity = savedInstanceState.getBoolean(KEY_MUST_REDIRECT_ON_CLICK);
        }
    }

    public void click(View view) {
        String toastContent = toastInput.getText().toString();
        if (this.shouldOpenNextActivity) {
            IntentActivity.startActivity(getApplicationContext(), toastContent);
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
    }
}
