import javax.swing.*;

public class taskComponent extends JPanel {

    private JCheckBox checkBox;
    private JTextPane taskField;
    private JButton deleteButton;
    // This panel updates the task component panel when deleting tasks
    private JPanel mainPanel;

    public taskComponent(JPanel mainPanel) {
        this.mainPanel = mainPanel;

        // task field stuff
        taskField = new JTextPane();
        taskField.setPreferredSize(commonConstants.TASKFIELD_SIZE);
        taskField.setContentType("text/html");

        // check box
        checkBox = new JCheckBox();
        checkBox.setPreferredSize();


        // adding to task component
        add(taskField);
    }

}
