package com.example.consolidatedassignments.assignment2;

import java.time.LocalDate;
import java.time.LocalTime;

public class Meeting {
    private String title;
    private String description;
    private String receiverEmail;
    private String meetingType;
    private String meetingLocation;
    private String priority;
    private String date;
    private String time;

    public Meeting() {
        this.title = "";
        this.description = "";
        this.receiverEmail = "";
        this.meetingType = "";
        this.meetingLocation = "";
        this.priority = "";
        this.date = "";
        this.time = "";
    }

    public Meeting(
            String title, String description, String meetingLocation,
            String receiverEmail, String meetingType,
            String priority, String date, String time
    ) {
        this.title = title;
        this.description = description;
        this.receiverEmail = receiverEmail;
        this.meetingType = meetingType;
        this.meetingLocation = meetingLocation;
        this.priority = priority;
        this.date = date;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReceiverEmail() {
        return receiverEmail;
    }

    public void setReceiverEmail(String receiverEmail) {
        this.receiverEmail = receiverEmail;
    }

    public String getMeetingType() {
        return meetingType;
    }

    public void setMeetingType(String meetingType) {
        this.meetingType = meetingType;
    }

    public String getMeetingLocation() {
        return meetingLocation;
    }

    public void setMeetingLocation(String meetingLocation) {
        this.meetingLocation = meetingLocation;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
