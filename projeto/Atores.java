import java.util.*;
import java.time.LocalDate;

/**
 * Escreva a descrição da classe Proprietario aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Atores implements Comparable<Atores>{
    private String email;
    private String nome;
    private String password;
    private String morada;
    private LocalDate dataNasc;
    private Set<DadosAluguer> historico;
    private String nif;
    
    public Atores(){
        this.email = "";
        this.nome = "";
        this.password = "";
        this.morada = "";
        this.dataNasc.of(1,1,1);
        this.historico = new TreeSet<DadosAluguer>();
        this.nif = "";
    }
    
    public Atores(String email, String password, String nome, String morada, LocalDate dataNasc, Set<DadosAluguer> historico, String nif){
        this.email = email;
        this.nome = nome;
        this.password = password;
        this.morada = morada;
        this.dataNasc = dataNasc;
        this.nif = nif;
        setHistorico(historico);
    }
    
    public Atores(Atores p){
        this.email = p.getEmail();
        this.password = p.getPassword();
        this.nome = p.getNome();
        this.morada = p.getMorada();
        this.dataNasc = p.getDataNasc();
        this.nif = p.getNif();
        this.historico = p.getHistorico();
    }
    
    public String getNif() {
        return this.nif;
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
    
    public Set<DadosAluguer> getHistorico(){
        Set<DadosAluguer> hist = new TreeSet<>();
        
        for(DadosAluguer s : this.historico){
            hist.add(s);
        }
        return hist;
    }
    
    public void setNif(String nif) {
        this.nif = nif;
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
    
    public void setHistorico(Set<DadosAluguer> l){
        this.historico = new TreeSet<>();
        historico.forEach(s -> {this.historico.add(s);});
    }
    
    public int compareTo(Atores a) {
        String nome = a.getNome();
        int res = this.nome.compareTo(nome);
        
        if(res <= 0) res = -1;
        else res = 1;
        return res;
    }
    
    public void addAluguer(DadosAluguer aluguer) {
        this.historico.add(aluguer);
    }
    
    public boolean equals(Object obj) {
       if(obj==this) return true;
       if(obj==null || obj.getClass()!=this.getClass()) return false;
       Atores a = (Atores) obj;
       return this.email.equals(a.getEmail()) && this.nome.equals(a.getNome()) && 
                this.password.equals(a.getPassword()) && this.morada.equals(a.getMorada()) &&
                this.dataNasc.equals(a.getDataNasc()) && this.nif.equals(a.getNif()); //falta historico
    }
    
    public String toString() {
        return "Nif: " + this.nif +" email: " + getEmail() + " nome: " + getNome() + "\npassword: " + getPassword() + " morada: " + getMorada() + "\ndata de nascimento: " + getDataNasc() + "\nhist: " + getHistorico();
    }
}
