/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jekaGUI;

import java.util.Random;

/**
 *
 * @author Jeka
 */
public class Model {

    public final int MEMBERS_COUNT = 100;
    public final int SORTS_COUNT = 7;
    private Integer[][] arrays;

    public Model() {
        arrays = new Integer[SORTS_COUNT][MEMBERS_COUNT];
    }

    public void generate() {
        for (int i = 0; i < SORTS_COUNT; i++) {
            Random r = new Random();
            for (int j = 0; j < MEMBERS_COUNT; j++) {
                arrays[i][j] = r.nextInt(MEMBERS_COUNT) + 1;
            }
        }
    }

//    public Integer[] randomMass() {
////        Integer[] mas = new Integer[MEMBERS_COUNT];
////        mas = new Integer[MEMBERS_COUNT];
////
////        return mas;
//    }

    public Integer[][] getArrays() {
        return arrays;
    }
}
