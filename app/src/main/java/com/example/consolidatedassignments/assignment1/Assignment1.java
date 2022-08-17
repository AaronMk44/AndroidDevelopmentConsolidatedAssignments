package com.example.consolidatedassignments.assignment1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.consolidatedassignments.R;

public class Assignment1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment1);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void openQuestion1(View v){
        Intent nextActivity = new Intent(this, Assignment1Q1.class);
        startActivity(nextActivity);
    }

    public void openQuestion2(View v){
        Intent nextActivity = new Intent(this, Assignment1Q2.class);
        startActivity(nextActivity);
    }
}