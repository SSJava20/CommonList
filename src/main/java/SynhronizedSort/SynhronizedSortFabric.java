/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SynhronizedSort;

/**
 *
 * @author Jeka
 */
public class SynhronizedSortFabric {

    private SynhronizedSortFabric() {
    }

    public static SynhronizedSort getInstace(int n) {
        SynhronizedSort ret = null;
        switch (n) {
            case 1: {
                ret = new SynhronizedShellSort();
                break;
            }
            case 2: {
                ret = new SynhronizedSelectionSort();
                break;
            }
            case 3: {
                ret = new SynhronizedQuickSort();
                break;
            }
            case 4: {
                ret = new SynhronizedMergeSort();
                break;
            }
            case 5: {
                ret = new SynhronizedInsertSort();
                break;
            }
            case 6: {
                ret = new SynhronizedHeapSort();
                break;
            }
            case 7: {
                ret = new SynhronizedBubbleSort();
                break;
            }
            default: {
                break;
            }
        }
        return ret;
    }

    public static String getName(int n) {
        String ret = null;
        switch (n) {
            case 1: {
                ret = "Shell Sort";
                break;
            }
            case 2: {
                ret = "Selection Sort";
                break;
            }
            case 3: {
                ret = "Quick Sort";
                break;
            }
            case 4: {
                ret = "Merge Sort";
                break;
            }
            case 5: {
                ret = "Insert Sort";
                break;
            }
            case 6: {
                ret = "Heap Sort";
                break;
            }
            case 7: {
                ret = "Bubble Sort";
                break;
            }
            default: {
                break;
            }
        }
        return ret;
    }
}
