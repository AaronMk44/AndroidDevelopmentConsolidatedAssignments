package com.example.consolidatedassignments.assignment2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.consolidatedassignments.R;
import com.google.android.material.textfield.TextInputEditText;

public class CreateMeeting extends AppCompatActivity {

    TextInputEditText title;
    TextInputEditText description;
    TextInputEditText receiverEmail;
    TextInputEditText meetingLocation;
    Spinner mySpinner;
    TimePickerDialog myTime;
    DatePickerDialog myDate;
    Button pickTime;
    Button pickDate;
    Button priority;
    TextView timeLabel;
    TextView dateLabel;
    TextView priorityLabel;
    Meeting meeting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_meeting);

        meeting = new Meeting();

        title = findViewById(R.id.title_fld);
        description = findViewById(R.id.description_fld);
        receiverEmail = findViewById(R.id.receiver_email_fld);
        meetingLocation = findViewById(R.id.meeting_location_fld);

        mySpinner = findViewById(R.id.meeting_type);
        ArrayAdapter<CharSequence> a = ArrayAdapter.createFromResource(
                this,
                R.array.meeting_types,
                android.R.layout.simple_spinner_item);
        a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mySpinner.setAdapter(a);
        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                meeting.setMeetingType(adapterView.getItemAtPosition(i).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        timeLabel = findViewById(R.id.time_label);
        dateLabel = findViewById(R.id.date_label);

        pickTime = findViewById(R.id.pick_time_btn);
        pickTime.setOnClickListener(v -> {
            myTime = new TimePickerDialog(this, (timePicker, h, m) -> {
                timeLabel.setText("" + h + " : "+ m + " hrs");
                meeting.setTime("" + h + " : "+ m + " hrs");
            }, 0, 0, true);
            myTime.show();
        });

        pickDate = findViewById(R.id.pick_date_btn);
        pickDate.setOnClickListener(v -> {
            myDate = new DatePickerDialog(this, (datePicker, y, m, d) -> {
                dateLabel.setText("" + d + "/" + m + "/" + y);
                meeting.setDate("" + d + "/" + m + "/" + y);
            }, 2020,7,4);
            myDate.show();
        });

        priority = findViewById(R.id.priority_btn);
        priorityLabel = findViewById(R.id.priority_label);
        registerForContextMenu(priority);

        getSupportActionBar().setTitle("Meeting Inviter");
        getSupportActionBar().setSubtitle("Fill out the form and invite");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                break;
            default:break;
        }
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        super.onContextItemSelected(item);
        switch (item.getItemId())
        {
            case R.id.low:
                meeting.setPriority("Low");
                priorityLabel.setText("Priority: Low");
                break;
            case R.id.medium:
                meeting.setPriority("Medium");
                priorityLabel.setText("Priority: Medium");
                break;
            case R.id.high:
                meeting.setPriority("High");
                priorityLabel.setText("Priority: High");
                break;
            default:break;
        }
        return true;
    }

    public void sendInvite(View v)
    {
        meeting.setTitle(title.getText().toString());
        meeting.setDescription(description.getText().toString());
        meeting.setReceiverEmail(receiverEmail.getText().toString());
        meeting.setMeetingLocation(meetingLocation.getText().toString());

        Intent sendMail = new Intent(Intent.ACTION_SEND);
        sendMail.putExtra(Intent.EXTRA_EMAIL, new String[]{meeting.getReceiverEmail()});
        sendMail.putExtra(Intent.EXTRA_SUBJECT, meeting.getTitle());
        sendMail.putExtra(Intent.EXTRA_TEXT, "" +
                "Hi, \n" +
                "You have been invited to attend a(n) " + meeting.getMeetingType() + " meeting " +
                "on " + meeting.getDate() + " at " + meeting.getTime() + ". \n\n" +
                "Since the Meeting will be " + meeting.getMeetingType() + ", use the address (link) " +
                "below: \n\n" + meeting.getMeetingLocation() + " \n\n" +
                "Meeting Description: \n" + meeting.getDescription());

        sendMail.setType("message/rfc822");
        startActivity(Intent.createChooser(sendMail,"Choose an Email client :"));
    }
}