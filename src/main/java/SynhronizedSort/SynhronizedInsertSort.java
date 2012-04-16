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
public class SynhronizedInsertSort<ToCompare extends Comparable<ToCompare>> extends SynhronizedSort<ToCompare> {

    private void insertionSort(ToCompare[] m, int a, int b) throws InterruptedException, BrokenBarrierException {
        ToCompare t;
        int i, j;
        for (i = a; i < b; i++) {
            t = m[i];
            for (j = i - 1; j >= a && m[j].compareTo(t) == 1; j--) {
                    //
                    gate.await();
                    //
                m[j + 1] = m[j];
            }
            m[j + 1] = t;
        }
    }

    public void run() {
        try {
            insertionSort(data, 0, data.length);
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
