import javax.swing.JFrame;
import java.awt.*;
public class SimpleGraphicsApp extends JFrame{
    SimpleGraphicsApp(String atitle){
        super(atitle);
    }

    public void paint(Graphics g){
        super.paint(g);
        Color c = new Color(100,0,100);
        g.setColor(c);
        g.drawLine(30, 140, 100, 200);
        g.setColor(Color.RED);
        g.drawRect(60, 130, 80, 100);
        g.setColor(Color.GREEN);
        g.drawOval(60,130,80,200);
        g.fillRect(90,120,60,50);
        g.fillOval(70,120,200,20);
        g.drawArc(10,120,30,40,0,180);

        Font f = new Font("Times new Roman", Font.BOLD,30);
        g.setFont(f);

        g.drawString("test string",10,20);

        int[] px = {20,50,70,30,10};
        int[] py = {200,220,240,130,107};

        Polygon p = new Polygon(px,py,px.length);
        g.drawPolygon(p);
    }

    public static void main(String[] args) {
        SimpleGraphicsApp frame = new SimpleGraphicsApp("Simple App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setVisible(true);
    }
}