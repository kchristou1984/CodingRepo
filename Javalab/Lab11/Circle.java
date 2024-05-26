import javax.swing.JFrame;
import java.awt.*;
import java.awt.geom.*;


public class Circle extends JFrame {
    Circle (String atitle){
        super(atitle);
    }

    public void paint(Graphics g){
        super.paint(g);
        Color c = new Color(100,5,63);
        g.setColor(c);
        g.drawOval(60,140,200,200);

    }

    public static void main(String[] args) {
        Circle frame = new Circle("Circle Draw");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        frame.setVisible(true);
    }
}
