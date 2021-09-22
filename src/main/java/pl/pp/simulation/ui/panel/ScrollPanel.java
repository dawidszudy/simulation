package pl.pp.simulation.ui.panel;

import pl.pp.simulation.utils.ProgramData;

import javax.swing.*;
import java.awt.*;

public class ScrollPanel extends JScrollPane {

    public static JTextArea textArea;

    //usunięcie przekazanie instancji bo niepotrzebne już
//    private static ScrollPanel scrollPanel = new ScrollPanel();
//
//    public static ScrollPanel getInstance() {
//        return scrollPanel;
//    }

    public ScrollPanel() {
        System.out.println("konstruktor - ScrollPanel");
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(ProgramData.frameWidth, ProgramData.frameHeight - ProgramData.maxHeight - 50));
    }
}