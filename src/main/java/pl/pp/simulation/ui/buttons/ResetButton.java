package pl.pp.simulation.ui.buttons;

import pl.pp.simulation.Step;
import pl.pp.simulation.model.Foxes;
import pl.pp.simulation.model.GrassUtils;
import pl.pp.simulation.model.Hares;
import pl.pp.simulation.ui.MyFrame;
import pl.pp.simulation.ui.panel.ControlPanel;

import javax.swing.*;

import static pl.pp.simulation.ui.charts.SimulationChart.simulationChart;
import static pl.pp.simulation.ui.panel.ScrollPanel.textArea;
import static pl.pp.simulation.utils.ProgramData.*;

public class ResetButton extends JButton {

    //usunięcie przekazanie instancji bo niepotrzebne już - tworzenie przez Bean
//    private static final ResetButton RESET_BUTTON = new ResetButton("Reset");
//
//    public static ResetButton getInstance() {
//        return RESET_BUTTON;
//    }

    public ResetButton(StopButton stopButton, StartButton startButton, Step timer, String text) {
        super(text);
        System.out.println("konstruktor - Reset Button ");

        addActionListener(e -> {
            running = false;
            started = false;

            textArea.setText("");

            simulationChart.clearSeries();

            //context usunięty bo wstrzykujemy w bean
            //Step timer = context.getBean("timer", Step.class);
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
        GrassUtils.grassList.clear();
        Hares.hareList.clear();
        Foxes.foxList.clear();

    }
}