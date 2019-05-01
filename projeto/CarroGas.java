import java.util.*;
import java.time.LocalDate;

/**
 * Write a description of class CarroGas here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CarroGas extends Viatura
{

    /**
     * Constructor for objects of class CarroGas
     */
    public CarroGas()
    {
        super();
    }
    
    public CarroGas(double vmedia, double preco, double consumo, Set<DadosAluguer> hist, double posx, double posy, double classi, double autonomia, double combustivel, String marca, String matricula)
    {
        super(vmedia, preco, consumo, hist, posx, posy, classi, autonomia, combustivel, marca, matricula);
    }
    
    public CarroGas(CarroGas c)
    {
        super(c);
    }
}
