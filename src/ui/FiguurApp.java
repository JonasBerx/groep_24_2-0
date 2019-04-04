package ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class FiguurApp {
    private Alert foutenboodschap = new Alert(Alert.AlertType.WARNING);
    ObservableList<String> Figuren = FXCollections.observableArrayList ("Lijnstuk" , "Driehoek", "Cirkel", "Rechthoek");
    private Label invoerKeuze;
    ChoiceBox cb;
    GridPane paneel;

    public FiguurApp(GridPane root) {
        cb = new ChoiceBox();
        cb.setItems(Figuren);
        paneel = new GridPane();
        invoerKeuze = new Label("Kies de figuur dat je wilt toevoegen:");
        root.add(invoerKeuze, 0,0);
        root.add(cb,0,1);
        root.add(paneel, 0, 2);

        cb.setOnAction(eventIngaveX ->{
            try {
                paneel.getChildren().clear();
                if(cb.getValue()=="Lijnstuk"){
                    new LijnstukApp(paneel);
                } else if(cb.getValue()=="Driehoek"){
                    new DriehoekApp(paneel);
                } else if(cb.getValue()=="Cirkel"){
                    new CirkelApp(paneel);
                } else if(cb.getValue()=="Rechthoek"){
                    new RechthoekApp(paneel);
                }
            } catch(NumberFormatException e){
                    foutenboodschap.setTitle("Warning");
                    foutenboodschap.setContentText("Fout bij het selecteren");
                    foutenboodschap.showAndWait();
                }
        });


    }


}
