public class App {
    public static void main(String[] args) throws Exception{
        System.out.println("Carregando...");
        Thread.sleep(3000);
        Jogo jogo = new Jogo();
        jogo.iniciar();
    }
}   
