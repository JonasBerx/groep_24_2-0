package domain;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

public class LijnStuk extends Vorm implements Drawable {
    private Punt startPunt;
    private Punt eindPunt;
    public LijnStuk(Punt startPunt, Punt eindPunt) throws DomainException {
        if(startPunt==null || eindPunt == null){
            throw new DomainException("Punt niet gedefineerd");
        }
        if(startPunt.equals(eindPunt)){
            throw new DomainException("De punten liggen op elkaar");
        }
        setStartEnEindPunt(startPunt,eindPunt);
    }
    private void setStartEnEindPunt(Punt startPunt, Punt eindPunt) throws DomainException {
        if(startPunt==null || eindPunt == null){
            throw new DomainException("Startpunt of eindpunt is null");
        }
        this.startPunt=startPunt;
        this.eindPunt=eindPunt;
    }

    public Punt getStartPunt() {
        return startPunt;
    }

    public Punt getEindPunt() {
        return eindPunt;
    }
    public boolean equals(Object o){
        if(o instanceof LijnStuk){
            if((((LijnStuk) o).getStartPunt().equals(this.startPunt) && ((LijnStuk) o).getEindPunt().equals(this.eindPunt)) || (((LijnStuk) o).getStartPunt().equals(this.eindPunt) && ((LijnStuk) o).getEindPunt().equals(this.startPunt))){
                return true;
            }
        }
        return false;
    }
    public String toString(){
        return "Lijn: startpunt: (" + this.startPunt.getX() + "," + this.startPunt.getY() + ")" + " - eindpunt: (" + this.startPunt.getX() + "," + this.startPunt.getY() + ")"
                +"\n" + super.toString();
    }

    @Override
    public void teken(Pane root) {
        if (isZichtbaar()) {
            Line lijnBoomstam = new Line(this.getStartPunt().getX(), this.getStartPunt().getY(), this.getEindPunt().getX(), this.getEindPunt().getY());
            root.getChildren().addAll(lijnBoomstam);
        }

    }
    public Omhullende getOmhullende() throws DomainException {
        Punt linkerbovenhoek = new Punt(startPunt.getX(),(startPunt.getY() > eindPunt.getY() ? startPunt.getY() : eindPunt.getY()) );
        Omhullende omhullende = new Omhullende(linkerbovenhoek, eindPunt.getX() - startPunt.getX(), startPunt.getY() > eindPunt.getY() ? eindPunt.getY() - startPunt.getY() : eindPunt.getY() - startPunt.getY());
        return omhullende;
    }
}
