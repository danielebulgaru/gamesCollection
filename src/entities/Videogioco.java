package entities;

public class Videogioco extends Gioco {

    private String piattaforma;
    private int durataOre;
    private ENumGenere genere;

    public Videogioco(String idGioco,
                      String titolo,
                      int annoPubblicazione,
                      double prezzo,
                      String piattaforma,
                      int durataOre,
                      ENumGenere genere) {

        super(idGioco, titolo, annoPubblicazione, prezzo);

        this.piattaforma = piattaforma;
        this.durataOre = durataOre;
        this.genere = genere;
    }

    @Override
    public String toString() {

        return "VIDEOGIOCO -> " +
                super.toString() +
                " Piattaforma: " + piattaforma +
                " Durata: " + durataOre +
                " Genere: " + genere;
    }
}
