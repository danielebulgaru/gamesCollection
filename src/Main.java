import exception.GiocoGiaPresenteException;
import exception.GiocoNonTrovatoException;
import entities.*;
import gestione.collezione;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        collezione Collezione = new collezione();

        int scelta = -1;

        while (scelta != 0) {

            System.out.println("\n--- MENU ---");
            System.out.println("1. Aggiungi videogioco");
            System.out.println("2. Aggiungi gioco da tavolo");
            System.out.println("3. Cerca per ID");
            System.out.println("4. Cerca per prezzo");
            System.out.println("5. Cerca per numero giocatori");
            System.out.println("6. Elimina gioco");
            System.out.println("7. Aggiorna gioco");
            System.out.println("8. Statistiche");
            System.out.println("0. Esci");

            try {

                System.out.print("Scelta: ");
                scelta = scanner.nextInt();
                scanner.nextLine();

                switch (scelta) {

                    //  VIDEOGIOCO
                    case 1 -> {

                        System.out.print("ID: ");
                        String id = scanner.nextLine();

                        System.out.print("Titolo: ");
                        String titolo = scanner.nextLine();

                        System.out.print("Anno: ");
                        int anno = scanner.nextInt();

                        System.out.print("Prezzo: ");
                        double prezzo = scanner.nextDouble();
                        scanner.nextLine();

                        System.out.print("Piattaforma: ");
                        String piattaforma = scanner.nextLine();

                        System.out.print("Durata ore: ");
                        int durataOre = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Genere (AZIONE, SPORT, AVVENTURA, HORROR, RPG): ");
                        ENumGenere genere = ENumGenere.valueOf(scanner.nextLine().toUpperCase());

                        Videogioco v = new Videogioco(
                                id,
                                titolo,
                                anno,
                                prezzo,
                                piattaforma,
                                durataOre,
                                genere
                        );

                        Collezione.aggiungiGioco(v);
                        System.out.println("Videogioco aggiunto");
                    }

                    //  GIOCO DA TAVOLO
                    case 2 -> {

                        System.out.print("ID: ");
                        String id = scanner.nextLine();

                        System.out.print("Titolo: ");
                        String titolo = scanner.nextLine();

                        System.out.print("Anno: ");
                        int anno = scanner.nextInt();

                        System.out.print("Prezzo: ");
                        double prezzo = scanner.nextDouble();

                        int giocatori;

                        while (true) {

                            System.out.print("Numero giocatori (2-10): ");
                            giocatori = scanner.nextInt();

                            if (giocatori >= 2 && giocatori <= 10) {
                                break;
                            }

                            System.out.println("Valore non valido! Riprova.");
                        }


                        System.out.print("Durata partita: ");
                        int durata = scanner.nextInt();
                        scanner.nextLine();

                        if (giocatori < 2 || giocatori > 10) {
                            System.out.println("Errore: numero giocatori non valido (2-10)");
                            break;
                        }

                        GiocoDaTavolo g = new GiocoDaTavolo(
                                id,
                                titolo,
                                anno,
                                prezzo,
                                giocatori,
                                durata
                        );

                        Collezione.aggiungiGioco(g);
                        System.out.println("Gioco da tavolo aggiunto");
                    }

                    //  RICERCA ID
                    case 3 -> {

                        System.out.print("ID: ");
                        String id = scanner.nextLine();

                        System.out.println(Collezione.cercaPerId(id));
                    }

                    //  RICERCA PREZZO
                    case 4 -> {

                        System.out.print("Prezzo massimo: ");
                        double prezzo = scanner.nextDouble();
                        scanner.nextLine();

                        Collezione.cercaPerPrezzo(prezzo)
                                .forEach(System.out::println);
                    }

                    //  RICERCA GIOCATORI
                    case 5 -> {

                        System.out.print("Numero giocatori: ");
                        int numero = scanner.nextInt();
                        scanner.nextLine();

                        Collezione.cercaPerNumeroGiocatori(numero)
                                .forEach(System.out::println);
                    }

                    //  ELIMINA
                    case 6 -> {

                        System.out.print("ID: ");
                        String id = scanner.nextLine();

                        Collezione.eliminaGioco(id);
                        System.out.println("Gioco eliminato");
                    }

                    //  AGGIORNA
                    case 7 -> {

                        System.out.print("ID: ");
                        String id = scanner.nextLine();

                        System.out.print("Nuovo titolo: ");
                        String titolo = scanner.nextLine();

                        System.out.print("Nuovo anno: ");
                        int anno = scanner.nextInt();

                        System.out.print("Nuovo prezzo: ");
                        double prezzo = scanner.nextDouble();
                        scanner.nextLine();

                        Collezione.aggiornaGioco(id, titolo, anno, prezzo);
                        System.out.println("Gioco aggiornato");
                    }

                    //  STATISTICHE 
                    case 8 -> Collezione.statistiche();

                    case 0 -> System.out.println("Uscita...");

                    default -> System.out.println("Scelta non valida");
                }

            } catch (GiocoGiaPresenteException | GiocoNonTrovatoException e) {
                System.out.println("Errore: " + e.getMessage());

            } catch (InputMismatchException e) {
                System.out.println("Errore: input non valido");
                scanner.nextLine();

            } catch (Exception e) {
                System.out.println("Errore generico");
            }
        }

        scanner.close();
    }
}
