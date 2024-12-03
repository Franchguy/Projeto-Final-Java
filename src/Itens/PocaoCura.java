package Itens;
import Personagens.Principais.Personagem;

public class PocaoCura implements Itens {
    private int cura;

    public PocaoCura() {
        this.cura = 20;
    }

    @Override
    public void usar(Personagem personagem) {
        personagem.setVida(personagem.getVida() + cura);
        System.out.println("Poção de cura usada!");
    }
}