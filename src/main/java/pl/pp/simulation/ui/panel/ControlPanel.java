package pl.pp.simulation.ui.panel;

import pl.pp.simulation.ui.buttons.ChartButton;
import pl.pp.simulation.ui.buttons.ResetButton;
import pl.pp.simulation.ui.buttons.StartButton;
import pl.pp.simulation.ui.buttons.StopButton;
import pl.pp.simulation.utils.ParameterModel;
import pl.pp.simulation.utils.ProgramData;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel {
    
    public static ParameterModel grassParameter = new ParameterModel("Trawa", 100);
    public static ParameterModel hareParameter = new ParameterModel("Zające", 20);
    public static ParameterModel foxParameter = new ParameterModel("Lisy", 10);

    public static JLabel timeLabel;

    private StopButton stopButton;
    private StartButton startButton;
    private ResetButton resetButton;

    public ControlPanel() {
        System.out.println("konstruktor - ControlPanel");
    }

    @PostConstruct
    private void init() {
        setLayout(new GridLayout(8, 1, 50, 50));

        setPreferredSize(new Dimension(ProgramData.frameWidth - ProgramData.maxWidth - 50, ProgramData.frameHeight));

        timeLabel = new JLabel("Czas: 0");

        add(timeLabel);
        add(grassParameter.getPanel());
        add(hareParameter.getPanel());
        add(foxParameter.getPanel());
        add(startButton);
        add(stopButton);
        add(resetButton);
        add(ChartButton.getInstance());
    }

    public static void setEditableParameters() {
        grassParameter.setEditable(true);
        hareParameter.setEditable(true);
        foxParameter.setEditable(true);
    }

    public static void setNotEditableParameters() {
        grassParameter.setEditable(false);
        hareParameter.setEditable(false);
        foxParameter.setEditable(false);
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

}