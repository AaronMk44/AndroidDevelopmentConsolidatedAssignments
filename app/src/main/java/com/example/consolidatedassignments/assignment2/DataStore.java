package com.example.consolidatedassignments.assignment2;

import java.util.ArrayList;
import java.util.List;

public class DataStore {
    public static List<Meeting> myMeetings;

    public static void init()
    {
       myMeetings = new ArrayList<Meeting>();
    }
}
