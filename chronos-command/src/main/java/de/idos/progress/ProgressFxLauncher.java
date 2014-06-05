package de.idos.progress;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ProgressFxLauncher extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void init() throws Exception {
        for (String parameter : getParameters().getRaw()) {
            System.out.println(parameter);
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("FX Progress Demo");
        stage.setScene(new Scene(createContent()));
        stage.setWidth(400);
        stage.setHeight(300);
        stage.show();
    }

    private Pane createContent() {
        ProgressGui progressGui = new ProgressGui();
        ProgressModel model = new ProgressModel();

        new ProgressPresenter(progressGui, model).present();

        return progressGui.getComponent();
    }

    @Override
    public void stop() throws Exception {
        System.out.println("executed on shutdown");
    }
}
