package pl.pp.simulation.ui.buttons;

import pl.pp.simulation.ui.charts.SimulationChart;

import javax.annotation.PostConstruct;
import javax.swing.*;

public class ChartButton extends JButton {

    private SimulationChart simulationChart;


    public ChartButton(String text) {
        super(text);
        System.out.println("konstruktor - Chart Button");
    }

    @PostConstruct
    private void init() {
        addActionListener(actionEvent -> simulationChart.setVisible(true));
    }

    public void setSimulationChart(SimulationChart simulationChart) {
        this.simulationChart = simulationChart;
    }

}