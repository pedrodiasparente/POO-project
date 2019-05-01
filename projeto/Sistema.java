import java.util.TreeSet;
import java.util.Set;

/**
 * Escreva a descrição da classe Sistema aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Sistema
{
    private Set<Cliente> clientes;
    private Set<Proprietario> proprietarios;
    private Set<Viatura> viaturas;
    private Set<DadosAluguer> totHist;
    
    public Sistema(){
        this.clientes = new TreeSet<>();
        this.proprietarios = new TreeSet<>();
        this.viaturas = new TreeSet<>();
        this.totHist = new TreeSet<>();
    }
    
    public Sistema(Set<Cliente> c, Set<Proprietario> p, Set<Viatura> v, Set<DadosAluguer> d){
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
    
    public Set<Cliente> getClientes(){
        Set<Cliente> res = new TreeSet<>();
        
        for(Cliente c : clientes){
            res.add(c);
        }
        
        return res;
    }
    
    public Set<Proprietario> getProprietarios(){
        Set<Proprietario> res = new TreeSet<>();
        
        for(Proprietario p : proprietarios){
            res.add(p);
        }
        
        return res;
    }
    
    public Set<Viatura> getViaturas(){
        Set<Viatura> res = new TreeSet<>();
        
        for(Viatura v : viaturas){
            res.add(v);
        }
        
        return res;
    }
    
    public Set<DadosAluguer> getTotHist(){
        Set<DadosAluguer> res = new TreeSet<>();
        
        for(DadosAluguer d : totHist){
            res.add(d);
        }
        
        return res;
    }
    
    public void setClientes(Set<Cliente> c){
        this.clientes = new TreeSet<>();
        clientes.forEach(s -> {this.clientes.add(s);});
    }
    
      public void setProprietarios(Set<Proprietario> p){
        this.proprietarios = new TreeSet<>();
        proprietarios.forEach(s -> {this.proprietarios.add(s);});
    }
    
      public void setViaturas(Set<Viatura> v){
        this.clientes = new TreeSet<>();
        clientes.forEach(s -> {this.clientes.add(s);});
    }
    
      public void setDados(Set<DadosAluguer> d){
        this.totHist = new TreeSet<>();
        totHist.forEach(s -> {this.totHist.add(s);});
    }
    
    public Sistema clone(){
        return new Sistema(this);
    }
        
        
    
    
    
    
}
