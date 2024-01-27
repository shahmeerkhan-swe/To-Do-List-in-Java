import javax.swing.*;

public class ToDoListGUI extends JFrame {

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
        scrollPane.setMaximumSize(commonConstants.TASK_PANEL_SIZE);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // adding a button prompt
        JButton taskButton = new JButton("Add Task");
        taskButton.setBounds(0, commonConstants.GUI_SIZE.height - 88,
                commonConstants.TASK_BUTTON_SIZE.width, commonConstants.TASK_BUTTON_SIZE.height);



        this.getContentPane().add(bannerText);
        this.getContentPane().add(scrollPane);
        this.getContentPane().add(taskButton);





    }








}
