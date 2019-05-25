import java.io.*;
import java.util.Scanner;
/**
 * Write a description of class Aluga1Carro here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Aluga1Carro {
    Sistema systemLogs;
    // Menus da aplicação
    private Menu menu;
    private Menu menuCliente;
    private Menu menuProprietario;
    private String currentCliente;
    
    /**
     * O método main cria a aplicação e invoca o método run()
     */
    public static void main(String[] args) {
        new Aluga1Carro().run();
    }
    
    /**
     * Construtor.
     * 
     * Cria os menus e a camada de negócio.
     */
    private Aluga1Carro() {
        // Criar o menu 
        String[] opcoesMenu = {"Ler dos Logs",
                               "Registar Cliente",
                               "Registar Proprietario",
                               "Log In Cliente",
                               "Log In Proprietario",
                               "Guardar estado",
                               "Carregar Estado"};
        String[] opcoesMenuCliente = {"Solicitar o aluguer de um carro mais próximo",
                                      "Solicitar o aluguer do carro mais barato",
                                      "Solicitar o aluguer do carro mais barato dentro de uma distância",
                                      "Solicitar o aluguer de um carro especifico",
                                      "Solicitar o aluguer de um carro com autonomia desejada"};
        String[] opcoesMenuProprietario = {"Registar Veiculo",
                                           "Abastecer Veiculo",
                                           "Alterar preço/km",
                                           "Consultar suas Viaturas"};
        this.menu = new Menu("Menu:",opcoesMenu);
        this.menuCliente = new Menu("Menu Cliente:",opcoesMenuCliente);
        this.menuProprietario = new Menu("Menu Proprietario:",opcoesMenuProprietario);
        this.systemLogs = new Sistema();
    }

    /**
     * Executa o menu principal e invoca o método correspondente à opção seleccionada.
     */
    private void run() {
        Scanner sc = new Scanner(System.in);
        double x, y, dist, autonomia;
        String matricula;
        do {
            menu.executa();
            switch (menu.getOpcao()) {
                case 1: System.out.println("Escolher ler os logs");
                        this.systemLogs = Sistema.loadData("logsPOO_carregamentoincial.bak");
                        break;
                case 2: System.out.println("Escolheu registar Cliente");
                        try{
                            this.systemLogs.addCliente(this.scanCliente());
                        } catch(ClienteJaExisteException e){
                            System.out.println(e.getMessage());
                        }
                        break;
                case 3: System.out.println("Escolheu registar Proprietario");
                        try{
                            this.systemLogs.addProprietario(this.scanProprietario());
                        } catch(ProprietarioJaExisteException e){
                            System.out.println(e.getMessage());
                        }
                        break;
                case 4: System.out.println("Escolheu dar Log In como Cliente (Introduza 0 para dar Log Off)");
                        try{
                            Cliente c = this.loginCliente();
                            do{
                                menuCliente.executa();
                                switch (menuCliente.getOpcao()) {
                                    case 1: System.out.println("Escolheu solicitar o aluguer de um carro mais próximo");
                                            System.out.println("Insira destino (X)");
                                            x = sc.nextDouble();
                                            System.out.println("Insira destino (Y)");
                                            y = sc.nextDouble();
                                            c.alugaCarroDist(this.systemLogs, x, y);
                                            break;
                                    case 2: System.out.println("Escolheu solicitar o aluguer do carro mais barato");
                                            System.out.println("Insira destino (X)");
                                            x = sc.nextDouble();
                                            System.out.println("Insira destino (Y)");
                                            y = sc.nextDouble();
                                            c.alugaCarroMaisBarato(this.systemLogs, x, y);
                                            break;
                                    case 3: System.out.println("Escolheu solicitar o aluguer do carro mais barato dentro de uma distância");
                                            System.out.println("Insira destino (X)");
                                            x = sc.nextDouble();
                                            System.out.println("Insira destino (Y)");
                                            y = sc.nextDouble();
                                            System.out.println("Insira distancia Maxima");
                                            dist = sc.nextDouble();
                                            c.alugaCarroDistPreco(this.systemLogs, x, y, dist);
                                            break;
                                    case 4: System.out.println("Escolheu solicitar o aluguer de um carro especifico");
                                            System.out.println("Insira destino (X)");
                                            x = sc.nextDouble();
                                            System.out.println("Insira destino (Y)");
                                            y = sc.nextDouble();
                                            System.out.println("Insira a Matricula da Viatura");
                                            matricula = sc.nextLine();
                                            c.alugaCarroEspecifico(this.systemLogs, matricula, x, y);
                                            break;
                                    case 5: System.out.println("Escolheu solicitar o aluguer de um carro com autonomia desejada");
                                            System.out.println("Insira destino (X)");
                                            x = sc.nextDouble();
                                            System.out.println("Insira destino (Y)");
                                            y = sc.nextDouble();
                                            System.out.println("Insira Autonomia desejada");
                                            autonomia = sc.nextDouble();
                                            c.alugaCarroAutonomia(this.systemLogs, x, y, autonomia);
                                            break;
                                }
                            } while(menuCliente.getOpcao() != 0);
                            System.out.println("Deu Log Off");
                        } catch(FailedLoginException e){
                            System.out.println(e);
                        }
                        break;
                case 5: System.out.println("Escolheu dar Log In como Proprietario (Introduza 0 para dar Log Off)");
                        try{
                            Proprietario p = this.loginProprietario();
                            do{
                                menuProprietario.executa();
                                switch (menuProprietario.getOpcao()) {
                                    case 1: System.out.println("Escolheu registar um veiculo");
                                            break;
                                    case 2: System.out.println("Escolheu abastecer o seu veiculo");
                                            break;
                                    case 3: System.out.println("Escolheu alterar preco/km");
                                            break;
                                    case 4: System.out.println("Escolheu consultar as suas viaturas");
                                            break;
                                }
                            } while(menuProprietario.getOpcao() != 0);
                            System.out.println("Deu Log Off");
                        } catch(FailedLoginException e){
                            System.out.println(e);
                        }
                        break;
                case 6: System.out.println("Escolheu guardar o estado");
                        systemLogs.saveEstado("estado.txt");
                        break;
                case 7: System.out.println("Escolheu carregar o estado");
                        systemLogs = Sistema.readEstado("estado.txt");
                        break;
            }
        } while (menu.getOpcao()!=0); // A opção 0 é usada para sair do menu.
        System.out.println("Até breve!...");     
    }
    
    private Cliente scanCliente(){
        Cliente c = new Cliente();
        Scanner scin = new Scanner(System.in);
        
        System.out.println("Insira o Nome:");
        c.setNome(scin.nextLine());
        System.out.println("Insira o NIF:");
        c.setNif(scin.nextLine());
        System.out.println("Insira a Email:");
        c.setEmail(scin.nextLine());
        System.out.println("Insira a Password:");
        c.setPassword(scin.nextLine());
        System.out.println("Insira a Morada:");
        c.setMorada(scin.nextLine());
        System.out.println("Insira a Posicao X:");
        c.setPosX(scin.nextDouble());
        System.out.println("Insira a Posicao Y:");
        c.setPosY(scin.nextDouble());
        
        return c;
    }
    
    private Proprietario scanProprietario(){
        Proprietario p = new Proprietario();
        Scanner scin = new Scanner(System.in);
        
        System.out.println("Insira o Nome:");
        p.setNome(scin.nextLine());
        System.out.println("Insira o NIF:");
        p.setNif(scin.nextLine());
        System.out.println("Insira a Email:");
        p.setEmail(scin.nextLine());
        System.out.println("Insira a Password:");
        p.setPassword(scin.nextLine());
        System.out.println("Insira a Morada:");
        p.setMorada(scin.nextLine());
        System.out.println("Insira a Posicao X:");

        return p;
    }
    
    private Cliente loginCliente() throws FailedLoginException{
        Scanner scin = new Scanner(System.in);
        System.out.println("Insira o NIF");
        String clienteNif = scin.nextLine();
        System.out.println("Insira a Password");
        String clientePassword = scin.nextLine();
        if(this.systemLogs.getClientes().containsKey(clienteNif) && 
           this.systemLogs.getClientes().get(clienteNif).getPassword().equals(clientePassword)){
            return this.systemLogs.getClientes().get(clienteNif).clone();
        }
        else throw new FailedLoginException();  
    }
    
    private Proprietario loginProprietario() throws FailedLoginException{
        Scanner scin = new Scanner(System.in);
        System.out.println("Insira o NIF");
        String proprietarioNif = scin.nextLine();
        System.out.println("Insira a Password");
        String proprietarioPassword = scin.nextLine();
        if(this.systemLogs.getProprietarios().containsKey(proprietarioNif) && 
           this.systemLogs.getProprietarios().get(proprietarioNif).getPassword().equals(proprietarioPassword)){
            return this.systemLogs.getProprietarios().get(proprietarioNif).clone();
        }
        else throw new FailedLoginException();  
    }
}


