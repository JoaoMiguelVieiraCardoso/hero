import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Hero extends Element{
    public Hero(int a, int b){
        position = new Position(a, b);
    }
    public Position moveUp() {
        return new Position(position.get_x(), position.get_y() - 1);
    }
    public Position moveDown() {
        return new Position(position.get_x(), position.get_y() + 1);
    }
    public Position moveLeft() {
        return new Position(position.get_x() - 1, position.get_y());
    }
    public Position moveRight() {
        return new Position(position.get_x() + 1, position.get_y());
    }
    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#00FF00"));
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.get_x(), position.get_y()), "X");
    }
}