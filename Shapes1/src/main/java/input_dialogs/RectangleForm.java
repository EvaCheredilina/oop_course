package input_dialogs;

import javax.swing.*;
import java.awt.event.*;

public class RectangleForm extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton Exit;
    private JTextField fieldWidth;
    private JTextField fieldHeight;
    private JLabel Widht;
    private JLabel Height;

    public String width = null;
    public String height = null;

    public RectangleForm() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);


        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        Exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        setTitle("Enter sides ot the rectangle");
        pack();
        setVisible(true);
    }

    private void onOK() {
        if (!(fieldWidth.getText().isEmpty() || fieldHeight.getText().isEmpty())) {
            width = fieldWidth.getText();
            height = fieldHeight.getText();
            dispose();
        }
    }

    private void onCancel() {
        dispose();
    }

    public static void main(String[] args) {
        RectangleForm dialog = new RectangleForm();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

}
