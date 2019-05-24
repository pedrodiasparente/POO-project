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
        this.viaturaList = p.getViaturas();
        this.classificacao = p.getClassificacao();
    }
    
    public Map<String, Viatura> getViaturas() {
        Map<String, Viatura> viaturaList = new HashMap<>();
        
        for(Viatura v : this.viaturaList.values()){
            viaturaList.put(v.getMatricula(), v.clone());
        }
        return viaturaList;
    }
    
    public double getClassificacao(){
        return this.classificacao;
    }
    
    public void setViaturas(Map<String, Viatura> l){
        this.viaturaList = new HashMap<>();
        for(Viatura v : l.values()){
            this.viaturaList.put(v.getMatricula(), v.clone());   
        }
    }
            
    public void setClassificacao(int c){
        this.classificacao = c;
    }
    
    public void addViatura(Viatura viatura, Sistema s) throws ViaturaJaExisteException{
        if(!this.viaturaList.containsKey(viatura.getMatricula())){
            this.viaturaList.put(viatura.getMatricula(), viatura.clone());
            try{
                s.addViatura(viatura.clone());
            } catch(ViaturaJaExisteException e){
                System.out.println(e);
            }
        } else throw new ViaturaJaExisteException();
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
        return super.toString() + "\nClassificacao " + getClassificacao() + " Viaturas: " + getViaturas();
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
    
    public boolean requestAluguer(String matricula, Cliente cliente){
        String[] opcoes = {"Sim",
                           "Nao"};
        int ret;
        String prompt = "Deseja alugar a Viatura " + matricula + " ao Cliente " + cliente + "?";
        
        Menu request = new Menu(prompt, opcoes);
        
        request.executa();
        
        if(request.getOpcao() == 1)
           return true;
        else 
            return false;
    }
    
    /*public void registaAluguer(Aluguer a){
        double preco;
        double x,y;
        x = a.getPosX();
        y = a.getPosY();
        double dist = Math.pow(a.getViatura().getPosX() - x, 2) + Math.pow(a.getViatura().getPosY() - y, 2);
        
        preco = dist * a.getViatura().getPreco();
        
        DadosAluguer d = new DadosAluguer(a.getViatura().getMatricula(), this.getNif(),a.getNif(),preco);
        
        addAluguer(d);
        a.getViatura().addAluguer(d);
        //falta meter os outros historicos idk
    }*/
}
