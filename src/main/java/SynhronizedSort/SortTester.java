/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SynhronizedSort;

/**
 *
 * @author Jeka
 */
public class SortTester {

    private SortTester() {
    }

    public static boolean testArray(Comparable[] array) {
        boolean b = true;
        for (int i = 0; i < array.length-1; i++) {
            b = (b) && ((array[i].compareTo(array[i + 1]) == -1) || (array[i].compareTo(array[i + 1]) == 0));
        }
        return b;
    }
}
