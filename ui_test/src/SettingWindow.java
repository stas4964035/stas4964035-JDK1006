import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingWindow extends JFrame {
    private static final int WIDTH = 230;
    private static final int HEIGHT = 350;
    private int currentSize;
    private int currentSizeWin;

    JButton btnStart;

    private JPanel gameModePanel() {
        JLabel title = new JLabel("Выберите режим");
        JRadioButton radioPvP = new JRadioButton("PVP");
        JRadioButton radioPvE = new JRadioButton("PVE");
        JPanel result = new JPanel(new GridLayout(3, 1));
        ButtonGroup group = new ButtonGroup();
        group.add(radioPvP);
        group.add(radioPvE);
        result.add(title);
        result.add(radioPvP);
        result.add(radioPvE);
        return result;
    }

    private JPanel fieldSizePanel() {
        JPanel result = new JPanel(new GridLayout(3, 1));
        JLabel title = new JLabel("Выберите размер поля");
        JLabel text = new JLabel("Текущий: " + currentSizeWin);
        JSlider slider = new JSlider(1, 10, 5);
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                currentSize = slider.getValue();
                text.setText("Размер поля: " + currentSize);
            }


        });
        result.add(title);
        result.add(text);
        result.add(slider);
        return result;
    }

    private JPanel winLenghtPanel() {
        JPanel result = new JPanel(new GridLayout(3, 1));
        JLabel title = new JLabel("Длина победы");
        JLabel text = new JLabel("В ряд для победы: " + currentSizeWin);

        JSlider slider = new JSlider(1,  10, 5);
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                currentSizeWin = slider.getValue();
                text.setText("В ряд для победы: " + currentSizeWin);
            }


        });
        result.add(title);
        result.add(text);
        result.add(slider);
        return result;
    }

    public SettingWindow(GameWindow gameWindow) {
        btnStart = new JButton("Start new game");
        JPanel panel = new JPanel(new GridLayout(3, 1));
        panel.add(gameModePanel());
        panel.add(fieldSizePanel());
        panel.add(winLenghtPanel());
        setLocationRelativeTo(gameWindow);
        setSize(WIDTH, HEIGHT);

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                gameWindow.startNewGame(0, 3, 3, 3);
            }
        });
        add(panel);
        add(btnStart, BorderLayout.SOUTH);
    }
}
