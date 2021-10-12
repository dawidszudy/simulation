package pl.pp.simulation.ui.panel;

import pl.pp.simulation.utils.ProgramData;

import javax.swing.*;
import java.awt.*;

public class ScrollPanel extends JScrollPane {

    public static JTextArea textArea;
    private int frameWidth;
    private int frameHeight;


    public ScrollPanel() {
        System.out.println("konstruktor - ScrollPanel");
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(frameWidth, frameHeight - ProgramData.maxHeight - 50));
    }

    public void setFrameWidth(int frameWidth) {
        this.frameWidth = frameWidth;
    }

    public void setFrameHeight(int frameHeight) {
        this.frameHeight = frameHeight;
    }
}