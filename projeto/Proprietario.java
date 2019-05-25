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
    
    /**
     * Constructor for objects of class Proprietario
     */
    public Proprietario(){
        super();
        this.viaturaList = new HashMap<>();
    }
    
    public Proprietario(String email, String password, String nome, String morada, LocalDate dataNasc, Map<Double, DadosAluguer> historico, Map<String,Viatura> viaturaList, String nif) {
        super(email,password,nome,morada, dataNasc, historico, nif);
        this.viaturaList = viaturaList;
    }
    
    public Proprietario(Proprietario p){
        super(p);
        this.viaturaList = p.getViaturas();
    }
    
    public Map<String, Viatura> getViaturas() {
        Map<String, Viatura> viaturaList = new HashMap<>();
        
        for(Viatura v : this.viaturaList.values()){
            viaturaList.put(v.getMatricula(), v.clone());
        }
        return viaturaList;
    }
    
    public void setViaturas(Map<String, Viatura> l){
        this.viaturaList = new HashMap<>();
        for(Viatura v : l.values()){
            this.viaturaList.put(v.getMatricula(), v.clone());   
        }
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
    
    public void updateViatura(Viatura viatura, Sistema s){
        this.viaturaList.put(viatura.getMatricula(), viatura.clone());
        s.updateViatura(viatura.clone());
    }
    
    public Proprietario clone() {
        return new Proprietario(this);
    }
    
    public boolean equals(Object obj) {
       if(obj==this) return true;
       if(obj==null || obj.getClass()!=this.getClass()) return false;
       Proprietario a = (Proprietario) obj;
       return super.equals(obj); //falta viaturas
    }
    
    public String toString(){
        return super.toString() + "\nViaturas: " + getViaturas();
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
    
    public boolean requestAluguer(String matricula, String cliente){
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
    
    public static Proprietario stringToProp(String s){
        String nome, nif, email, morada;
        Proprietario prop = new Proprietario();
        String[] atributos;
        
        atributos = s.split(",");
        
        prop.setNome(atributos[0]);
        prop.setNif(atributos[1]);
        prop.setPassword(atributos[1]);
        prop.setEmail(atributos[2]);
        prop.setMorada(atributos[3]);
        
        return prop;
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
