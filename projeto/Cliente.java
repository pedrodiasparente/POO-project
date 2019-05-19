import java.util.*;
import java.time.LocalDate;

/**
 * Escreva a descrição da classe Cliente aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Cliente extends Atores
{
    private double posX;
    private double posY;
    
    public Cliente(){
        super();
        this.posX = 0;
        this.posY = 0;
    }
    
    public Cliente(String email, String password, String nome, String morada, LocalDate dataNasc, double posX, double posY, Set<DadosAluguer> historico, String nif){
        super(email,password,nome,morada, dataNasc, historico, nif);
        this.posX = posX;
        this.posY = posY;
    }
    
    public Cliente(Cliente c){
        super(c);
        this.posX = c.getPosX();
        this.posY = c.getPosY();
    }
    
    public double getPosX() {
        return this.posX;
    }
    
    public double getPosY() {
        return this.posY;
    }
    
    public void setPosX(double x) {
        this.posX = x;
    }
    
    public void setPosY(double y) {
        this.posY = y;
    }
    
    public Cliente clone() {
        return new Cliente(this);
    }
    
    public boolean equals(Object obj) {
       if(obj==this) return true;
       if(obj==null || obj.getClass()!=this.getClass()) return false;
       Cliente a = (Cliente) obj;
       return super.equals(obj) && this.posX == a.getPosX() && this.posY == a.getPosY();
    }
    
    public String toString(){
        return "Posx: " + this.posX + " psy: " + this.posY + "\n" + super.toString();
    }
    
    public Viatura solicitaCarroMaisPerto(Sistema s){
        
        double min = 999999999;
        double dist,x,y;
        Viatura ve = new Viatura();
            
        for(Viatura v : s.getViaturas()){
            x = v.getPosX();
            y = v.getPosY();
            dist = Math.pow(this.posX - x, 2) + Math.pow(this.posY - y, 2);
            if (min > dist){
                min = dist;
                ve = v;
            }     
     }
    return ve;
    }
   
    public Viatura solicitaCarroMaisBarato(Sistema s){
              
        double min = 999999999, preco;        
        Viatura ve = new Viatura();
            
        for(Viatura v : s.getViaturas()){
            preco = v.getPreco();
                        
            if (min > preco){
                min = preco;
                ve = v;
            }     
        }
        return ve;
    }

    public Viatura solicitaCarroDistPreco(Sistema s, double distancia){    
        double min = 999999999, preco, dist, x, y;     
        Viatura ve = new Viatura();
            
        for(Viatura v : s.getViaturas()){
            x = v.getPosX();
            y = v.getPosY();
            preco = v.getPreco();
            dist = Math.pow(this.posX - x, 2) + Math.pow(this.posY - y, 2);            
            if (min > preco && dist <= distancia){
                min = preco;
                ve = v;
            }     
        }
        return ve;
    }
 
    public Viatura solicitaCarroEspecifico(Sistema s, String matricula){//nao sei se e melhor comparar por matricula ou viatura em si               
        Viatura ve = new Viatura();
            
        for(Viatura v : s.getViaturas()){            
                        
            if (v.getMatricula().equals(matricula)){//nao sei se e melhor comparar por matricula ou viatura em si
              ve = v;//
            }     
        }
        return ve;
    }
    
    public Viatura solicitaCarroAutonomia(Sistema s, double autonomia){
        Viatura ve = new Viatura();
        
        for(Viatura v : s.getViaturas()){
            
            if (v.getAutonomia() == autonomia){
                ve = v;
            }
            
        }
        
        return ve;
    }
                
}
