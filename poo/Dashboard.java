import java.awt.*;
import javax.swing.*;

public class Dashboard extends JPanel{

    public Dashboard() {
        setLayout(new BorderLayout());

        JPanel panel = new Content();

        JPanel pw = new JPanel();
        JPanel pe = new JPanel();
        JPanel pn = new JPanel();
        JPanel ps = new JPanel();

        pw.setPreferredSize(new Dimension(32, 0));
        pe.setPreferredSize(new Dimension(32, 0));
        pn.setPreferredSize(new Dimension(0, 32));
        ps.setPreferredSize(new Dimension(0, 32));

        pw.setBackground(Styles.BG_COLOR);
        pe.setBackground(Styles.BG_COLOR);
        pn.setBackground(Styles.BG_COLOR);
        ps.setBackground(Styles.BG_COLOR);

        add(pw, BorderLayout.WEST);
        add(pe, BorderLayout.EAST);
        add(pn, BorderLayout.NORTH);
        add(ps, BorderLayout.SOUTH);

        add(panel, BorderLayout.CENTER);
        // setSize(new Dimension(1920,1080));
    }
}