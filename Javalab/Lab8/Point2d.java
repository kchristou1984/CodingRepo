class Point2d {
    int xPos;
    int yPos;

    Point2d(int x, int y){
        xPos = x;
        yPos = y;
    }

    public String toString(){
        return "(" + xPos + "," + yPos + ")";
    }

    public static void main(String[] args) {
        Point2d point = new Point2d(4, 15);
        System.out.println(point);
    }
}

class Point3d extends Point2d{
    int zPos;

    Point3d(int x,int y, int z){
        super(x, y);
        zPos = z;
    }

    public String toString(){
        return "(" + xPos + "," + yPos + "," + zPos +  ")" ;
    }

    public static void main(String[] args) {
        Point3d point3 = new Point3d(5, 8, 12);
        System.out.println(point3);
    }
}
