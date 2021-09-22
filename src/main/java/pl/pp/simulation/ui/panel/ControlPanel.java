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
    
    public static ParameterModel grassParameter;
    public static ParameterModel hareParameter;
    public static ParameterModel foxParameter;

    public static JLabel timeLabel;

    //usunięcie przekazanie instancji bo niepotrzebne już
//    private static final ControlPanel controlPanel = new ControlPanel();
//
//    public static ControlPanel getInstance() {
//        return controlPanel;
//    }

    //zmiana na public bo potrzebne w SimulationConfig
    public ControlPanel() {
        System.out.println("konstruktor - ControlPanel");
        setLayout(new GridLayout(8, 1, 50, 50));

        setPreferredSize(new Dimension(ProgramData.frameWidth - ProgramData.maxWidth - 50, ProgramData.frameHeight));

        timeLabel = new JLabel("Czas: 0");

        grassParameter = new ParameterModel("Trawa", 100);
        hareParameter = new ParameterModel("Zające", 20);
        foxParameter = new ParameterModel("Lisy", 10);

        add(timeLabel);
        add(grassParameter.getPanel());
        add(hareParameter.getPanel());
        add(foxParameter.getPanel());
        add(StartButton.getInstance());
        add(StopButton.getInstance());
        add(ResetButton.getInstance());
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