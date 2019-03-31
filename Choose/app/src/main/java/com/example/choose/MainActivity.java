package com.example.choose;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;




public class MainActivity extends AppCompatActivity {
    //making variables
    private Button btnFirNum, btnSecNum, btnRestart;
    private TextView tvScore, tvFinal, tvResult;
    private int score =0, points_won =0, points_loss =0, total_clicked = 0;
    private int random_int1, random_int2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//linking the variables with resource

        btnFirNum = findViewById(R.id.btnFirNum);
        btnSecNum = findViewById(R.id.btnSecNum);
        btnRestart= findViewById(R.id.btnRestart);

        tvScore = findViewById(R.id.tvScore);
        tvFinal= findViewById(R.id.tvWoL);
        tvResult= findViewById(R.id.tvResult);
        randomGen();
        assignValue();

        //check if random values match or not
        if (random_int1 == random_int2){
            randomGen();
            assignValue();

        }

        tvScore.setText(Integer.toString(score));



        //when clicking first button

        btnFirNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (random_int1 > random_int2){
                    score = score +1;
                    points_won = points_won +1;
                    total_clicked = total_clicked +1;

                    tvScore.setText(Integer.toString(score));



                    randomGen();
                    assignValue();
                    check(points_won, points_loss, total_clicked);


                }

                else if (random_int2 > random_int1){
                    score = score -1;
                    points_loss = points_loss +1;
                    total_clicked = total_clicked +1;

                    tvScore.setText(Integer.toString(score));

                    randomGen();
                    assignValue();
                    check(points_won, points_loss, total_clicked);
                    return;

                }


            }
        });

        //when clicking second button

        btnSecNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (random_int2 > random_int1){
                    score = score +1;
                    points_won = points_won +1;
                    total_clicked = total_clicked +1;

                    tvScore.setText(Integer.toString(score));



                    randomGen();
                    assignValue();
                    check(points_won, points_loss, total_clicked);
                    return;

                }
                else if (random_int1 > random_int2){
                    score = score -1;
                    points_loss = points_loss +1;
                    total_clicked = total_clicked +1;

                    tvScore.setText(Integer.toString(score));

                    randomGen();
                    assignValue();
                    check(points_won, points_loss, total_clicked);
                    return;

                }


            }
        });

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                randomGen();
                assignValue();
                btnFirNum.setEnabled(true);
                btnSecNum.setEnabled(true);
                score =0;
                points_won =0;
                points_loss =0;
                total_clicked =0;

                tvFinal.setText(" ");
                tvScore.setText(Integer.toString(score));
                tvResult.setText(" ");
                return;
            }
        });
    }
    // generate random numbers
    private void randomGen(){
        Random rand = new Random();
        random_int1 = rand.nextInt(101);
        random_int2 = rand.nextInt(101);
        // check if random numbers are same

        if (random_int1==random_int2){
            randomGen();
        }
    }
    //assign those values

    private void assignValue(){
        btnFirNum.setText(Integer.toString(random_int1));
        btnSecNum.setText(Integer.toString(random_int2));
    }
    // making buttons not work
    private void cancel(){
        btnFirNum.setEnabled(false);
        btnSecNum.setEnabled(false);
        return;

    }
    // checking to see if score is 10 or -10
    private void check(int points_won, int points_loss, int total_clicked){
        if(score ==10){
            tvFinal.setText("Congrats, You Win!!!!");
            tvResult.setText("Win= "+points_won+" Loss= "+points_loss+" Total Clicked= "+total_clicked);
            cancel();
        }

        else if (score ==-10){
            tvFinal.setText("Sorry, You Lost!!!");
            cancel();
        }
    }


}
