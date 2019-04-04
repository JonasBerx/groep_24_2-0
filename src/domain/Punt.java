package domain;



public class Punt implements  Comparable<Punt>{
    private int xCoordinaat, yCoordinaat;

    public Punt(int xCoordinaat, int yCoordinaat) {
        this.xCoordinaat = xCoordinaat;
        this.yCoordinaat = yCoordinaat;
    }


    public int getX() {
        return xCoordinaat;
    }

    public int getY() {
        return yCoordinaat;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Punt) {
            if (((Punt) o).yCoordinaat == this.yCoordinaat && ((Punt) o).xCoordinaat == this.xCoordinaat) {
                return true;
            }
            return false;
        }
        return false;
    }


    public String toString() {
        return "(" + getX() + ", " + getY() + ")";
    }


    @Override
    public int compareTo(Punt o) {
        if(this.xCoordinaat < o.getX())
            return -1;

        else if(this.xCoordinaat > o.getX())
            return 1;

        else
            if(this.yCoordinaat < o.getY())
                return -1;

            else if(this.getY() > o.getY())
                return 1;

            else return 0;
    }
}

