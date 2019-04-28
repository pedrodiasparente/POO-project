
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
    private List<CarroGas> carrosGas;
    private List<CarroEletro> carrosEletro;
    private List<CarroHibrido> carrosHibrido;
    
    /**
     * Constructor for objects of class Proprietario
     */
    public Proprietario(){
        super();
        this.carrosGas = new ArrayList<>();
        this.carrosEletro = new ArrayList<>();
        this.carrosHibrido = new ArrayList<>();
    }
    
    public Proprietario(String email, String password, String nome, String morada, LocalDate dataNasc, List<DadosAluguer> historico, double classificacao, List<CarroGas> carroGas, List<CarroEletro> carroEletro, List<CarroHibrido> carroHibrido){
        super(email,password,nome,morada, dataNasc, historico, classificacao);
        this.carrosGas = carroGas;
        this.carrosEletro = carroEletro;
        this.carrosHibrido = carroHibrido;
    }
    
    public Proprietario(Proprietario p){
        super(p);
        this.carrosGas = p.getCarroGas();
        this.carrosEletro = p.getCarroEletro();
        this.carrosHibrido = p.getCarroHibrido();
    }
    
    public List<CarroGas> getCarroGas() {
        List<CarroGas> carroList = new ArrayList<>();
        
        for(CarroGas s : carrosGas){
            carroList.add(s);
        }
        return carroList;
    }
    
    public List<CarroEletro> getCarroEletro() {
        List<CarroEletro> carroList = new ArrayList<>();
        
        for(CarroEletro s : carrosEletro){
            carroList.add(s);
        }
        return carroList;
    }
    
    public List<CarroHibrido> getCarroHibrido() {
        List<CarroHibrido> carroList = new ArrayList<>();
        
        for(CarroHibrido s : carrosHibrido){
            carroList.add(s);
        }
        return carroList;
    }
    
    public void setCarroGasList(List<CarroGas> l){
        this.carrosGas = new ArrayList<>();
        carrosGas.forEach(s -> {this.carrosGas.add(s);});
    }
    
    public void setCarroEletroList(List<CarroEletro> l){
        this.carrosEletro = new ArrayList<>();
        carrosEletro.forEach(s -> {this.carrosEletro.add(s);});
    }
    
    public void setCarroHibridoList(List<CarroHibrido> l){
        this.carrosHibrido = new ArrayList<>();
        carrosHibrido.forEach(s -> {this.carrosHibrido.add(s);});
    }
}
