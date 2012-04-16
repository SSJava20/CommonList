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
public class SynhronizedQuickSort<ToCompare extends Comparable<ToCompare>> extends SynhronizedSort<ToCompare> {

    private void qSort(ToCompare[] A, int low, int high) throws InterruptedException, BrokenBarrierException {
        int i = low;
        int j = high;
        ToCompare x = A[(low + high) / 2];
        do {
            while (A[i].compareTo(x) == -1) {
                ++i;
            }
            while (A[j].compareTo(x) == 1) {
                --j;
            }
            if (i <= j) {

                    gate.await();

                ToCompare temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                i++;
                j--;
            }
        } while (i <= j);

        if (low < j) {
            qSort(A, low, j);
        }
        if (i < high) {
            qSort(A, i, high);
        }
    }

    public void run() {
        try {
            qSort(data, 0, data.length - 1);
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

