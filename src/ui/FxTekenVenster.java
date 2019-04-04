package ui;

import domain.DomainException;
import domain.Tekening;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FxTekenVenster extends Application {

    private TextField invoerNaam;

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        Scene scene = new Scene(root,1000,1000);
        invoerNaam = new TextField("Geef de naam van de tekening");
        root.getChildren().add(invoerNaam);

        primaryStage.setScene(scene);

        invoerNaam.setOnAction( eventIngaveNaam -> {
            primaryStage.setTitle(invoerNaam.getText());
            root.getChildren().clear();
            try {
                new TekenVenster(root,new Tekening(invoerNaam.getText()));
            } catch (DomainException e) {
                e.printStackTrace();
            }
        });

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}