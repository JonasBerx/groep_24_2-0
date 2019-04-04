package domain;

import javafx.scene.layout.Pane;

import java.awt.*;

public abstract class Vorm implements Drawable{
    private Color kleur = Color.white;
    private boolean isZichtbaar = true;

    public Color getKleur;

    public void setKleur(Color kleur) {
        this.kleur = kleur;
    }

    public boolean isZichtbaar() {
        return this.isZichtbaar;
    }

    public void setZichtbaar(boolean bool) {
        this.isZichtbaar = bool;
    }

    private Omhullende omhullende;

    public abstract Omhullende getOmhullende() throws DomainException;
    public String toString(){
        return omhullende.toString();
    }


}
