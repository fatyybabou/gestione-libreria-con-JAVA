import java.util.Objects;


public class Libro implements Comparable <Libro>{

    private Persona autore;
    private String titolo;
    private CasaEditrice casaEditrice;
    private int id;
    private static int prossimoId=0;
    private Persona personaAttuale;
    private int valore;
    private int numeroPrestiti;
    private static int numeroLibriDisponibili=0;

    public Libro(Persona autore, String titolo, CasaEditrice casaEditrice, int valore)
    {
        this.autore=autore;
        this.titolo=titolo;
        this.casaEditrice=casaEditrice;
        this.id=prossimoId;
        prossimoId++;
        this.personaAttuale=null;
        this.valore=valore;
        this.numeroPrestiti=0;
        numeroLibriDisponibili++;
    }



    public Persona getAutore() {
        return autore;
    }


    public String getTitolo() {
        return titolo;
    }


    public CasaEditrice getCasaEditrice() {
        return casaEditrice;
    }


    public int getId() {
        return id;
    }

    public Persona getPersonaAttuale() {
        return personaAttuale;
    }


    public int getValore() {
        return valore;
    }



    public void setAutore(Persona autore){
        this.autore=autore;
    }


    public void setTitolo(String titolo){
        this.titolo=titolo;
    }


    public void setCasaEditrice(CasaEditrice casaEditrice) {
        this.casaEditrice=casaEditrice;
    }


    public boolean setPersonaAttuale(Persona personaAttuale) {
        this.personaAttuale=personaAttuale;
        return true;
    }


    public void setValore(int valore) {
        this.valore=valore;
    }


    public void aumentaValore(int incremento){
        this.valore+= incremento;
    }

    public boolean cambiaLettore(Persona nuovoLettore){
        this.personaAttuale=nuovoLettore;
        aumentaNumeroPrestiti();
        return true;
    }

    public int getNumeroPrestiti() {
        return numeroPrestiti;
    }

    public static int getNumeroLibriDisponibili() {
        return numeroLibriDisponibili;
    }


    private void aumentaNumeroPrestiti(){
        this.numeroPrestiti++;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return Objects.equals(autore, libro.autore) && Objects.equals(titolo, libro.titolo);
    }

    @Override
    public String toString() {
       return  "Libro: " +
                " autore=" + autore.getCognome() +
                ", titolo='" + titolo + '\'' +
                ", casaEditrice=" + casaEditrice.getNome() +
                ", id=" + id +
                ", valore=" + valore + " " +
               "Numero di prestiti: " + numeroPrestiti + "\n";

    }


    public int compareTo(Libro l) {
        return this.getTitolo().compareTo(l.getTitolo());
    }



    }






