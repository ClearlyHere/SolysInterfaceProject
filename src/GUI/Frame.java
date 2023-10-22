package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Frame extends JFrame implements ActionListener {
    int count = 0;
    private final JFrame frame;
    private final JPanel panel;
    private final JButton button;
    private final JLabel label;
    private final Color backgroundColor = new Color(40,40,60);

    public Frame(){
        frame = new JFrame();

        panel = new JPanel();
        button = new JButton("Click");
        button.addActionListener(this);
        label = new JLabel("Number of clicks : 0");


        panel.setBorder(BorderFactory.createEmptyBorder(250, 250, 250, 250));
        panel.setBackground(backgroundColor);
        panel.setLayout(new GridLayout(0,1));
        panel.add(button);
        panel.add(label);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Solys");
        ImageIcon solysIcon = new ImageIcon(Objects.requireNonNull(Frame.class.getResource("/assets/Solys.png")));
        frame.setIconImage(solysIcon.getImage());

        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        count++;
        label.setText("Number of clicks : " + count);
    }
}
