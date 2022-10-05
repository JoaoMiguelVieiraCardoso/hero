import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Element {
    public Position position;
    public Position getPosition(){
        return position;
    }
    public void setPosition(Position pos){
        position.set_x(pos.get_x());
        position.set_y(pos.get_y());
    }
}
