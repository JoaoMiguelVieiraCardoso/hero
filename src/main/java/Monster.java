import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.Random;

public class Monster extends Element{
    public Monster(int a, int b){
        position = new Position(a, b);
    }
    public void draw(TextGraphics graphics){
        graphics.setForegroundColor(TextColor.Factory.fromString("#FF33FF"));
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.get_x(), position.get_y()), "V");
    }
    public Position move(Position pos){
        Random random = new Random();
        int a = random.nextInt(4);
        Position p = new Position(pos.get_x(), pos.get_y());
        if(a==0) p.set_x(pos.get_x() - 1);
        if(a == 1) p.set_x(pos.get_x() + 1);
        if(a == 2) p.set_y(pos.get_y() - 1);
        if(a == 3) p.set_y(pos.get_y() + 1);
        return p;
    }
}
