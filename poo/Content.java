import java.awt.*;
import javax.swing.*;

public class Content extends JPanel {

    public Content() {
        JPanel pan = new JPanel();
        pan.setBackground(null);
        pan.setLayout(new BorderLayout(0, 16));
        pan.add(header(), BorderLayout.NORTH);
        // pan.add(new Title("0 objet selectionné", false), BorderLayout.SOUTH);

        setBackground(Styles.BG_COLOR);
        setLayout(new BorderLayout(0, 32));
        add(pan, BorderLayout.NORTH);

        add(new TableScroll(), BorderLayout.CENTER);
    }

    public JPanel header() {
        JPanel h = new JPanel();
        h.setPreferredSize(new Dimension(0, 64));
        h.setBackground(null);
        h.setLayout(new BorderLayout(32, 0));

        //Title t = new Title("Dashboard", false);
        Search s = new Search();

        h.add(new Title("Dashboard", false), BorderLayout.WEST);
        h.add(s, BorderLayout.CENTER);

        return h;
    }
}
