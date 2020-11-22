/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringvsenum;

import java.util.Comparator;

/**
 *
 * @author Tundral
 */
public class DayOfPeriod {
    
    //Field Variables
    private Weekday weekday;
    private Week periodweek;
    
    //Contructors
    public DayOfPeriod(String dayWeek){

        String day = dayWeek.substring(0, 2);

        char week = dayWeek.charAt(2);
        
        switch(day){
            case "ma":
                weekday = Weekday.MONDAY;
                break;
            case "ti":
                weekday = Weekday.TUESDAY;
                break;
            case "ke":
                weekday = Weekday.WEDNESDAY;
                break;
            case "to":
                weekday = Weekday.THURSDAY;
                break;
            case "pe":
                weekday = Weekday.FRIDAY;
                break;
            case "la":
                weekday = Weekday.SATRUDAY;
                break;
            case "su":
                weekday = Weekday.SUNDAY;
                break;
        }
        switch(week){
            case '1':
                periodweek = Week.ONE;
                break;
            case '2':
                periodweek = Week.TWO;
                break;
            case '3':
                periodweek = Week.THREE;
                break;
        }
    
    }

    //Methods

    public static Weekday MapStringToWeekDay(String string){
        switch (string.substring(0,2)) {
            case "ma":
                return Weekday.MONDAY;
            case "ti":
                return Weekday.TUESDAY;
            case "ke":
                return Weekday.WEDNESDAY;
            case "to":
                return Weekday.THURSDAY;
            case "pe":
                return Weekday.FRIDAY;
            case "la":
                return Weekday.SATRUDAY;
            case "su":
                return Weekday.SUNDAY;
            default:
                throw new IllegalArgumentException("String must represent weekday by first two letters in lower case");
        }
    }

    public static Week MapStringToWeek(String string){
        switch (string.charAt(2)) {
            case '1':
                return Week.ONE;
            case '2':
                return Week.TWO;
            case '3':
                return Week.THREE;
            default:
                throw new IllegalArgumentException("String must represent week by single digit from 1 to 3");
        }
    }

    @Override
    public String toString() {
        return "DayOfPeriod{" +
                "weekday=" + weekday +
                ", periodweek=" + periodweek +
                '}';
    }

    //Static elements
    public enum Weekday{
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATRUDAY,
        SUNDAY;
    }
    public enum Week{
        ONE,
        TWO,
        THREE;
    }
    
    //Comparators
    public static Comparator<DayOfPeriod> ascending = new Comparator<DayOfPeriod>() {
        @Override
        public int compare(DayOfPeriod o1, DayOfPeriod o2) {
            int weekcomparison = o1.periodweek.compareTo(o2.periodweek);
            if (weekcomparison == 0) {
                return o1.weekday.compareTo(o2.weekday);
            }
            else{
                return weekcomparison;
            }
        }
    };
    
}


