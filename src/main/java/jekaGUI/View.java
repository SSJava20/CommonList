/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jekaGUI;

import SynhronizedSort.Sleeper;
import SynhronizedSort.SynhronizedSort;
import SynhronizedSort.SynhronizedSortFabric;
import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.CyclicBarrier;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author Jeka
 */
public class View extends JFrame {

    private JTextField field;
    private Model model = new Model();
    private MassPanel[] masPanel;
    private final int DEF_W = 900;
    private final int DEF_H = 600;

    public View() {
        model.generate();
        initComponents();
        initMassPenels();
    }

    public void initComponents() {
        masPanel = new MassPanel[model.SORTS_COUNT];
        this.setSize(DEF_W, DEF_H);
        this.setLayout(null);
        Button b = new Button("LET\'S ROCK");
        field=new JTextField("30");
        field.setLocation(30, DEF_H/2-100);
        field.setSize(100, 40);
        b.setLocation(30, DEF_H/2-40);
        b.setSize(100, 40);
        b.setBackground(Color.red);
        b.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                ControlThread th = new ControlThread();
                th.start();
            }
        });
        this.add(field);
        this.add(b);
    }

    public void initMassPenels() {
        int dy = 30;
        for (int i = 0; i < masPanel.length; i++) {
            JTextField text=new JTextField();
            text.setText(SynhronizedSortFabric.getName(i+1));
            masPanel[i] = new MassPanel(model.getArrays()[i], 150, dy);
            text.setLocation(150+50+masPanel[i].DEF_W,dy);
            text.setSize(100,30);
            text.setEditable(false);
            this.add(masPanel[i]);
            this.add(text);
            dy += 70;
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                View f = new View();
                f.setVisible(true);
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
    }
    
     public class ControlThread extends Thread {

        Thread[] threads;
        Sleeper s;
        
        public ControlThread() {
            threads=new Thread[model.SORTS_COUNT+1];
            CyclicBarrier barrier = new CyclicBarrier(model.SORTS_COUNT+1, new PanelPainter(masPanel));
            for(int i=0;i<model.SORTS_COUNT;i++){
                SynhronizedSort sort=SynhronizedSortFabric.getInstace(i+1);
                sort.sort(model.getArrays()[i]);
                sort.setGate(barrier);
                threads[i]=new Thread(sort);
            }
            s=new Sleeper(Integer.parseInt(field.getText()));
            s.setGate(barrier);
            threads[7]=new Thread(s);
        }

        @Override
        public void run() {
            for(int i=0;i<threads.length;i++){
                threads[i].start();
            }
        }
    }
}
