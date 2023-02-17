import java.awt.*;
import javax.swing.*;

public class MyButton extends JButton {

    int radius = 0;

    public MyButton(String lable, int r, Color bg, Color fg) {
        setText(lable);
        this.radius = r;

        setBackground(bg);
        setForeground(fg);
        setFont(Styles.BTN_FONT);

        setFocusable(false);
        setContentAreaFilled(false);
        setBorder(null);

    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;

        g2.fillRoundRect(-50, -50, getWidth() - 50, getHeight() - 50, radius, radius);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth() - 0, getHeight() - 0, radius, radius);
        super.paintComponent(grphcs);
    }
}