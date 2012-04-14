/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sorts;

/**
 *
 * @author Jeka
 */
public class InsertSort<ToCompare extends Comparable<ToCompare>> extends Sort<ToCompare> {

    private void insertionSort(ToCompare[] m, int a, int b) {
        ToCompare t;
        int i, j;
        for (i = a; i < b; i++) {
            t = m[i];
            for (j = i - 1; j >= a && m[j].compareTo(t) == 1; j--) {
                m[j + 1] = m[j];
            }
            m[j + 1] = t;
        }
    }

    @Override
    public void sort(ToCompare[] data) {
        insertionSort(data, 0, data.length);
    }
}
