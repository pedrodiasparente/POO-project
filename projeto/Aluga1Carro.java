
/**
 * Write a description of class Aluga1Carro here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Aluga1Carro {
    
    // Menus da aplicação
    private Menu menu;
    
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
        String[] opcoes = {"Adicionar Viatura",
                           "Adicionar Proprietario",
                           "Adicionar Cliente",
                           "outras coisas"};
        this.menu = new Menu("#Menu:",opcoes);        
    }

    /**
     * Executa o menu principal e invoca o método correspondente à opção seleccionada.
     */
    private void run() {
        do {
            menu.executa();
            switch (menu.getOpcao()) {
                case 1: System.out.println("Escolheu adicionar Viatura");
                        break;
                case 2: System.out.println("Escolheu adicionar Proprietario");
                        break;
                case 3: System.out.println("Escolheu adicionar Cliente");
                        break;
                case 4: System.out.println("Escolheu outras coisas");
                        break;        
            }
        } while (menu.getOpcao()!=0); // A opção 0 é usada para sair do menu.
        System.out.println("Até breve!...");     
    }
    
}


