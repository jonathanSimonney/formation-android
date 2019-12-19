package com.example.androidformation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText toastInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.toastInput = findViewById(R.id.toastInput);
    }

    public void click(View view) {
        switch (view.getId()){
            case R.id.buttonToast:
                showToast();
        }
    }

    private void showToast() {
        Toast toast = Toast.makeText(getApplicationContext(), toastInput.getText(), Toast.LENGTH_LONG);
        toast.show();
    }
}
