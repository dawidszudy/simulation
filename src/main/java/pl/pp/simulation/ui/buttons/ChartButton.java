package pl.pp.simulation.ui.buttons;

import javax.swing.*;

import static pl.pp.simulation.ui.charts.SimulationChart.simulationChart;

public class ChartButton extends JButton {

    //inicjalizacja
    private static final ChartButton CHART_BUTTON = new ChartButton("Wykres");

    //instancja jedna wzorzec singleton
    public static ChartButton getInstance() {
        return CHART_BUTTON;
    }

    //konstruktor
    private ChartButton(String text) {
        super(text);

        addActionListener(actionEvent -> simulationChart.setVisible(true));
    }
}