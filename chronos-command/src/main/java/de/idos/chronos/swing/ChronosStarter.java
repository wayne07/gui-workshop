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
        DateTime dateTimeInUTC = new DateTime(DateTimeZone.UTC);
        if (args.length > 0) {
            dateTimeInUTC = new DateTime(Long.parseLong(args[0]), DateTimeZone.UTC);
        }
        new ChronosStarter().start(dateTimeInUTC);
    }

    private void start(final DateTime dateTimeInUTC) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                ChronosSwingGui chronosGui = new ChronosSwingGui();
                ChronosModel model = new ChronosModel(dateTimeInUTC);
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
        frame.setSize(300, 250);
        frame.setVisible(true);
    }

}
