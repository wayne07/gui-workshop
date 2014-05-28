package de.idos.chronos;

import java.util.Date;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;


public class ChronosStarter {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Ich brauche die millis seit 1970, z.B. " + new Date().getTime());
        }
        new ChronosStarter().start(args);
    }

    private void start(String[] args) {
        DateTime dateTime = new DateTime(Long.parseLong(args[0]), DateTimeZone.UTC);
        final DateTime startTime = dateTime.withZone(DateTimeZone.forID("Europe/Athens"));

        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                ChronosGui chronosGui = new ChronosGui();
                ChronosModel model = new ChronosModel(startTime);

                new ChronosPresenter(chronosGui, model).refreshPeridic();

                createAndShowGUI(chronosGui.getComponent());
            }
        });
    }

    private void createAndShowGUI(JComponent display) {
        JFrame frame = new JFrame("application name");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(display);
        frame.pack();
        frame.setSize(400, 200);
        frame.setVisible(true);
    }

}
