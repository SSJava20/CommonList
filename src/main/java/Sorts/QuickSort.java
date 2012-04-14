/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sorts;

/**
 *
 * @author Jeka
 */
public class QuickSort<ToCompare extends Comparable<ToCompare>> extends Sort<ToCompare> {

    @Override
    public void sort(ToCompare[] data) {
        qSort(data, 0, data.length - 1);
    }

    public void qSort(ToCompare[] A, int low, int high) {
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
}
