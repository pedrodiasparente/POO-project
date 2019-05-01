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
    private String id;
    
    public Cliente(){
        super();
        this.posX = 0;
        this.posY = 0;
        this.id = "";
    }
    
    public Cliente(String email, String password, String nome, String morada, LocalDate dataNasc, double posX, double posY, Set<DadosAluguer> historico, String id){
        super(email,password,nome,morada, dataNasc, historico);
        this.posX = posX;
        this.posY = posY;
        this.id = id;
    }
    
    public Cliente(Cliente c){
        super(c);
        this.posX = c.getPosX();
        this.posY = c.getPosY();
        this.id = c.getId();
    }
    
    public String getId() {
        return this.id;
    }
    
    public double getPosX() {
        return this.posX;
    }
    
    public double getPosY() {
        return this.posY;
    }
    
    public void setId(String id) {
        this.id = id;
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
       return super.equals(obj) && this.posX == a.getPosX() && this.posY == a.getPosY() && this.id.equals(a.getId());//falta historico e viaturas
    }
    
    public String toString(){
        return "Id: " + this.id + " posx: " + this.posX + " psy: " + this.posY + super.toString();
    }
}
