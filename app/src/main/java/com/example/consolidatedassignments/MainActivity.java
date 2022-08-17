package com.example.consolidatedassignments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("");

    }

    public void openAssignments(View v)
    {
        Intent nextActivity = new Intent(this, AssignmentActivity.class);
        startActivity(nextActivity);
    }
}