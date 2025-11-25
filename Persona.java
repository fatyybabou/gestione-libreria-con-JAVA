public class Persona {
    private int id;
    private static int prossimoId=0;
    private String cognome;
    private String indirizzo;

    public Persona(String cognome, String indirizzo){

        this.id=prossimoId;
        prossimoId++;
        this.cognome=cognome;
        this.indirizzo=indirizzo;

    }
    public int getId() {
        return this.id;
    }

    public String getCognome() {
        return this.cognome;
    }

    public String getIndirizzo() {
        return this.indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo=indirizzo;
    }


    @Override
    public String toString() {
        return  cognome ;
    }
}
