package com.example.anew.squlitedatabasetextinput;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private EditText editText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.tvShow);
        button = (Button) findViewById(R.id.btShow);
        editText= (EditText) findViewById(R.id.EtShow);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpleText();
            }
        });}


    private void simpleText() {
        try {


            InputStream is = this.getResources().openRawResource(R.raw.simpletext);
            byte[] buffer = new byte[is.available()];
            String jsontext=null;
            while (is.read(buffer) != -1) {
                 jsontext = new String(buffer);
            }
            String arr[]=jsontext.split(",");
            String getValue=editText.getText().toString();
            for(String s:arr){
                if(Objects.equals(getValue, s)){
                    textView.setText("yes");
                    break;
                }else{
                    textView.setText("No");
                }
            }



            //textView.setText(jsontext);

        } catch (Exception e) {

            throw new RuntimeException("Error" + e);
        }


    }}


