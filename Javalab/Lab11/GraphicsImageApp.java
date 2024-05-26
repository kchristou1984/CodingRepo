import javax.swing.JFrame;
import java.awt.*;
import java.io.*;
import javax.imageio.*;

public class GraphicsImageApp extends JFrame {
    static Image img;

    GraphicsImageApp(String atitle) {
        super(atitle);
    }

    public void paint(Graphics screen) {
        super.paint(screen);

        int iWidth = img.getWidth(this);
        int iHeight = img.getHeight(this);
        int xPos = 10;

        screen.drawImage(img, xPos, 10, iWidth / 4, iHeight / 4, this);

        xPos += (iWidth / 4) + 10;
        screen.drawImage(img, xPos, 10, this);
    }

    public static void main(String[] args) {
        try {
            img = ImageIO.read(new File("UTH.jpg"));
        } catch (IOException e) {
            e.printStackTrace(); // Print stack trace for better debugging
        }

        GraphicsImageApp frame = new GraphicsImageApp("Simple Graphics App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1400, 700);
        frame.setVisible(true);
    }
}
