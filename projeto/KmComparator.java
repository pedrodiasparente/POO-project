import java.util.*;

public class KmComparator implements Comparator<Cliente> {
    public int compare(Cliente c1, Cliente c2){
        double km1, km2;
        km1 = 0;
        km2 = 0;
        for(DadosAluguer d : c1.getHistorico().values()){
            km1 += d.getDistancia();
        }
        for(DadosAluguer d : c2.getHistorico().values()){
            km2 += d.getDistancia();
        }
        if(km1 < km2) return -1;
        else return 1;
    }
}
