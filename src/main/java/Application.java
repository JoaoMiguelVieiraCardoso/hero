
import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        Hero hero = new Hero(10, 10);
        try {
            game.run();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
