public class Misurazione {
    public static int lastId = 0;
    public int id;
    public Citta citta_A;
    public Citta citta_B;
    public double distCalcolata;
    public double distReale;
    public double differenzaDistanze;

    public Misurazione(Citta citta_A, Citta citta_B) {
        this.id = lastId++;
        this.citta_A = citta_A;
        this.citta_B = citta_B;
        this.distCalcolata = new Operazione().distanza(citta_A.latitudine, citta_A.longitudine, citta_B.latitudine, citta_B.longitudine) ;
    }

    public void setDifferenzaDistanze(){
        differenzaDistanze = Math.abs(distCalcolata-distReale);
    }


    @Override
    public String toString(){
        return "\nID: " + id + "\nCittà A: " + citta_A + "\nCittà B: " + citta_B + "\nDistanza calcolata: " + distCalcolata + " km."
                + "\nDistanza reale: " + distReale + " km." + "\nDifferenza: " + differenzaDistanze;

    }
}