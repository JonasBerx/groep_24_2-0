package ui;

import domain.DomainException;
import domain.LijnStuk;
import domain.Punt;
import domain.Tekening;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import domain.*;

public class LijnstukApp {
    private Label invoerXLabel, invoerYLabel;
    private TextField invoerX, invoerY;
    private Alert foutenboodschap = new Alert(Alert.AlertType.WARNING);

    private Punt punt1;
    private Punt punt2;
    private Vorm vorm;

    public LijnstukApp(GridPane root) {

        invoerXLabel =  new Label("Geef de x-coördinaat van het beginpunt ");
        invoerX= new TextField();
        invoerYLabel = new Label("Geef de y-coördinaat van het eindpunt ");
        invoerY = new TextField();

        addBegin(root);


        invoerX.setOnAction(eventIngaveX ->{
            try {
                Integer.parseInt(invoerX.getText());
                root.add(invoerYLabel, 0, 2);
                root.add(invoerY, 1, 2);
            }
            catch(NumberFormatException e){
                    invoerX.clear();
                    foutenboodschap.setTitle("Warning");
                    foutenboodschap.setContentText("x coördinaat moet een geheel getal zijn");
                    foutenboodschap.showAndWait();
                }
        });

        invoerY.setOnAction(eventIngaveY -> {
            try {
                if(punt1==null){
                    punt1 = new Punt(Integer.parseInt(invoerX.getText()), Integer.parseInt(invoerY.getText()));
                    root.getChildren().clear();
                    addBegin(root);
                } else{
                    punt2 = new Punt(Integer.parseInt(invoerX.getText()), Integer.parseInt(invoerY.getText()));
                    vorm = new LijnStuk(punt1, punt2);
                    Text uitvoer = new Text();
                    root.getChildren().clear();
                    uitvoer.setText(punt1.toString() + " x " + punt2.toString());
                    root.add(uitvoer, 0, 0);
                }
            } catch(NumberFormatException n){

                invoerY.clear();

                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("y coördinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            } catch (DomainException d){
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("Lijnstuk is niet correct");
                foutenboodschap.showAndWait();
            }
        });
    }

    public LijnstukApp(GridPane root, Tekening tekening) {
        init(root,1);
        invoerX.setOnAction(eventIngaveX ->{
            try {
                Integer.parseInt(invoerX.getText());
                root.add(invoerYLabel, 0, 2);
                root.add(invoerY, 1, 2);
            }
            catch(NumberFormatException e){
                invoerX.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("x coördinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }

            invoerY.setOnAction(eventIngaveY -> {
                try {
                    if(punt1==null){
                        punt1 = new Punt(Integer.parseInt(invoerX.getText()), Integer.parseInt(invoerY.getText()));
                        root.getChildren().clear();
                        addBegin(root);
                    } else{
                        punt2 = new Punt(Integer.parseInt(invoerX.getText()), Integer.parseInt(invoerY.getText()));
                        vorm = new LijnStuk(punt1, punt2);
                        Text uitvoer = new Text();
                        root.getChildren().clear();
                        uitvoer.setText(punt1.toString() + " x " + punt2.toString());
                        root.add(uitvoer, 0, 0);

                    }
                } catch(NumberFormatException n){

                    invoerY.clear();

                    foutenboodschap.setTitle("Warning");
                    foutenboodschap.setContentText("y coördinaat moet een geheel getal zijn");
                    foutenboodschap.showAndWait();
                } catch (DomainException d){
                    foutenboodschap.setTitle("Warning");
                    foutenboodschap.setContentText("Lijnstuk is niet correct");
                    foutenboodschap.showAndWait();
                }
            });

        });
    }


    private void init(GridPane root, int teller){
        invoerXLabel =  new Label("Geef de x-coördinaat van het punt ");
        invoerX= new TextField();

        invoerYLabel = new Label("Geef de y-coördinaat van het punt ");
        invoerY = new TextField();

        root.add(invoerXLabel,0,teller);
        root.add(invoerX,1,teller);

        invoerX.setOnAction(eventIngaveX ->{
            try {
                Integer.parseInt(invoerX.getText());
                root.add(invoerYLabel, 0, teller + 1);
                root.add(invoerY, 1, teller + 1);
            }
            catch(NumberFormatException e){
                invoerX.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("x coördinaat van het beginpunt moet gedefineerd zijn");
                foutenboodschap.showAndWait();
            }

        });

        invoerY.setOnAction(eventIngaveY -> {
            try {
                Integer.parseInt(invoerY.getText());
            } catch (NumberFormatException e){
                invoerY.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("y coördinaat van beginpunt moet gedefineerd zijn");
                foutenboodschap.showAndWait();

            }
        });
    }







    private void addBegin(GridPane root){
        root.add(invoerXLabel,0,1);
        root.add(invoerX,1,1);
    }

    private void  cleanUp(GridPane root){
        root.getChildren().remove(invoerXLabel);
        root.getChildren().remove(invoerX);
        root.getChildren().remove(invoerYLabel);
        root.getChildren().remove(invoerY);

    }
}
