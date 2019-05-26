import java.util.*;
import java.time.LocalDate;
import java.io.*;
/**
 * Escreva a descrição da classe Proprietario aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public abstract class Atores implements Comparable<Atores>, Serializable{
    private String email;
    private String nome;
    private String password;
    private String morada;
    private Map<Double, DadosAluguer> historico;
    private String nif;
    private List<Double> classificacao;
    
    public Atores(){
        this.email = "";
        this.nome = "";
        this.password = "";
        this.morada = "";
        this.historico = new HashMap<Double, DadosAluguer>();
        this.nif = "";
        this.classificacao = new ArrayList<>();
    }
    
    public Atores(String email, String password, String nome, String morada, Map<Double, DadosAluguer> historico, String nif, List<Double> classificacao){
        this.email = email;
        this.nome = nome;
        this.password = password;
        this.morada = morada;
        this.nif = nif;
        this.setClassificacao(classificacao);
        this.setHistorico(historico);
    }
    
    public Atores(Atores p){
        this.email = p.getEmail();
        this.password = p.getPassword();
        this.nome = p.getNome();
        this.morada = p.getMorada();
        this.nif = p.getNif();
        this.setHistorico(p.getHistorico());
        this.setClassificacao(p.getClassificacao());
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
    
    public Map<Double, DadosAluguer> getHistorico(){
        Map<Double, DadosAluguer> hist = new HashMap<>();
        
        for(DadosAluguer d : this.historico.values()){
            hist.put(d.getPreco(), d.clone());
        }
        return hist;
    }
    
    public List<Double> getClassificacao(){
        List<Double> newClass = new ArrayList<>();
        for(double d : this.classificacao){
            newClass.add(d);
        }
        return newClass;
    }
    
    public double getMediaClassificacao(){
        double total;
        total = this.classificacao.stream().mapToDouble(f -> f.doubleValue()).sum();
        return (total/this.classificacao.size());
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
    
    public void setHistorico(Map<Double, DadosAluguer> l){
        this.historico = new HashMap<>();
        for(DadosAluguer d : l.values()){
            this.historico.put(d.getPreco(), d.clone());
        }
    }
    
    public void setClassificacao(List<Double> classificacao){
        List<Double> newClass = new ArrayList<>();
        for(double d : classificacao){
            newClass.add(d);
        }
        this.classificacao = newClass;
    }
    
    public void addClassificacao(double c){
        this.classificacao.add(c);
    }
    
    public int compareTo(Atores a) {
        String nome = a.getNome();
        int res = this.nome.compareTo(nome);
        
        if(res <= 0) res = -1;
        else res = 1;
        return res;
    }
    
    public void addAluguer(DadosAluguer aluguer) {
        this.historico.put(aluguer.getPreco(), aluguer.clone());
    }
    
    public boolean equals(Object obj) {
       if(obj==this) return true;
       if(obj==null || obj.getClass()!=this.getClass()) return false;
       Atores a = (Atores) obj;
       return this.email.equals(a.getEmail()) && this.nome.equals(a.getNome()) && 
                this.password.equals(a.getPassword()) && this.morada.equals(a.getMorada()) &&
                this.nif.equals(a.getNif()); //falta historico
    }
    
    public String toString() {
        return "Nif: " + this.getNif() +" email: " + this.getEmail() + " nome: " + this.getNome() + "\npassword: " + this.getPassword() + " morada: " + this.getMorada() + "\nhist: " + this.getHistorico();
    }
}
