import Figures.*;
import input_dialogs.CircleForm;
import input_dialogs.RectangleForm;
import input_dialogs.SquareForm;
import input_dialogs.TriangleForm;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class MainForm extends JFrame {
    private JList shapesJList;
    private JPanel panel1;
    private JButton moveUpButton;
    private JButton moveDownButton;
    private JButton removeButton;
    private JButton createTriangleButton;
    private JButton createRectangleButton;
    private JButton createCircleButton;
    private JButton createSquareButton;
    private JButton exitButton;
    private ArrayList<String> stringArrayList = new ArrayList<>();
    private List<Shape> shapeList = new ArrayList<>();

    public MainForm() {
        setListeners();
        setTitle("Figures");
        setContentPane(panel1);
        pack();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        addWindowListener(new WindowListener() {
            @Override
            public void windowClosing(WindowEvent e) {
                writeShapesToFile();
                dispose();
            }

            @Override
            public void windowOpened(WindowEvent e) {
                readShapesFromFile();
            }

            @Override
            public void windowClosed(WindowEvent e) { }

            @Override
            public void windowIconified(WindowEvent e) { }

            @Override
            public void windowDeiconified(WindowEvent e) { }

            @Override
            public void windowActivated(WindowEvent e) { }

            @Override
            public void windowDeactivated(WindowEvent e) { }
        });
    }

    private void writeShapesToFile() {
        FileManager.write(shapeList);
    }

    private void readShapesFromFile() {
        shapeList.addAll((List<Shape>) FileManager.read());

        for (Shape shape : shapeList)
            this.stringArrayList.add(shape.toString());

        shapesJList.setListData(stringArrayList.toArray(new String[0]));
    }

    private void setListeners(){
        moveUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int selectedIndex = shapesJList.getSelectedIndex();
                if (selectedIndex != -1) {
                    if (selectedIndex != 0) {
                        Collections.swap(stringArrayList, selectedIndex, selectedIndex - 1);

                        Collections.swap(shapeList, selectedIndex, selectedIndex - 1);

                        shapesJList.setListData(stringArrayList.toArray(new String[0]));
                        shapesJList.setSelectedIndex(selectedIndex - 1);
                    }
                }
            }
        });


        moveDownButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    int selectedIndex = shapesJList.getSelectedIndex();
                    if (selectedIndex != -1) {
                        if (selectedIndex != stringArrayList.size() - 1) {
                            Collections.swap(stringArrayList, selectedIndex, selectedIndex + 1);

                            Collections.swap(shapeList, selectedIndex, selectedIndex + 1);

                            shapesJList.setListData(stringArrayList.toArray(new String[0]));
                            shapesJList.setSelectedIndex(selectedIndex + 1);
                        }
                    }
                }
        });

        removeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    int selectedIndex = shapesJList.getSelectedIndex();
                    if (selectedIndex != -1) {
                        stringArrayList.remove(selectedIndex);
                        shapeList.remove(selectedIndex);
                        shapesJList.setListData(stringArrayList.toArray(new String[0]));
                    }
                }
        });

        createTriangleButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    TriangleForm form = new TriangleForm();

                    if (form.sideA == null || form.sideB == null || form.sideC == null) return;
                    else {
                        String sideAStr = form.sideA;
                        String sideBStr = form.sideB;
                        String sideCStr = form.sideC;

                        try {
                            shapeList.add(new Triangle(
                                    Double.parseDouble(sideAStr),
                                    Double.parseDouble(sideBStr),
                                    Double.parseDouble(sideCStr)));
                            stringArrayList.add(shapeList.get(shapeList.size() - 1).toString());
                            shapesJList.setListData(stringArrayList.toArray(new String[0]));
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage());
                        }
                    }
                }
        });

        createRectangleButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    RectangleForm form = new RectangleForm();

                    if (form.height == null || form.width == null) return;
                    else {
                        String widthStr = form.width;
                        String heightStr = form.height;

                        try {
                            shapeList.add(new Rectangle(
                                    Double.parseDouble(widthStr),
                                    Double.parseDouble(heightStr)));
                            stringArrayList.add(shapeList.get(shapeList.size() - 1).toString());
                            shapesJList.setListData(stringArrayList.toArray(new String[0]));
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage());
                        }
                    }
                }
        });

        createCircleButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    CircleForm form = new CircleForm();

                    if (form.radius == null) return;
                    else {
                        String radiusStr = form.radius;

                        try {
                            shapeList.add(new Circle(
                                    Double.parseDouble(radiusStr)));
                            stringArrayList.add(shapeList.get(shapeList.size() - 1).toString());
                            shapesJList.setListData(stringArrayList.toArray(new String[0]));
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage());
                        }
                    }
                }
        });

        createSquareButton.addActionListener(new

            ActionListener() {
                @Override
                public void actionPerformed (ActionEvent actionEvent){
                    SquareForm form = new SquareForm();

                    if (form.side == null) return;
                    else {
                        String sideStr = form.side;

                        try {
                            shapeList.add(new Square(
                                    Double.parseDouble(sideStr)));
                            stringArrayList.add(shapeList.get(shapeList.size() - 1).toString());
                            shapesJList.setListData(stringArrayList.toArray(new String[0]));
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage());/////////////////////
                        }

                    }
                }
            });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                writeShapesToFile();
                dispose();
            }
        });
    }
}
