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
    private Map<String ,Viatura> viaturaList;
    private double classificacao;
    
    /**
     * Constructor for objects of class Proprietario
     */
    public Proprietario(){
        super();
        this.viaturaList = new HashMap<>();
        this.classificacao = 0;
    }
    
    public Proprietario(String email, String password, String nome, String morada, LocalDate dataNasc, Map<Double, DadosAluguer> historico, double classificacao, Map<String,Viatura> viaturaList, String nif) {
        super(email,password,nome,morada, dataNasc, historico, nif);
        this.viaturaList = viaturaList;
        this.classificacao = classificacao;
    }
    
    public Proprietario(Proprietario p){
        super(p);
        this.viaturaList = p.getViaturaList();
        this.classificacao = p.getClassificacao();
    }
    
    public Map<String, Viatura> getViaturaList() {
        Map<String, Viatura> viaturaList = new HashMap<>();
        
        for(Viatura v : this.viaturaList.values()){
            viaturaList.put(v.getMatricula(), v.clone());
        }
        return viaturaList;
    }
    
    public Viatura getSingleViatura(String matricula){//ISTO E MM ESTUPIDOOO MUDAR PARA HASHMAP
        Viatura ve = new Viatura();
        ve = null;
            
        for(Viatura v : this.getViaturaList().values()){
            if (v.getMatricula().equals(matricula)){
              ve = v.clone();
            }     
        }
        return ve;
    }
    
    public double getClassificacao(){
        return this.classificacao;
    }
    
    public void setViaturaList(Map<String, Viatura> l){
        this.viaturaList = new HashMap<>();
        for(Viatura v : l.values()){
            this.viaturaList.put(v.getMatricula(), v.clone());   
        }
    }
            
    public void setClassificacao(int c){
        this.classificacao = c;
    }
    
    public void addViatura(Viatura viatura, Sistema s){
        this.viaturaList.put(viatura.getMatricula(), viatura.clone());
        s.addViatura(viatura.clone());
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
        for(Viatura s : this.viaturaList.values()){
            if (s.equals(v)){
                combustivel = s.getCombustivel();
                s.setCombustivel(combustivel + quantidade);
                break;
            }
        }
    }
    
    public void alteraPrecoKm(double preco, Viatura v){
        for(Viatura s : this.viaturaList.values()){
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
