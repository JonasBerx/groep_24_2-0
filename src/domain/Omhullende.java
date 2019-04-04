package domain;

public class Omhullende {
    private Punt linkerBovenhoek;
    private int breedte, hoogte;

    public Omhullende(Punt linkerBovenhoek, int breedte, int hoogte) throws DomainException {
        setLinkerBovenhoek(linkerBovenhoek);
        setBreedte(breedte);
        setHoogte(hoogte);
    }

    private void setLinkerBovenhoek(Punt linkerBovenhoek) throws DomainException {
        if (linkerBovenhoek == null) throw new DomainException("linker bovenhoek mag niet null zijn.");
        this.linkerBovenhoek = linkerBovenhoek;
    }

    private void setBreedte(int breedte) throws DomainException {
//        if (breedte < 0) throw new DomainException("breedte moet groter dan 0 zijn.");
        this.breedte = breedte;
    }

    private void setHoogte(int hoogte) throws DomainException {
//        if (hoogte < 0) throw new DomainException("hoogte mag niet kleiner dan 0 zijn.");
        this.hoogte = hoogte;
    }

    public Punt getLinkerBovenhoek(){
        return linkerBovenhoek;
    }

    public int getBreedte(){
        return breedte;
    }

    public int getHoogte(){
        return hoogte;
    }

    public int getMinimumX(){
        return linkerBovenhoek.getX();
    }

    public int getMinimumY(){
        return linkerBovenhoek.getY() - hoogte;
    }

    public int getMaximumX(){
        return linkerBovenhoek.getX() + breedte;
    }

    public int getMaximumY(){
        return linkerBovenhoek.getY();
    }



    public boolean equals(Object o){

        if (o instanceof Omhullende) {
            if (((Omhullende) o).linkerBovenhoek == null) return false;
            return ((Omhullende) o).linkerBovenhoek == this.linkerBovenhoek && ((Omhullende) o).breedte == this.breedte && ((Omhullende) o).hoogte == this.hoogte;
        }
        return false;
    }

    public String toString(){
        return "Omhullende: ( " + linkerBovenhoek.getX() + ", " + linkerBovenhoek.getY() + ") - " + breedte + " - " + hoogte;
    }


}
