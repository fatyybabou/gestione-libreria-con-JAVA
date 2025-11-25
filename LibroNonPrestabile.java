public class LibroNonPrestabile extends Libro{

    public LibroNonPrestabile(Persona Autore, String titolo, CasaEditrice casaEditrice, int valore){
        super(Autore, titolo, casaEditrice, valore);

    }

    @Override
    public boolean setPersonaAttuale(Persona personaAttuale) {
     return false;
    }

    @Override
    public boolean cambiaLettore(Persona nuovoLettore) {
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + " Questo libro non può essere prestato" ;

    }
}
