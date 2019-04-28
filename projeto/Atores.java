import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

/**
 * Escreva a descrição da classe Proprietario aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Atores{
    private String email;
    private String nome;
    private String password;
    private String morada;
    private LocalDate dataNasc;
    private double classificacao;
    private List<DadosAluguer> historico;
    private List<Viatura> viaturas;
    
    public Atores(){
        this.email = "";
        this.nome = "";
        this.password = "";
        this.morada = "";
        this.dataNasc.of(1,1,1);
        this.classificacao = 0;
        this.historico = new ArrayList<>();
        this.viaturas = new ArrayList<>();
    }
    
    public Atores(String email, String password, String nome, String morada, LocalDate dataNasc, List<DadosAluguer> historico, double classificacao){
        this.email = email;
        this.nome = nome;
        this.password = password;
        this.morada = morada;
        this.dataNasc = dataNasc;      
        setHistorico(historico);
        this.classificacao = classificacao;
    }
    
    public Atores(Atores p){
        this.email = p.getEmail();
        this.password = p.getPassword();
        this.nome = p.getNome();
        this.morada = p.getMorada();
        this.dataNasc = p.getDataNasc();
        this.historico = p.getHistorico();
        this.classificacao = p.getClassificacao();
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public String getMorada(){
        return this.morada;
    }
    
    public LocalDate getDataNasc(){
        return this.dataNasc;
    }
    
    public List<DadosAluguer> getHistorico(){
        List<DadosAluguer> hist = new ArrayList<>();
        
        for(DadosAluguer s : historico){
            hist.add(s);
        }
        return hist;
    }
    
    public double getClassificacao(){
        return this.classificacao;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setMorada(String morada){
        this.morada = morada;
    }
    
    public void setDataNasc(LocalDate data){
        this.dataNasc = data;
    }
    
    public void setHistorico(List<DadosAluguer> l){
        this.historico = new ArrayList<>();
        historico.forEach(s -> {this.historico.add(s);});
    }
        
    public void setClassificacao(int c){
        this.classificacao = c;
    }
        
    public Atores clone() {
        return new Atores(this);
    }    
        
    public boolean equals(Object obj) {
       if(obj==this) return true;
       if(obj==null || obj.getClass()!=this.getClass()) return false;
       Atores a = (Atores) obj;
       return this.email.equals(a.getEmail()) && this.nome.equals(a.getNome()) && 
                this.password.equals(a.getPassword()) && this.morada.equals(a.getMorada()) &&
                this.dataNasc.equals(a.getDataNasc()) && this.classificacao == a.getClassificacao(); //falta historico e viaturas
    }
    
    
    
    
}
