package de.idos.chronos;

import java.util.Date;
import java.util.Timer;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalTime;


public class ChronosStarter {

    private final JLabel separator1 = new JLabel(":");
    private final JLabel separator2 = new JLabel(":");
    private final JLabel hour = new JLabel();
    private final JLabel minute = new JLabel();
    private final JLabel second = new JLabel();

    private GuiUpdater guiUpdater;

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
                createAndShowGUI(createContent(startTime.toLocalTime()));
                startTimer(startTime);
            }
        });
    }

    private JPanel createContent(final LocalTime startTime) {
        JLabel label = new JLabel("Uhrzeit: ");

        guiUpdater = new GuiUpdater(hour, minute, second);

        final JPanel panel = new JPanel();
        panel.add(label);
        panel.add(hour);
        panel.add(separator1);
        panel.add(minute);
        panel.add(separator2);
        panel.add(second);
        return panel;
    }

    private void startTimer(final DateTime startDateTime) {
        Timer timer = new Timer();
        ChronosTimerTask timerTask = new ChronosTimerTask(guiUpdater, startDateTime);
        long delayInMillis = 1000l;
        timer.schedule(timerTask, startDateTime.toDate(), delayInMillis);
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
