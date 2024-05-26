import javax.swing.JFrame;
import java.awt.*;

public class SimpleApp extends JFrame{

    String s;

    SimpleApp(String atitle){
        super(atitle);
        s = "Hello App World!";
    }

    public void paint(Graphics g){
        super.paint(g);
        g.setColor(Color.RED);

        g.drawString(s,100,100);
    }

    public static void main(String[] args) {
        SimpleApp frame = new SimpleApp("Simple App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(300,300);
        frame.setVisible(true);
    }
}