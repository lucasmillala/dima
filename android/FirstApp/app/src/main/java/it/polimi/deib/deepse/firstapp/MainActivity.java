package it.polimi.deib.deepse.firstapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
    }

    public void pressMe(View input){
        System.out.println("Hello!!!");
        EditText editText = findViewById(R.id.editText1);
        String text = editText.getText().toString();
        TextView textView = findViewById(R.id.textView1);
        textView.setText(""+text.length());
    }
}
