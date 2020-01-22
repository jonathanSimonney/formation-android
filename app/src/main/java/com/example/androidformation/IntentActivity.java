package com.example.androidformation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class IntentActivity extends AppCompatActivity {
    public static final String KEY_INTENT_USER_INPUT_LIST = "listUserInput";

    public static void startActivity(Context context, String text, ArrayList<String> userInputList){
        Intent intent = new Intent(context, IntentActivity.class);
        intent.putExtra(Intent.EXTRA_TEXT, text);
        intent.putExtra(KEY_INTENT_USER_INPUT_LIST, userInputList);
        context.startActivity(intent);
    }

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        this.textView = findViewById(R.id.precedent_input_text);

        Bundle extras = getIntent().getExtras();
        if(extras != null && extras.containsKey(Intent.EXTRA_TEXT)) {
            String inputString = extras.getString(Intent.EXTRA_TEXT);
            this.textView.setText(inputString);
        }
    }
}
