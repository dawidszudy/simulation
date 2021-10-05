package pl.pp.simulation.ui.panel;

import pl.pp.simulation.ui.buttons.ChartButton;
import pl.pp.simulation.ui.buttons.ResetButton;
import pl.pp.simulation.ui.buttons.StartButton;
import pl.pp.simulation.ui.buttons.StopButton;
import pl.pp.simulation.utils.ParameterModel;
import pl.pp.simulation.utils.ProgramData;

import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel {
    
    public static ParameterModel grassParameter = new ParameterModel("Trawa", 100);
    public static ParameterModel hareParameter = new ParameterModel("Zające", 20);
    public static ParameterModel foxParameter = new ParameterModel("Lisy", 10);

    public static JLabel timeLabel;

    //usunięcie przekazanie instancji bo niepotrzebne już - tworzenie przez Bean
//    private static final ControlPanel controlPanel = new ControlPanel();
//
//    public static ControlPanel getInstance() {
//        return controlPanel;
//    }

    //zmiana na public bo potrzebne w SimulationConfig Do Bean-a
    public ControlPanel(StopButton stopButton, StartButton startButton, ResetButton resetButton) {
        System.out.println("konstruktor - ControlPanel");
        setLayout(new GridLayout(8, 1, 50, 50));

        setPreferredSize(new Dimension(ProgramData.frameWidth - ProgramData.maxWidth - 50, ProgramData.frameHeight));

        timeLabel = new JLabel("Czas: 0");

        //przeniesione do pól bo control panel jest zarządzany przez springa
//        grassParameter = new ParameterModel("Trawa", 100);
//        hareParameter = new ParameterModel("Zające", 20);
//        foxParameter = new ParameterModel("Lisy", 10);

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

}