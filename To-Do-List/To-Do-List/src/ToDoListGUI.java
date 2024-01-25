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

        this.getContentPane().add(bannerText);
    }
}
