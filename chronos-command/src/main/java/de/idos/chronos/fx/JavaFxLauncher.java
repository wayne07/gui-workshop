package de.idos.chronos.fx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import de.idos.chronos.common.ChronosModel;
import de.idos.chronos.common.ChronosPresenter;
import de.idos.chronos.common.GuiBuilder;

public class JavaFxLauncher extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    private DateTime dateTimeInUTC;

    @Override
    public void init() throws Exception {
        for (String parameter : getParameters().getRaw()) {
            System.out.println(parameter);
        }
        dateTimeInUTC = new DateTime(DateTimeZone.UTC);
        if ( !getParameters().getRaw().isEmpty()) {
            dateTimeInUTC = new DateTime(Long.parseLong(getParameters().getRaw().get(0)), DateTimeZone.UTC);
        }
        System.out.println(dateTimeInUTC);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Chronos FX Time");
        stage.setScene(new Scene(createContent()));
        stage.setWidth(300);
        stage.setHeight(250);
        stage.show();
    }

    private Pane createContent() {
        ChronosFxGui chronosGui = new ChronosFxGui();
        ChronosModel model = new ChronosModel(dateTimeInUTC);
        GuiBuilder guiBuilder = new FxGuiBuilder();

        new ChronosPresenter(chronosGui, model, guiBuilder).refreshPeriodic();

        return chronosGui.getComponent();


        //        Label label = new Label("hello world");
        //        final TextField textField = new TextField();
        //        final Button button = new Button("press me");
        //
        //        HBox hBox = new HBox();
        //        hBox.getChildren().add(label);
        //        hBox.getChildren().add(button);
        //        hBox.getChildren().add(textField);
        //
        //        return hBox;
    }

    @Override
    public void stop() throws Exception {
        System.out.println("executed on shutdown");
    }
}
