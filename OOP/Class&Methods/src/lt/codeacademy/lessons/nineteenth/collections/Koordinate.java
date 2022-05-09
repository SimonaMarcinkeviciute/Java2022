package lt.codeacademy.lessons.nineteenth.collections;


//Sukurti klasę Koordinate, kuri turi private kintamuosius x ir y bei konstruktoriųpriimanti du parametrus
// ir getterius/setterius•Sukurti sąrašą, kuris saugo Koordinate tipo elementus•Į sąrašą įdėti kelis elementus
// (pvz sarasas.add(new Koordinate(2, 5));)•Kordinatės: (1; 5), (5; 9), (4; 0), (0; 0), (9; 1), ...
// •Atspausdinti koordinates•Rasti kelinta sąraše yra (0; 0) koordinatė•Pakeisti šio (0; 0) o
// bjekto koordinates į (1; 1)•Atspausdinti koordinates
public class Koordinate {
    private int x;
    private int y;

    public Koordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return
                "(" + x + "; "+ y + ")" ;
    }
}
