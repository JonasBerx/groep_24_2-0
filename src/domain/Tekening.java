package domain;

import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class Tekening implements Drawable {
    private String naam;
    private ArrayList<Vorm> vormen = new ArrayList<>();
    public static final int MIN_X = 0;
    public static final int MIN_Y = 0;
    public static final int MAX_X = 399;
    public static final int MAX_Y = 399;

    public Tekening(String naam) throws DomainException {
        if (naam == null || naam.trim().isEmpty() || isValidNaam(naam)) {
            throw new DomainException("Naam is leeg");
        }
        this.naam = naam;
    }

    public static boolean isValidNaam(String naam){
        return naam == null || naam.trim().isEmpty();
    }

    public void voegToe(Vorm vorm) throws DomainException {
        if (vorm == null) {

            throw new DomainException("Vorm is leeg");
        }
        if (vorm.getOmhullende().getMinimumY() > MIN_Y || vorm.getOmhullende().getMinimumX() > MIN_X || vorm.getOmhullende().getMaximumY() < MAX_Y || vorm.getOmhullende().getMaximumX() < MAX_X) {
            vormen.add(vorm);
        } else {
            throw new DomainException("Vorm is out of bounds");
        }
    }

    public String getNaam() {
        return naam;
    }

    public Vorm getVorm(int index) {
        return this.vormen.get(index);
    }
    
    public int getAantalVormen() {
        return vormen.size();
    }

    public void verwijder(Vorm vorm) throws DomainException {
        if (vormen.size() == 0) {
            throw new DomainException("Lijst is leeg");
        }
        for (int i = 0; i < vormen.size(); i++) {
            if (vormen.get(i).getClass() == vorm.getClass()) {
                vormen.remove(vorm);
            }
        }


    }

    public boolean bevat(Vorm vorm) {
        return vormen.contains(vorm);
    }

    public ArrayList<Vorm> getVormen() {
        return vormen;
    }

    public boolean equals(Object o) {
        if (o instanceof Tekening) {
            if (((Tekening) o).getAantalVormen() == this.vormen.size()) {
                for (int i = 0; i < ((Tekening) o).getAantalVormen(); i++) {
                    for (int j = 0; j < this.vormen.size(); j++) {
                        //Nog aan te passen, geeft niet juiste antwoorden omdat de onderstaande lijn niet juist is.
                        if (((Tekening) o).getVormen().get(i) == this.vormen.get(i)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public String toString() {
        String uitvoer = "";
        uitvoer += "Naam van tekening: " + naam;
        return uitvoer;
    }

    @Override
    public void teken(Pane root) {
        for (Vorm v : vormen) {
            if (v.isZichtbaar()) {
                v.teken(root);
            }
        }
    }
}
