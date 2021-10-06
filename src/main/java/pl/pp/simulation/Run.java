package pl.pp.simulation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.pp.simulation.config.SimulationConfig;
import pl.pp.simulation.ui.MyFrame;

import static pl.pp.simulation.utils.ProgramData.context;

public class Run {
    public static void main(String[] args) {

        //wywołanie myFrame() z SimulationConfig
        MyFrame myFrame = context.getBean("myFrame", MyFrame.class);

        myFrame.setVisible(true);

    }

}