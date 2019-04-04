package domain;
import domain.DomainException;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;

public class Driehoek extends Vorm implements Drawable {
    private Punt hoekPunt1, hoekPunt2, hoekPunt3;

    public Driehoek(Punt hoekPunt1, Punt hoekPunt2, Punt hoekPunt3) throws DomainException {

        if (hoekPunt1 == null || hoekPunt2 == null || hoekPunt3 == null)
            throw new DomainException("Elk hoekpunt moet een waarde hebben ");

        if (hoekPunt1.equals(hoekPunt2) || hoekPunt2.equals(hoekPunt3) || hoekPunt1.equals(hoekPunt3))
            throw new DomainException("hoekpunten mogen niet samenvallen");

        if(liggenOp1Lijn(hoekPunt1, hoekPunt2, hoekPunt3))
            throw new DomainException("De driepunten liggen op 1 lijn");


        this.hoekPunt1 = hoekPunt1;
        this.hoekPunt2 = hoekPunt2;
        this.hoekPunt3 = hoekPunt3;

    }


    public boolean liggenOp1Lijn(Punt hoekPunt1, Punt hoekPunt2, Punt hoekPunt3){
        if ((hoekPunt2.getX() - hoekPunt1.getX() * (hoekPunt3.getY() - hoekPunt1.getY())) == (hoekPunt3.getX() - hoekPunt1.getX()) * (hoekPunt2.getY() - hoekPunt1.getY()))
            return true;
        return false;
    }

    private void sorteerHoekpunten(){
        Punt swap = new Punt(hoekPunt1.getX(), hoekPunt1.getY() );
        if(hoekPunt1.compareTo(hoekPunt2) > 0) {
            hoekPunt1 = swap;
            hoekPunt2 = hoekPunt1;
            hoekPunt2 = swap;
        }

        if(hoekPunt2.compareTo(hoekPunt3) > 0) {
            hoekPunt2 = swap;
            hoekPunt3 = hoekPunt2;
            hoekPunt3 = swap;
        }

        if(hoekPunt3.compareTo(hoekPunt1) > 0) {
            hoekPunt3 = swap;
            hoekPunt1 = hoekPunt3;
            hoekPunt1 = swap;
        }
    }

    public boolean equals(Object o){

        if(o instanceof Driehoek){
            if(((Driehoek) o).getHoekPunt1() == ((Driehoek) o).getHoekPunt2() && ((Driehoek) o).getHoekPunt1() == ((Driehoek) o).getHoekPunt3() && ((Driehoek) o).getHoekPunt2() == ((Driehoek) o).getHoekPunt3())
                return true;

            return false;
        }
        return false;
    }



    public String toString(){
        return "Driehoek: hoekpunt1: (" +hoekPunt1.getX()+","+hoekPunt1.getX()+
                ") - hoekpunt2: (" + hoekPunt2.getX() + "," + hoekPunt2.getX()+
                ") - hoekpunt3: (" +hoekPunt3.getX()+","+hoekPunt3.getX()+")";
    }

    private Punt getGrootsteY(Punt p1, Punt p2, Punt p3) {
        if (p1.getY() > p2.getY()) {
            if (p1.getY() > p3.getY()) {
                return p1;
            } else {
                return p3;
            }
        } else if (p2.getY() > p3.getY()){
            return p2;
        } else {
            return p3;
        }
    }

    private Punt getLaagsteY(Punt p1, Punt p2, Punt p3) {
        if (p1.getY() < p2.getY()) {
            if (p1.getY() < p3.getY()) {
                return p1;
            } else {
                return p3;
            }
        } else if (p2.getY() < p3.getY()){
            return p2;
        } else {
            return p3;
        }
    }

    @Override
    public Omhullende getOmhullende() throws DomainException{

        Punt linkerbovenhoek = new Punt(hoekPunt1.getX(), this.getGrootsteY(hoekPunt1, hoekPunt2, hoekPunt3).getY());
        Omhullende omhullende = new Omhullende(linkerbovenhoek, hoekPunt3.getX() - hoekPunt1.getX(), getGrootsteY(hoekPunt1, hoekPunt2, hoekPunt3).getY() - getLaagsteY(hoekPunt1, hoekPunt2, hoekPunt3).getY());
        return omhullende;
    }

    public Punt getHoekPunt1() {
        return hoekPunt1;
    }

    public Punt getHoekPunt2() {
        return hoekPunt2;
    }

    public Punt getHoekPunt3() {
        return hoekPunt3;
    }

    @Override
    public void teken(Pane root) {
        if (isZichtbaar()) {
            Polyline driehoekDak = new Polyline();
            driehoekDak.setFill(Color.RED);
            driehoekDak.setStroke(Color.BLACK);
            driehoekDak.getPoints().addAll(new Double[]{(double) this.getHoekPunt1().getX(), (double) this.getHoekPunt1().getY(), (double) this.getHoekPunt2().getX(),
                    (double) this.getHoekPunt2().getY(), (double) this.getHoekPunt3().getX(), (double) this.getHoekPunt3().getY()});
            root.getChildren().addAll(driehoekDak);
        }

    }
}