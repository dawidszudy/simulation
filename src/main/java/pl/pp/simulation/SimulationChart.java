package pl.pp.simulation;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;

import static pl.pp.simulation.utils.Components.simulationChart;

public class SimulationChart extends JFrame {

    private XYSeries hareSeries;
    private XYSeries grassSeries;
    private XYSeries foxSeries;

    public SimulationChart() {
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setTitle("Wykres");

        XYSeriesCollection dataset = getDataSet();
        JFreeChart freeChart = getChart(dataset);

        ChartPanel chartPanel = new ChartPanel(freeChart);

        add(chartPanel);
        pack();
    }

    private JFreeChart getChart(XYSeriesCollection dataset) {
        JFreeChart freeChart = ChartFactory.createXYLineChart(
                "Ilość organizmów w zależeności od czasu",
                "czas",
                "ilosć",
                dataset
        );
        return freeChart;
    }

    private XYSeriesCollection getDataSet() {
        XYSeriesCollection dataset = new XYSeriesCollection();
        grassSeries = new XYSeries("trawa");
        hareSeries = new XYSeries("zające");
        foxSeries = new XYSeries("lisy");

        dataset.addSeries(hareSeries);
        dataset.addSeries(grassSeries);
        dataset.addSeries(foxSeries);
        return dataset;
    }

    public XYSeries getHareSeries() {
        return hareSeries;
    }

    public XYSeries getGrassSeries() {
        return grassSeries;
    }

    public XYSeries getFoxSeries() {
        return foxSeries;
    }

    public void clearSeries() {
        hareSeries.clear();
        grassSeries.clear();
        foxSeries.clear();
    }

}