/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jekaGUI;

import java.awt.*;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author Jeka
 */
public class MassPanel extends JPanel {

    public int DEF_W = 0;
    public int DEF_H = 60;
    private Integer[] currentMass;

    public MassPanel(Integer[] mass, int x, int y) {
        DEF_W = mass.length * 5;
        currentMass = mass;
        this.setLayout(null);
        this.setSize(new Dimension(DEF_W, DEF_H));
        this.setLocation(x, y);
        this.setBackground(Color.black);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2f));
        int dx = 3;
        int dy = max() / DEF_H;
        for (int i = 0; i < currentMass.length; i++) {
            if (i % 2 == 0) {
                g2.setColor(Color.white);
            } else {
                g2.setColor(Color.GREEN);
            }
            g2.drawLine(dx, DEF_H, dx, ((DEF_H+20)-currentMass[i] * dy));
            dx += (this.DEF_W) / currentMass.length;
        }
    }

    private int max() {
        int max = 0;
        for (int i = 0; i < currentMass.length; i++) {
            if (max < currentMass[i]) {
                max = currentMass[i];
            }
        }
        return max;
    }

    public void setMass(Integer[] mass) {
        currentMass = mass;
    }

    public Integer[] getMass() {
        return currentMass;
    }
}
