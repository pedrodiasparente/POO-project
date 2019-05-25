import java.io.*;
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
    }

    /**
     * Executa o menu principal e invoca o método correspondente à opção seleccionada.
     */
    private void run() {
        do {
            menu.executa();
            switch (menu.getOpcao()) {
                case 1: System.out.println("Escolher ler os logs");
                        systemLogs = Sistema.loadData("logsPOO_carregamentoincial.bak");
                        break;
                case 2: System.out.println("Escolheu registar Cliente");
                        break;
                case 3: System.out.println("Escolheu registar Proprietario");
                        break;
                case 4: System.out.println("Escolheu dar Log In como Cliente (Introduza 0 para dar Log Off)");
                        do{
                            menuCliente.executa();
                            switch (menuCliente.getOpcao()) {
                                case 1: System.out.println("Escolheu solicitar o aluguer de um carro mais próximo");
                                        break;
                                case 2: System.out.println("Escolheu solicitar o aluguer do carro mais barato");
                                        break;
                                case 3: System.out.println("Escolheu solicitar o aluguer do carro mais barato dentro de uma distância");
                                        break;
                                case 4: System.out.println("Escolheu solicitar o aluguer de um carro especifico");
                                        break;
                                case 5: System.out.println("Escolheu solicitar o aluguer de um carro com autonomia desejada");
                                        break;
                            }
                        } while(menuCliente.getOpcao() != 0);
                        System.out.println("Deu Log Off");
                        break;
                case 5: System.out.println("Escolheu dar Log In como Proprietario (Introduza 0 para dar Log Off)");
                        do{
                            menuProprietario.executa();
                            switch (menuProprietario.getOpcao()) {
                                case 1: System.out.println("Escolheu registar o seu veiculo");
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
    
}


