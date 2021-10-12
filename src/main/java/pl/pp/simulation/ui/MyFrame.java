package pl.pp.simulation.ui;

import pl.pp.simulation.ui.panel.ControlPanel;
import pl.pp.simulation.ui.panel.ScrollPanel;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    private ControlPanel controlPanel;
    private ScrollPanel scrollPanel;
    private SimulationComponent simulationComponent;

    private int frameWidth;
    private int frameHeight;


    public MyFrame() throws HeadlessException {
    }

    @PostConstruct
    private void init() {
        setTitle("Sumulacja drapieżnik - ofiara");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(frameWidth, frameHeight);
        setResizable(false);

        add(simulationComponent);
        add(controlPanel, BorderLayout.EAST);
        add(scrollPanel, BorderLayout.SOUTH);
    }

    public void setControlPanel(ControlPanel controlPanel) {
        this.controlPanel = controlPanel;
    }

    public void setScrollPanel(ScrollPanel scrollPanel) {
        this.scrollPanel = scrollPanel;
    }

    public void setSimulationComponent(SimulationComponent simulationComponent) {
        this.simulationComponent = simulationComponent;
    }

    public void setFrameWidth(int frameWidth) {
        this.frameWidth = frameWidth;
    }

    public void setFrameHeight(int frameHeight) {
        this.frameHeight = frameHeight;
    }
}