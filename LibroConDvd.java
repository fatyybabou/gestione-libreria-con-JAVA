public class LibroConDvd extends Libro{
   private String titoloDvd;
    private long durataDvd;
    private int prezzoDvd;

    public LibroConDvd(Persona Autore, String titolo, CasaEditrice casaEditrice, int valore, String titoloDvd, long durataDvd, int prezzoDvd){
        super(Autore, titolo, casaEditrice, valore);
        this.titoloDvd=titoloDvd;
        this.durataDvd=durataDvd;
        this.prezzoDvd=prezzoDvd;

    }

    public String getTitoloDvd() {
        return titoloDvd;
    }

    public long getDurataDvd() {
        return durataDvd;
    }

    public int getPrezzoDvd() {
        return prezzoDvd;
    }

    public void cambiaPrezzo(int nuovoPrezzoDvd){
       this.prezzoDvd=nuovoPrezzoDvd;

    }

public int getValoreTot(){
       return super.getValore() + this.prezzoDvd;
}

    @Override
    public String toString() {
        return "Dvd: " +
                "titoloDvd='" + titoloDvd + '\'' +
                ", durataDvd=" + durataDvd +
                ", prezzoDvd=" + prezzoDvd + " " +
        super.toString() ;
    }
}


