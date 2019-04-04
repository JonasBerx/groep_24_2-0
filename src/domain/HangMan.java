package domain;


import domain.db.WoordenLijst;
import ui.LijnstukApp;

import java.awt.*;
import java.util.ArrayList;

public class HangMan {

    private Speler speler;
    private WoordenLijst woordenLijst;
    private TekeningHangMan tekeningHangMan;
    private HintWoord hintWoord;

    private boolean gewonnen = false;



    public HangMan(Speler speler, WoordenLijst woordenlijst) throws DomainException {
        setSpeler(speler);
        setWoordenlijst(woordenlijst);
        this.tekeningHangMan = new TekeningHangMan("Hangman");
        this.hintWoord = new HintWoord(woordenlijst.getRandomWoord());
    }

    public Speler getSpeler(){
       return speler;
    }

    public TekeningHangMan getTekening(){
        return this.tekeningHangMan;
    }

    public String getHint(){
        return hintWoord.toString();
    }

    private void setSpeler(Speler speler) throws DomainException {
        if (speler == null) {
            throw new DomainException("Speler is leeg");
        }
        this.speler = speler;
    }

    private void setWoordenlijst(WoordenLijst woordenlijst) throws DomainException {
        if (woordenlijst == null) {
            throw new DomainException("Lijst is null");
        }
        this.woordenLijst = woordenlijst;
    }

    public boolean isGameOver(){
        ArrayList<Vorm> vormen = tekeningHangMan.getVormen();
        boolean uitvoer = true;
        for (int i = 0; i < vormen.size(); i++) {
            if (vormen.get(i).isZichtbaar()) {
                uitvoer = false;
                break;
            }
        }
        return uitvoer;
    }

    public boolean isGewonnen() throws DomainException {
        if(hintWoord.isGeraden()){
            return true;
        } else{
            return false;
        }

    }

    public boolean raad(char c){
        boolean uitvoer = hintWoord.raad(c);
        if (hintWoord.isGeraden()) {
            gewonnen = true;
        }
        return uitvoer;
    }


    public HintWoord getWoord() {
        return this.hintWoord;
    }
}
