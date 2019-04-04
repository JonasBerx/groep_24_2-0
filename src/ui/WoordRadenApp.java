package ui;

import domain.db.WoordenLijst;
import domain.DomainException;
import domain.HintWoord;
import domain.Speler;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class WoordRadenApp {
    private Label raadwoord, hintWoordLabel, invoerLetterLabel, uitvoerLabel, victory;
    private TextField invoerLetter;
    private HintWoord woord;


    private int guesses;

    private Alert foutenboodschap = new Alert(Alert.AlertType.WARNING);

    public WoordRadenApp(GridPane root, Speler speler, String fileName) throws IOException, DomainException {
        WoordenLijst lijst = new WoordenLijst();
        lijst.leesBestand(fileName);

        raadwoord = new Label("Rarara, welk woord zoeken we?");
        root.add(raadwoord, 0, 0);

        woord = new HintWoord("test");

        hintWoordLabel = new Label(woord.toString());
        root.add(hintWoordLabel, 0, 1);

        invoerLetterLabel = new Label("Geef een letter");
        invoerLetter = new TextField();

        root.add(invoerLetterLabel, 0, 3);
        root.add(invoerLetter, 0, 4);

        guesses = 0;

        invoerLetter.setOnAction(eventIngaveLetter ->{
            try {
                root.getChildren().clear();

                if (invoerLetter.getText().length() > 1) {
                    throw new DomainException("Je mag maar 1 letter per keer meegeven");
                }
                if (invoerLetter.getText().length() == 0) {
                    throw new DomainException("Je hebt geen letter meegegeven");
                }
                if (woord.raad(invoerLetter.getText().charAt(0))) {
                    uitvoerLabel = new Label("Juist geraden, doe zo voort");
                    guesses++;
                } else {
                    uitvoerLabel = new Label("Jammer, volgende keer beter");
                    guesses++;
                }
                root.add(uitvoerLabel, 0, 0);
                root.add(raadwoord, 0, 1);

                hintWoordLabel = new Label(woord.toString());
                root.add(hintWoordLabel, 0, 2);

                root.add(invoerLetterLabel, 0, 3);
                root.add(invoerLetter, 0, 4);

                if (woord.isGeraden()) {
                    root.getChildren().clear();
                    victory = new Label("Well played " + speler.getNaam() + "! Je hebt het woord in " + guesses + " zetten geraden");
                    root.add(victory, 0, 0);
                }
                invoerLetter.clear();
            } catch (DomainException e) {
                invoerLetter.clear();

                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText(e.getMessage());
                foutenboodschap.showAndWait();
            } catch (IllegalArgumentException e){
            uitvoerLabel = new Label(e.getMessage());
            root.add(uitvoerLabel,0,0);
            root.add(raadwoord, 0, 1);

            hintWoordLabel = new Label(woord.toString());
            root.add(hintWoordLabel, 0,2);

            root.add(invoerLetterLabel, 0, 3);
            root.add(invoerLetter, 0,4);
            invoerLetter.clear();
        }
        });
    }
}
