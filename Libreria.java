import java.util.Arrays;

public class Libreria {

    private Persona titolare;
    private String nome;
    private String indirizzo;
    private Libro[] libri;
    private int dimensioneMax;
    private int numLibri;

    public Libreria(Persona titolare, String nome, String indirizzo, int dimensioneMax) {
        this.titolare = titolare;
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.numLibri = 0;
        this.dimensioneMax = dimensioneMax;
        this.libri = new Libro[dimensioneMax];

    }

    public Persona getTitolare() {
        return titolare;
    }

    public void setTitolare(Persona titolare) {
        this.titolare = titolare;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public int inserisciLibro(Libro libro) {

        if (numLibri < dimensioneMax) {
            libri[numLibri] = libro;
            int indiceInserito = numLibri;
            numLibri++;
            return indiceInserito;
        } else {
            return -1;
        }
    }

        public Persona trovaAutore(int indice){
            if (indice >= 0 && indice < dimensioneMax && libri[indice] != null) {
                return libri[indice].getAutore();
            }
            return null;

        }

        public Persona trovaAutorePerId (int id){
            for (int i = 0; i < dimensioneMax; i++) {
                if (libri[i] != null && libri[i].getId() == id) {
                    return libri[i].getAutore();
                }
            }
            return null;
        }

     public String[] trovaLibriPerAutore(Persona autore) {
         String[] risultato = new String[dimensioneMax];
         int contatore = 0;

         for (int i = 0; i < dimensioneMax; i++) {
             if (libri[i] != null && libri[i].getAutore().equals(autore)) {
                 risultato[contatore] = libri[i].getTitolo();
                 contatore++;
             }
         }
String[] titoliAutore=new String [contatore];
         for(int i=0;i<contatore; i++){
             titoliAutore[i]= risultato[i];

         }
         return titoliAutore;
     }

public String[] datiLibri(){
        String[] libriString=new String[numLibri];
        for(int i=0; i<numLibri; i++){
            libriString[i]= libri[i].toString();

        }
        return libriString;
}



public int contaLibriConDvd(){
        int contatore=0;
        for(int i =0; i<numLibri; i++){
            if(libri[i]!=null && libri[i] instanceof LibroConDvd){
                contatore++;
            }
        }
        return contatore;
}

    public boolean modificaValore(int indice, int nuovoValore){
        if(indice>=0 && indice<numLibri && libri[indice]!= null){
            libri[indice].setValore(nuovoValore);
            return true;
        }
        return false;
    }

   public int calcolaValoreTot(){
        int valoreTot=0;
        for(int i=0; i<numLibri; i++){
            valoreTot += libri[i].getValore();
        }
        return valoreTot;
   }

   public Libro trovaValoreMax(){
        if(numLibri==0) {
            return null;
        }

        Libro libroMax=libri[0];
        for(int i=0; i<numLibri; i++){
            if(libri[i].getValore() > libroMax.getValore()){
                libroMax=libri[i];
            }
        }
        return libroMax;
   }


    public Libro trovaValoreMin(){
        if(numLibri==0) {
            return null;
        }

        Libro libroMin=libri[0];
        for(int i=0; i<numLibri; i++){
            if(libri[i].getValore() < libroMin.getValore()){
                libroMin=libri[i];
            }
        }
        return libroMin;
    }

public String[] TrovaLibriPerCasaEditrice(CasaEditrice casaEditrice){
        String[] titoliCerca=new String[numLibri];
        int contatore=0;

        for(int i=0; i<numLibri; i++){
            if(libri[i]!=null && libri[i].getCasaEditrice().equals(casaEditrice)){
                titoliCerca[contatore]=libri[i].getTitolo();
                contatore++;
            }

        }
        String[]titoliCasaEditrice=new String[contatore];
        for(int i=0; i<contatore; i++){
         titoliCasaEditrice[i]=titoliCerca[i];
        }
        return titoliCasaEditrice;
}

public int[] trovaLibriMaiPrestati(){
        int contatore=0;
        for(int i=0; i<numLibri; i++){
            if(libri[i]!=null && libri[i].getNumeroPrestiti()==0){
                contatore++;
            }
        }
        if(contatore==0){
            return new int[0];
        }
        int[] indici=new int[contatore];
        int indice=0;

        for(int i=0; i<numLibri; i++){
            if(libri[i]!=null && libri[i].getNumeroPrestiti()==0){
                indici[indice]=i;
                indice++;
            }
        }
        return indici;
}

    public Libro[] ordinaLibri(){
        Libro[] libriOrdinati=Arrays.copyOf(libri, numLibri);
        Arrays.sort(libriOrdinati);
        return libriOrdinati;
    }



}

