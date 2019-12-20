package com.example.androidformation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class IntentActivity extends AppCompatActivity {
    public static void startActivity(Context context, String text){
        Intent intent = new Intent(context, IntentActivity.class);
        intent.putExtra(Intent.EXTRA_TEXT, text);
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
