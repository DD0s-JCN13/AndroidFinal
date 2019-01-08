package com.fju.guess;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView guesser;
    TextView tester;
    TextView information;
    int max =100;
    int min =1;
    Random r = new Random();
    int counter = 0;
    public final int set = r.nextInt(100)+1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findview();
        tester.setText(set+"");
    }

    public void findview(){
        guesser = findViewById(R.id.number);
        tester = findViewById(R.id.secret);
        information = findViewById(R.id.info);
    }
    public void send(View v){
        int input = Integer.parseInt(guesser.getText().toString());
        if(input<set){
            counter++;
            min = input;
            /*new AlertDialog.Builder(this)
                    .setTitle("HINT")
                    .setMessage(input+" to 100")
                    .setPositiveButton("OK",null)
                    .show();*/
            information.setText("Please enter a number ("+min+"-"+max+")");
        }else if(input>set){
            counter++;
            max = input;
            /*
            new AlertDialog.Builder(this)
                    .setTitle("HINT")
                    .setMessage("1 to "+input)
                    .setPositiveButton("OK",null)
                    .show();*/
            information.setText("Please enter a number ("+min+"-"+max+")");
        }else{
            if(counter<=3){
                Intent intent = new Intent(this,ExcellentActivity.class);
                startActivity(intent);
            }else {
                new AlertDialog.Builder(this)
                        .setTitle("Congratulation")
                        .setMessage("Yes, the number is " + input)
                        .setPositiveButton("OK", null)
                        .show();
            }
        }
    }
}
