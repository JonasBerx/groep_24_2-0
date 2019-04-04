package domain.db;


import domain.DomainException;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.zip.DataFormatException;

import static domain.db.WoordLezer.getReader;
import static domain.db.WoordLezer.getReader;


public class WoordenLijst {
   private ArrayList<String> woorden;

    public WoordenLijst(){
        woorden = new ArrayList<>();
    }

    private static String readLine(BufferedReader in){
        String line = "";
        try {
            line = in.readLine();
        } catch (IOException e) {
            System.out.println("I/O Error");
            System.exit(0);
        }
        return Objects.requireNonNullElse(line, "");
    }

    public void leesBestand(String fileName) throws IOException {

        BufferedReader in = getReader(fileName);
        while(true){
            String line = readLine(in);
            if(line.equals("")){
                break;
            }
            woorden.add(line);
        }
    }

    public WoordenLijst(WoordLezer woordLezer) {
        woorden = woordLezer.getWoorden();
    }

    public int getAantalWoorden() throws DomainException {

        return  woorden.size();
    }

    public void voegToe(String woord) throws DbException {
        if (woord == null || woord.trim().isEmpty() ){
            throw new DbException("woord mag niet leeg zijn.");
        }
        for (String w: woorden){
            if (w.equals(woord)) throw new DbException("de woord zit al in de lijst.");
        }
        woorden.add(woord);

    }

    public String getRandomWoord() {
        int random = (int) Math.random() * (woorden.size() + 1);
        if (woorden.size() == 0) {
            return "null";
        } else {
            return woorden.get(random);
        }
    }

    public String toString() {
        String uitvoer = "";
        for (int i = 0; i < woorden.size(); i++) {
            uitvoer += woorden.get(i) + "\n";
        }
        return uitvoer;
    }


}