package com.example.lostphonetracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RadioButton rdoFirst, rdoSecond, rdoThird;
    ImageView imgPhoto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rdoFirst= findViewById(R.id.rdoFirst);
        rdoSecond= findViewById(R.id.rdoSecond);
        rdoThird = findViewById(R.id.rdoThird);

        imgPhoto = findViewById(R.id.imgPhoto);


        rdoFirst.setOnClickListener(this);
        rdoSecond.setOnClickListener(this);
        rdoThird.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rdoFirst:
                imgPhoto.setImageResource(R.drawable.donaldduck);
                break;

            case R.id.rdoSecond:
                imgPhoto.setImageResource(R.drawable.mickey);
                break;

            case R.id.rdoThird:
                imgPhoto.setImageResource(R.drawable.tomandjerry);
                break;
        }

    }
}
