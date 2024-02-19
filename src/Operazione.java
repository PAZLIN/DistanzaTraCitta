import java.util.ArrayList;
import java.util.Arrays;

public class Operazione {


    // MEDIA ARITMETICA *******************************************************
    public float mediaAritmetica (float...args){
        float sum = 0;
        for (float f : args){
            sum += f;
        }
        return sum / args.length;
    }

    //MODA *******************************************************
    public ArrayList<float[]> moda (float... args){
        ArrayList<float[]> array = new ArrayList<>();
        for (float fl: args){
            int index = indexElement(array, fl);
            if (index!=-1)
                array.get(index)[1] ++;
            else array.add(new float[]{fl, 1});
        }
        return array;
    }
    //ci si appoggia il metodo moda
    public int indexElement(ArrayList<float[]> a, float f){
        for (int i = 0; i<a.size(); i++){
            if (a.get(i)[0] == f)
                return i;
        }
        return -1;
    }
    // sempre moda, giusto per rendere leggibile il tutto...
    public String arrayListToString(ArrayList<float[]> a){
        String result = "";
        for (float[] f : a){
            result += "[" + f[0] +", " + f[1] + "]\n";
        }
        return result;
    }

    // MEDIANA *******************************************************
    public float mediana (float...args){
        Arrays.sort(args);
        if (args.length%2==0)     //se l'array è pari
            return (args[args.length/2-1] + args[args.length / 2]) / 2;
        else return args[args.length/2];
    }

    // SCARTO (o deviazione) *******************************************************
    // ritorna un ArrayList che contiene un array di float (elemento + relativo scarto)
    public ArrayList<float[]> arrayListScarti(float...args){
        ArrayList<float[]> result = new ArrayList<>();
        float media = mediaAritmetica(args);
        for (float f : args){
            result.add(new float[]{f, f-media});
        }
        return result;
    }
    // ritorna solo un array di scarti, in base a x args forniti
    public float[] scarti(float...args){
        float[] result = new float[args.length];
        float media = mediaAritmetica(args);
        for (int i = 0; i<args.length; i++){
            result[i] = args[i]-media;
        }
        return result;
    }

    //VARIANZA (media dei quadrati degli scarti)
    // accetta varargs float o un array di float
    public float varianza (float...args){
        float[] scartiQuadr = scarti(args);
        for (int i = 0; i<args.length; i++){
            scartiQuadr[i] = (float) Math.pow(scartiQuadr[i], 2);
        }
        return mediaAritmetica(scartiQuadr);
    }


    // DEVIAZIONE STANDARD (o SCARTO QUADRATICO MEDIO)
    // radice quadrata della media dei quadrati degli scarti (o radice quadrata della varianza)
    public float deviazioneStandard (float...args){
        return (float) Math.sqrt(varianza(args));
    }

    // COVARIANZA
    // (media del prodotto degli scarti)
    public float covarianza (float[] x, float[] y){
        if (x.length!=y.length) return 0.0F;
        float[] scartiX = scarti(x);
        float[] scartiY = scarti(y);
        float[] prodottoScarti = new float[x.length];
        for (int i = 0; i<x.length; i++){
            prodottoScarti[i] = scartiX[i]*scartiY[i];
        }
        return mediaAritmetica(prodottoScarti);
    }

    // COEFFICIENTE DI CORRELAZIONE
    // Cov (X, Y) / DevStdX * DevStdY
    public float correlazione(float[] x, float[] y){
        float cov = covarianza(x, y);
        float devStdX = deviazioneStandard(x);
        float devStdY = deviazioneStandard(y);
        return cov / (devStdX*devStdY);
    }

    // REGRESSIONE LINEARE (retta di regressione o retta dei minimi quadrati)
    // dati due set x e y, fornendo un valore "x" fuori dal set, calcola il "previsto" y.
    public float regressioneLineare(float[] x, float[] y, float nuovoX){
        float a = covarianza(x, y) / varianza(x);
        float b = mediaAritmetica(y) - (a * mediaAritmetica(x));
        return a * nuovoX + b;
    }

    // COORDINATE SFERICHE - DISTANZA TRA DUE CITTA
    public double distanza(double X_lat, double X_lon, double Y_lat, double Y_lon){
        X_lat = Math.toRadians(X_lat);
        X_lon = Math.toRadians(X_lon);
        Y_lat = Math.toRadians(Y_lat);
        Y_lon= Math.toRadians(Y_lon);
        double distLong = Y_lon-X_lon;
        double R = 6371000;
        double d =  Math.acos(Math.sin(X_lat) * Math.sin(Y_lat) +
                Math.cos(X_lat) * Math.cos(Y_lat) *
                        Math.cos(distLong) ) * R;
        double distKm = d/1000;
        return distKm   ;
    }












}