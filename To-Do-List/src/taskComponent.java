import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

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
        taskField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        taskField.setPreferredSize(commonConstants.TASKFIELD_SIZE);
        taskField.setContentType("text/html");
        taskField.addFocusListener(new FocusListener() {

            @Override
            // Indicates which task field is currently selected
            public void focusGained(FocusEvent e) {
                taskField.setBackground(Color.WHITE);

            }

            @Override
            public void focusLost(FocusEvent e) {
                taskField.setBackground(null);
            }
        });

        // check box
        checkBox = new JCheckBox();
        checkBox.setPreferredSize(commonConstants.CHECKBOX_SIZE);
        checkBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        checkBox.addActionListener(this);

        // delete button
        deleteButton = new JButton("X");
        deleteButton.setPreferredSize(commonConstants.DELETE_BUTTON_SIZE);
        deleteButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        deleteButton.addActionListener(this);

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

        if (e.getActionCommand().equalsIgnoreCase("X")) {
            // deletes the task box from parent panel
            parentPanel.remove(this);
            parentPanel.repaint();
            parentPanel.revalidate();

        }

    }
}
