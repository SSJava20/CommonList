/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sorts;

/**
 *
 * @author Jeka
 */
public class BubbleSort<ToCompare extends Comparable<ToCompare>> extends Sort<ToCompare> {

    @Override
    public void sort(ToCompare[] data) {
        bubblesort(data);
    }

    private void swap(ToCompare[] arr, int i, int j) {
        ToCompare t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    private void bubblesort(ToCompare[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j].compareTo(arr[j + 1])==1) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }
}
