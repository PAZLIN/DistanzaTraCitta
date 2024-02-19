import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {

        Operazione op = new Operazione();



        float[] datiX = new float[]{1, 2, 3, 4, 5, 69};
        float[] datiY = new float[]{12, 18, 22, 30, 45, 50};

        System.out.println(op.covarianza(datiX, datiY));
        System.out.println(op.correlazione(datiX, datiY));
        System.out.println(op.regressioneLineare(datiX, datiY, 10));

        System.out.println(op.distanza(10, 20, 10, 30));

        // creo qualche citta con relative coordinate
        Citta milano = new Citta("Milano", 45.4637, 9.18817);
        Citta firenze = new Citta("Firenze", 43.7687, 11.2569);
        Citta roma = new Citta("Roma", 41.878243, 12.52809);
        Citta londra = new Citta("Londra", 51.509648, -0.099076);
        Citta mosca = new Citta("Mosca", 55.741469, 37.615561);
        Citta tokio = new Citta("Tokio", 35.695126, 139.75391);
        Citta palermo = new Citta("Palermo", 38.128635, 13.334865);
        Citta lisbona = new Citta("Lisbona", 38.748243, -9.140093);

        // aggiungo le citta a un arraylist di citta
        ArrayList<Citta> listaCitta = new ArrayList<>();
        listaCitta.add(milano);
        listaCitta.add(firenze);
        listaCitta.add(roma);
        listaCitta.add(londra);
        listaCitta.add(mosca);
        listaCitta.add(tokio);
        listaCitta.add(palermo);
        listaCitta.add(lisbona);

        // creo un arrayList misurazioni
        ArrayList<Misurazione> misurazioni = new ArrayList<>();

        // aggiungo le varie combinazioni in misurazioni
        for (int i = 0; i < listaCitta.size() - 1; i++) {
            for (int j = i + 1; j < listaCitta.size(); j++) {
                misurazioni.add(new Misurazione(listaCitta.get(i), listaCitta.get(j)));
            }
        }

        misurazioni.get(0).distReale = 253.33;
        misurazioni.get(1).distReale = 482.34;
        misurazioni.get(2).distReale = 956.27;
        misurazioni.get(3).distReale = 2285.70;
        misurazioni.get(4).distReale = 9717.63;
        misurazioni.get(5).distReale = 886.34;
        misurazioni.get(6).distReale = 1680.15;
        misurazioni.get(7).distReale = 235.41;
        misurazioni.get(8).distReale = 1209.45;
        misurazioni.get(9).distReale = 2281.72;
        misurazioni.get(10).distReale = 9751.86;
        misurazioni.get(11).distReale = 653.68;
        misurazioni.get(12).distReale = 1798.55;
        misurazioni.get(13).distReale = 1436.27;
        misurazioni.get(14).distReale = 2374.77;
        misurazioni.get(15).distReale = 9856.60;
        misurazioni.get(16).distReale = 422.56;
        misurazioni.get(17).distReale = 1864.63;
        misurazioni.get(18).distReale = 2498.66;
        misurazioni.get(19).distReale = 9559.13;
        misurazioni.get(20).distReale = 1820.37;
        misurazioni.get(21).distReale = 1583.56;
        misurazioni.get(22).distReale = 7481.98;
        misurazioni.get(23).distReale = 2662.30;
        misurazioni.get(24).distReale = 3903.55;
        misurazioni.get(25).distReale = 10128.70;
        misurazioni.get(26).distReale = 11141.93;
        misurazioni.get(27).distReale = 1953.77;

        System.out.println(misurazioni);

















    }




}