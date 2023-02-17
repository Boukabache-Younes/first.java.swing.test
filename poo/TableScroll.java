import java.awt.*;
import javax.swing.*;

public class TableScroll extends JPanel {

        static JTable tab;
        JScrollPane jScrollPane1;

        public TableScroll() {

                JPanel p = new JPanel();
                p.setLayout(new BorderLayout(0, 8));
                p.setBackground(null);
                p.setPreferredSize(new Dimension(0, 110));

        
                

                JPanel pa = new PanelAction();

                p.add(new Title("List de Produits", true), BorderLayout.NORTH);
                p.add(pa, BorderLayout.SOUTH);

                tab = creatTab();

                setLayout(new BorderLayout(0, 8));
                setBackground(null);

                this.jScrollPane1 = new JScrollPane();

                this.jScrollPane1.setViewportView(tab);

                add(jScrollPane1, BorderLayout.CENTER);
                add(p, BorderLayout.NORTH);
        }

        public JTable creatTab() {
                JTable tabl = new JTable();

                new DBcon().afficher(tabl);

                tabl.setRowHeight(40);
                tabl.setBackground(Styles.WHITE_COLOR);
                tabl.setForeground(Styles.TEXT_COLOR);
                tabl.setFont(Styles.LABLE_FONT);
                tabl.setSelectionBackground(Styles.GRAY_COLOR);

                tabl.getTableHeader().setBackground(Styles.TEXT_COLOR);
                tabl.getTableHeader().setForeground(Styles.WHITE_COLOR);
                tabl.getTableHeader().setFont(Styles.LABLE_FONT);

                return tabl;
        }
}
