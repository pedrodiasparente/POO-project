 
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
    private Viatura viatura;
    private Proprietario proprietario;
    private Cliente cliente;
    private double preco;
    private double classificacao;
    
    public DadosAluguer(){
        this.viatura = new Viatura();
        this.proprietario = new Proprietario();
        this.cliente = new Cliente();
        this.classificacao = 0;
        this.preco = 0;
    }
    
    public DadosAluguer(Viatura v, Proprietario p, Cliente c, double ca, double preco){
        this.viatura = v;
        this.proprietario = p;
        this.cliente = c;
        this.classificacao = ca;
        this.preco = preco;
    }
    
    public DadosAluguer(DadosAluguer d){
        this.viatura = d.getViatura();
        this.proprietario = d.getProprietario();
        this.cliente = d.getCliente();
        this.classificacao = d.getClassificacao();
        this.preco = d.getPreco();
    }
    
    public int compareTo(DadosAluguer a) {
        double classificacao = a.getClassificacao();
        int res;
        
        if(this.classificacao <= classificacao) res = -1;
        else res = 1;
        return res;
    }
    
    public double getPreco(){
        return this.preco;
    }
    
    public Viatura getViatura(){
        return this.viatura;
    }
    
    public Proprietario getProprietario(){
        return this.proprietario;
    }
    
    public Cliente getCliente(){
        return this.cliente;
    }
    
    public double getClassificacao(){
        return this.classificacao;
    }
    
    public void setViatura(Viatura v){
        this.viatura = v;
    }
    
    public void setCliente(Cliente c){
        this.cliente = c;
    }
    
    public void setProprietario(Proprietario p){
        this.proprietario = p;
    }
    
    public void setClassificacao(int c){
        this.classificacao = c;
    }
    
    public DadosAluguer clone() {
        return new DadosAluguer(this);
    }
    
    public String toString() {
        return "Proprietario: " + getProprietario().getNome() + " Cliente: " + getCliente().getNome() + " Viatura: " + getViatura().getMatricula() + " Classificacao: " + getClassificacao();
    }
    
    public boolean equals(Object obj) {
       if(obj==this) return true;
       if(obj==null || obj.getClass()!=this.getClass()) return false;
       DadosAluguer a = (DadosAluguer) obj;
       return this.classificacao == a.getClassificacao() && this.cliente.equals(a.getCliente()) && this.viatura.equals(a.getViatura()) && this.proprietario.equals(getProprietario());
    }
}
