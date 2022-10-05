public class Position {
    private int x;
    private int y;
    public Position(int a, int b){
        x = a;
        y = b;
    }
    public void set_x(int a){
        x = a;
    }
    public void set_y(int b){
        y = b;
    }
    public int get_x(){
        return x;
    }
    public int get_y(){
        return y;
    }
}
