 
import java.util.List;
import java.util.ArrayList;

/**
 * Escreva a descrição da classe Viatura aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Viatura
{
    private int tipo; 
    private double vMedia;
    private double preço;
    private double consumo;
    private List<DadosAluguer> historico;
    private double classificacao;
    private double posX;
    private double posY;
    private double autonomia;
    private double combustivel;
    
    public Viatura(){
        this.tipo = -1;
        this.vMedia = 0;
        this.preço = 0;
        this.consumo = 0;
        this.historico = new ArrayList<>();
        this.classificacao = 0;
        this.posX = 0;
        this.posY = 0;
        this.autonomia = 0;
        this.combustivel = 0;
    }
    
    public Viatura(int tipo, double vmedia, double preço, double consumo, List<DadosAluguer> hist, double posx, double posy, double classi, double autonomia, double combustivel){ 
        this.tipo = tipo;
        this.vMedia = vmedia;
        this.preço = preço;
        this.consumo = consumo;
        setHistorico(hist);
        this.posX = posx;
        this.posY = posy;
        this.classificacao = classi;
        this.autonomia = autonomia;
        this.combustivel = combustivel;
    }
    
    public Viatura(Viatura v){
        this.tipo = v.getTipo();
        this.vMedia = v.getVMedia();
        this.preço = v.getPreço();
        this.consumo = v.getConsumo();
        this.historico  =v.getHistorico();
        this.posX = v.getPosX();
        this.posY = v.getPosY();
        this.classificacao = v.getClassificacao();
        this.autonomia = v.getAutonomia();
        this.combustivel = v.getCombustivel();
    }
    
    public int getTipo(){
        return this.tipo;
    }
    
    public double getVMedia(){
        return this.vMedia;
    }
    
    public double getPreço(){
        return this.preço;
    }
    
    public double getConsumo(){
        return this.consumo;
    }
    
    public List<DadosAluguer> getHistorico(){
        List<DadosAluguer> hist = new ArrayList<>();
        
        for(DadosAluguer s : historico){
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
    
    public void setTipo(int t){
        this.tipo = t;
    }
    
    public void setVMedia(double v){
        this.vMedia = v;
    }
    
    public void setPreço(double p){
        this.preço = p;
    }
    
    public void setHistorico(List<DadosAluguer> l){
        this.historico = new ArrayList<>();
        historico.forEach(s -> {this.historico.add(s);});
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
}
    
