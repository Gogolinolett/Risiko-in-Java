package gui;

import classes.Player;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class PlayerSelection extends JFrame {

    private JButton remAll;
    private JButton pAdd;
    private int pCounter = 0;
    private JComboBox<String> pColor;
    private JTextField pName;
    private LinkedList<Player> players = new LinkedList<>();
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private LinkedList<JLabel> labels;
    private JButton fertigButton;


    public PlayerSelection() throws IOException {
        initComponents();
        labels = new LinkedList<>();
        labels.add(label1);
        labels.add(label2);
        labels.add(label3);
        labels.add(label4);
        labels.add(label5);
        labels.add(label6);
    }

    private void initComponents() throws IOException {
        setMaximizedBounds(new Rectangle(0, 0, 400, 640));
        setMinimumSize(new Dimension(267, 430));
        setResizable(false);
        setIconImage(ImageIO.read(new File("src\\resources\\other\\star.png")));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        Container contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        ((GridBagLayout) contentPane.getLayout()).columnWidths = new int[]{0, 0};
        ((GridBagLayout) contentPane.getLayout()).rowHeights = new int[]{0, 0, 0};
        ((GridBagLayout) contentPane.getLayout()).columnWeights = new double[]{1.0, 1.0E-4};
        ((GridBagLayout) contentPane.getLayout()).rowWeights = new double[]{1.0, 0.0, 1.0E-4};

        //players
        JPanel players = new JPanel();
        players.setLayout(new GridBagLayout());
        ((GridBagLayout) players.getLayout()).columnWidths = new int[]{0, 0};
        ((GridBagLayout) players.getLayout()).rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
        ((GridBagLayout) players.getLayout()).columnWeights = new double[]{1.0, 1.0E-4};
        ((GridBagLayout) players.getLayout()).rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0E-4};

        //label1
        label1 = new JLabel();
        label1.setText("Kein Spieler");
        players.add(label1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));

        //label2
        label2 = new JLabel();
        label2.setText("Kein Spieler");
        players.add(label2, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));

        //label3
        label3 = new JLabel();
        label3.setText("Kein Spieler");
        players.add(label3, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));

        //label4
        label4 = new JLabel();
        label4.setText("Kein Spieler");
        players.add(label4, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));

        //label5
        label5 = new JLabel();
        label5.setText("Kein Spieler");
        players.add(label5, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));

        //label6
        label6 = new JLabel();
        label6.setText("Kein Spieler");
        players.add(label6, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

        contentPane.add(players, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 14, 0), 0, 0));

        //optPanel
        JPanel optPanel = new JPanel();
        optPanel.setLayout(new BoxLayout(optPanel, BoxLayout.Y_AXIS));

        //remAll
        remAll = new JButton();
        remAll.addActionListener(new TileListener());
        remAll.setText("Alle entfernen");
        remAll.setAlignmentX(Component.CENTER_ALIGNMENT);
        optPanel.add(remAll);

        //pName
        pName = new JTextField();
        pName.setMaximumSize(new Dimension(101, 23));
        pName.setMinimumSize(new Dimension(101, 23));
        pName.setText("Name");
        pName.setAlignmentX(Component.CENTER_ALIGNMENT);
        optPanel.add(pName);

        //pColor
        pColor = new JComboBox<>();
        pColor.setMaximumRowCount(6);
        pColor.setModel(new DefaultComboBoxModel<>(new String[]{"Blau", "Schwarz", "Grün", "Rosa", "Rot", "Gelb"}));
        pColor.setMaximumSize(new Dimension(101, 23));
        pColor.setMinimumSize(new Dimension(121, 23));
        pColor.setAlignmentX(Component.CENTER_ALIGNMENT);
        optPanel.add(pColor);

        //pAdd
        pAdd = new JButton();
        pAdd.addActionListener(new TileListener());
        pAdd.setText("Spieler Hinzufügen");
        pAdd.setAlignmentX(Component.CENTER_ALIGNMENT);
        optPanel.add(pAdd);

        //fertigButton
        fertigButton = new JButton();
        fertigButton.setText("Fertig");
        fertigButton.addActionListener(new TileListener());
        fertigButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        optPanel.add(fertigButton);

        contentPane.add(optPanel, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
        pack();
        setLocationRelativeTo(getOwner());
    }

    private Color stringToColor(String s) {
        if (s.equalsIgnoreCase("Gelb")) {
            return Color.YELLOW;
        } else if (s.equalsIgnoreCase("Rot")) {
            return Color.RED;
        } else if (s.equalsIgnoreCase("Rosa")) {
            return Color.PINK;
        } else if (s.equalsIgnoreCase("Grün")) {
            return Color.GREEN;
        } else if (s.equalsIgnoreCase("Schwarz")) {
            return Color.BLACK;
        }
        return Color.BLUE;
    }

    class TileListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(pAdd)) {
                if (pCounter < 6) {
                    for (Player p : players) {
                        if (stringToColor((String) pColor.getSelectedItem()).equals(p.getFarbe())) {
                            Main.errorMessage("Diese Farbe ist vergeben", "Bitte andere Farbe wählen!!!");
                            return;
                        } else if (p.getPlayername().equalsIgnoreCase(pName.getText())) {
                            Main.errorMessage("Dieser Spielernamen ist schon vergeben", "ERRRORORROROR");
                            return;
                        }
                    }
                    Player player = new Player(stringToColor((String) pColor.getSelectedItem()), Main.getBoard(), pName.getText());
                    players.add(player);
                    labels.get(pCounter).setText(pName.getText());
                    labels.get(pCounter).setForeground(stringToColor((String) pColor.getSelectedItem()));
                    pCounter++;
                }
            } else if (e.getSource().equals(remAll)) {
                pCounter = 0;
                players = new LinkedList<>();
                for (JLabel label : labels) {
                    label.setText("Kein Spieler");
                    label.setForeground(Color.BLACK);
                }
            } else if (e.getSource().equals(fertigButton)) {
                if (pCounter > 1) {
                    Main.startGame(players);
                }
            }
        }
    }
}
