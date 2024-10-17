package com.algorithm.practice.arrays.hard;

import java.util.ArrayList;
import java.util.List;

public class CalendarMatching
{
    public static List<StringMeeting> calendarMatching(
            List<StringMeeting> calendar1,
            StringMeeting dailyBounds1,
            List<StringMeeting> calendar2,
            StringMeeting dailyBounds2,
            int meetingDuration
    ) {
        List<Meeting> calendar1InMins = updateCalendar(calendar1, dailyBounds1);
        List<Meeting> calendar2InMins = updateCalendar(calendar2, dailyBounds2);
        List<Meeting> mergedCalendar = mergeCalendar(calendar1InMins, calendar2InMins);
        List<Meeting> flattenCalendar = flattenCalendar(mergedCalendar);
        return getMeetingWindows(flattenCalendar, meetingDuration);
    }

    static List<StringMeeting> getMeetingWindows(List<Meeting> flatCalendar, int meetDuration){
        List<StringMeeting> meetingWindows = new ArrayList<>();
        for(int i=1;i<flatCalendar.size();i++){
            int prevEnd = flatCalendar.get(i-1).end;
            int currentStart = flatCalendar.get(i).start;
            if(currentStart-prevEnd>=meetDuration){
                meetingWindows.add(new StringMeeting(minsToHours(prevEnd), minsToHours(currentStart)));
            }
        }
        return meetingWindows;
    }

    static List<Meeting> updateCalendar(List<StringMeeting> calendar, StringMeeting dailyBounds){
        calendar.add(0, new StringMeeting("0:00", dailyBounds.start));
        calendar.add(new StringMeeting(dailyBounds.end, "23:59"));
        List<Meeting> updatedCalendar = new ArrayList<>();
        for(StringMeeting meeting : calendar){
            updatedCalendar.add(new Meeting(hoursToMins(meeting.start), hoursToMins(meeting.end)));
        }
        return updatedCalendar;
    }

    static List<Meeting> mergeCalendar(List<Meeting> calendar1, List<Meeting> calendar2){
        int i=0, j=0;
        List<Meeting> mergedCalendar = new ArrayList<>();
        while(i<calendar1.size() && j<calendar2.size()){
            if(calendar1.get(i).start < calendar2.get(j).start){
                mergedCalendar.add(calendar1.get(i++));
            }else{
                mergedCalendar.add(calendar2.get(j++));
            }
        }
        while(i<calendar1.size()){
            mergedCalendar.add(calendar1.get(i++));
        }
        while(j<calendar2.size()){
            mergedCalendar.add(calendar2.get(j++));
        }
        return mergedCalendar;
    }

    static List<Meeting> flattenCalendar(List<Meeting> calendar){
        List<Meeting> flatCalendar = new ArrayList<>();
        flatCalendar.add(calendar.get(0));
        for(int i=1;i<calendar.size();i++){
            int prevEnd = flatCalendar.get(flatCalendar.size()-1).end;
            int currentStart = calendar.get(i).start;
            if(currentStart<prevEnd){
                Meeting newPrev = new Meeting(flatCalendar.get(flatCalendar.size()-1).start,
                        Math.max(flatCalendar.get(flatCalendar.size()-1).end, calendar.get(i).end));
                flatCalendar.set(flatCalendar.size()-1, newPrev);
            }else{
                flatCalendar.add(calendar.get(i));
            }
        }
        return flatCalendar;
    }

    static int hoursToMins(String time){
        int delimiterPos = time.indexOf(":");
        int hour = Integer.parseInt(time.substring(0, delimiterPos));
        int mins = Integer.parseInt(time.substring(delimiterPos+1, time.length()));
        return hour*60+mins;
    }

    static String minsToHours(int min){
        int mins = min % 60;
        int hour = min / 60;
        String hourString = Integer.toString(hour);
        String minsString = mins<10 ? "0"+Integer.toString(mins) : Integer.toString(mins);
        return hourString +":"+minsString;
    }

    static class StringMeeting {
        public String start;
        public String end;

        public StringMeeting(String start, String end) {
            this.start = start;
            this.end = end;
        }
    }

    static class Meeting{
        public int start;
        public int end;
        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }


    public static void main(String[] args) {
        StringMeeting slot1 = new StringMeeting("9:00", "10:30");
        StringMeeting slot2 = new StringMeeting("12:00", "13:00");
        StringMeeting slot3 = new StringMeeting("16:00", "18:00");
        StringMeeting slot4 = new StringMeeting("10:00", "11:30");
        StringMeeting slot5 = new StringMeeting("12:30", "14:30");
        StringMeeting slot6 = new StringMeeting("14:30", "15:00");
        StringMeeting slot7 = new StringMeeting("16:00", "17:00");
        StringMeeting dailyBounds1 = new StringMeeting("9:00", "20:00");
        StringMeeting dailyBounds2 = new StringMeeting("10:00", "18:30");

        List<StringMeeting> calendar1 = new ArrayList<>();
        calendar1.add(slot1);
        calendar1.add(slot2);
        calendar1.add(slot3);
        List<StringMeeting> calendar2 = new ArrayList<>();
        calendar2.add(slot4);
        calendar2.add(slot5);
        calendar2.add(slot6);
        calendar2.add(slot7);

        List<StringMeeting> matches = calendarMatching(calendar1, dailyBounds1, calendar2, dailyBounds2, 30);

        for(StringMeeting meet: matches){
            System.out.println(meet.start);
            System.out.println(meet.end);

            System.out.println();
        }
    }
}
