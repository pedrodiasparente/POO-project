import java.util.*;
import java.time.LocalDate;

/**
 * Write a description of class Proprietario here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Proprietario extends Atores
{
    private Set<Viatura> viaturaList;
    private double classificacao;
    
    /**
     * Constructor for objects of class Proprietario
     */
    public Proprietario(){
        super();
        this.viaturaList = new TreeSet<>();
        this.classificacao = 0;
    }
    
    public Proprietario(String email, String password, String nome, String morada, LocalDate dataNasc, Set<DadosAluguer> historico, double classificacao, Set<Viatura> viaturaList, String nif) {
        super(email,password,nome,morada, dataNasc, historico, nif);
        this.viaturaList = viaturaList;
        this.classificacao = classificacao;
    }
    
    public Proprietario(Proprietario p){
        super(p);
        this.viaturaList = p.getViaturaList();
        this.classificacao = p.getClassificacao();
    }
    
    public Set<Viatura> getViaturaList() {
        Set<Viatura> viaturaList = new TreeSet<>();
        
        for(Viatura s : this.viaturaList){
            viaturaList.add(s);
        }
        return viaturaList;
    }
    
    public double getClassificacao(){
        return this.classificacao;
    }
    
    public void setViaturaList(Set<Viatura> l){
        this.viaturaList = new TreeSet<>();
        viaturaList.forEach(s -> {this.viaturaList.add(s);});
    }
            
    public void setClassificacao(int c){
        this.classificacao = c;
    }
    
    public void addViatura(Viatura viatura) {
        this.viaturaList.add(viatura);
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
    
    public String toString(){
        return super.toString() + "\nClassificacao " + getClassificacao() + " Viaturas: " + getViaturaList();
    }
    
        public void abastecerVeiculo(double quantidade, Viatura v){
        double combustivel;
        for(Viatura s : this.viaturaList){
            if (s.equals(v)){
                combustivel = s.getCombustivel();
                s.setCombustivel(combustivel + quantidade);
                break;
            }
        }
    }
    
    public void alteraPrecoKm(double preco, Viatura v){
        for(Viatura s : this.viaturaList){
            if (s.equals(v)){
                v.setPreco(preco);
                break;
            }
        }
    }
    
    public void registaAluguer(Aluguer a){
        double preco;
        double x,y;
        x = a.getPosX();
        y = a.getPosY();
        double dist = Math.pow(a.getViatura().getPosX() - x, 2) + Math.pow(a.getViatura().getPosY() - y, 2);
        
        preco = dist * a.getViatura().getPreco();
        
        DadosAluguer d = new DadosAluguer(a.getViatura(), this.getNif(),a.getNif(),preco);
        
        addAluguer(d);
        a.getViatura().addAluguer(d);
        //falta meter os outros historicos idk
    }
}
