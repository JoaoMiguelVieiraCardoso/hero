import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Hero {
    private Position position;
    public Hero(int a, int b){
        position = new Position(a, b);
    }
    public int get_x(){
        return position.get_x();
    }
    public int get_y(){
        return position.get_y();
    }
    public void set_x(int a){
        position.set_x(a);
    }
    public void set_y(int b){
        position.set_y(b);
    }
    public void setPosition(Position pos){
        position.set_x(pos.get_x());
        position.set_y(pos.get_y());
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
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.get_x(), position.get_y()), "X");
    }
}