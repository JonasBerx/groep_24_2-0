package domain;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Rechthoek extends Vorm implements Drawable {
    private Punt linkerbovenhoek;
    private int breedte;
    private int hoogte;


    public Rechthoek(Punt linkerbovenhoek, int breedte, int hoogte) throws DomainException{

        if (linkerbovenhoek == null) {
            throw new DomainException("Linkerbovenhoek is niet gedefinieerd");
        }

        if (breedte <= 0) {
            throw new DomainException("Breedte is kleiner dan 0");
        }
        if (hoogte <= 0) {
            throw new DomainException("Hoogte is kleiner dan 0");
        }


        this.linkerbovenhoek = linkerbovenhoek;
        this.breedte = breedte;
        this.hoogte = hoogte;
    }

    public boolean equals(Object r) {

        if (r instanceof Rechthoek) {
            if (((Rechthoek) r).getLinkerBovenhoek() == this.linkerbovenhoek && ((Rechthoek) r).getBreedte() == this.breedte && ((Rechthoek) r).getHoogte() == this.hoogte)
                return true;
            return ((Rechthoek) r).getBreedte() == this.breedte && ((Rechthoek) r).getHoogte() == this.hoogte && ((Rechthoek) r).linkerbovenhoek.equals(this.linkerbovenhoek);

        }
        return false;
    }


    public String toString(){
        return "Rechthoek: linkerbovenhoek: " + linkerbovenhoek + " - breedte: " + breedte + " - hoogte: " + hoogte +"\n" + super.toString();
    }


    public Punt getLinkerBovenhoek() {
        return linkerbovenhoek;
    }

    public int getHoogte() {
        return hoogte;
    }

    public int getBreedte() {
        return breedte;
    }

    @Override
    public Omhullende getOmhullende() throws DomainException {
        return new Omhullende(linkerbovenhoek, breedte, hoogte);
    }

    @Override
    public void teken(Pane root) {
        if (isZichtbaar()) {
            Rectangle rechthoekGebouw = new Rectangle(this.getLinkerBovenhoek().getX(), this.getLinkerBovenhoek().getY(), this.getBreedte(), this.getHoogte());
            rechthoekGebouw.setFill(Color.WHITE);
            rechthoekGebouw.setStroke(Color.BLACK);
            root.getChildren().addAll(rechthoekGebouw);
        }
    }
}