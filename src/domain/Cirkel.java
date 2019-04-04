package domain;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Cirkel extends Vorm implements Drawable {
    private Punt middelpunt;
    private int radius;

    public Cirkel(Punt middelpunt, int radius) throws DomainException {
        setMiddelpunt(middelpunt);
        setRadius(radius);
    }

    private void setMiddelpunt(Punt middelpunt) throws DomainException {
        if (middelpunt == null) throw new DomainException("middelpunt mag niet null zijn.");
        this.middelpunt = middelpunt;
    }

    private void setRadius(int radius) throws DomainException {
        if (radius <= 0) throw new DomainException("radius mag niet null zijn.");
        this.radius = radius;
    }

    public Punt getMiddelpunt(){
        return middelpunt;
    }

    public int getRadius(){
        return radius;
    }

    public boolean equals(Object o){

        if (o instanceof Cirkel) {
            if (((Cirkel) o).middelpunt == null) return false;
            if (((Cirkel) o).middelpunt == this.middelpunt && ((Cirkel) o).radius == this.radius) {
                return true;
            }
            return false;
        }
        return false;
    }

    public String toString(){
      return "Cirkel: middelpunt: " + middelpunt.toString() + " - straal: " + radius
              +"\n" + super.toString();
    }

    @Override

    public void teken(Pane root) {
        Circle cirkelBoomKruin = new Circle(this.getMiddelpunt().getX(), this.getMiddelpunt().getY(), this.getRadius());
        cirkelBoomKruin.setFill(Color.GREEN);
        cirkelBoomKruin.setStroke(Color.BLACK);
        root.getChildren().addAll(cirkelBoomKruin);
    }
    public Omhullende getOmhullende() throws DomainException {
            Punt linkerbovenhoek = new Punt(middelpunt.getX(), middelpunt.getY());
            Omhullende omhullende = new Omhullende(linkerbovenhoek, radius * 2, radius * 2);
            return omhullende;
        }
    }

