import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

/**
 * Write a description of class Proprietario here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Proprietario extends Atores
{
    private List<Viatura> viaturaList;
    
    /**
     * Constructor for objects of class Proprietario
     */
    public Proprietario(){
        super();
        this.viaturaList = new ArrayList<>();
    }
    
    public Proprietario(String email, String password, String nome, String morada, LocalDate dataNasc, List<DadosAluguer> historico, double classificacao, List<Viatura> viaturaList){
        super(email,password,nome,morada, dataNasc, historico, classificacao);
        this.viaturaList = viaturaList;
    }
    
    public Proprietario(Proprietario p){
        super(p);
        this.viaturaList = p.getViaturaList();
    }
    
    public List<Viatura> getViaturaList() {
        List<Viatura> viaturaList = new ArrayList<>();
        
        for(Viatura s : viaturaList){
            viaturaList.add(s);
        }
        return viaturaList;
    }
    
    public void setViaturaList(List<Viatura> l){
        this.viaturaList = new ArrayList<>();
        viaturaList.forEach(s -> {this.viaturaList.add(s);});
    }
}
