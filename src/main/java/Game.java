import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    private Screen screen;
    private Arena arena;
    public Game() {
        try{
            arena = new Arena(190, 50);
            TerminalSize terminalSize = new TerminalSize(190, 50);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();
            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null); // we don't need a cursor
            screen.startScreen(); // screens must be started
            screen.doResizeIfNecessary();
        }catch (IOException e){
            e.printStackTrace();
            }
    }

    private void draw() throws IOException{
        screen.clear();
        arena.draw(screen.newTextGraphics());
        screen.refresh();
    }
    private void processKey(KeyStroke key) {
        arena.processKey(key);
    }
    public void run()throws IOException{
        while(true) {
            draw();
            KeyStroke key = screen.readInput();
            if ((key.getKeyType() == KeyType.Character && key.getCharacter() == 'q') || (arena.drainEnergy() == true)){
                screen.close();
                break;
            }
            processKey(key);
        }
    }
}
