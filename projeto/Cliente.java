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
    
    public Viatura solicitaCarroMaisPerto(Sistema s, double xDest, double yDest){
        
        double min = 999999999;
        double dist,x,y, distDest;
        Viatura ve = new Viatura();
        ve = null;
            
        for(Viatura v : s.getViaturas()){
            x = v.getPosX();
            y = v.getPosY();
            dist = Math.pow(this.posX - x, 2) + Math.pow(this.posY - y, 2);
            distDest = Math.hypot(v.getPosX() - xDest, v.getPosY() - yDest);
            if (min > dist && distDest >= v.getAutonomia()){
                min = dist;
                ve = v;
            }     
        }   
        return ve;
    }
   
    public Viatura solicitaCarroMaisBarato(Sistema s, double xDest, double yDest){
              
        double min = 999999999;
        double preco, dist;        
        Viatura ve = new Viatura();
        ve = null; 
        
        for(Viatura v : s.getViaturas()){
            preco = v.getPreco();
            dist= Math.hypot(v.getPosX() - xDest, v.getPosY() - yDest);            
            if (min > preco && dist >= v.getAutonomia()){
                min = preco;
                ve = v;
            }     
        }
        return ve;
    }

    public Viatura solicitaCarroDistPreco(Sistema s, double distancia, double xDest, double yDest){    
        double min = 999999999;
        double preco, dist, x, y, distDest;     
        Viatura ve = new Viatura();
        
        ve = null;
            
        for(Viatura v : s.getViaturas()){
            x = v.getPosX();
            y = v.getPosY();
            preco = v.getPreco();
            dist = Math.pow(this.posX - x, 2) + Math.pow(this.posY - y, 2);
            distDest = Math.hypot(v.getPosX() - xDest, v.getPosY() - yDest);
            if (min > preco && dist <= distancia && distDest > v.getAutonomia()){
                min = preco;
                ve = v;
            }     
        }
        return ve;
    }
 
    public Viatura solicitaCarroEspecifico(Sistema s, String matricula, double xDest, double yDest){             
        double distDest;
        Viatura ve = new Viatura();
        ve = null;
            
        for(Viatura v : s.getViaturas()){            
            distDest = Math.hypot(v.getPosX() - xDest, v.getPosY() - yDest);
            if (v.getMatricula().equals(matricula) && distDest > v.getAutonomia()){
              ve = v;//
            }     
        }
        return ve;
    }
    
    public Viatura solicitaCarroAutonomia(Sistema s, double autonomia, double xDest, double yDest){
        double distDest;
        Viatura ve = new Viatura();
        ve = null;
        
        for(Viatura v : s.getViaturas()){
            distDest = Math.hypot(v.getPosX() - xDest, v.getPosY() - yDest);
            if (v.getAutonomia() == autonomia && distDest > v.getAutonomia()){
                ve = v;
            }
            
        }
        
        return ve;
    }
                
}
