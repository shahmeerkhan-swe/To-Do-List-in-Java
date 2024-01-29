import javax.swing.*;

public class taskComponent extends JPanel {

    private JCheckBox checkBox;
    private JTextPane taskField;
    private JButton deleteButton;

    public JTextPane getTaskField() {
        return taskField;
    }
    // This panel updates the task component panel when deleting tasks
    private JPanel parentPanel;

    public taskComponent(JPanel parentPanel) {

        this.parentPanel = parentPanel;

        // task field stuff
        taskField = new JTextPane();
        taskField.setPreferredSize(commonConstants.TASKFIELD_SIZE);
        taskField.setContentType("text/html");

        // check box
        checkBox = new JCheckBox();
        checkBox.setPreferredSize(commonConstants.CHECKBOX_SIZE);

        // delete button
        deleteButton = new JButton("X");
        deleteButton.setPreferredSize(commonConstants.DELETE_BUTTON_SIZE);

        // adding to task component
        add(checkBox);
        add(taskField);
        add(deleteButton);

    }

}
