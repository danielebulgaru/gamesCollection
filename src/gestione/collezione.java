package gestione;

import exception.GiocoGiaPresenteException;
import exception.GiocoNonTrovatoException;
import entities.Gioco;
import entities.GiocoDaTavolo;
import entities.Videogioco;

import java.util.ArrayList;
import java.util.List;

public class collezione {

    private List<Gioco> listaGiochi;

    public collezione() {
        listaGiochi = new ArrayList<>();
    }

    public void aggiungiGioco(Gioco gioco)
            throws GiocoGiaPresenteException {

        boolean trovato = listaGiochi.stream()
                .anyMatch(g -> g.getIdGioco().equalsIgnoreCase(gioco.getIdGioco()));

        if(trovato) {
            throw new GiocoGiaPresenteException("ID già esistente");
        }

        listaGiochi.add(gioco);
    }

    public Gioco cercaPerId(String id)
            throws GiocoNonTrovatoException {

        for(Gioco gioco : listaGiochi) {

            if(gioco.getIdGioco().equalsIgnoreCase(id)) {
                return gioco;
            }
        }

        throw new GiocoNonTrovatoException("Gioco non trovato");
    }

    public List<Gioco> cercaPerPrezzo(double prezzo) {

        return listaGiochi.stream()
                .filter(g -> g.getPrezzo() < prezzo)
                .toList();
    }

    public List<GiocoDaTavolo> cercaPerNumeroGiocatori(int numero) {

        return listaGiochi.stream()
                .filter(g -> g instanceof GiocoDaTavolo)
                .map(g -> (GiocoDaTavolo) g)
                .filter(g -> g.getNumeroGiocatori() == numero)
                .toList();
    }

    public void eliminaGioco(String id)
            throws GiocoNonTrovatoException {

        Gioco gioco = cercaPerId(id);

        listaGiochi.remove(gioco);
    }

    public void aggiornaGioco(String id,
                              String nuovoTitolo,
                              int nuovoAnno,
                              double nuovoPrezzo)
            throws GiocoNonTrovatoException {

        Gioco gioco = cercaPerId(id);

        gioco.setTitolo(nuovoTitolo);
        gioco.setAnnoPubblicazione(nuovoAnno);
        gioco.setPrezzo(nuovoPrezzo);
    }

    public void statistiche() {

        long numeroVideogiochi =
                listaGiochi.stream()
                        .filter(g -> g instanceof Videogioco)
                        .count();

        long numeroGiochiTavolo =
                listaGiochi.stream()
                        .filter(g -> g instanceof GiocoDaTavolo)
                        .count();

        double mediaPrezzi =
                listaGiochi.stream()
                        .mapToDouble(Gioco::getPrezzo)
                        .average()
                        .orElse(0);

        Gioco giocoCostoso =
                listaGiochi.stream()
                        .max((g1, g2) ->
                                Double.compare(g1.getPrezzo(),
                                        g2.getPrezzo()))
                        .orElse(null);

        System.out.println("Videogiochi: " + numeroVideogiochi);
        System.out.println("Giochi da tavolo: " + numeroGiochiTavolo);
        System.out.println("Media prezzi: " + mediaPrezzi);

        if(giocoCostoso != null) {
            System.out.println("Gioco più costoso:");
            System.out.println(giocoCostoso);
        }
    }
}
