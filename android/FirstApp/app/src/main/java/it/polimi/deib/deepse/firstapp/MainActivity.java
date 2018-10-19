package it.polimi.deib.deepse.firstapp;

import android.app.Activity;
import android.content.Intent;
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

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("data", text.length());
        startActivity(intent);

    }
}
