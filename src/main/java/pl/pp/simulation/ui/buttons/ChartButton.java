package pl.pp.simulation.ui.buttons;

import pl.pp.simulation.ui.charts.SimulationChart;

import javax.annotation.PostConstruct;
import javax.swing.*;

//import static pl.pp.simulation.ui.charts.SimulationChart.simulationChart;

public class ChartButton extends JButton {

//    //inicjalizacja
//    private static final ChartButton CHART_BUTTON = new ChartButton("Wykres");
//
//    //instancja jedna wzorzec singleton
//    public static ChartButton getInstance() {
//        return CHART_BUTTON;
//    }

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