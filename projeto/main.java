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
        cliente.setId("21312");
        cliente.setEmail("randomemail@gmail.com");
        cliente.setNome("Manel");
        cliente.setPassword("ponteheyfell");
        cliente.setMorada("rua das trotinetes");
        cliente.setDataNasc(date);
        cliente.setPosX(34);
        cliente.setPosY(72);
        aluguer.setCliente(cliente);
        aluguer.setViatura(viatura);
        aluguer.setProprietario(proprietario);
        aluguer.setClassificacao(100);
        cliente.addAluguer(aluguer);
        System.out.println("cliente => " + cliente.toString());
        
    }
}
