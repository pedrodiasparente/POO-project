import java.time.LocalDate;
import java.util.*;
import java.lang.String;

/**
 * Escreva a descrição da classe Viatura aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Viatura implements Comparable<Viatura>
{
    private double vMedia;
    private double preco;
    private double consumo;
    private Set<DadosAluguer> historico;
    private double classificacao;
    private double posX;
    private double posY;
    private double autonomia;
    private double combustivel;
    private String marca;
    private String matricula;
    
    public Viatura(){
        this.vMedia = 0;
        this.preco = 0;
        this.consumo = 0;
        this.historico = new TreeSet<>();
        this.classificacao = 0;
        this.posX = 0;
        this.posY = 0;
        this.autonomia = 0;
        this.combustivel = 0;
        this.marca = "";
        this.matricula = "00-00-00";
    }
    
    public Viatura(double vmedia, double preco, double consumo, Set<DadosAluguer> hist, double posx, double posy, double classi, double autonomia, double combustivel, String marca, String matricula){ 
        this.vMedia = vmedia;
        this.preco = preco;
        this.consumo = consumo;
        setHistorico(hist);
        this.posX = posx;
        this.posY = posy;
        this.classificacao = classi;
        this.autonomia = autonomia;
        this.combustivel = combustivel;
        this.marca = marca;
        this.matricula = matricula;
    }
    
    public Viatura(Viatura v){
        this.vMedia = v.getVMedia();
        this.preco = v.getPreco();
        this.consumo = v.getConsumo();
        this.historico  =v.getHistorico();
        this.posX = v.getPosX();
        this.posY = v.getPosY();
        this.classificacao = v.getClassificacao();
        this.autonomia = v.getAutonomia();
        this.combustivel = v.getCombustivel();
        this.marca = v.getMarca();
        this.matricula = v.getMatricula();
    }
    
    public int compareTo(Viatura a) {
        String matricula = a.getMatricula();
        int res = this.matricula.compareTo(matricula);
        
        if(res < 0) res = -1;
        else if (res > 0) res = 1;
        else res = 0;
        return res;
    }
    
    public double getVMedia(){
        return this.vMedia;
    }
    
    public double getPreco(){
        return this.preco;
    }
    
    public double getConsumo(){
        return this.consumo;
    }
    
    public Set<DadosAluguer> getHistorico(){
        Set<DadosAluguer> hist = new TreeSet<>();
        
        for(DadosAluguer s : this.historico){
            hist.add(s);
        }
        return hist;
    }
    
    public double getPosX(){
        return this.posX;
    }
    
    public double getPosY(){
        return this.posY;
    }
    
    public double getClassificacao(){
        return this.classificacao;
    }
    
    public double getAutonomia(){
        return this.autonomia;
    }
    
    public double getCombustivel(){
        return this.combustivel;
    }
    
    public String getMarca(){
        return this.marca;
    }
    
    public String getMatricula(){
        return this.matricula;
    }
    
    public void setVMedia(double v){
        this.vMedia = v;
    }
    
    public void setPreco(double p){
        this.preco = p;
    }
    
    public void setHistorico(Set<DadosAluguer> l){
        this.historico = new TreeSet<>();
        historico.forEach(s -> {this.historico.add(s);});
    }
    
    public void addAluguer(DadosAluguer aluguer) {
        this.historico.add(aluguer);
    }
    
    public void setConsumo(double c){
        this.consumo = c;
    }
    
    public void setPosX(double x){
        this.posX = x;
    }
    
    public void setPosY(double y){
        this.posY = y;
    }
    
    public void setClassificacao(int c){
        this.classificacao = c;
    }
    
    public void setCombustivel(double c){
        this.combustivel = c;
    }
    
    public void setAutonomia(double a){
        this.autonomia = a;
    }
    
    public void setMarca(String marca){
        this.marca = marca;
    }
    
    public void setMatricula(String matricula){
        this.matricula = matricula;
    }
    
    public boolean equals(Object obj) {
       if(obj==this) return true;
       if(obj==null || obj.getClass()!=this.getClass()) return false;
       Viatura v = (Viatura) obj;
       return this.vMedia == v.getVMedia() && this.preco == v.getPreco() && 
              this.consumo == v.getConsumo() && this.posX == v.getPosX() && this.posY == v.getPosY() &&
              this.autonomia == v.getAutonomia() && this.classificacao == v.getClassificacao() && 
              this.combustivel == v.getCombustivel() && this.marca.equals(v.getMarca()) &&
              this.matricula.equals(v.getMatricula()); //falta historico
    }
    
    public String toString() {
        return "VelocMedia: " + getVMedia() + " Preco: " + getPreco() + " Consumo: " + getConsumo() + "\nClassificacao: " + getClassificacao() + " PosX: " + getPosX() + " PosY: " + getPosY() + "\nAutonomia: " + getAutonomia() + " Combustivel: " + getCombustivel() + "\nMarca: " + getMarca() + " Matricula: " + getMatricula() + "\nHistorico: " + getHistorico();
    }
}
    
