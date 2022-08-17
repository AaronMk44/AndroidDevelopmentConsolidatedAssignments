package com.example.consolidatedassignments;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.consolidatedassignments.assignment1.Assignment1;
import com.example.consolidatedassignments.assignment2.Assignment2;

public class AssignmentActivity extends AppCompatActivity {

    String[] maintitle = {
            "Assignment 1","Assignment 2",
            "Assignment 3","Assignment 4",
            "Assignment 5","Assignment 6",
    };

    String[] subtitle = {
            "Layouts and Widgets","Advanced Widgets | Meeting Inviter App",
            "Coming Soon...","Coming Soon...",
            "Coming Soon...","Coming Soon..."
    };

    Integer[] imgid = {
            R.drawable.img_1,R.drawable.img_2,
            R.drawable.img_3,R.drawable.img_4,
            R.drawable.img_5,R.drawable.img_6
    };

    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment);

        CustomListAdapter adapter = new CustomListAdapter(this, maintitle, subtitle, imgid);
        list = findViewById(R.id.list);
        list.setAdapter(adapter);

        list.setOnItemClickListener((parent, view, position, id) -> {
            openAssignmentAt(position);
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Assignments");
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

    private void openAssignmentAt(int position)
    {
        Intent nextActivity;
        switch (position)
        {
            case 0:
                nextActivity = new Intent(this, Assignment1.class);
                startActivity(nextActivity);
                break;
            case 1:
                nextActivity = new Intent(this, Assignment2.class);
                startActivity(nextActivity);
                break;
            default:
                break;
        }
    }
}