import java.awt.*;

public class commonConstants {

    // tab configurations
    public static final Dimension GUI_SIZE  = new Dimension(540, 760);  // GUI Dimension sizes

    // banner configurations
    public static final Dimension BANNER_SIZE = new Dimension(GUI_SIZE.width, 50);

    // task panel configuration
    public static final Dimension TASK_PANEL_SIZE = new Dimension(GUI_SIZE.width - 30, GUI_SIZE.height - 175);

    // button configuration
    public static final Dimension TASK_BUTTON_SIZE = new Dimension(GUI_SIZE.width, 50);

    // taskComponent configurations
    public static final Dimension TASKFIELD_SIZE = new Dimension((int)(TASK_PANEL_SIZE.width * 0.80), 50);  
    public static final Dimension CHECKBOX_SIZE = new Dimension((int)(TASKFIELD_SIZE.width * 0.05), 50);






}
