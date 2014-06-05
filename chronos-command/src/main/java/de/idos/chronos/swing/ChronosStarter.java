package de.idos.chronos.swing;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import de.idos.chronos.common.ChronosModel;
import de.idos.chronos.common.ChronosPresenter;
import de.idos.chronos.common.GuiBuilder;

public class ChronosStarter {

    public static void main(String[] args) {
        DateTime dateTimeInUTC = new DateTime();
        if (args.length > 0) {
            dateTimeInUTC = new DateTime(Long.parseLong(args[0]), DateTimeZone.UTC);
        }
        new ChronosStarter().start(dateTimeInUTC);
    }

    private void start(DateTime dateTimeInUTC) {
        final DateTime startTime = dateTimeInUTC.withZone(DateTimeZone.forID("Europe/Athens"));

        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                ChronosSwingGui chronosGui = new ChronosSwingGui();
                ChronosModel model = new ChronosModel(startTime);
                GuiBuilder guiBuilder = new SwingGuiBuilder();

                new ChronosPresenter(chronosGui, model, guiBuilder).refreshPeriodic();

                showGUI(chronosGui.getComponent());
            }
        });
    }

    private void showGUI(JComponent display) {
        JFrame frame = new JFrame("Chronos Time");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(display);
        frame.pack();
        frame.setSize(400, 200);
        frame.setVisible(true);
    }

}
