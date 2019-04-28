import java.util.List;
import java.util.ArrayList;
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
    
    public Cliente(String email, String password, String nome, String morada, LocalDate dataNasc, double posX, double posY, List<DadosAluguer> historico, double classificacao){
        super(email,password,nome,morada, dataNasc, historico, classificacao);
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
}
