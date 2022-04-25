package pl.pp.simulation.ui.panel;

import pl.pp.simulation.utils.ProgramData;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

public class ScrollPanel {

    public JTextArea textArea = new JTextArea();
    private int frameWidth;
    private int frameHeight;
    //composition instead of inheritance
    private final JScrollPane scrollPane;

    public ScrollPanel() {
        scrollPane = new JScrollPane(textArea);
        System.out.println("konstruktor - ScrollPanel");
    }

    @PostConstruct
    public void init() {
        textArea.setEditable(false);
        scrollPane.setPreferredSize(new Dimension(frameWidth, frameHeight - ProgramData.maxHeight - 50));
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void addText(String text) {
        textArea.append(text);
    }

    public void setFrameWidth(int frameWidth) {
        this.frameWidth = frameWidth;
    }

    public void setFrameHeight(int frameHeight) {
        this.frameHeight = frameHeight;
    }

    public JTextArea getTextArea() {
        return textArea;
    }
}