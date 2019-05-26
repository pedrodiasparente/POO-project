import java.util.*;

public class VezesComparator implements Comparator<Cliente> {
    public int compare(Cliente c1, Cliente c2){
        double km1;
        if(c1.getHistorico().size() < c2.getHistorico().size()) return -1;
        else return 1;
    }
}
