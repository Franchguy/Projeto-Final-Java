package Itens;
import Personagens.Principais.Personagem;

public class PocaoForca extends Itens {
    private int forca;

    public PocaoForca() {
        this.forca = 10;
    }

    @Override
    public void usar(Personagem personagem) {
        personagem.setDano(personagem.getDano() + forca);
        System.out.println("Poção de força usada!");
    }
}