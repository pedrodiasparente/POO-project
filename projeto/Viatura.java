import java.time.LocalDate;
import java.util.*;
import java.lang.String;
import java.io.*;

/**
 * Escreva a descrição da classe Viatura aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Viatura implements Comparable<Viatura>,Serializable
{
    private double vMedia;
    private double preco;
    private double consumo;
    private Map<Double, DadosAluguer> historico;
    private List<Double> classificacao;
    private double posX;
    private double posY;
    private double autonomia;
    private double combustivel;
    private String marca;
    private String matricula;
    private String nifProprietario;
    private String tipo;
    
    public Viatura(){
        this.vMedia = 0;
        this.preco = 0;
        this.consumo = 0;
        this.historico = new HashMap<>();
        this.classificacao = new ArrayList<>();
        this.posX = 0;
        this.posY = 0;
        this.autonomia = 0;
        this.combustivel = 0;
        this.marca = "";
        this.matricula = "00-00-00";
        this.nifProprietario = "";
        this.tipo = "";
    }
    
    public Viatura(double vmedia, double preco, double consumo, Map<Double, DadosAluguer> hist, double posx, double posy, List<Double> classi, double autonomia, double combustivel, String marca, String matricula, String proprietario, String tipo){ 
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
        this.nifProprietario = proprietario;
        this.tipo = tipo;
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
        this.nifProprietario = v.getNifProprietario();
        this.tipo = v.getTipo();
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
    
    public Map<Double, DadosAluguer> getHistorico(){
        Map<Double, DadosAluguer> hist = new HashMap<>();
        
        for(DadosAluguer d : this.historico.values()){
            hist.put(d.getPreco(), d.clone());
        }
        return hist;
    }
    
    public double getPosX(){
        return this.posX;
    }
    
    public double getPosY(){
        return this.posY;
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
    
    public String getNifProprietario(){
        return this.nifProprietario;
    }

    public String getTipo(){
        return this.tipo;
    }    
    
    public void setVMedia(double v){
        this.vMedia = v;
    }
    
    public void setPreco(double p){
        this.preco = p;
    }
    
    public void setHistorico(Map<Double, DadosAluguer> l){
        this.historico = new HashMap<>();
        for(DadosAluguer d : l.values()){
            this.historico.put(d.getPreco(), d.clone());
        }
    }
    
    public void addAluguer(DadosAluguer aluguer) {
        this.historico.put(aluguer.getPreco(), aluguer.clone());
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
    
    public void setNifProprietario(String nif){
        this.nifProprietario = nif;
    }

    public void setTipo(String t){
        this.tipo = t;
    }    
    
    public boolean equals(Object obj) {
       if(obj==this) return true;
       if(obj==null || obj.getClass()!=this.getClass()) return false;
       Viatura v = (Viatura) obj;
       return this.vMedia == v.getVMedia() && this.preco == v.getPreco() && 
              this.consumo == v.getConsumo() && this.posX == v.getPosX() && this.posY == v.getPosY() &&
              this.combustivel == v.getCombustivel() && this.marca.equals(v.getMarca()) &&
              this.matricula.equals(v.getMatricula()) && this.nifProprietario.equals(v.getNifProprietario()) &&
              this.tipo.equals(v.getTipo()); //falta historico
    }
    
    public String toString() {
        return "VelocMedia: " + getVMedia() + " Preco: " + getPreco() + " Consumo: " + getConsumo() + "\nClassificacao: " + getClassificacao() + " PosX: " + getPosX() + " PosY: " + getPosY() + "\nAutonomia: " + getAutonomia() + " Combustivel: " + getCombustivel() + "\nMarca: " + getMarca() + " Matricula: " + getMatricula() + " Tipo: " + getTipo() + "\nHistorico: " + getHistorico();
    }
    
    public Viatura clone() {
        return new Viatura(this);
    }
    
    public static Viatura stringToViatura(String s){
        String[] atributos;
        Viatura v = new Viatura();
        
        atributos = s.split(",");
        
        v.setMarca(atributos[1]);
        v.setMatricula(atributos[2]);
        v.setNifProprietario(atributos[3]);
        try {
            v.setVMedia(Double.parseDouble(atributos[4]));
        } catch (NumberFormatException | NullPointerException e) {return null;}
        try {
            v.setPreco(Double.parseDouble(atributos[5]));
        } catch (NumberFormatException | NullPointerException e) {return null;}
        try {
            v.setConsumo(Double.parseDouble(atributos[6]));
        } catch (NumberFormatException | NullPointerException e) {return null;}
        try {
            v.setAutonomia(Double.parseDouble(atributos[7]));
        } catch (NumberFormatException | NullPointerException e) {return null;}
        try {
            v.setPosX(Double.parseDouble(atributos[8]));
        } catch (NumberFormatException | NullPointerException e) {return null;}
        try {
            v.setPosY(Double.parseDouble(atributos[9]));
        } catch (NumberFormatException | NullPointerException e) {return null;}
        v.setCombustivel(v.getAutonomia() * (v.getConsumo()/10));     
        
        return v;
    }
    //falta registar preço de viagens e responder a pedidos de alguguer
}
    
