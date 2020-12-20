package input_dialogs;

import javax.swing.*;
import java.awt.event.*;

public class TriangleForm extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField fieldSide1;
    private JTextField fieldSide2;
    private JTextField fieldSide3;

    public String sideA = null;
    public String sideB = null;
    public String sideC = null;

    public TriangleForm() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
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

        setTitle("Enter side ot the triangle");
        pack();
        setVisible(true);
    }

    private void onOK() {
        if (!(fieldSide1.getText().isEmpty() || fieldSide2.getText().isEmpty() || fieldSide3.getText().isEmpty())) {
            sideA = fieldSide1.getText();
            sideB = fieldSide2.getText();
            sideC = fieldSide3.getText();
            dispose();
        }
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        TriangleForm dialog = new TriangleForm();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
