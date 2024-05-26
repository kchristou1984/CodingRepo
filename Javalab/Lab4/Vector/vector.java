package Vector;

class Point {
    int x;
    int y;

    public Point(int xPos, int yPos){
        x = xPos;
        y = yPos;
    
    }

    int getX(){
        return x;
    }

    void setX(int xPos){
        x = xPos;
    }

    int getY(){
        return y;
    }

    void setY(int yPos){
        y = yPos;
    }
}

class Vector {

    Point p1 = new Point(3,5);
    Point p2 = new Point(5,8);

    public double lengthCalculate(){

        int dx = p2.getX() - p1.getX();
        int dy = p2.getY() - p1.getY();

        double length = Math.sqrt(dx*dx+dy*dy);
        return length;
    }

public static void main(String[] args) {
    Vector vector = new Vector();
    double length = vector.lengthCalculate();
    System.out.println("Length of the vector is: " + length);
    }    

}
