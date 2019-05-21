 
import java.util.List;
import java.util.ArrayList;

/**
 * Escreva a descrição da classe DadosAluguer aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class DadosAluguer implements Comparable<DadosAluguer>
{
    private String viatura;
    private String nifProp;
    private String nifClient;
    private double preco;
    
    public DadosAluguer(){
        this.viatura = "";
        this.nifProp = "";
        this.nifClient = "";
        this.preco = 0;
    }
    
    public DadosAluguer(String v, String p, String c, double preco){
        this.viatura = v;
        this.nifProp = p;
        this.nifClient = c;
        this.preco = preco;
    }
    
    public DadosAluguer(DadosAluguer d){
        this.viatura = d.getViatura();
        this.nifProp = d.getProprietario();
        this.nifClient = d.getCliente();
        this.preco = d.getPreco();
    }
    
    public int compareTo(DadosAluguer a) {
        double preco = a.getPreco();
        int res;
        
        if(this.preco <= preco) res = -1;
        else res = 1;
        return res;
    }
    
    public double getPreco(){
        return this.preco;
    }
    
    public String getViatura(){
        return this.viatura;
    }
    
    public String getProprietario(){
        return this.nifProp;
    }
    
    public String getCliente(){
        return this.nifClient;
    }
    
    public void setViatura(String v){
        this.viatura = v;
    }
    
    public void setCliente(String c){
        this.nifClient = c;
    }
    
    public void setProprietario(String p){
        this.nifProp = p;
    }
    
    public DadosAluguer clone() {
        return new DadosAluguer(this);
    }
    
    public String toString() {
        return "Preco: " + this.getPreco() + "Proprietario: " + this.getProprietario() + " Cliente: " + this.getCliente() + " Viatura: " + this.getViatura();
    }
    
    public boolean equals(Object obj) {
       if(obj==this) return true;
       if(obj==null || obj.getClass()!=this.getClass()) return false;
       DadosAluguer a = (DadosAluguer) obj;
       return this.nifClient.equals(a.getCliente()) && this.viatura.equals(a.getViatura()) && this.nifProp.equals(getProprietario());
    }
}
