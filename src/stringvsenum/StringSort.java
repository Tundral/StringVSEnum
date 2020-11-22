/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringvsenum;

import java.util.ArrayList;
import java.util.Comparator;

public class StringSort implements Runnable {

    long time;
    ArrayList<String> strings;

    StringSort(ArrayList<String> strings) {
        this.strings = strings;
    }
    
    @Override
    public void run() {

        long startTime = System.nanoTime();
        System.out.println("StringSort thread started.");
        strings.sort(ascending);
        long stopTime = System.nanoTime();
        System.out.print("StringSort thread stopped. Thread time = ");
        time = stopTime - startTime;
        System.out.println(time);
        
    }

    //Comparators
    public static Comparator<String> ascending = new Comparator<String>() {
        @Override
        public int compare(String s1, String s2) {
            int weekcomparison = DayOfPeriod.MapStringToWeek(s1).compareTo(DayOfPeriod.MapStringToWeek(s2));
            if (weekcomparison == 0){
                return DayOfPeriod.MapStringToWeekDay(s1).compareTo(DayOfPeriod.MapStringToWeekDay(s2));
            } else {
                return weekcomparison;
            }
        }
    };

}
