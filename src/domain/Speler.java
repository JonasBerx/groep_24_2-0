package domain;
import domain.DomainException;

public class Speler {
    private String naam;
    private int score;

    public Speler(String naam) throws DomainException {

        if (naam == null || naam.trim().isEmpty()) {
            throw new DomainException("Naam ingeven");
        }
        this.naam = naam;
        setScore(score);
    }

    public boolean equals(Object o) {
        if (o instanceof Speler) {
            if (((Speler) o).getNaam().equals(this.naam) && ((Speler) o).getScore() == this.score) {
                return true;
            }
        }
        return false;
    }


    public void addToScore(int amount) throws DomainException {
        score += amount;
        if (score < 0) {
            throw new DomainException("Score is negatief");
        }
    }

    public String format(){
        return "Naam: " + naam + "\nScore" + score;
    }


    public String getNaam() {
        return naam;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        if(score < 0)
            throw new IllegalArgumentException("score moet groter dan 0 zijn");

        this.score = score;
    }

    public void setNaam(String naam) throws DomainException {
        if (naam == null || naam.trim().isEmpty()) {
            throw new DomainException("Naam is ongeldig");
        }
        this.naam = naam;
    }
}
