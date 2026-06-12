package entities;

public class GiocoDaTavolo extends Gioco {

    private int numeroGiocatori;
    private int durataPartita;

    public GiocoDaTavolo(String idGioco,
                         String titolo,
                         int annoPubblicazione,
                         double prezzo,
                         int numeroGiocatori,
                         int durataPartita) {

        super(idGioco, titolo, annoPubblicazione, prezzo);

        if(numeroGiocatori < 2 || numeroGiocatori > 10) {
            System.out.println("Numero giocatori non valido");
            return;
        }

        this.numeroGiocatori = numeroGiocatori;
        this.durataPartita = durataPartita;
    }

    public int getNumeroGiocatori() {
        return numeroGiocatori;
    }

    @Override
    public String toString() {

        return "GIOCO DA TAVOLO -> " +
                super.toString() +
                " Giocatori: " + numeroGiocatori +
                " Durata partita: " + durataPartita;
    }
}
