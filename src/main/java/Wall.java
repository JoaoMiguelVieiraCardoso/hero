import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Wall extends Element {
    public Wall(int a, int b){
        position = new Position(a, b);
    }
    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#00ffff"));
        graphics.setBackgroundColor(TextColor.Factory.fromString("#00ffff"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.get_x(), position.get_y()), "W");
    }
}
