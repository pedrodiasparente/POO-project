 
import java.util.List;
import java.util.ArrayList;

/**
 * Escreva a descrição da classe DadosAluguer aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class DadosAluguer
{
    private Viatura viatura;
    private Proprietario proprietario;
    private Cliente cliente;
    private double classificacao;
    
    public DadosAluguer(){
        this.viatura = new Viatura();
        this.proprietario = new Proprietario();
        this.cliente = new Cliente();
        this.classificacao = 0;
    }
    
    public DadosAluguer(Viatura v, Proprietario p, Cliente c, double ca){
        this.viatura = v;
        this.proprietario = p;
        this.cliente = c;
        this.classificacao = ca;
    }
    
    public DadosAluguer(DadosAluguer d){
        this.viatura = d.getViatura();
        this.proprietario = d.getProprietario();
        this.cliente = d.getCliente();
        this.classificacao = d.getClassificacao();
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
    
    protected DadosAluguer clone() {
        return new DadosAluguer(this);
    }
    
    //nao tem equals
}
