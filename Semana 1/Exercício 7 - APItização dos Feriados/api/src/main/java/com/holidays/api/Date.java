package com.holidays.api;

public class Date {
    private String day;
    private String month;
    private String year;
    private boolean isHoliday;
    private String holidayName;

    public Date(){}

    public Date(String fullDate){}

    Date(String fullDate, boolean isHoliday){
        this.day = fullDate.substring(0,2);
        this.month = fullDate.substring(3, 5);
        this.year = fullDate.substring(6, 10);
        this.isHoliday = isHoliday;
    }
    public Date(String fullDate, boolean isHoliday, String holidayName){
        this.day = fullDate.substring(0,2);
        this.month = fullDate.substring(3,5);
        this.year = fullDate.substring(6,10);
        this.isHoliday = isHoliday;
        this.holidayName = holidayName;
    }

    public Date(String day, String month, String year, boolean isHoliday){
        this.day = day;
        this.month = month;
        this.year = year;
        this.isHoliday = isHoliday;
    }
    public Date(String day, String month, String year, boolean isHoliday, String holidayName){
        this.day = day;
        this.month = month;
        this.year = year;
        this.isHoliday = isHoliday;
        this.holidayName = holidayName;
    }

    public String getDate(){
        return (this.day + "-" + this.month + "-" + this.year);
    }    

    public String getFullDate(){
        if (this.isHoliday){
            return (this.day + "-" + this.month + "-" + this.year + " => " + this.holidayName);
        }
        else {
            return (this.day + "-" + this.month + "-" + this.year);
        }        
    }

    public String setDate(String fullDate, boolean isHoliday, String holidayName){

        String result = "";
        if(fullDate.length() == 10){
            int day = Integer.parseInt(fullDate.substring(0,2));
            int month = Integer.parseInt(fullDate.substring(3,5));
            int year = Integer.parseInt(fullDate.substring(6,10));

            if(day >= 1 && day <= 31 && month >= 1 && month <= 12 && year >= 1){
                if(month == 2 && day > 29){
                    return "Invalid date!";
                }
                else if ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30){
                    return "Invalid date!";
                }
                else {
                    this.day = String.valueOf(day);
                    this.month = String.valueOf(month);
                    this.year = String.valueOf(year);
                    this.isHoliday = isHoliday;
                    if (isHoliday){
                        this.holidayName = holidayName;
                        result = (fullDate + " => " + holidayName);
                    }
                    else {
                        result = (fullDate);
                    }
                }
            }
        }
        else {
            return "Invalid date!";
        }
        return result;
    }
}
