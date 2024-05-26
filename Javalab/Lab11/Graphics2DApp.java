import javax.swing.JFrame;
import java.awt.*;
import java.awt.geom.*;

public class Graphics2DApp extends JFrame {

    Graphics2DApp(String atitle) {
        super(atitle);
    }

    public void paint(Graphics screen) {
        super.paint(screen);

        Graphics2D screen2D = (Graphics2D) screen;
	       screen2D.setColor(Color.green);


        BasicStroke pen = new BasicStroke(20,BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND);
        screen2D.setStroke(pen);

        Ellipse2D.Float ee = new Ellipse2D.Float(50, 50, 200, 200);
        Ellipse2D.Float eb = new Ellipse2D.Float(200, 50, 200, 200);

        screen2D.draw(ee);
        screen2D.draw(eb);
    }    

    public static void main(String[] args) {
        Graphics2DApp frame = new Graphics2DApp("Simple Graphics App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(1800, 1800);
        frame.setVisible(true);
    }
}