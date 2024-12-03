import Personagens.Principais.*;
import java.util.Scanner;

public class Jogo {
    Scanner scanner = new Scanner(System.in);

    public void iniciar() throws InterruptedException {
        Batalha batalha = new Batalha();

        //Exército 1
        Exército exército1 = iniciarExército();

        System.out.println("\nIntegrantes do exército");

        for(int i = 1; i < 10; i++){
            int numeroSorteado = (int) (Math.random() * 3) + 1;
            Personagem personagem = selecionarPersonagem(numeroSorteado);
            exército1.adicionarPersonagem(personagem);
        }

        System.out.println(exército1.getNome() + " criado com sucesso!");

        

        //Exército 2
        Exército exército2 = iniciarExército();
        for(int i = 1; i < 10; i++){
            int numeroSorteado = (int) (Math.random() * 3) + 1;
            Personagem personagem = selecionarPersonagem(numeroSorteado);
            exército2.adicionarPersonagem(personagem);
        }

        System.out.println(exército2.getNome() + " criado com sucesso!");

        batalha.iniciarBatalha(exército1, exército2);
    }

    public Personagem selecionarPersonagem() throws InterruptedException {
        System.out.println("Escolha seu líder: \n1 - Mago \n2 - Cavaleiro \n3 - Arqueiro");

        int escolha;
        try {
            escolha = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Entrada incorreta! Por favor, escolha um número de 1 a 3.");
            return null;
        }

        

        String nome;
        switch (escolha) {
            case 1:
                System.out.println("Mago escolhido como líder!");
                
                System.out.println("Digite o nome do seu Mago: ");
                nome = scanner.nextLine();
                
                return new Mago(nome);
            case 2:
                System.out.println("Cavaleiro escolhido como líder!");
                
                System.out.println("Digite o nome do seu Cavaleiro: ");
                nome = scanner.nextLine();
                
                return new Cavaleiro(nome);
            case 3:
                System.out.println("Arqueiro escolhido como líder!");
                
                System.out.println("Digite o nome do seu Arqueiro: ");
                nome = scanner.nextLine();
                
                return new Arqueiro(nome);
            default:
                System.out.println("Entrada incorreta!");
                return null;
        }
    }

    public Personagem selecionarPersonagem(int i) throws InterruptedException {
        String nome;
        Thread.sleep(1000);
        switch (i) {
            case 1:
                System.out.println("- Mago invocado! Digite o nome do seu Mago: ");
                nome = scanner.nextLine();
                Thread.sleep(1000);
                return new Mago(nome);
            case 2:
                System.out.println("- Cavaleiro invocado! Digite o nome do seu Cavaleiro: ");
                nome = scanner.nextLine();
                Thread.sleep(1000);
                return new Cavaleiro(nome);
            case 3:
                System.out.println("- Arqueiro invocado! Digite o nome do seu Arqueiro: ");
                nome = scanner.nextLine();
                Thread.sleep(1000);
                return new Arqueiro(nome);
            default:
                System.out.println("Entrada incorreta!");
                return null;
        }
    }

    public Exército iniciarExército() throws InterruptedException{
        System.out.println("Digite o nome do seu exército: ");
        String nomeExército;
        try {
            nomeExército = scanner.nextLine();
        } catch (NumberFormatException e) {
            System.out.println("Entrada incorreta!");
            return null;
        }
        

        Personagem personagemLíder = selecionarPersonagem();

        return new Exército(nomeExército, personagemLíder);
    }
}
