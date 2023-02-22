import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Notification extends JFrame implements ActionListener {

    MyButton del ;
    JTextField input;

    public Notification() {
        setSize(new Dimension(600, 300));

        JPanel p = new JPanel();
        p.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;

        int ins = 8;
        gbc.insets = new Insets(ins, ins, ins, ins);

        gbc.gridheight = 1;

        

        

        del = new MyButton("Ok", 24, Styles.WARNING_COLOR, Styles.WHITE_COLOR);
        del.setPreferredSize(new Dimension(200, 64));
        del.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 6;
        p.add(del, gbc);

        setLayout(null);

        JLabel t = new Title("Notification", false);
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