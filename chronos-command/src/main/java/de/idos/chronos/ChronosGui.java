package de.idos.chronos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

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
            }
        });
    }

    private JPanel createContent(LocalTime startTime) {
        JLabel label = new JLabel("Uhrzeit: ");

        JLabel hour = new JLabel("" + startTime.getHourOfDay());
        JLabel minute = new JLabel("" + startTime.getMinuteOfHour());
        JLabel second = new JLabel("" + startTime.getSecondOfMinute());

        //        final JTextField textField = new JTextField();
        //        textField.setPreferredSize(new Dimension(160, 25));
        //        final JButton button = new JButton("press me");

        //        listenToButtonPressAndRespond(textField, button);
        //        listenToTextInputAndUpdateButtonText(textField, button);

        final JPanel panel = new JPanel();
        panel.add(label);
        panel.add(hour);
        panel.add(minute);
        panel.add(second);
        return panel;
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
