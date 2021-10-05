package pl.pp.simulation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.pp.simulation.Step;
import pl.pp.simulation.ui.MyFrame;
import pl.pp.simulation.ui.SimulationComponent;
import pl.pp.simulation.ui.buttons.ResetButton;
import pl.pp.simulation.ui.buttons.StartButton;
import pl.pp.simulation.ui.buttons.StopButton;
import pl.pp.simulation.ui.panel.ControlPanel;
import pl.pp.simulation.ui.panel.ScrollPanel;

@Configuration
public class SimulationConfig {

    @Bean
    public StopButton stopButton() {
        //return new StopButton(startButton(), "Stop");
        return new StopButton(timer(), "Stop");
    }

    @Bean
    public StartButton startButton() {
        return new StartButton(stopButton(), timer(), "Start");
    }

    @Bean
    public ResetButton resetButton() {
        return new ResetButton(stopButton(), startButton(), timer(), "Reset");
    }

    @Bean
    public Step timer() {
        return new Step(simulationComponent());
    }

    @Bean
    public ControlPanel controlPanel() {
        return new ControlPanel(stopButton(), startButton(), resetButton());
    }

    @Bean
    public ScrollPanel scrollPanel() {
        return new ScrollPanel();
    }

    @Bean
    public SimulationComponent simulationComponent() {
        return  new SimulationComponent();
    }

    @Bean
    public MyFrame myFrame() {
        return new MyFrame(controlPanel(), scrollPanel(), simulationComponent());
    }
}
