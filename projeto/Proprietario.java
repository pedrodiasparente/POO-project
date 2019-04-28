import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

/**
 * Write a description of class Proprietario here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Proprietario extends Atores
{
    /**
     * Constructor for objects of class Proprietario
     */
    public Proprietario(){
        super();
    }
    
    public Proprietario(String email, String password, String nome, String morada, LocalDate dataNasc, List<DadosAluguer> historico, double classificacao){
        super(email,password,nome,morada, dataNasc, historico, classificacao);
    }
    
    public Proprietario(Proprietario p){
        super(p);
    }
}
