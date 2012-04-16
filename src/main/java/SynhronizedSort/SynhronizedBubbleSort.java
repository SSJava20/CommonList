/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SynhronizedSort;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jeka
 */
public class SynhronizedBubbleSort<ToCompare extends Comparable<ToCompare>> extends SynhronizedSort<ToCompare> {

    private void swap(ToCompare[] arr, int i, int j) {
        ToCompare t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    private void bubblesort(ToCompare[] arr) throws InterruptedException, BrokenBarrierException {
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j].compareTo(arr[j + 1]) == 1) {
                        //Synhronized value
                        gate.await();
                        //
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public void run() {
        try {
            bubblesort(data);
            while (true) {
                gate.await();
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } catch (BrokenBarrierException ex) {
            ex.printStackTrace();
        }
    }
}
