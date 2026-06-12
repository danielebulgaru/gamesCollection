package entities;

public abstract class Gioco {

    private String idGioco;
    private String titolo;
    private int annoPubblicazione;
    private double prezzo;

    public Gioco(String idGioco, String titolo,
                 int annoPubblicazione, double prezzo) {

        if(prezzo <= 0) {
            System.out.println("Prezzo non valido");
            return;
        }

        this.idGioco = idGioco;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.prezzo = prezzo;
    }

    public String getIdGioco() {
        return idGioco;
    }

    public String getTitolo() {
        return titolo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public void setPrezzo(double prezzo) {

        if(prezzo <= 0) {
            System.out.println("Prezzo non valido");
            return;
        }

        this.prezzo = prezzo;
    }

    @Override
    public String toString() {

        return "ID: " + idGioco +
                " Titolo: " + titolo +
                " Anno: " + annoPubblicazione +
                " Prezzo: " + prezzo;
    }
}
