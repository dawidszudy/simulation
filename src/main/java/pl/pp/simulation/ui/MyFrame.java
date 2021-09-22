package pl.pp.simulation.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.pp.simulation.config.SimulationConfig;
import pl.pp.simulation.ui.panel.ControlPanel;
import pl.pp.simulation.ui.panel.ScrollPanel;
import pl.pp.simulation.utils.ProgramData;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    private ControlPanel controlPanel;
    private ScrollPanel scrollPanel;
    private SimulationComponent simulationComponent;

    public MyFrame(ControlPanel controlPanel, ScrollPanel scrollPanel, SimulationComponent simulationComponent) throws HeadlessException {
        this.controlPanel = controlPanel;
        this.scrollPanel = scrollPanel;
        this.simulationComponent = simulationComponent;

        //przekopiowane z konstruktora bezargumentowego
        setTitle("Sumulacja drapieżnik - ofiara");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(ProgramData.frameWidth, ProgramData.frameHeight);
        setResizable(false);

        add(simulationComponent);
        add(controlPanel, BorderLayout.EAST);
        add(scrollPanel, BorderLayout.SOUTH);
    }

    //niepotrzebne żeby nie dublować contextu który powoduje wywołanie 2x konstruktorów
//    public MyFrame() {
//        //stworzenie contextu i pobranie bean
//        ApplicationContext context = new AnnotationConfigApplicationContext(SimulationConfig.class);
//        ControlPanel controlPanel = context.getBean("controlPanel", ControlPanel.class);
//        ScrollPanel scrollPanel = context.getBean("scrollPanel", ScrollPanel.class);
//        SimulationComponent simulationComponent = context.getBean("simulationComponent", SimulationComponent.class);
//
//    }

}