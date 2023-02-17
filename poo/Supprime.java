import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Supprime extends JFrame implements ActionListener {

    MyButton del;
    JTextField input;

    public Supprime() {
        setSize(new Dimension(600, 300));

        JPanel p = new JPanel();
        p.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;

        int ins = 8;
        gbc.insets = new Insets(ins, ins, ins, ins);

        gbc.gridheight = 1;

        JLabel lab = new JLabel("Code");
        lab.setForeground(Styles.TEXT_COLOR);
        lab.setFont(Styles.TEXT_FONT);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        p.add(lab, gbc);

        input = new JTextField();
        input.setPreferredSize(new Dimension(160, 40));
        input.setBackground(Styles.WHITE_COLOR);
        input.setForeground(Styles.TEXT_COLOR);
        input.setFont(new Font("Poppins", Font.PLAIN, 20));
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        p.add(input, gbc);

        del = new MyButton("Supprimer", 24, Styles.WARNING_COLOR, Styles.WHITE_COLOR);
        del.setPreferredSize(new Dimension(200, 64));
        del.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 6;
        p.add(del, gbc);

        setLayout(null);

        JLabel t = new Title("Supprimer", false);
        t.setBounds(16, 8, 600, 60);
        add(t);

        p.setBounds(20, 80, 560, 180);
        add(p);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == del) {
            if (input.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter code");
            } else {
                if (!new DBcon().codeExist(input.getText())) {
                    JOptionPane.showMessageDialog(null, "Code does not exist");
                } else {
                    new DBcon().supprime(input.getText());
                    new DBcon().afficher(TableScroll.tab);
                    dispose();
                    JOptionPane.showMessageDialog(null, "product deleted secsessfully");
                }
            }
        }
    }
}
