import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ToDoListGUI extends JFrame implements ActionListener {

    private JPanel taskPanel, taskComponentPanel;
    public ToDoListGUI() {
        super("To Do List Application");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(commonConstants.GUI_SIZE);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);


        addGUIComponent();


    }

    private void addGUIComponent() {
        // Banner text
        JLabel bannerText =  new JLabel("To Do List");
        bannerText.setFont(createFont("add-ons/LEMONMILK-LightItalic.otf", 36f));
        bannerText.setBounds((commonConstants.GUI_SIZE.width - bannerText.getPreferredSize().width)/2,
                15,
                commonConstants.BANNER_SIZE.width,
                commonConstants.BANNER_SIZE.height
        );

        //task panel
        taskPanel = new JPanel();
        taskComponentPanel = new JPanel();

        //task component Panel
        taskComponentPanel.setLayout(new BoxLayout(taskComponentPanel, BoxLayout.Y_AXIS));
        taskPanel.add(taskComponentPanel);

        // adding in scrolling
        JScrollPane scrollPane = new JScrollPane(taskPanel);
        scrollPane.setBounds(8, 70, commonConstants.TASK_PANEL_SIZE.width, commonConstants.TASK_PANEL_SIZE.height);
        scrollPane.setBorder(BorderFactory.createLoweredBevelBorder());
        scrollPane.setMaximumSize(commonConstants.TASK_PANEL_SIZE);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // changing the speed of scrolling
        JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
        verticalScrollBar.setUnitIncrement(20);

        // adding a button prompt
        JButton taskButton = new JButton("Add task");
        taskButton.setFont(createFont("add-ons/LEMONMILK-LightItalic.otf", 26f));
        taskButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        taskButton.setBounds(0, commonConstants.GUI_SIZE.height - 88,
                commonConstants.TASK_BUTTON_SIZE.width, commonConstants.TASK_BUTTON_SIZE.height);
        taskButton.addActionListener(this);

        // adding stuff to the frame
        this.getContentPane().add(bannerText);
        this.getContentPane().add(scrollPane);
        this.getContentPane().add(taskButton);


    }

    private Font createFont(String resource, float size) {
        // getting font file path...
        String filePath = getClass().getClassLoader().getResource(resource).getPath();

        if (filePath.contains("%20")) {
            filePath = getClass().getClassLoader().getResource(resource).getPath()
                    .replaceAll("%20", " ");
        }

        // creating font
        try {
            File customFontFile = new File(filePath);
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, customFontFile).deriveFont(size);
            return customFont;
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        return null;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
       // System.out.println(command);

        if (command.equalsIgnoreCase("Add task")) {
            // creating a task component
            taskComponent tComponent = new taskComponent(taskComponentPanel);
            taskComponentPanel.add(tComponent);

            // make the previous task appear disabled
            if (taskComponentPanel.getComponentCount() > 1) {
                taskComponent previousTask = (taskComponent) taskComponentPanel.getComponent(
                        taskComponentPanel.getComponentCount() - 2
                );
                previousTask.getTaskField().setBackground(null);
            }

            // requesting focus for task field
            tComponent.getTaskField().requestFocus();
            repaint();
            revalidate();
        }
    }
}
