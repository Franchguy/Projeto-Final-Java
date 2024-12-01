package Personagens.Principais;

public abstract class Personagem {

    // VARIÁVEIS
    protected String nome;
    protected float vida;
    protected float dano;
    protected float protecao;
    protected boolean defendendo;

    // CONSTRUTOR
    public Personagem(String nome){
        this.nome = nome;
        vida = 10;
        this.defendendo = false;
    }

    // GETs e SETs
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return nome;
    }
    public void setVida(float vida){
        this.vida = vida;
    }
    public float getVida(){
        return vida;
    }
    public void setProtecao(float protecao){
        this.protecao = protecao;
    }
    public float getProtecao(){
        return protecao;
    }
    public void setDano(float dano){
        this.dano = dano;
    }
    public float getDano(){
        return dano;
    }

    // MÉTODOS ABSTRATOS
    public abstract void atacar(Personagem personagem);
    public abstract void receberDano(float dano);

    // MÉTODOS
    public boolean estaVivo(){
        return this.vida > 0;
    }

    public void entrarDefesa() {
        this.defendendo = true;
    }

    @Override
    public String toString(){
        return "Personagem: " + nome + "\nVida: " + vida + "\nDano: " + dano + "\nProteção: " 
        + protecao;
    }
}
