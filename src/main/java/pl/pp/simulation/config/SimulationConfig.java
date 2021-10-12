package pl.pp.simulation.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import pl.pp.simulation.Step;
import pl.pp.simulation.model.FoxesService;
import pl.pp.simulation.model.GrassService;
import pl.pp.simulation.model.HaresService;
import pl.pp.simulation.ui.MyFrame;
import pl.pp.simulation.ui.SimulationComponent;
import pl.pp.simulation.ui.buttons.ChartButton;
import pl.pp.simulation.ui.buttons.ResetButton;
import pl.pp.simulation.ui.buttons.StartButton;
import pl.pp.simulation.ui.buttons.StopButton;
import pl.pp.simulation.ui.charts.SimulationChart;
import pl.pp.simulation.ui.panel.ControlPanel;
import pl.pp.simulation.ui.panel.ScrollPanel;
import pl.pp.simulation.utils.ParameterModel;

import javax.swing.*;
import java.util.Objects;

@Configuration
@PropertySource("simulation.properties")
public class SimulationConfig {

    @Autowired
    private Environment environment;

    @Bean
    public StartButton startButton() {
        StartButton startButton = new StartButton(environment.getProperty("button.start.text"));
        startButton.setStopButton(stopButton());
        startButton.setTimer(timer());

        startButton.setGrassService(grassService());
        startButton.setHaresService(haresService());
        startButton.setFoxesService(foxesService());

        startButton.setGrassParameter(grassParameter());
        startButton.setFoxParameter(foxParameter());
        startButton.setHareParameter(hareParameter());
        return startButton;
    }

    @Bean
    public ChartButton chartButton() {
        ChartButton chartButton = new ChartButton(environment.getProperty("button.chart.text"));
        chartButton.setSimulationChart(simulationChart());
        return chartButton;
    }

    @Bean
    public StopButton stopButton() {
        StopButton stopButton = new StopButton(environment.getProperty("button.stop.text"));
        stopButton.setTimer(timer());
        return stopButton;
    }

    @Bean
    public JLabel timeLabel() {
        return new JLabel(environment.getProperty("time.label"));
    }

    @Bean
    public ResetButton resetButton() {
        ResetButton resetButton = new ResetButton(environment.getProperty("button.reset.text"));
        resetButton.setStartButton(startButton());
        resetButton.setStopButton(stopButton());
        resetButton.setTimer(timer());
        resetButton.setSimulationChart(simulationChart());

        resetButton.setGrassService(grassService());
        resetButton.setHaresService(haresService());
        resetButton.setFoxesService(foxesService());
        resetButton.setTimeLabel(timeLabel());

        resetButton.setGrassParameter(grassParameter());
        resetButton.setFoxParameter(foxParameter());
        resetButton.setHareParameter(hareParameter());
        return resetButton;
    }

    @Bean
    public GrassService grassService() {
        GrassService grassService = new GrassService();
        grassService.setSimulationChart(simulationChart());
        grassService.setGrassParameter(grassParameter());
        return grassService;
    }

    @Bean
    public HaresService haresService() {
        HaresService haresService = new HaresService();
        haresService.setSimulationChart(simulationChart());
        haresService.setHareParameter(hareParameter());
        return haresService;
    }

    @Bean
    public FoxesService foxesService() {
        FoxesService foxesService = new FoxesService();
        foxesService.setSimulationChart(simulationChart());
        foxesService.setFoxParameter(foxParameter());
        return foxesService;
    }

    @Bean
    public ParameterModel grassParameter() {
        String label = environment.getProperty("parameter.grass.label");
        int defaultValue = Integer.parseInt(Objects.requireNonNull(environment.getProperty("parameter.grass.value")));
        return new ParameterModel(label, defaultValue);
    }

