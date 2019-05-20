import java.util.*;
import java.util.Map;

/**
 * Escreva a descrição da classe Sistema aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Sistema
{
    private Map<String, Cliente> clientes;
    private Map<String, Proprietario> proprietarios;
    private Map<String, Viatura> viaturas;
    private Map<Double, DadosAluguer> totHist;
    
    public Sistema(){
        this.clientes = new HashMap<>();
        this.proprietarios = new HashMap<>();
        this.viaturas = new HashMap<>();
        this.totHist = new HashMap<>();
    }
    
    public Sistema(Map<String, Cliente> c, Map<String, Proprietario> p, Map<String, Viatura> v, Map<Double, DadosAluguer> d){
        setClientes(c);
        setProprietarios(p);
        setViaturas(v);
        setDados(d);
    }
    
    public Sistema(Sistema s){
        this.clientes = s.getClientes();
        this.proprietarios = s.getProprietarios();
        this.viaturas = s.getViaturas();
        this.totHist = s.getTotHist();
    }
    
    public Map<String, Cliente> getClientes(){
        Map<String, Cliente> res = new HashMap<>();
        
        for(Cliente c : this.clientes.values()){
            res.put(c.getNif(), c.clone());
        }
        
        return res;
    }
    
    public Map<String, Proprietario> getProprietarios(){
        Map<String, Proprietario> res = new HashMap<>();
        
        for(Proprietario p : this.proprietarios.values()){
            res.put(p.getNif(), p.clone());
        }
        
        return res;
    }
    
    public Map<String, Viatura> getViaturas(){
        Map<String, Viatura> res = new HashMap<>();
        
        for(Viatura v : this.viaturas.values()){
            res.put(v.getMatricula(), v.clone());
        }
        
        return res;
    }
    
    public Map<Double, DadosAluguer> getTotHist(){
        Map<Double, DadosAluguer> res = new HashMap<>();
        
        for(DadosAluguer d : this.totHist.values()){
            res.put(d.getPreco(), d);
        }
        
        return res;
    }
    
    public void setClientes(Map<String, Cliente> c){
        this.clientes = new HashMap<>();
        for(Cliente c1 : c.values()){
            this.clientes.put(c1.getNif(), c1.clone());
        }
    }
    
    public void setProprietarios(Map<String, Proprietario> p){
        this.proprietarios = new HashMap<>();
        for(Proprietario p1 : p.values()){
            this.proprietarios.put(p1.getNif(), p1.clone());
        }
    }
    
    public void setViaturas(Map<String, Viatura> v){
        this.viaturas = new HashMap<>();
        for(Viatura v1 : v.values()){
            this.viaturas.put(v1.getMatricula(), v1.clone());
        }
    }
    
    public void setDados(Map<Double, DadosAluguer> d){
        this.totHist = new HashMap<>();
        for(DadosAluguer d1 : d.values()){
            this.totHist.put(d1.getPreco(), d1);
        }
        
    }
    
    public void addCliente(Cliente clientes) {
        this.clientes.put(clientes.getNif(), clientes.clone());
    }
    
    public void addProprietario(Proprietario prop) {
        this.proprietarios.put(prop.getNif(), prop.clone());
    }
    
    public void addViatura(Viatura viatura) {
        this.viaturas.put(viatura.getMatricula(), viatura.clone());
    }
    
    public void addAluguer(DadosAluguer aluguer) {
        this.totHist.put(aluguer.getPreco(), aluguer.clone());
    }
    
    public Sistema clone(){
        return new Sistema(this);
    }
        
    public String toString() {
        return "Sistema =>\nClientes: " + getClientes() + "\nProprietarios: " + getProprietarios() + "\nViaturas: " + getViaturas() + "\nTotalHistory: " + getTotHist();
    }
    
    
    
    
}
