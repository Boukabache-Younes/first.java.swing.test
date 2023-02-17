import javax.swing.*;

public class Title extends JLabel {
    public Title(String str, boolean sub) {
        setText(str);
        setForeground(Styles.TEXT_COLOR);
        if (sub) {
            setFont(Styles.SUB_TITLE_FONT);
        } else {
            setFont(Styles.TITLE_FONT);
        }

    }
}
