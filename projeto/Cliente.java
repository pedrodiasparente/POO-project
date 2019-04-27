import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

/**
 * Escreva a descrição da classe Cliente aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Cliente
{
    private String email;
    private String nome;
    private String password;
    private String morada;
    private LocalDate dataNasc;
    private double posX;
    private double posY;
    private List<DadosAluguer> historico;
    private double classificacao; 
    
    public Cliente(){
        this.email = "";
        this.nome = "";
        this.password = "";
        this.morada = "";
        this.dataNasc.of(1,1,1);
        this.posX = 0;
        this.posY = 0;
        this.historico = new ArrayList<>();
        this.classificacao = 0;
    }
    
    public Cliente(String email, String password, String nome, String morada, LocalDate dataNasc, double posX, double posY, List<DadosAluguer> historico, double classificacao){
        this.email = email;
        this.nome = nome;
        this.password = password;
        this.morada = morada;
        this.dataNasc = dataNasc;
        this.posX = posX;
        this.posY = posY;
        setHistorico(historico);
        this.classificacao = classificacao;
    }
    
    public Cliente(Cliente c){
        this.email = c.getEmail();
        this.password = c.getPassword();
        this.nome = c.getNome();
        this.morada = c.getMorada();
        this.dataNasc = c.getDataNasc();
        this.posX = c.getPosX();
        this.posY = c.getPosY();
        this.historico = c.getHistorico();
        this.classificacao = c.getClassificacao();
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
    
    public double getPosX(){
        return this.posX;
    }
    
    public double getPosY(){
        return this.posY;
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
    
    public void setPosX(double x){
        this.posX = x;
    }
    
    public void setPosY(double y){
        this.posY = y;
    }
    
    public void setHistorico(List<DadosAluguer> l){
        this.historico = new ArrayList<>();
        historico.forEach(s -> {this.historico.add(s);});
    }
        
    public void setClassificacao(int c){
        this.classificacao = c;
    }
    
    protected Cliente clone() {
        return new Cliente(this);
    }
    
    public boolean equals(Object obj) {
       if(obj==this) return true;
       if(obj==null || obj.getClass()!=this.getClass()) return false;
       Cliente c = (Cliente) obj;
       return this.email.equals(c.getEmail()) && this.nome.equals(c.getNome()) && 
                this.password.equals(c.getPassword()) && this.morada.equals(c.getMorada()) &&
                this.dataNasc.equals(c.getDataNasc()) && this.posX == c.getPosX() && this.posY == c.getPosY() &&
                this.classificacao == c.getClassificacao(); //falta historico
    }
     
}
        
        
        
    
    
    
    
    
    
    
    
    
    
    
    
    

}
