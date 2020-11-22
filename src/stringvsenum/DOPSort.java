/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringvsenum;

import java.util.ArrayList;

public class DOPSort implements Runnable {

    long time;
    ArrayList<DayOfPeriod> dops;

    DOPSort(ArrayList<DayOfPeriod> dops) {
        this.dops = dops;
    }

    @Override
    public void run() {
        long startTime = System.nanoTime();
        System.out.println("DOPSort thread started.");
        dops.sort(DayOfPeriod.ascending);
        long stopTime = System.nanoTime();
        System.out.print("DOPSort thread stopped. Thread time = ");
        time = stopTime - startTime;
        System.out.println(time);
    }

}
