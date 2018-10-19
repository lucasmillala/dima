package it.polimi.deib.deepse.firstapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();

        int length = intent.getIntExtra("data", 0);
        TextView textView = findViewById(R.id.textView1);
        textView.setText(R.string.mystring);
    }
}
