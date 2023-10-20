import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class JFrame1 {
    private JFrame frame1;



    public JFrame1() {
        this.frame1 = new JFrame("Frame Title");
        frame1.setSize(500,500);

        String[] labels = {"Length","Width","Height"};

        JPanel panel1 = new JPanel(new GridLayout(3,2, -50,10));
        panel1.setBounds(68,70,180,100);
        panel1.setBackground(Color.lightGray);
        frame1.add(panel1);

        JPanel panel2 = new JPanel(new GridLayout(1,3,0,0));
        panel2.setBounds(0,250,500,40);
        panel2.setBackground(Color.cyan);
        frame1.add(panel2);

        JTextField[] textFields = new JTextField[labels.length];
        for (int i= 0; i< labels.length;i++) {
            JLabel label1 = new JLabel(labels[i]);
            panel1.add(label1);
            JTextField textField = new JTextField("0.0",0);
            textFields[i] = textField;
            panel1.add(textField);
        }

        String[] buttonLabels = {"Calculate Volume","Calculate Surface Area","Display Box Detail"};
        JButton[] buttons = new JButton[buttonLabels.length];
        for (int i= 0; i < buttonLabels.length; i++) {
            JButton btn = new JButton(buttonLabels[i]);
            buttons[i] = btn;
            panel2.add(btn);
            JFrame paneFrame = new JFrame();
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println(e.getActionCommand());
                    Box boxData = new Box();
                        for (int i = 0; i < textFields.length; i++) {
                            String text = labels[i].toLowerCase();

                            double textFieldValue = Double.parseDouble(textFields[i].getText());
                            switch (text) {
                                case ("length"):
                                    boxData.setLength(textFieldValue);
                                    break;
                                case ("width"):
                                    boxData.setWidth(textFieldValue);
                                    break;
                                case ("height"):
                                    boxData.setHeight(textFieldValue);
                                    break;
                            }
                        }
                        String buttonPressed = e.getActionCommand().toLowerCase();
                        //Button msg
                        String msg = "";

                        switch (buttonPressed) {
                            case("calculate volume"):
                                msg = "Volume: "+ boxData.getVolume();
                                break;
                            case("calculate surface area"):
                                msg = "Surface Area: " + boxData.getSurfaceArea();
                                break;
                            case("display box detail"):
                                msg = "<html><u>Display Box Detail</u> <br>Length: "+ boxData.getLength()+"<br>Width: "+ boxData.getWidth()+"<br>Height: "+ boxData.getHeight()+"</html>";
                                break;

                        }
                        JOptionPane.showMessageDialog(paneFrame, msg);

                }
            });

        }





        frame1.setLayout(null);
        frame1.setVisible(true);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {

    }

}