/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jekaGUI;

/**
 *
 * @author Jeka
 */
public class PanelPainter implements Runnable {

    MassPanel[] array;
    Integer[] mas;

    public PanelPainter(MassPanel[] array) {
        this.array = array;
    }

    public void run() {
        for (int i = 0; i < array.length; i++) {
            array[i].repaint();
        }
    }
}
