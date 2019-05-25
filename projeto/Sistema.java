import java.util.*;
import java.util.Map;
import java.io.*;

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
    private boolean loadingData;
    
    public Sistema(){
        this.clientes = new HashMap<>();
        this.proprietarios = new HashMap<>();
        this.viaturas = new HashMap<>();
        this.totHist = new HashMap<>();
        this.loadingData = false;
    }
    
    public Sistema(Map<String, Cliente> c, Map<String, Proprietario> p, Map<String, Viatura> v, Map<Double, DadosAluguer> d){
        setClientes(c);
        setProprietarios(p);
        setViaturas(v);
        setDados(d);
        this.loadingData = false;
    }
    
    public Sistema(Sistema s){
        this.clientes = s.getClientes();
        this.proprietarios = s.getProprietarios();
        this.viaturas = s.getViaturas();
        this.totHist = s.getTotHist();
        this.loadingData = s.getLoadingData();
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
    
    public boolean getLoadingData(){
        return this.loadingData;
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
    
    public void setLoading(Boolean l){
        this.loadingData = l;
    }
    
    public void addCliente(Cliente cliente) throws ClienteJaExisteException {
        if(!this.clientes.containsKey(cliente.getNif()))
            this.clientes.put(cliente.getNif(), cliente.clone());
        else throw new ClienteJaExisteException();
    }
    
    public void updateCliente(Cliente cliente){
        this.clientes.put(cliente.getNif(), cliente.clone());
    }
    
    public void addProprietario(Proprietario prop) throws ProprietarioJaExisteException {
        if(!this.proprietarios.containsKey(prop.getNif())){
            this.proprietarios.put(prop.getNif(), prop.clone());
        }
        else throw new ProprietarioJaExisteException();
    }
     
    public void addViatura(Viatura viatura) throws ViaturaJaExisteException {
        if(!this.viaturas.containsKey(viatura.getMatricula())){
            this.viaturas.put(viatura.getMatricula(), viatura.clone());
        } else throw new ViaturaJaExisteException();
    }
    
    public void updateViatura(Viatura viatura){
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
    
    public Proprietario getProprietarioViatura(String matricula){
        Proprietario prop = new Proprietario();

        for(Proprietario p1 : this.proprietarios.values()){
            if(p1.getViaturas().containsKey(matricula)){
                prop = p1.clone();
            }
        }
        
        return prop;
    }
    
    public void updateSingleViatura(Viatura newViatura){
        Proprietario prop = new Proprietario();

        for(Proprietario p1 : this.proprietarios.values()){
            if(p1.getViaturas().get(newViatura.getMatricula()) != null){
                prop = p1.clone();
            }
        }

        prop.updateViatura(newViatura, this);
        
        this.proprietarios.put(prop.getNif(), prop);
        
        return;
    }
    
    public void updateHistoricos(DadosAluguer aluguer){
        this.addAluguer(aluguer.clone());
        
        for(Proprietario p : this.proprietarios.values()){
           if(p.getNif().equals(aluguer.getProprietario())){
               p.addAluguer(aluguer.clone());
           }
        }
        for(Viatura v : this.viaturas.values()){
           if(v.getMatricula().equals(aluguer.getViatura())){
               v.addAluguer(aluguer.clone());
           }
        }
        for(Cliente c : this.clientes.values()){
           if(c.getNif().equals(aluguer.getCliente())){
               c.addAluguer(aluguer.clone());
           }
        }
    }
        
    public static Sistema loadData(String fich) throws FileNotFoundException, IOException{
        Sistema s = new Sistema();
        s.setLoading(true);
        BufferedReader br = new BufferedReader(new FileReader(fich));
        String linha, str;
        String[] cont;
        String[] atributos;
        
        while((linha = br.readLine()) != null) {
            cont = linha.split(":");
            switch(cont[0]){
                case "NovoProp":
                    try{
                        s.addProprietario(Proprietario.stringToProp(cont[1]));
                    } catch(ProprietarioJaExisteException e){
                        System.out.println(e);
                    }
                    break;
                case "NovoCliente":
                    try{
                        s.addCliente(Cliente.stringToCliente(cont[1]));
                    } catch(ClienteJaExisteException e){
                        System.out.println(e);
                    }
                    break;
                case "NovoCarro":
                    try{
                        s.addViatura(Viatura.stringToViatura(cont[1]));
                    } catch(ViaturaJaExisteException e){
                        System.out.println(e);
                    }
                    break;
                case "Aluguer":
                    str = cont[1];
                    atributos = str.split(",");
                    Cliente c = s.getClientes().get(atributos[0]);
                    if(atributos[4].equals("MaisPerto"))
                        c.alugaCarroDist(s, Double.parseDouble(atributos[1]), Double.parseDouble(atributos[2]));
                    else
                        c.alugaCarroMaisBarato(s, Double.parseDouble(atributos[1]), Double.parseDouble(atributos[2]));
                        s.updateCliente(c);
                    break;
                case "Classificacar":
                    str = cont[1];
                    atributos = str.split(",");
                    Viatura v = s.getViaturas().get(atributos[0]);
                    Cliente cc = s.getClientes().get(atributos[0]);
                    if(atributos[0].charAt(2) == '-'){
                        v.addClassificacao(Double.parseDouble(atributos[1]));
                        s.updateSingleViatura(v);
                    } else{
                        cc.addClassificacao(Double.parseDouble(atributos[1]));
                        s.updateCliente(cc);
                    }
                    break;
                default:
                    break;
            }
        }
        
        s.setLoading(false);
        
        return s;
    }

    
        
}
