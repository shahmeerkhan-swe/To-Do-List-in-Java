import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class taskComponent extends JPanel implements ActionListener {

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
        checkBox.addActionListener(this);

        // delete button
        deleteButton = new JButton("X");
        deleteButton.setPreferredSize(commonConstants.DELETE_BUTTON_SIZE);

        // adding to task component
        add(checkBox);
        add(taskField);
        add(deleteButton);

    }

    @Override
    public void actionPerformed(ActionEvent e) {


        if (checkBox.isSelected()) {
            // Converts html tags to empty strings
            String taskText = taskField.getText().replaceAll("<[^>]*>", "");
            // Adding a strikethough
            taskField.setText("<html><s>" + taskText + "</s></html>");

        } else if (!checkBox.isSelected()) {
            String taskText = taskField.getText().replaceAll("<[^>]*>", "");

            taskField.setText(taskText);
        }

    }
}
