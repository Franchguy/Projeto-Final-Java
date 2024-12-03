package Itens;
import Personagens.Principais.Personagem;

public class PocaoDefesa implements Itens {
    private int defesa;

    public PocaoDefesa() {
        this.defesa = 10;
    }

    @Override
    public void usar(Personagem personagem) {
        personagem.setProtecao(personagem.getProtecao() + defesa);
        System.out.println("Poção de defesa usada!");
    }
}