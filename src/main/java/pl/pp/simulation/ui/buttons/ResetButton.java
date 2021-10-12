package pl.pp.simulation.ui.buttons;

import pl.pp.simulation.Step;
import pl.pp.simulation.model.FoxesService;
import pl.pp.simulation.model.GrassService;
import pl.pp.simulation.model.HaresService;
import pl.pp.simulation.ui.charts.SimulationChart;
import pl.pp.simulation.utils.ParameterModel;

import javax.annotation.PostConstruct;
import javax.swing.*;

import static pl.pp.simulation.ui.panel.ScrollPanel.textArea;
import static pl.pp.simulation.utils.ProgramData.*;

public class ResetButton extends JButton {

    private StopButton stopButton;
    private StartButton startButton;
    private Step timer;

    private GrassService grassService;
    private HaresService haresService;
    private FoxesService foxesService;

    private ParameterModel grassParameter;
    private ParameterModel hareParameter;
    private ParameterModel foxParameter;

    private SimulationChart simulationChart;

    private JLabel timeLabel;

    public ResetButton(String text) {
        super(text);
        System.out.println("konstruktor - Reset Button ");
    }

    @PostConstruct
    private void init() {
        addActionListener(e -> {
            running = false;
            started = false;

            textArea.setText("");
            simulationChart.clearSeries();

            timer.stop();

            clear();

            stopButton.setEnabled(false);
            startButton.setEnabled(true);

            setEditableParameters();

            steps = 0;
            timeLabel.setText("Czas: 0");

        });
    }

    private void setEditableParameters() {
        grassParameter.setEditable(true);
        hareParameter.setEditable(true);
        foxParameter.setEditable(true);
    }

    private void clear() {
        grassService.getGrassList().clear();
        haresService.getHareList().clear();
        foxesService.getFoxList().clear();
    }

    public void setStopButton(StopButton stopButton) {
        this.stopButton = stopButton;
    }

    public void setStartButton(StartButton startButton) {
        this.startButton = startButton;
    }

    public void setTimer(Step timer) {
        this.timer = timer;
    }

    public void setGrassService(GrassService grassService) {
        this.grassService = grassService;
    }

    public void setHaresService(HaresService haresService) {
        this.haresService = haresService;
    }

    public void setFoxesService(FoxesService foxesService) {
        this.foxesService = foxesService;
    }

    public void setSimulationChart(SimulationChart simulationChart) {
        this.simulationChart = simulationChart;
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
}