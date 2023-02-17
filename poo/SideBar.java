import java.awt.*;
import javax.swing.*;

public class SideBar extends JPanel{
    public SideBar(){
        setLayout(new BorderLayout());//impooooortantttt

        setPreferredSize(new Dimension(280, 0));
        setBackground(Styles.BLUE_COLOR);

        JPanel panel = new Menu();

        JPanel pw = new JPanel();
        JPanel pe = new JPanel();
        JPanel pn = new JPanel();
        JPanel ps = new JPanel();

        pw.setPreferredSize(new Dimension(32, 0));
        pe.setPreferredSize(new Dimension(32, 0));
        pn.setPreferredSize(new Dimension(0, 32));
        ps.setPreferredSize(new Dimension(0, 32));

        pw.setBackground(Styles.BLUE_COLOR);
        pe.setBackground(Styles.BLUE_COLOR);
        pn.setBackground(null);
        ps.setBackground(null);

        add(pw, BorderLayout.WEST);
        add(pe, BorderLayout.EAST);
        add(pn, BorderLayout.NORTH);
        add(ps, BorderLayout.SOUTH);

        add(panel, BorderLayout.CENTER);
    }
}
