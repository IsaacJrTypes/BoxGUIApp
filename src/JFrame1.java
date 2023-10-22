/**
 * Description: The JFrame1 class creates a graphical user interface (GUI) with a JFrame containing
 * input fields for box dimensions (length, width, and height) and buttons to perform
 * calculations and display box details.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JFrame1 {

    /**
     * Constructs a new `JFrame1` object, which sets up the GUI components and functionality.
     */
    public JFrame1() {
        // create the main JFrame
        JFrame mainFrame = new JFrame("Box Calculator");
        mainFrame.setSize(500, 275);

        // create a main panel to hold input fields
        JPanel mainPanel = new JPanel(new GridLayout(3, 2, -50, 10));
        mainPanel.setBounds(155, 50, 180, 100);
        //mainPanel.setBackground(Color.lightGray);
        mainFrame.add(mainPanel);

        // create a dialogue panel to hold buttons
        JPanel dialoguePanel = new JPanel(new GridLayout(1, 3, 0, 0));
        dialoguePanel.setBounds(0, 175, 500, 40);
        //dialoguePanel.setBackground(Color.cyan);
        mainFrame.add(dialoguePanel);

        String[] labels = {"Length", "Width", "Height"};
        JTextField[] textFields = createTextFields(mainPanel, labels);
        String[] buttonLabels = {"Calculate Volume", "Calculate Surface Area", "Display Box Detail"};

        generateButtonFunctionality(dialoguePanel, textFields, labels, buttonLabels);

        mainFrame.setLayout(null);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * generates button functionality for the GUI. It creates buttons, adds them to the
     * dialogue panel, and defines action listeners for each button.  Also handles exceptions
     * via panel warning
     *
     * @param dialoguePanel the panel containing buttons
     * @param textFields an array of input text fields
     * @param textLabels an array of labels for the input fields
     * @param buttonLabels an array of labels for the buttons
     */
    private static void generateButtonFunctionality(JPanel dialoguePanel, JTextField[] textFields, String[] textLabels, String[] buttonLabels) {
        for (String buttonLabel : buttonLabels) {
            JButton btn = new JButton(buttonLabel);
            dialoguePanel.add(btn);
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Box boxData = new Box();
                    JFrame paneFrame = new JFrame();
                    try {
                        setBoxValues(textLabels, textFields, boxData);
                        String msg = getMsgFromTextField(e, boxData);
                        JOptionPane.showMessageDialog(paneFrame, msg);
                    } catch (IllegalArgumentException e1) {
                        JOptionPane.showMessageDialog(paneFrame, "Please Input Positive Numbers Only");
                    }
                }
            });
        }
    }

    /**
     * creates text fields with labels and adds them to a panel
     *
     * @param panel1  the panel where text fields and labels will be added
     * @param labels  an array of labels for the text fields
     * @return an array of created text fields
     */
    public static JTextField[] createTextFields(JPanel panel1, String[] labels) {
        JTextField[] textFields = new JTextField[labels.length];
        for (int i = 0; i < labels.length; i++) {
            JLabel label1 = new JLabel(labels[i]);
            panel1.add(label1);
            JTextField textField = new JTextField("0.0", 0);
            textFields[i] = textField;
            panel1.add(textField);
        }
        return textFields;
    }

    /**
     * Retrieves a message based on the button pressed and the box data
     *
     * @param e the ActionEvent listener
     * @param boxData the Box object containing box dimensions
     * @return a message string
     */
    private static String getMsgFromTextField(ActionEvent e, Box boxData) {
        String buttonPressed = e.getActionCommand().toLowerCase();
        //Button msg
        return switch (buttonPressed) {
            case ("calculate volume") -> "Volume: " + boxData.getVolume();
            case ("calculate surface area") -> "Surface Area: " + boxData.getSurfaceArea();
            case ("display box detail") ->
                    "<html><u>Display Box Detail</u> <br>Length: " + boxData.getLength() + "<br>Width: " + boxData.getWidth() + "<br>Height: " + boxData.getHeight() + "</html>";
            default -> "";
        };
    }

    /**
     * sets box values based on input text fields
     *
     * @param labels    an array of labels for the input fields
     * @param textFields an array of input text fields
     * @param boxData   the Box object to update with new values
     */
    private static void setBoxValues(String[] labels, JTextField[] textFields, Box boxData) {
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
    }
}