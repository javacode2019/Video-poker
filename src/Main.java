public class Main {
    public static void main(String[] args) {
        Game game;
        if (args.length < 1) {
            game = new Game();
        } else {
            game = new Game(args);
        }
        game.play();
    }
}
