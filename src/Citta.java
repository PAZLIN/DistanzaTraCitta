public class Citta {

    String nome;
    double latitudine;
    double longitudine;


    public Citta(String nome, double latitudine, double longitudine){
        this.nome = nome;
        this.latitudine = latitudine;
        this.longitudine = longitudine;
    }


    @Override
    public String toString() {
        return "Citta{" +
                "nome='" + nome + '\'' +
                '}';
    }
}