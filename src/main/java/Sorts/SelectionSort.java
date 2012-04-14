/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sorts;

/**
 *
 * @author Jeka
 */
public class SelectionSort<ToCompare extends Comparable<ToCompare>> extends Sort<ToCompare> {

    @Override
    public void sort(ToCompare[] numbers) {
        int min;
        ToCompare temp;

        for (int index = 0; index < numbers.length - 1; index++) {
            min = index;
            for (int scan = index + 1; scan < numbers.length; scan++) {
                if (numbers[scan].compareTo(numbers[min]) == -1) {
                    min = scan;
                }
            }

            // Swap the values
            temp = numbers[min];
            numbers[min] = numbers[index];
            numbers[index] = temp;
        }
    }
}
