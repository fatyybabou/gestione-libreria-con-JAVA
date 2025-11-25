import java.util.Objects;

public class CasaEditrice {

    private String nome;
    private String citta;



    public CasaEditrice(String nome, String citta)
    {
        this.nome=nome;
        this.citta=citta;

    }

    public String getNome() {
        return this.nome;
    }


    public String getCitta() {
        return this.citta;
    }

    public void setCitta(String citta) {
        this.citta=citta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CasaEditrice that = (CasaEditrice) o;
        return Objects.equals(nome, that.nome) && Objects.equals(citta, that.citta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, citta);
    }
}
