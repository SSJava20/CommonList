/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SynhronizedSort;

import java.lang.reflect.Array;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jeka
 */
public class SynhronizedMergeSort<ToCompare extends Comparable<ToCompare>> extends SynhronizedSort<ToCompare> {

    private void mergesort(ToCompare[] a, int l, int r) throws BrokenBarrierException, InterruptedException {
        //base case: a[l..r] is empty or has only one element 
        if (l >= r) {
            return;
        }

        //recursion step: a[l..r] is not empty 
        //divide into sublists and merge 
        int m = (l + r) / 2;
        mergesort(a, l, m);
        mergesort(a, m + 1, r);
        merge(a, l, m, r);
    }

    //merges to sublists 
    private void merge(ToCompare[] a, int l, int m, int r) throws BrokenBarrierException, InterruptedException {
        //base case: second sublist is empty 
        if (m + 1 > r) {
            return;
        }
        ToCompare[] b = (ToCompare[]) Array.newInstance(Comparable.class, a.length);
        //create temporary array //copy a[l..m] to b[l..m] 
        for (int i = l; i != m + 1; i++) {
            b[i] = a[i];
        }
        //copy a[m+1..r] to b[m+1..r] in reverse order 
        for (int i = m + 1; i != r + 1; i++) {
            b[i] = a[r + m + 1 - i];
        }
        //merge b[l..m] with b[m+1..r] to a[l..r] 
        int k = l;
        int j = r; //pointer wandering from outside inward 
        for (int i = l; i != r + 1; i++) {
            if ((b[k].compareTo(b[j]) == 0) || (b[k].compareTo(b[j]) == -1)) {
                
                    gate.await();

                a[i] = b[k++];
            } else {
                    gate.await();
                    
                a[i] = b[j--];
            }
        }
    }

    public void run() {
        try {
            mergesort(data, 0, data.length - 1);
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
