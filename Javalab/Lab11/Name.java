import javax.swing.JFrame;
import java.awt.*;
import java.util.*;

public class Name extends JFrame{

    String s;

    Name(String atitle, String s){
        super(atitle);
        this.s = s;
        // s = "Kostas";
    }

    public void paint(Graphics g){
        super.paint(g);
        g.drawRect(120,120,200,100);
        g.drawString(s,200,175);
    }

    public static void main(String[] args) {
        Scanner text = new Scanner(System.in);
        System.out.println("Enter Name");
        String s = text.nextLine();
        text.close();

        Name frame = new Name("Name App", s);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setVisible(true);
    }
}
