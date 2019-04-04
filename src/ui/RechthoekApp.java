package ui;

import domain.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class RechthoekApp {
    private Label invoerXLabel, invoerYLabel, invoerBreedteLabel, invoerHoogteLabel;
    private TextField invoerX, invoerY, invoerBreedte, invoerHoogte;
    private Alert foutenboodschap = new Alert(Alert.AlertType.WARNING);

    private Punt linkerbovenhoek;
    private int hoogte;
    private int breedte;
    private Vorm rechthoek;

    public RechthoekApp(GridPane root) {

        invoerXLabel =  new Label("Geef de x-coördinaat van het linkerbovenhoek ");
        invoerX= new TextField();

        root.add(invoerXLabel,0,0);
        root.add(invoerX,1,0);


        invoerYLabel = new Label("Geef de y-coördinaat van het linkerbovenhoek ");
        invoerY = new TextField();

        root.add(invoerYLabel,0,0);
        root.add(invoerY,1,0);


        invoerBreedteLabel = new Label("Geef de breedte van de rechthoek");
        invoerBreedte = new TextField();



        invoerHoogteLabel = new Label("geef hoogte van de rechthoek");
        invoerHoogte = new TextField();




        invoerX.setOnAction(eventIngaveX ->{
            try {
                Integer.parseInt(invoerX.getText());
                addBegin(root);
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
                if (linkerbovenhoek == null) {
                    linkerbovenhoek = new Punt(Integer.parseInt(invoerX.getText()), Integer.parseInt(invoerY.getText()));
                    root.getChildren().clear();
                    addBegin(root);
                }
            } catch (NumberFormatException n) {
                invoerY.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("y coördinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });

        invoerBreedte.setOnAction(eventIngaveBreedte ->{
            try {
                if (breedte == 0) {
                    breedte = Integer.parseInt(invoerBreedte.getText());
                    root.getChildren().clear();
                    addBegin(root);
                }
            }
            catch (NumberFormatException n) {
                invoerY.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("y coördinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });

        invoerHoogte.setOnAction(eventIngaveHoogte ->{
            try {
                if (hoogte == 0) {
                    hoogte = Integer.parseInt(invoerX.getText());
                    root.getChildren().clear();
                    addBegin(root);
                }
            }
            catch (NumberFormatException n) {
                invoerY.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("y coördinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });
    }

    public RechthoekApp(GridPane root, Tekening tekening) {
        init(root,1);
        invoerHoogte.setOnAction(eventIngaveHoogte -> {
            try {
                Punt linkerhoek = new Punt(Integer.parseInt(invoerX.getText()),Integer.parseInt(invoerY.getText()));
                rechthoek =  new Rechthoek(linkerhoek, Integer.parseInt(invoerBreedte.getText()), Integer.parseInt(invoerHoogte.getText()));
                tekening.voegToe(rechthoek);

                Text uitvoer = new Text();
                root.getChildren().clear();
                uitvoer.setText( "Linkerhoek: (" + linkerhoek.getX() + "," + linkerhoek.getY() + ") breedte: " + breedte + " hoogte:" + hoogte);
                root.add(uitvoer,0,0);

                cleanUp(root);



            } catch (DomainException e){

                cleanUp(root);
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setHeaderText(null);
                foutenboodschap.setContentText(e.getMessage());
                foutenboodschap.showAndWait();
            } catch (NumberFormatException ne){
                invoerHoogte.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("straal van de cirkel moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }

        });
    }

    private void init(GridPane root, int teller){
        invoerXLabel =  new Label("Geef de x-coördinaat van de linkerhoek ");
        invoerX= new TextField();

        invoerYLabel = new Label("Geef de y-coördinaat van de linkerhoek ");
        invoerY = new TextField();

        invoerBreedteLabel = new Label("Geef de breedte van de rechthoek");
        invoerBreedte = new TextField();

        invoerHoogteLabel = new Label("Geef de hoogte van de rechthoek");
        invoerHoogte = new TextField();

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
                foutenboodschap.setContentText("x coördinaat van de linkerhoek moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }

        });

        invoerY.setOnAction(eventIngaveY -> {
            try {
                Integer.parseInt(invoerY.getText());
                root.add(invoerBreedteLabel, 0, teller + 2);
                root.add(invoerBreedte, 1, teller +  2);
            } catch (NumberFormatException e){
                invoerY.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("y coördinaat van de linkerhoek moet een geheel getal zijn");
                foutenboodschap.showAndWait();

            }
        });
        invoerBreedte.setOnAction(eventIngaveBreedte -> {
            try {
                Integer.parseInt(invoerBreedte.getText());
                root.add(invoerHoogteLabel, 0, teller + 3);
                root.add(invoerHoogte, 1, teller + 3 );
            } catch (NumberFormatException e){
                invoerBreedte.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("de breedte moet binnen de outline liggen");
                foutenboodschap.showAndWait();

            }
        });

    }

    private void  cleanUp(GridPane root){
        root.getChildren().remove(invoerXLabel);
        root.getChildren().remove(invoerX);
        root.getChildren().remove(invoerYLabel);
        root.getChildren().remove(invoerY);
        root.getChildren().remove(invoerBreedteLabel);
        root.getChildren().remove(invoerBreedte);
        root.getChildren().remove(invoerHoogteLabel);
        root.getChildren().remove(invoerHoogte);

    }

    private void addBegin(GridPane root){
        root.add(invoerXLabel,0,0);
        root.add(invoerX,1,0);
    }
}
