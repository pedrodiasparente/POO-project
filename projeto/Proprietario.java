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
    private double classificacao;
    
    /**
     * Constructor for objects of class Proprietario
     */
    public Proprietario(){
        super();
        this.viaturaList = new ArrayList<>();
        this.classificacao = 0;
    }
    
    public Proprietario(String email, String password, String nome, String morada, LocalDate dataNasc, List<DadosAluguer> historico, double classificacao, List<Viatura> viaturaList){
        super(email,password,nome,morada, dataNasc, historico);
        this.viaturaList = viaturaList;
        this.classificacao = classificacao;
    }
    
    public Proprietario(Proprietario p){
        super(p);
        this.viaturaList = p.getViaturaList();
        this.classificacao = p.getClassificacao();
    }
    
    public List<Viatura> getViaturaList() {
        List<Viatura> viaturaList = new ArrayList<>();
        
        for(Viatura s : viaturaList){
            viaturaList.add(s);
        }
        return viaturaList;
    }
    
        public double getClassificacao(){
        return this.classificacao;
    }
    
    public void setViaturaList(List<Viatura> l){
        this.viaturaList = new ArrayList<>();
        viaturaList.forEach(s -> {this.viaturaList.add(s);});
    }
            
    public void setClassificacao(int c){
        this.classificacao = c;
    }
    
    public Proprietario clone() {
        return new Proprietario(this);
    }
    
    public boolean equals(Object obj) {
       if(obj==this) return true;
       if(obj==null || obj.getClass()!=this.getClass()) return false;
       Proprietario a = (Proprietario) obj;
       return super.equals(obj) && this.classificacao == a.getClassificacao(); //falta viaturas
    }
}
