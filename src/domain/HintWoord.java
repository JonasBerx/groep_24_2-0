package domain;

import java.util.ArrayList;

public class HintWoord {
    private HintLetter[] hintwoord;
    private String woord;

    public HintWoord(String woord) throws DomainException {
        if(woord == null || woord.trim().isEmpty()){
            throw new DomainException("Woord mag niet leeg zijn");
        }
        this.woord = woord;
        int length=woord.length();
        int finallength=length;
        for(int i = 0; i<length;i++){
            if(String.valueOf(woord.charAt(i)).equals(" ")){
                finallength--;
            }
        }
        this.hintwoord = new HintLetter[finallength];
        int numSpaces = 0;
        for(int i = 0; i<woord.length();i++){
            if(String.valueOf(woord.charAt(i)).equals(" ")){
                numSpaces++;
            } else{
                HintLetter letter = new HintLetter(woord.charAt(i));
                this.hintwoord[i-numSpaces] = letter;
            }

        }
    }
    public boolean raad(char letter){
        boolean isTrue=false;
        if (letter != ' ') {
            for(HintLetter l : hintwoord){
                if(l.raad(letter)){
                    isTrue=true;

                }
            }
        }

        return isTrue;
    }
    public boolean isGeraden(){
        for(HintLetter l : hintwoord){
            if(!l.isGeraden()){
                return false;
            }
        }
        return true;
    }

    public String getWoord(){
        return this.woord;
    }
    @Override
    public String toString(){
        String s = "";
        String prefix = "";
        int numSpaces = 0;
        for(int i = 0; i<woord.length();i++){
            if(String.valueOf(woord.charAt(i)).equals(" ")){
                s+=" ";
                numSpaces++;
            } else{
                s += prefix + hintwoord[i-numSpaces].toChar();
                prefix = " ";
            }
        }
        return s;
    }
}
