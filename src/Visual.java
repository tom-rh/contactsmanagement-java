import java.awt.*;
import java.awt.Font;

public class Visual extends Canvas {
    public Visual() {
        System.out.println("Constructor");
    }

    public void paint(Graphics g) {
        Font font = new Font("Serif", Font.PLAIN, 12);
        g.setFont(font);
        g.drawString("Hello",40,40);
        setBackground(Color.WHITE);
        g.fillRect(130, 30,100, 80);
        g.drawOval(30,130,50, 60);
        setForeground(Color.RED);
        g.fillOval(130,130,50, 60);
        g.drawArc(30, 200, 40,50,90,60);
        g.fillArc(30, 130, 40,50,180,40);
    }
}
