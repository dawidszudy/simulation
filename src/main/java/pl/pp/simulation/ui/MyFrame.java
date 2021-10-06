package pl.pp.simulation.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.pp.simulation.config.SimulationConfig;
import pl.pp.simulation.ui.panel.ControlPanel;
import pl.pp.simulation.ui.panel.ScrollPanel;
import pl.pp.simulation.utils.ProgramData;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    private ControlPanel controlPanel;
    private ScrollPanel scrollPanel;
    private SimulationComponent simulationComponent;

    public MyFrame() throws HeadlessException {

    }

    //@PostConstruct - adnotacja do wywołania metody po konstruktorze
    @PostConstruct
    private void init() {
        //przekopiowane z konstruktora bezargumentowego
        setTitle("Sumulacja drapieżnik - ofiara");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(ProgramData.frameWidth, ProgramData.frameHeight);
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

}