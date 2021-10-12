package pl.pp.simulation.model;

import pl.pp.simulation.ui.charts.SimulationChart;
import pl.pp.simulation.utils.ParameterModel;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

import static pl.pp.simulation.utils.ProgramData.steps;

public class FoxesService {

    private final List<Fox> foxList = new LinkedList<>();
    private final List<Fox> newFoxList = new LinkedList<>();
    private final List<Fox> deathFoxList = new LinkedList<>();

    private SimulationChart simulationChart;
    private ParameterModel foxParameter;


    public void move() {
        newFoxList.clear();
        deathFoxList.clear();
        for (Fox fox : foxList) {
            fox.move();
        }
        foxList.addAll(newFoxList);
        foxList.removeAll(deathFoxList);
    }

    public void updateAmount() {
        int foxAmount = foxList.size();
        foxParameter.setValue(foxAmount);
        simulationChart.getFoxSeries().add(steps, foxAmount);
    }

    public void draw(Graphics2D graphics2D) {
        for (Fox grass : foxList) {
            grass.draw(graphics2D);
        }
    }

    public List<Fox> getDeathFoxList() {
        return deathFoxList;
    }

    public List<Fox> getNewFoxList() {
        return newFoxList;
    }

    public List<Fox> getFoxList() {
        return foxList;
    }

    public void setSimulationChart(SimulationChart simulationChart) {
        this.simulationChart = simulationChart;
    }

    public void setFoxParameter(ParameterModel foxParameter) {
        this.foxParameter = foxParameter;
    }
}