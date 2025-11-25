import java.util.*;

public class Main {
    public static void main(String[] args) {

        Persona persona = new Persona("Bruni", "Via Colombo");
        Persona persona2 = new Persona("Colombo", "Via Pascoli");
        Persona persona3 = new Persona("Gallo", "via Luigi Einaudi");
        Persona persona4 = new Persona("Angeli", "via Roma");
        Persona autore1 = new Persona("Manzoni", "Via XI settembre");
        Persona autore2 = new Persona("Orwell", "Via Carducci");
        Persona autore3 = new Persona("Svevo", "Piazza Martiri della Libertà");
        CasaEditrice casaEditrice1 = new CasaEditrice("Feltrinelli", "Milano");
        CasaEditrice casaEditrice2 = new CasaEditrice("Mondadori", "Torino");
        Persona titolare1 = new Persona("Levi", "Via Nizza");
        Libreria libreria1 = new Libreria(titolare1, "Libreria1", "Via XX settembre", 6);
        Libreria libreria2=new Libreria(titolare1, "Libreria2", "Corso Casale", 6 );
        Libreria libreria3=new Libreria(titolare1, "Libreria3", "Corso Belgio ", 6 );

        Libro libro1 = new Libro(autore1, "I promessi Sposi", casaEditrice1, 25);
        Libro libro2 = new Libro(autore2, "1984", casaEditrice2, 21);
        Libro libro3 = new Libro(autore3, "La coscienza di Zeno", casaEditrice2, 32);
        Libro libro4 = new Libro(autore1, "I promessi Sposi", casaEditrice1, 25);

        LibroConDvd libroConDvd1 = new LibroConDvd(autore1, "Il Re Leone", casaEditrice2, 30, "Il Re leone", 95, 10);
        LibroNonPrestabile libroNonPrestabile1 = new LibroNonPrestabile(autore3, "Senilità", casaEditrice1, 28);

        YellowPages yellowPages=new YellowPages();

        casaEditrice2.setCitta("Roma");
        System.out.println("La nuova sede della casa editrice '" + casaEditrice2.getNome() + "' è " + casaEditrice2.getCitta());

        libro2.aumentaValore(12);
        System.out.println("Il nuovo valore del libro '" + libro2.getTitolo() + "' è di " + libro2.getValore() + "€");

        libro1.cambiaLettore(persona2);
        System.out.println("Il nuovo lettore che ha in prestito il libro '" + libro1.getTitolo() + "' è " + libro1.getPersonaAttuale().getCognome());

        libro1.cambiaLettore(persona3);
        System.out.println("Il nuovo lettore che ha in prestito il libro '" + libro1.getTitolo() + "' è " + libro1.getPersonaAttuale().getCognome());

        libroConDvd1.cambiaLettore(persona);
        System.out.println("Il nuovo lettore che ha in prestito il libro '" + libroConDvd1.getTitolo() + "' è " + libroConDvd1.getPersonaAttuale().getCognome());


        System.out.println("Il numero di prestiti totali del libro '" + libro1.getTitolo() + "' è " + libro1.getNumeroPrestiti());


        System.out.println("Il numero di libri disponibili al momento è di " + Libro.getNumeroLibriDisponibili());

        System.out.println(libro1);
        System.out.println(libroConDvd1);
        System.out.println(libroNonPrestabile1);


        boolean b = libroNonPrestabile1.setPersonaAttuale(persona2);
        if (!b) {
            System.out.println("Il libro '" + libroNonPrestabile1.getTitolo() + "' non può essere dato in prestito");
        }

        boolean b1 = libroNonPrestabile1.cambiaLettore(persona3);
        if (!b1) {
            System.out.println("Il libro '" + libroNonPrestabile1.getTitolo() + "' non può essere dato in prestito");
        }

        System.out.println("Il valore iniziale del libro '" + libroConDvd1.getTitolo() + "' è " + libroConDvd1.getValoreTot() + " €");

        libroConDvd1.cambiaPrezzo(5);
        System.out.println("Il nuovo prezzo del libro '" + libroConDvd1.getTitolo() + "' è " + libroConDvd1.getValoreTot() + " €");

        libroConDvd1.cambiaPrezzo(12);
        System.out.println("Il nuovo prezzo del libro '" + libroConDvd1.getTitolo() + "' è " + libroConDvd1.getValoreTot() + " €");

        if (libro1.equals(libroConDvd1)) {
            System.out.println("Il libro '" + libro1.getTitolo() + " e il libro '" + libroConDvd1.getTitolo() + "' sono equivalenti");
        } else {
            System.out.println("Il libro '" + libro1.getTitolo() + " e il libro '" + libroConDvd1.getTitolo() + "' non sono equivalenti");
        }

        if (libro1.equals(libro4)) {
            System.out.println("Il libro '" + libro1.getTitolo() + " e il libro '" + libro4.getTitolo() + "' sono equivalenti");
        } else {
            System.out.println("Il libro '" + libro1.getTitolo() + " e il libro '" + libro4.getTitolo() + "' non sono equivalenti");
        }

        int indice0 = libreria1.inserisciLibro(libro1);
        System.out.println("Il libro " + libro1.getTitolo() + " è stato inserito all'indice: " + indice0);

        int indice1 = libreria1.inserisciLibro(libro2);
        System.out.println("Il libro " + libro2.getTitolo() + " è stato inserito all'indice: " + indice1);

        int indice2 = libreria1.inserisciLibro(libro3);
        System.out.println("Il libro " + libro3.getTitolo() + " è stato inserito all'indice: " + indice2);

        int indice3 = libreria1.inserisciLibro(libro4);
        System.out.println("Il libro " + libro4.getTitolo() + " è stato aggiunto all'indice: " + indice3);


        int indice4 = libreria1.inserisciLibro(libroConDvd1);
        System.out.println("Il libro " + libroConDvd1.getTitolo() + " è stato inserito all'indice: " + indice4);

        int indice5 = libreria1.inserisciLibro(libroNonPrestabile1);
            System.out.println("Il libro " + libroNonPrestabile1.getTitolo() + " è stato inserito all'indice: " + indice5);

        int indice6 = libreria1.inserisciLibro(libro4);
        if(indice6 == -1) {
            System.out.println("Impossibile aggiungere il libro '" + libro4.getTitolo() + "' perché la libreria è piena");
        }
        else {
            System.out.println("Il libro " + libro4.getTitolo() + " è stato inserito all'indice: " + indice6);
        }

        System.out.println("Autore del libro in posizione 1: " + libreria1.trovaAutore(1));


        int ind0 = libreria2.inserisciLibro(libro1);
        System.out.println("Il libro " + libro1.getTitolo() + " è stato inserito all'indice: " + indice0);

        int ind1 = libreria2.inserisciLibro(libro2);
        System.out.println("Il libro " + libro2.getTitolo() + " è stato inserito all'indice: " + indice1);

        int ind2 = libreria2.inserisciLibro(libro4);
        System.out.println("Il libro " + libro4.getTitolo() + " è stato aggiunto all'indice: " + indice2);



        int idLibroCercare = 2;
        Persona autoreTrovato = libreria1.trovaAutorePerId(idLibroCercare);

        if (autoreTrovato != null) {
            System.out.println("L'autore del libro con l'id " + idLibroCercare + " è " + autoreTrovato.getCognome());
        } else {
            System.out.println("Il libro con " + idLibroCercare + " non è stato trovato");

        }
String[] titoliAutore=libreria1.trovaLibriPerAutore(autore1);
        System.out.println("Libri scritti da Manzoni: ");
        for(String titolo: titoliAutore) {
            if (titolo != null) {
                System.out.println(titolo);
            }
        }

        String[] libriString= libreria1.datiLibri();
        System.out.println("Dati di tutti i libri in libreria");
        for(String dati : libriString){
            System.out.println(dati);
        }

        int numeroLibriConDvd=libreria1.contaLibriConDvd();
        System.out.println("Il numero di libri con dvd è " + numeroLibriConDvd);

        System.out.println("Valore iniziale del libro in posizione 2: " + libro3.getValore() + " €" );
       boolean nuovoValore=libreria1.modificaValore(indice2, 40);

if(nuovoValore){
    System.out.println("Il valore del libro in posizione " + indice2 + " è stato modificato.");
    System.out.println("Il nuovo valore del libro " + libro3.getTitolo() + " è di " + libro3.getValore() + " €" );

}
else{
    System.out.println("L'azione di modificare il valore del libro non è andata a buon fine");
}



int valoreTot=libreria1.calcolaValoreTot();
        System.out.println("Il valore totale dei libri presenti nella libreria è di " + valoreTot + " €");

  Libro libroMax=libreria1.trovaValoreMax();
  Libro libroMin=libreria1.trovaValoreMin();

  if(libroMax!=null){
      System.out.println("Il libro presente nella libreria con il valore massimo è '" + libroMax.getTitolo() + "' e il suo valore è di " + libroMax.getValore() + " €");
  }

  if(libroMin!=null){
      System.out.println("Il libro presente nella libreria con il valore minimo è '" + libroMin.getTitolo() + "' e il suo valore è di " + libroMin.getValore() + " €");
        }


  String[] titoliMondadori=libreria1.TrovaLibriPerCasaEditrice(casaEditrice2);

        System.out.println("Libri pubblicati da Mondadori:");
  for(String titolo : titoliMondadori){
      System.out.println(titolo);
  }

  int[] indiciMaiPrestati=libreria1.trovaLibriMaiPrestati();

        System.out.println("Gli indici dei libri che non sono mai stati presi in prestito sono: ");
        for(int indice: indiciMaiPrestati){
            System.out.println(indice);
        }

        System.out.println("Lista dei libri in ordine alfabetico:");
        Libro[] libriOrdinati=libreria1.ordinaLibri();
        for(Libro libri: libriOrdinati){
            System.out.println(libri.getTitolo());
        }

       boolean l1= yellowPages.inserisciLibreria("Torino", libreria1);
        if(l1){
            System.out.println("La libreria1 ora si trova a Torino");
        }
        else{
            System.out.println("Nella città di Torino è già presente una libreria");
        }

        boolean l2=yellowPages.inserisciLibreria("Torino", libreria2);
        if(l2){
            System.out.println("La libreria2 ora si trova  a Torino");
        }
        else{
            System.out.println("Nella città di Torino è già presente una libreria");
        }

        boolean lib2=yellowPages.inserisciLibreria("Milano", libreria2);
        if(lib2){
            System.out.println("La libreria2 ora si trova a Milano");
        }
        else{
            System.out.println("Nella città di Milano è già presente una libreria");
        }


        boolean l3=yellowPages.inserisciLibreria("Firenze", libreria3);
        if(l3){
            System.out.println("La libreria3 ora si trova a Firenze");
        }
        else{
            System.out.println("Nella città di Firenze è già presente una libreria");
        }

        boolean libreriaCitta3=yellowPages.eliminaLibreria("Firenze", libreria3);
        if(libreriaCitta3){
            System.out.println("La coppia Firenze-libreria3 è stata eliminata");
        }
        else{
            System.out.println("Non è stato possibile eliminare la coppia Firenze-libreria3");
        }

       boolean pIscritta=yellowPages.inserisciIscritto(persona3);
        if(pIscritta){
            System.out.println("Il Signor " + persona3.getCognome() + " è stato inserito nella lista delle persone iscritte alle librerie");
        }
        else{
            System.out.println("Non è stato possibile inserire il Signor "  + persona3.getCognome() + " nella lista delle persone iscritte alle librerie");
        }

        boolean rimuoviP=yellowPages.rimuoviIscritto(persona3);
        if(rimuoviP){
            System.out.println("Il Signor " + persona3.getCognome() + " è stato rimosso dalla lista delle persone iscritte alle librerie");
        }
        else{
            System.out.println("Non è stato possibile rimuovere il Signor "  + persona3.getCognome() + " dalla lista delle persone iscritte alle librerie");
        }

        boolean pIscritta1=yellowPages.inserisciIscritto(persona);
        if(pIscritta1){
            System.out.println("Il Signor " + persona.getCognome() + " è stato inserito nella lista delle persone iscritte alle librerie");
        }
        else{
            System.out.println("Non è stato possibile inserire il Signor "  + persona.getCognome() + " nella lista delle persone iscritte alle librerie");
        }

        boolean pIscritta2=yellowPages.inserisciIscritto(persona2);
        if(pIscritta2){
            System.out.println("Il Signor " + persona2.getCognome() + " è stato inserito nella lista delle persone iscritte alle librerie");
        }
        else{
            System.out.println("Non è stato possibile inserire il Signor "  + persona2.getCognome() + " nella lista delle persone iscritte alle librerie");
        }

        boolean pIscritta4=yellowPages.inserisciIscritto(persona4);
        if(pIscritta4){
            System.out.println("Il Signor " + persona4.getCognome() + " è stato inserito nella lista delle persone iscritte alle librerie");
        }
        else{
            System.out.println("Non è stato possibile inserire il Signor "  + persona4.getCognome() + " nella lista delle persone iscritte alle librerie");
        }



        ArrayList<String> cittaConLibri=yellowPages.trovaCittaPerAutore(autore1);
        System.out.println("Citta le cui librerie contengono libri scritti da " + autore1.getCognome() + ": ");
        for(String citta : cittaConLibri){
            System.out.println(citta);
        }

        ArrayList<String> titoliTorino=yellowPages.trovaLibriPerCitta("Torino");
        System.out.println("Libri disponibili nella libreria di Torino: ");
        for(String titolo : titoliTorino){
            System.out.println(titolo);
        }

        ArrayList<String> iscrittiAlfabetico=yellowPages.elencoIscrittiAlfabetico();
        System.out.println("Elenco dei cognomi delle persone iscritte alle librerie in ordine alfabetico:");

        for(String cognome : iscrittiAlfabetico){
            System.out.println(cognome);
        }

        System.out.println("Numero di persone iscritte alle librerie: " + yellowPages.getNumeroIscritti());

        ArrayList<String> cittaConLibrerieElenco=yellowPages.elencoCittaConLibrerie();
        System.out.println("Elenco delle città in cui c'è una libreria: ");
        for(String citta : cittaConLibrerieElenco){
            System.out.println(citta);
        }

    }
}

