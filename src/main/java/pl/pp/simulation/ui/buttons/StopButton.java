package pl.pp.simulation.ui.buttons;

import pl.pp.simulation.Step;

import javax.swing.*;

import static pl.pp.simulation.utils.ProgramData.*;

public class StopButton extends JButton {

    //usunięcie przekazanie instancji bo niepotrzebne już - tworzenie przez Bean
//    private static final StopButton STOP_BUTTON = new StopButton("Stop");
//
//    public static StopButton getInstance() {
//        return STOP_BUTTON;
//    }

    //TODO fix this
    //public StopButton(StartButton startButton, String text) {
    public StopButton(Step timer, String text) {
        super(text);
        System.out.println("konstruktor - Stop Button ");

        setEnabled(false);
        addActionListener(e -> {
            running = false;
            setEnabled(false);
            //TODO fix this
           // startButton.setEnabled(true);

            //context usunięty bo wstrzykujemy w bean
            //Step timer = context.getBean("timer", Step.class);
            timer.stop();
        });
    }
}