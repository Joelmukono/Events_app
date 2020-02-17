package com.joel.events.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.joel.events.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG  = MainActivity.class.getSimpleName();



    @BindView(R.id.openAddEventsButton) Button mOpenEventsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mOpenEventsButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        if(v == mOpenEventsButton){
            Intent intent = new Intent(MainActivity.this, AddEvents.class);
            startActivity(intent);
        }
    }


}
