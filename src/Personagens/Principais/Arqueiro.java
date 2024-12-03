package Personagens.Principais;

public class Arqueiro extends Personagem {
    public Arqueiro(String nome){
        super(nome);
        this.dano = 15;
    }
    
    @Override
    public void atacar(Personagem personagem){
        int numeroSorteado = (int) (Math.random() * 10) + 1;
        float danoCritico = dano * 0.3f;
        float danoFinal;
    
        if(numeroSorteado == 1 || numeroSorteado == 5 || numeroSorteado == 10){
            danoFinal = dano + danoCritico;
            System.out.println("Dano crítico!");
        } else {
            danoFinal = dano;
        }
    
        personagem.receberDano(danoFinal);
    }

    @Override
    public void receberDano(float dano){
        if (defendendo) {
            dano *= 0.2; 
            this.defendendo = false; 
        }
        else {
            float danoFinal = dano - this.protecao;
            this.vida = this.vida - danoFinal;
            if (this.vida <= 0) {
                this.vida = 0;
            }
        }
    }
}
