import Personagens.Principais.*;
import Itens.*;
import java.util.List;
import java.util.Scanner;

public class Batalha {
    Scanner scanner = new Scanner(System.in);
    private int rodadas;

    public Batalha(){
        this.rodadas = 1;
    }

    public void iniciarBatalha(Exército exército1, Exército exército2) throws InterruptedException{
        boolean jogoAtivo = true;

        System.out.println("\nJogar cara ou coroa");
        Thread.sleep(2000);
        System.out.println("\nCara: " + exército1.getNome() + "\nCoroa: " + exército2.getNome());

        Thread.sleep(2000);

        int numeroSorteado = (int) (Math.random() * 2);
        Exército exércitoAtual = (numeroSorteado == 0) ? exército1 : exército2;
        Exército exércitoInimigo = (exércitoAtual == exército1) ? exército2 : exército1;
    
        System.out.println((numeroSorteado == 0 ? "Cara!" : "Coroa!"));
        System.out.println(exércitoAtual.getNome() + " irá começar!");

        while (jogoAtivo) {
            System.out.println("\n--- Rodada " + rodadas + " ---");
            Thread.sleep(2000);
    
            for (Personagem personagem : exércitoAtual.getPersonagens()) {
                if (personagem.estaVivo()) {
                    realizarAcao(personagem, exércitoInimigo);
                    Thread.sleep(2000);
                }
            }

            Exército temp = exércitoAtual;
            exércitoAtual = exércitoInimigo;
            exércitoInimigo = temp;
    
            adicionarRodada();

            if (exército1.estaDerrotado() || exército2.estaDerrotado()) {
                jogoAtivo = false;
                System.out.println("\nO exército " + (exército1.estaDerrotado() ? exército2.getNome() : exército1.getNome()) + " venceu!");
            }
        }
    }

    public void realizarAcao(Personagem personagem, Exército exército) throws InterruptedException {
        System.out.println("\n" + personagem.getNome() + ", escolha sua ação:");
        System.out.println("1 - Atacar");
        System.out.println("2 - Defender");
        System.out.println("3 - Usar item");
    
        int escolha;
        try {
            escolha = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Entrada incorreta! Turno perdido.");
            return;
        }
    
        if(escolha == 1) {
            atacar(personagem, exército);
        }
        else if (escolha == 2) {
            defender(personagem);
        }
        else if (escolha == 3) {
            usarItem(personagem, exército);
        }
    }    

    public int getRodadas(){
        return rodadas;
    }

    public void adicionarRodada(){
        this.rodadas += 1;
    }

    public void atacar(Personagem atacante, Exército exércitoInimigo) throws InterruptedException {
        System.out.println("Escolha o inimigo para atacar:");
    
        int i = 1;
        for (Personagem inimigo : exércitoInimigo.getPersonagens()) {
            System.out.println(i + " - " + inimigo.getNome() + " (Vida: " + inimigo.getVida() + ")");
            i++;
        }
    
        int escolha;
        try {
            escolha = Integer.parseInt(scanner.nextLine()) - 1;
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            System.out.println("Escolha inválida! Turno perdido.");
            return;
        }
    
        Personagem alvo = exércitoInimigo.getPersonagens().get(escolha);
        if (alvo.getVida() > 0) {
            alvo.receberDano(atacante.getDano());
            System.out.println(atacante.getNome() + " atacou " + alvo.getNome() + ". " + alvo.getNome() + " está com " + alvo.getVida() + " de vida!");
        } else {
            System.out.println("Alvo já está morto!");
        }
    }
    
    public void defender(Personagem personagem) {
        personagem.entrarDefesa();
        System.out.println(personagem.getNome() + " está em modo de defesa e receberá menos dano na próxima rodada.");
    }

    public void usarItem(Personagem personagem, Exército exército) throws InterruptedException {
        System.out.println("\nItens disponíveis no exército " + exército.getNome() + ":");
        List<Itens> inventario = exército.getItens();

        if (inventario.isEmpty()){
            System.out.println("Nenhum item disponível para usar!");
            return;
        }

        for (int i = 0; i < inventario.size(); i++) {
            System.out.println((i + 1) + " - " + inventario.get(i).getClass().getSimpleName());
        }

        System.out.println("Escolha o número do item que deseja usar: ");
        int escolha;

        try {
            escolha = Integer.parseInt(scanner.nextLine()) - 1;
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida! Turno perdido.");
            return;
        }

        if (escolha < 0 || escolha >= inventario.size()){
            System.out.println("Escolha inválida! Turno perdido.");
            return;
        }

        Itens itemSelecionado = inventario.get(escolha);
        exército.usarItem(personagem, itemSelecionado);
        Thread.sleep(1000);
    }
}
