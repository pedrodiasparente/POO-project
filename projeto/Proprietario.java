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
    
    public Proprietario(String email, String password, String nome, String morada, Map<Double, DadosAluguer> historico, Map<String,Viatura> viaturaList, String nif, List<Double> classificacao) {
        super(email,password,nome,morada, historico, nif, classificacao);
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
    
        
    public Viatura getSingleViatura(String v) throws ViaturaInexistenteException{
        Viatura vret = null;
        for(Viatura v1 : this.viaturaList.values()){
            if (v1.getMatricula().equals(v)){
                vret = v1.clone();
                break;
            }
        }
        if(vret != null)
            return vret;
        else throw new ViaturaInexistenteException();
    }
    
    public void setViaturas(Map<String, Viatura> l){
        this.viaturaList = new HashMap<>();
        for(Viatura v : l.values()){
            this.viaturaList.put(v.getMatricula(), v.clone());   
        }
    }
    
    public void addViatura(Viatura viatura) throws ViaturaJaExisteException{
        if(!this.viaturaList.containsKey(viatura.getMatricula())){
            this.viaturaList.put(viatura.getMatricula(), viatura.clone());
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
        return super.toString();
    }
    
    public void abastecerViatura(Sistema s, double quantidade,String v) throws ViaturaInexistenteException{
        double combustivel;
        Viatura viaturaAbastecida = null;
        for(Viatura v1 : this.viaturaList.values()){
            if (v1.getMatricula().equals(v)){
                viaturaAbastecida = v1.clone();
                combustivel = viaturaAbastecida.getCombustivel();
                v1.setCombustivel(combustivel + quantidade);
                v1.setAutonomia(v1.getCombustivel()/(v1.getConsumo()/10));
                break;
            }
        }
        if(viaturaAbastecida != null){
            viaturaAbastecida.setAutonomia(viaturaAbastecida.getCombustivel() / (viaturaAbastecida.getConsumo()/10));
            s.updateSingleViatura(viaturaAbastecida);
        } else throw new ViaturaInexistenteException();
    }
    
    public void alteraPrecoKm(Sistema s, double preco, String viatura) throws ViaturaInexistenteException{
        Viatura vnew = null;
        for(Viatura v : this.viaturaList.values()){
            if (v.getMatricula().equals(viatura)){
                vnew = v.clone();
                vnew.setPreco(preco);
                break;
            }
        }
        if(vnew != null){
            s.updateSingleViatura(vnew);
        } else throw new ViaturaInexistenteException();
    }
    
    public double getFaturacaoViatura(String viatura) throws ViaturaInexistenteException{
        Viatura vnew = null;
        double res = 0;
        for(Viatura v : this.viaturaList.values()){
            if (v.getMatricula().equals(viatura)){
                vnew = v.clone();
                res = vnew.totalFaturado();
                break;
            }
        }
        if(vnew != null){
            return res;
        } else throw new ViaturaInexistenteException();
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
    
    public List<String> getMatriculas(){
        List<String> lm = new ArrayList<>();
        for(Viatura v : this.viaturaList.values()){
            lm.add(v.getMatricula());
        }
        return lm;
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
    
    public void checkWarning(Viatura v){
        if(this.viaturaList.get(v.getMatricula()).getAutonomia() < 50){
            System.out.println("[Warning] Proprietario " + this.getNif() + ": a Viatura " + v.getMatricula() + " so tem autonomia para " + v.getAutonomia() + "km!");
        }
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
