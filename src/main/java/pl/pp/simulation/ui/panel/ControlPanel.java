package pl.pp.simulation.ui.panel;

import pl.pp.simulation.ui.buttons.ChartButton;
import pl.pp.simulation.ui.buttons.ResetButton;
import pl.pp.simulation.ui.buttons.StartButton;
import pl.pp.simulation.ui.buttons.StopButton;
import pl.pp.simulation.ui.charts.SimulationChart;
import pl.pp.simulation.utils.ParameterModel;
import pl.pp.simulation.utils.ProgramData;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel {

    private ParameterModel grassParameter;
    private ParameterModel hareParameter;
    private ParameterModel foxParameter;

    private JLabel timeLabel;

    private StopButton stopButton;
    private StartButton startButton;
    private ResetButton resetButton;
    private ChartButton chartButton;

    private SimulationChart simulationChart;

    private int frameWidth;
    private int frameHeight;


    public ControlPanel() {
        System.out.println("konstruktor - ControlPanel");
    }

    @PostConstruct
    private void init() {
        setLayout(new GridLayout(8, 1, 50, 50));

        setPreferredSize(new Dimension(frameWidth - ProgramData.maxWidth - 50, frameHeight));

        add(timeLabel);
        add(grassParameter.getPanel());
        add(hareParameter.getPanel());
        add(foxParameter.getPanel());
        add(startButton);
        add(stopButton);
        add(resetButton);
        add(chartButton);
    }

    public void setStopButton(StopButton stopButton) {
        this.stopButton = stopButton;
    }

    public void setStartButton(StartButton startButton) {
        this.startButton = startButton;
    }

    public void setResetButton(ResetButton resetButton) {
        this.resetButton = resetButton;
    }

    public void setSimulationChart(SimulationChart simulationChart) {
        this.simulationChart = simulationChart;
    }

    public void setChartButton(ChartButton chartButton) {
        this.chartButton = chartButton;
    }

    public void setTimeLabel(JLabel timeLabel) {
        this.timeLabel = timeLabel;
    }

    public void setGrassParameter(ParameterModel grassParameter) {
        this.grassParameter = grassParameter;
    }

    public void setHareParameter(ParameterModel hareParameter) {
        this.hareParameter = hareParameter;
    }

    public void setFoxParameter(ParameterModel foxParameter) {
        this.foxParameter = foxParameter;
    }

    public void setFrameWidth(int frameWidth) {
        this.frameWidth = frameWidth;
    }

    public void setFrameHeight(int frameHeight) {
        this.frameHeight = frameHeight;
    }
}