package de.idos.chronos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalTime;


public class ChronosGui {

    private final JLabel separator1 = new JLabel(":");
    private final JLabel separator2 = new JLabel(":");
    private final JLabel hour = new JLabel();
    private final JLabel minute = new JLabel();
    private final JLabel second = new JLabel();

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Ich brauche die millis seit 1970, z.B. " + new Date().getTime());
        }
        new ChronosGui().start(args);
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

        updateTime(startTime);

        final JPanel panel = new JPanel();
        panel.add(label);
        panel.add(hour);
        panel.add(separator1);
        panel.add(minute);
        panel.add(separator2);
        panel.add(second);
        return panel;
    }

    private void startTimer(final DateTime dateTime) {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {

            DateTime nextDateTime = dateTime;

            @Override
            public void run() {
                nextDateTime = nextDateTime.plusSeconds(1);
                updateTime(nextDateTime.toLocalTime());
            }
        };
        long delayInMillis = 1000l;
        timer.schedule(timerTask, dateTime.toDate(), delayInMillis);
    }

    private void updateTime(LocalTime startTime) {
        hour.setText(format(startTime.getHourOfDay()));
        minute.setText(format(startTime.getMinuteOfHour()));
        second.setText(format(startTime.getSecondOfMinute()));
    }

    private String format(int anyInteger) {
        if (anyInteger < 10) {
            return "0" + anyInteger;
        }
        return "" + anyInteger;
    }

    private void listenToButtonPressAndRespond(final JTextField textField, JButton button) {
        button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                textField.setText("Ouch, not so hard...");
            }
        });
    }

    private void listenToTextInputAndUpdateButtonText(final JTextField textField, final JButton button) {
        textField.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                button.setText(textField.getText());
            }
        });
    }

    private void createAndShowGUI(JComponent display) {
        JFrame frame = new JFrame("application name");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(display);
        frame.pack();
        frame.setVisible(true);
    }


}
