package gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MissionsKarte extends JFrame {

    private Image img;

    private ImagePanel imgPanel;

    public MissionsKarte(Image img) throws IOException {
        this.img = img;
        imgPanel = new ImagePanel(img);
        initComponents();
    }

    private void initComponents() throws IOException {
        setVisible(true);
        setAlwaysOnTop(true);
        setResizable(false);
        setIconImage(ImageIO.read(new File("src\\resources\\other\\star.png")));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setMinimumSize(new Dimension(267, 430));
        setTitle("Mission");
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        ((GridBagLayout) contentPane.getLayout()).columnWidths = new int[]{0, 0};
        ((GridBagLayout) contentPane.getLayout()).rowHeights = new int[]{0, 0};
        ((GridBagLayout) contentPane.getLayout()).columnWeights = new double[]{1.0, 1.0E-4};
        ((GridBagLayout) contentPane.getLayout()).rowWeights = new double[]{1.0, 1.0E-4};

        imgPanel.setMaximumSize(new Dimension(267, 430));
        imgPanel.setMinimumSize(new Dimension(267, 430));
        imgPanel.setLayout(null);

        contentPane.add(imgPanel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
    }

    private class ImagePanel extends JPanel {
        private final Image img;
        private Image scaled;

        public ImagePanel(Image img) {
            this.img = img;
        }

        @Override
        public void invalidate() {
            super.invalidate();
            int width = getWidth();
            int height = getHeight();

            if (width > 0 && height > 0) {
                scaled = img.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return img == null ? new Dimension(200, 200) : new Dimension(
                    img.getWidth(this), img.getHeight(this));
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(scaled, 0, 0, imgPanel.getWidth(), imgPanel.getHeight(), null);
        }
    }
}