    @Bean
    public ParameterModel hareParameter() {
        String label = environment.getProperty("parameter.hare.label");
        int defaultValue = Integer.parseInt(Objects.requireNonNull(environment.getProperty("parameter.hare.value")));
        return new ParameterModel(label, defaultValue);
    }

    @Bean
    public ParameterModel foxParameter() {
        String label = environment.getProperty("parameter.fox.label");
        int defaultValue = Integer.parseInt(Objects.requireNonNull(environment.getProperty("parameter.fox.value")));
        return new ParameterModel(label, defaultValue);
    }

    @Bean
    public Step timer() {
        Step step = new Step();
        step.setSimulationComponent(simulationComponent());
        step.setGrassService(grassService());
        step.setHaresService(haresService());
        step.setFoxesService(foxesService());
        step.setTimeLabel(timeLabel());
        return step;
    }

    @Bean
    public Integer frameWidth() {
        return Integer.valueOf(Objects.requireNonNull(environment.getProperty("frame.frameWidth")));
    }

    @Bean
    public Integer frameHeight() {
        return Integer.valueOf(Objects.requireNonNull(environment.getProperty("frame.frameHeight")));
    }

    @Bean
    public ControlPanel controlPanel() {
        ControlPanel controlPanel = new ControlPanel();
        controlPanel.setResetButton(resetButton());
        controlPanel.setStartButton(startButton());
        controlPanel.setStopButton(stopButton());
        controlPanel.setChartButton(chartButton());
        controlPanel.setTimeLabel(timeLabel());
        controlPanel.setFoxParameter(foxParameter());
        controlPanel.setGrassParameter(grassParameter());
        controlPanel.setHareParameter(hareParameter());

        controlPanel.setSimulationChart(simulationChart());
        controlPanel.setFrameWidth(frameWidth());
        controlPanel.setFrameHeight(frameHeight());
        return controlPanel;
    }

    @Bean
    public ScrollPanel scrollPanel() {
        ScrollPanel scrollPanel = new ScrollPanel();
        scrollPanel.setFrameWidth(frameWidth());
        scrollPanel.setFrameHeight(frameHeight());
        return scrollPanel;
    }

    @Bean
    public SimulationComponent simulationComponent() {
        SimulationComponent simulationComponent = new SimulationComponent();
        simulationComponent.setGrassService(grassService());
        simulationComponent.setHaresService(haresService());
        simulationComponent.setFoxesService(foxesService());
        return simulationComponent;
    }

    @Bean
    public String titleChart() {
        return environment.getProperty("chart.titleChart");
    }

    @Bean
    public String xTitle() {
        return environment.getProperty("chart.xTitle");
    }

    @Bean
    public String yTitle() {
        return environment.getProperty("chart.yTitle");
    }

    @Bean
    public String titleHareSeries() {
        return environment.getProperty("chart.titleHareSeries");
    }

    @Bean
    public String titleGrassSeries() {
        return environment.getProperty("chart.titleGrassSeries");
    }

    @Bean
    public String titleFoxSeries() {
        return environment.getProperty("chart.titleFoxSeries");
    }

    @Bean
    public SimulationChart simulationChart() {
        SimulationChart simulationChart = new SimulationChart();
        simulationChart.setTitleChart(titleChart());
        simulationChart.setxTitle(xTitle());
        simulationChart.setyTitle(yTitle());
        simulationChart.setTitleFoxSeries(titleFoxSeries());
        simulationChart.setTitleGrassSeries(titleGrassSeries());
        simulationChart.setTitleHareSeries(titleHareSeries());
        return simulationChart;
    }

    @Bean
    public MyFrame myFrame() {
        MyFrame myFrame = new MyFrame();
        myFrame.setSimulationComponent(simulationComponent());
        myFrame.setControlPanel(controlPanel());
        myFrame.setScrollPanel(scrollPanel());
        myFrame.setFrameWidth(frameWidth());
        myFrame.setFrameHeight(frameHeight());
        return myFrame;
    }

}
