import java.util.ArrayList;
import java.util.List;
import Personagens.Principais.Personagem;
import Itens.*;

public class Exército {
    private String nome;
    private Personagem lider;
    private List<Personagem> tropas;
    private List<Itens> itens;

    public Exército(String nome, Personagem lider) {
        this.nome = nome;
        this.lider = lider;
        lider.setVida(lider.getVida() + 10);
        lider.setDano(lider.getDano() + 10);

        this.tropas = new ArrayList<>();
        this.tropas.add(lider);

        this.itens = new ArrayList<>();
        inicializarItens();
    }

    public void adicionarPersonagem(Personagem personagem) {
        tropas.add(personagem);
    }

    public void atacar(Personagem atacante, Personagem alvo) {
        if (atacante.estaVivo() && alvo.estaVivo()) {
            atacante.atacar(alvo);
            System.out.println(atacante.getNome() + " atacou " + alvo.getNome());
        } else {
            System.out.println("Ataque inválido! Atacante ou alvo está morto.");
        }
    }

    public void usarItem(Personagem personagem, Itens item) {
        if (itens.contains(item)) {
            item.usar(personagem);
            itens.remove(item);
            System.out.println(personagem.getNome() + " usou " + item.getClass());
        } else {
            System.out.println("Item não disponível!");
        }
    }
    

    public boolean estaDerrotado() {
        return tropas.stream().noneMatch(Personagem::estaVivo);
    }

    public String getNome(){
        return this.nome;
    }

    public void exibirEstado() {
        System.out.println("Exército: " + nome);
        System.out.println("Itens disponíveis: " + itens.size());
        System.out.println("Tropas:");
        for (Personagem p : tropas) {
            System.out.println("- " + p.getNome() + " (Vida: " + p.getVida() + ")");
        }
    }

    public void inicializarItens() {
        for (int i = 0; i < 2; i++) {
            itens.add(new PocaoCura());
            itens.add(new PocaoDefesa());
            itens.add(new PocaoForca());
        }
    }

    public List<Personagem> getPersonagens() {
        return this.tropas;
    }

    public List<Itens> getItens(){
        return this.itens;
    }
}
