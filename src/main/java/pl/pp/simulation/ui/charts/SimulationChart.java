package pl.pp.simulation.ui.charts;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.annotation.PostConstruct;
import javax.swing.*;

public class SimulationChart extends JFrame {

    private XYSeries hareSeries;
    private XYSeries grassSeries;
    private XYSeries foxSeries;

    private String titleChart;
    private String xTitle;
    private String yTitle;
    private String titleHareSeries;
    private String titleGrassSeries;
    private String titleFoxSeries;


    public SimulationChart() {
        System.out.println("konstruktor - SimulationChart");
    }

    @PostConstruct
    private void init() {
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setTitle("Wykres");

        XYSeriesCollection dataset = getDataSet();
        JFreeChart freeChart = getChart(dataset);

        ChartPanel chartPanel = new ChartPanel(freeChart);

        add(chartPanel);
        pack();
    }

    private JFreeChart getChart(XYSeriesCollection dataset) {

        return ChartFactory.createXYLineChart(
                titleChart,
                xTitle,
                yTitle,
                dataset
        );
    }

    private XYSeriesCollection getDataSet() {
        XYSeriesCollection dataset = new XYSeriesCollection();
        hareSeries = new XYSeries(titleHareSeries);
        grassSeries = new XYSeries(titleGrassSeries);
        foxSeries = new XYSeries(titleFoxSeries);

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
        grassSeries.clear();
        hareSeries.clear();
        foxSeries.clear();
    }

    public void setTitleChart(String titleChart) {
        this.titleChart = titleChart;
    }

    public void setxTitle(String xTitle) {
        this.xTitle = xTitle;
    }

    public void setyTitle(String yTitle) {
        this.yTitle = yTitle;
    }

    public void setTitleHareSeries(String titleHareSeries) {
        this.titleHareSeries = titleHareSeries;
    }

    public void setTitleGrassSeries(String titleGrassSeries) {
        this.titleGrassSeries = titleGrassSeries;
    }

    public void setTitleFoxSeries(String titleFoxSeries) {
        this.titleFoxSeries = titleFoxSeries;
    }
}