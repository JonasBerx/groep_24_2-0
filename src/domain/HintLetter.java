package domain;

public class HintLetter {
    private char letter;
    private boolean isGeraden;
    public HintLetter(char letter) {
        this.letter = letter;
        this.isGeraden = false;
    }

    public char getLetter() {
        return letter;
    }

    public boolean raad(char letter){
        if(this.isGeraden){
            return false;
        }
        if(String.valueOf(this.letter).toLowerCase().equals(String.valueOf(letter).toLowerCase())){
            this.isGeraden = true;
            return true;
        }
        return false;
    }
    public char toChar(){
        if(this.isGeraden){
            return letter;
        }
        return '_';
    }

    public boolean isGeraden(){
        return isGeraden;
    }
}
