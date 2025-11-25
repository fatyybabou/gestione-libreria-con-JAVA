import java.util.*;

public class YellowPages {

    private HashMap<String, Libreria> librerieCitta;
    private ArrayList<Persona> personeIscritte;

    public YellowPages() {
        librerieCitta = new HashMap<String, Libreria>();
        personeIscritte = new ArrayList<>();
    }

    public boolean inserisciLibreria(String citta, Libreria l) {
        if (citta == null || l == null) {
            return false;
        }
            return librerieCitta.putIfAbsent(citta, l) == null;
        }


    public boolean eliminaLibreria(String citta, Libreria l) {
        return librerieCitta.remove(citta, l);
    }

    public boolean inserisciIscritto(Persona p) {
        return personeIscritte.add(p);
    }

    public boolean rimuoviIscritto(Persona p) {
        return personeIscritte.remove(p);
    }

    public ArrayList<String> trovaCittaPerAutore(Persona autore) {
        ArrayList<String> cittaConAutore = new ArrayList<>();

        for (Map.Entry<String, Libreria> entry : librerieCitta.entrySet()) {
            String citta = entry.getKey();
            Libreria libreria = entry.getValue();

            String[] libriAutore = libreria.trovaLibriPerAutore(autore);
            if (libriAutore != null && libriAutore.length > 0) {
                cittaConAutore.add(citta);
            }
        }
        return cittaConAutore;

    }

    public ArrayList<String> trovaLibriPerCitta(String citta) {
        ArrayList<String> titoliLibri = new ArrayList<>();

        Libreria libreria = librerieCitta.get(citta);
        if (libreria != null) {
            String[] titoli = libreria.datiLibri();
            for (String titolo : titoli) {
                titoliLibri.add(titolo);
            }
        }

        return titoliLibri;

    }

    public ArrayList<String> elencoIscrittiAlfabetico(){
        ArrayList<String> cognomiIscritti=new ArrayList<>();

        for(Persona persona : personeIscritte){
            cognomiIscritti.add(persona.getCognome());
        }

        Collections.sort(cognomiIscritti);
        return cognomiIscritti;
    }

    public int getNumeroIscritti(){
        return personeIscritte.size();
    }

public ArrayList<String> elencoCittaConLibrerie(){
        ArrayList<String> elencoCitta=new ArrayList<>(librerieCitta.keySet());
        Collections.sort(elencoCitta);
        return elencoCitta;
}
}