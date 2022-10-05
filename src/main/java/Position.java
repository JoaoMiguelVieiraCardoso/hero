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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        Position p = (Position) o;
        return this.x == p.get_x() && this.y == p.get_y();
    }
}
