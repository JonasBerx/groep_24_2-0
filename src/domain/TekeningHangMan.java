package domain;

import ui.UiException;

public class TekeningHangMan extends Tekening {
    Vorm galgBodem = new Rechthoek(new Punt(10, 350), 300, 40);// altijd zichtbaar
    Vorm galgStaaf = new LijnStuk(new Punt(160, 350), new Punt(160, 50));// altijd zichtbaar
    Vorm hangbar = new LijnStuk(new Punt(160, 50), new Punt(280, 50));// altijd zichtbaar
    Vorm koord = new LijnStuk(new Punt(280, 50), new Punt(280, 100));// altijd zichtbaar
    Vorm hoofd = new Cirkel(new Punt(280, 125), 25);// zichtbaar na 1 fout
    Vorm oogLinks = new Cirkel(new Punt(270, 118), 2);// zichtbaar na 2 fouten
    Vorm oogRechts = new Cirkel(new Punt(290, 118), 2);//…
    Vorm neus = new Cirkel(new Punt(280, 128), 2);
    Vorm mond = new LijnStuk(new Punt(270, 138), new Punt(290, 138));
    Vorm lijf = new LijnStuk(new Punt(280, 150), new Punt(280, 250));
    Vorm beenLinks = new LijnStuk(new Punt(280, 250), new Punt(240, 310));
    Vorm beenRechts = new LijnStuk(new Punt(280, 250), new Punt(320, 310));
    Vorm voetLinks = new Cirkel(new Punt(240, 310), 5);
    Vorm voetRechts = new Cirkel(new Punt(320, 310), 5);
    Vorm armLinks = new LijnStuk(new Punt(280, 200), new Punt(230, 170));
    Vorm armRechts = new LijnStuk(new Punt(280, 200), new Punt(330, 170));
    Vorm handLinks = new Cirkel(new Punt(230, 170), 5);
    Vorm handRechts = new Cirkel(new Punt(330, 170), 5);

    public TekeningHangMan(String naam) throws DomainException {
        super(naam);
        //altijd zichtbaar
        super.voegToe(galgBodem);
        galgBodem.setZichtbaar(true);
        super.voegToe(galgStaaf);
        galgStaaf.setZichtbaar(true);
        super.voegToe(hangbar);
        hangbar.setZichtbaar(true);
        super.voegToe(koord);
        koord.setZichtbaar(true);

        //zichtbaar na fouten
        super.voegToe(hoofd);
        hoofd.setZichtbaar(false);
        super.voegToe(oogLinks);
        oogLinks.setZichtbaar(false);
        super.voegToe(oogRechts);
        oogRechts.setZichtbaar(false);
        super.voegToe(neus);
        neus.setZichtbaar(false);
        super.voegToe(mond);
        mond.setZichtbaar(false);
        super.voegToe(lijf);
        lijf.setZichtbaar(false);
        super.voegToe(beenLinks);
        beenLinks.setZichtbaar(false);
        super.voegToe(beenRechts);
        beenRechts.setZichtbaar(false);
        super.voegToe(voetLinks);
        voetLinks.setZichtbaar(false);
        super.voegToe(voetRechts);
        voetRechts.setZichtbaar(false);
        super.voegToe(armLinks);
        armLinks.setZichtbaar(false);
        super.voegToe(armRechts);
        armRechts.setZichtbaar(false);
        super.voegToe(handLinks);
        handLinks.setZichtbaar(false);
        super.voegToe(handRechts);
        handRechts.setZichtbaar(false);


    }

    public int getAantalOnzichtbaar() {
        int aantal = 0;
        for (int i = 0; i < super.getAantalVormen(); i++) {
            if (!super.getVormen().get(i).isZichtbaar()) {
                aantal++;
            }
        }
        return aantal;
    }

    public void zetVolgendeZichtbaar() throws DomainException {
        if (super.getVormen() == null) {
            throw new UiException("Lijst is leeg");
        }
        for (int i = 3; i < super.getAantalVormen(); i++) {
            if (!super.getVormen().get(i).isZichtbaar()) {
                super.getVormen().get(i).setZichtbaar(true);
                break;
            }
            if (super.getVorm(super.getAantalVormen()-1).isZichtbaar()) {
                throw new DomainException("Klaar");
            }
        }
    }

    public void voegToe(Vorm vorm) throws DomainException {
        if (vorm != null) {
            super.voegToe(vorm);
        } else {
            throw new DomainException("Vorm is leeg");
        }

    }

    public void verwijder(Vorm vorm) throws DomainException {
        if (super.bevat(vorm)) {
            super.verwijder(vorm);
        } else {
            throw new DomainException("Vorm is niet gevonden");
        }

    }
}
