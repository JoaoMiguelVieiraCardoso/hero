import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {
    private int width;
    private int height;
    private Hero hero;
    private List<Wall> walls;
    private List<Coin> coins;
    private List<Monster> monsters;
    public Arena(int a, int b){
        width = a;
        height = b;
        hero = new Hero(10, 10);
        this.walls = createWalls();
        this.coins = createCoins();
        this.monsters = createMonsters();
    }
    public void processKey(KeyStroke key) {
        if (key.getKeyType() == KeyType.ArrowUp) moveHero(hero.moveUp());
        if (key.getKeyType() == KeyType.ArrowDown) moveHero(hero.moveDown());
        if (key.getKeyType() == KeyType.ArrowLeft) moveHero(hero.moveLeft());
        if (key.getKeyType() == KeyType.ArrowRight) moveHero(hero.moveRight());
    }
    public void draw(TextGraphics graphics){
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        hero.draw(graphics);
        for(Wall wall : walls){
            wall.draw(graphics);
        }
        for(Coin coin : coins){
            coin.draw(graphics);
        }
        for(Monster monster : monsters){
            monster.draw(graphics);
        }
    }
    public void moveHero(Position position){
        if(canHeroMove(position)){
            hero.setPosition(position);
            moveMonsters();
            retrieveCoins(position);

        }
    }
    public boolean canHeroMove(Position position){
        for (Wall wall : walls){
            if(wall.getPosition().equals(position)){
                return false;
            }
        }
        return true;
    }
    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();
        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }
        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }
        return walls;
    }
    private List<Coin> createCoins() {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            coins.add(new Coin(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1));
        return coins;
    }
    public void retrieveCoins(Position position){
        for (Coin coin : coins){
            if(coin.getPosition().equals(position)){
                coins.remove(coin);
                break;
            }
        }
    }
    private List<Monster> createMonsters() {
        Random random = new Random();
        ArrayList<Monster> monsters = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            monsters.add(new Monster(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1));
        return monsters;
    }
    public boolean canMonsterMove(Position position){
        for (Wall wall : walls){
            if(wall.getPosition().equals(position)){
                return false;
            }
            for(Monster monster : monsters){
                if(monster.getPosition().equals(position)){
                    return false;
                }
            }
        }
        return true;
    }
    public void moveMonsters(){
        boolean flag;
        for(Monster monster : monsters){
            flag = true;
            while(flag) {
                Position pos;
                pos = monster.move(monster.getPosition());
                if (canMonsterMove(pos)) {
                    monster.setPosition(pos);
                    flag = false;
                }
            }
        }
    }
}
