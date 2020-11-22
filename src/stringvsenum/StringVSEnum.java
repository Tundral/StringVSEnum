/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringvsenum;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

public class StringVSEnum {

    public static void main(String[] args) throws InterruptedException {


        //Create lists for strings and the DayOFPeriod objects
        ArrayList<String> strings = new ArrayList<String>();
        ArrayList<DayOfPeriod> dops = new ArrayList<DayOfPeriod>();


        //Generate 'rounds' amount of objects with random fields
        int rounds = 12;
        System.out.println("Generating " + rounds + " objects");

        //Variables used in the loop

        int day; //Day from 1-7 (mon - sun)
        String stringday; //and resulting string representation

        int week; //Week from 1-3 (first - last week of three week period)
        String stringweek; //and resulting string representation

        for (int i = 0; i < rounds; i++) {
            //Generate random int representations of days and weeks
            day = getRandomNumberInRange(1, 7);
            week = getRandomNumberInRange(1, 3);

            //'Reset' string values
            stringday = null;
            stringweek = null;

            //Set string values in swtiches according to generated integers
            switch (day) {
                case 1:
                    stringday = "ma";
                    break;
                case 2:
                    stringday = "ti";
                    break;
                case 3:
                    stringday = "ke";
                    break;
                case 4:
                    stringday = "to";
                    break;
                case 5:
                    stringday = "pe";
                    break;
                case 6:
                    stringday = "la";
                    break;
                case 7:
                    stringday = "su";
                    break;
            }
            switch (week) {
                case 1:
                    stringweek = "1";
                    break;
                case 2:
                    stringweek = "2";
                    break;
                case 3:
                    stringweek = "3";
                    break;
            }

            //Add appropriate objects to the ArrayLists
            strings.add(stringday + stringweek);
            dops.add(new DayOfPeriod(stringday + stringweek));

        }

        System.out.println("Generating complete");

        //Create StringSort and DOPSort objects which implement runnable to sort the lists in their own threads
        StringSort stringsort = new StringSort(strings);
        DOPSort dopsort = new DOPSort(dops);

        //Run threads with above objects
        new Thread(stringsort).start();
        new Thread(dopsort).start();


        //Wait till both threads are done and thus have field variable time set to something other than zero
        while (dopsort.time == 0 || stringsort.time == 0) {
            Thread.sleep(500);
        }

        //Print out results for the user in a nice format!
        System.out.print("StringSort lasted ");
        double difference = (double) stringsort.time / (double) dopsort.time;
        DecimalFormat df = new DecimalFormat("#.###");
        df.setRoundingMode(RoundingMode.CEILING);
        System.out.print(df.format(difference));
        System.out.println("x the time DOPSort lasted");


        /*PrintFirstLastFive printFirstLastFive = new PrintFirstLastFive() {
            @Override
            public void print(ArrayList list) {
                for (Object o : list) {
                    int index = list.indexOf(o);
                    if (index < 5 || index > (list.size() -6)){
                        System.out.println(o);
                    }
                }
            }
        };


        printFirstLastFive.print(strings);
        System.out.println("===================================");
        printFirstLastFive.print(dops);

         */
    }

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

}
