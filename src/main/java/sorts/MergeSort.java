/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sorts;

import java.lang.reflect.Array;

/**
 *
 * @author Jeka
 */
public class MergeSort<ToCompare extends Comparable<ToCompare>> extends Sort<ToCompare> {

    private void mergesort(ToCompare[] a, int l, int r) {
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
    private void merge(ToCompare[] a, int l, int m, int r) {
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
                a[i] = b[k++];
            } else {
                a[i] = b[j--];
            }
        }
    }

    @Override
    public void sort(ToCompare[] data) {
        mergesort(data, 0, data.length - 1);
    }
}
