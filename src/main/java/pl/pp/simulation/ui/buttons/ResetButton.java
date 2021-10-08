package pl.pp.simulation.ui.buttons;

import pl.pp.simulation.Step;
import pl.pp.simulation.model.FoxesService;
import pl.pp.simulation.model.GrassService;
import pl.pp.simulation.model.HaresService;
import pl.pp.simulation.ui.panel.ControlPanel;

import javax.annotation.PostConstruct;
import javax.swing.*;

import static pl.pp.simulation.ui.charts.SimulationChart.simulationChart;
import static pl.pp.simulation.ui.panel.ScrollPanel.textArea;
import static pl.pp.simulation.utils.ProgramData.*;

public class ResetButton extends JButton {

    private StopButton stopButton;
    private StartButton startButton;
    private Step timer;

    private GrassService grassService;
    private HaresService haresService;
    private FoxesService foxesService;

    public ResetButton(String text) {
        super(text);
        System.out.println("konstruktor - Reset Button ");
    }

    //metoda inicjalizowana po konstruktorze obiektu
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

            ControlPanel.setEditableParameters();

            steps = 0;
            ControlPanel.timeLabel.setText("Czas: 0");

        });
    }

    public void clear() {
        grassService.getGrassList().clear();
        haresService.getHareList().clear();
        foxesService.getFoxList().clear();
    }

    //settery do ustawiania na obiekcie w SimulationConfig - @Bean
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

}