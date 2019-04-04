package ui;

import domain.DomainException;
import domain.db.WoordLezer;
import domain.Speler;
import domain.db.WoordenLijst;
import domain.db.WoordLezer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class FxHangManApp extends Application {


    @Override
    public void start(Stage primaryStage) throws IOException {
        WoordLezer woordenlezer = new WoordLezer("src\\domain\\db\\hangman.txt");
        WoordenLijst woordenlijst = new WoordenLijst();
        woordenlijst.leesBestand("src\\domain\\db\\hangman.txt");

        VBox root = new VBox();
        Scene scene = new Scene(root,400,450);
        TextField invoerNaam = new TextField("Geef de naam van de speler");
        root.getChildren().add(invoerNaam);

        primaryStage.setScene(scene);

        invoerNaam.setOnAction( eventIngaveNaam -> {
                    primaryStage.setTitle(invoerNaam.getText());
                    root.getChildren().clear();
            try {
                new HangManApp(root,new Speler(invoerNaam.getText()), woordenlijst);
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
