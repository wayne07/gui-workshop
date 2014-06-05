package de.idos.progress;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class ProgressGui {

    private static final Integer MAX = 50;

    private final GridPane pane = new GridPane();
    private UpdateProgressTask iteratingTask;


    public Pane getComponent() {
        HBox box = new HBox();
        final ProgressIndicator progressIndicator = createProgressIndicator(MAX);
        final ProgressBar progressBar = createProgressBar(MAX);
        box.getChildren().addAll(progressIndicator, progressBar);

        final Button button = new Button("start Progress ...");

        final Slider slider = new Slider();
        slider.setMin(0);
        slider.setMax(50);

        iteratingTask = new UpdateProgressTask(MAX, progressIndicator);

        listenToButtonPress(button, iteratingTask, progressIndicator, slider);

        slider.valueProperty().addListener(new ChangeListener<Number>() {

            public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
                progressBar.setProgress(new_val.doubleValue() / 50);
                progressIndicator.setProgress(new_val.doubleValue() / 50);
            }
        });


        pane.addRow(0, box);
        pane.addRow(1, slider);
        pane.addRow(2, button);
        return pane;
    }

    private void listenToButtonPress(final Button button, final UpdateProgressTask task, final ProgressIndicator progressIndicator, final Slider slider) {
        final int totalIterations = 50;
        button.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                progressIndicator.setProgress(0);

                new Thread() {

                    @Override
                    public void run() {
                        //Do some stuff in another thread
                        Platform.runLater(new Runnable() {

                            public void run() {
                                int iterations = 0;
                                for (iterations = 0; iterations < totalIterations; iterations++) {
                                    System.out.println("Iteration " + iterations);
                                    slider.setValue(iterations);
                                    //                                    progressIndicator.setProgress(iterations / totalIterations);

                                    try {
                                        Thread.sleep(200);
                                    } catch (InterruptedException interrupted) {
                                        break;
                                    }
                                }
                            }
                        });
                    }
                }.start();
                //                button.setDisable(true);
                //                task.run();
                //                button.setDisable(false);
            }
        });
    }


    public void startProcess() {
        iteratingTask.run();
    }

    private ProgressIndicator createProgressIndicator(Integer maxValue) {
        ProgressIndicator indicator = new ProgressIndicator(0);

        return indicator;
    }

    private ProgressBar createProgressBar(Integer maxValue) {
        ProgressBar pb = new ProgressBar(0);

        return pb;
    }


    public class UpdateProgressTask extends Task<Node> {

        private final Integer totalIterations;
        private final ProgressIndicator progressIndicator;

        public UpdateProgressTask(Integer iterations, ProgressIndicator progressIndicator) {
            this.totalIterations = iterations;
            this.progressIndicator = progressIndicator;
        }

        @Override
        protected Node call() throws Exception {
            Platform.runLater(new Runnable() {

                public void run() {
                    int iterations = 0;
                    for (iterations = 0; iterations < totalIterations; iterations++) {
                        if (isCancelled()) {
                            updateMessage("Cancelled");
                            break;
                        }
                        System.out.println("Iteration " + iterations);
                        progressIndicator.setProgress(iterations / totalIterations);

                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException interrupted) {
                            if (isCancelled()) {
                                updateMessage("Cancelled");
                                break;
                            }
                        }
                    }
                }
            });
            return null;
        }
    }

}
