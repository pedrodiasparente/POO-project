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
        CarroGas viatura = new CarroGas();
        DadosAluguer aluguer = new DadosAluguer();
        Sistema systemLogs = new Sistema();
        
        cliente.setNif("21312");
        cliente.setEmail("randomemail@gmail.com");
        cliente.setNome("Manel");
        cliente.setPassword("ponteheyfell");
        cliente.setMorada("rua das trotinetes");
        cliente.setDataNasc(date);
        cliente.setPosX(34);
        cliente.setPosY(72);
        
        viatura.setVMedia(40);
        viatura.setPreco(10);
        viatura.setConsumo(5);
        viatura.setClassificacao(90);
        viatura.setPosX(42);
        viatura.setPosY(44);
        viatura.setAutonomia(80);
        viatura.setCombustivel(400);
        viatura.setMarca("AudiR8 mfs");
        viatura.setMatricula("EZ-69-69");
        
        proprietario.setNif("69420");
        proprietario.setClassificacao(96);
        proprietario.setEmail("proprietario69@gmail.com");
        proprietario.setNome("Ze");
        proprietario.setPassword("torre da heyfell");
        proprietario.setMorada("ovos mexidos street");
        proprietario.setDataNasc(date);

        proprietario.addViatura(viatura, systemLogs);
        systemLogs.addCliente(cliente);
        systemLogs.addProprietario(proprietario);
        System.out.println("SYS BEFORE ALUGUER " + systemLogs.toString() + "\n\n\n\n");
        (systemLogs.getClientes().get("21312")).alugaCarroEspecifico(systemLogs, "EZ-69-69", 50, 50);
        (systemLogs.getClientes().get("21312")).alugaCarroDist(systemLogs, 54, 53);
        (systemLogs.getClientes().get("21312")).alugaCarroMaisBarato(systemLogs, 56, 57);

        
        //System.out.println("Cliente => " + cliente.toString() + "\n\n\n");
        //System.out.println("Viatura => " + viatura.toString() + "\n\n\n");
        //System.out.println("Proprietario => " + proprietario.toString() + "\n\n\n");
        System.out.println("SYS AFTER ALUGUER " + systemLogs.toString() + "\n\n\n\n");
        //System.out.println("client: " + cliente.equals(clienteClone) + "\nproprietario: " + proprietario.equals(proprietarioClone) + "\nviatura: " + viatura.equals(viaturaClone) + "\ndados aluguer: " + aluguer.equals(aluguerClone));
        
    }
}
