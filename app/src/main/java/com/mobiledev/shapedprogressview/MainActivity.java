package com.mobiledev.shapedprogressview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
private Button squareButton, circleButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        squareButton = (Button)findViewById(R.id.SquareProgress);
        circleButton = (Button)findViewById(R.id.CircleProgress);
        squareButton.setOnClickListener(this);
        circleButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.SquareProgress)
        {
            Intent intentSquare = new Intent(MainActivity.this, SquareProgressActivity.class);
            startActivity(intentSquare);
        }
        else if(view.getId() == R.id.CircleProgress)
        {


        }
    }
}
