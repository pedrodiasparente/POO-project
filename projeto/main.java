import java.util.*;
import java.time.LocalDate;
/**
 * Write a description of class main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class main
{
    public static void main(String args[]) {
        LocalDate date = LocalDate.now();
        Cliente cliente = new Cliente();
        Proprietario proprietario = new Proprietario();
        Viatura viatura = new Viatura();
        DadosAluguer aluguer = new DadosAluguer();
        Sistema systemLogs = new Sistema();
        
        cliente.setId("21312");
        cliente.setEmail("randomemail@gmail.com");
        cliente.setNome("Manel");
        cliente.setPassword("ponteheyfell");
        cliente.setMorada("rua das trotinetes");
        cliente.setDataNasc(date);
        cliente.setPosX(34);
        cliente.setPosY(72);
        
        viatura.setVMedia(40);
        viatura.setPreco(40000);
        viatura.setConsumo(34);
        viatura.setClassificacao(90);
        viatura.setPosX(42);
        viatura.setPosY(44);
        viatura.setAutonomia(10);
        viatura.setCombustivel(45);
        viatura.setMarca("AudiR8 mfs");
        viatura.setMatricula("EZ-69-69");
        
        proprietario.setClassificacao(96);
        proprietario.setEmail("proprietario69@gmail.com");
        proprietario.setNome("Ze");
        proprietario.setPassword("torre da heyfell");
        proprietario.setMorada("ovos mexidos street");
        proprietario.setDataNasc(date);
        
        aluguer.setCliente(cliente);
        aluguer.setViatura(viatura);
        aluguer.setProprietario(proprietario);
        aluguer.setClassificacao(100);
        
        DadosAluguer aluguerClone = aluguer.clone();
        
        cliente.addAluguer(aluguer);
        cliente.addAluguer(aluguerClone);
        viatura.addAluguer(aluguer);
        viatura.addAluguer(aluguerClone);
        proprietario.addAluguer(aluguer);
        proprietario.addAluguer(aluguerClone);
        proprietario.addViatura(viatura);
        systemLogs.addCliente(cliente);
        systemLogs.addViatura(viatura);
        systemLogs.addProprietario(proprietario);
        systemLogs.addAluguer(aluguer);
        
        System.out.println("Cliente => " + cliente.toString() + "\n\n\n");
        System.out.println("Viatura => " + viatura.toString() + "\n\n\n");
        System.out.println("Proprietario => " + proprietario.toString() + "\n\n\n");
        System.out.println(systemLogs.toString());
        
    }
}
