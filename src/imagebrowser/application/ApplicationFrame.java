package imagebrowser.application;

import imagebrowser.control.ActionListenerFactory;
import imagebrowser.ui.ImageViewer;
import imagebrowser.ui.ImageViewerPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ApplicationFrame extends JFrame {
    
    private ActionListenerFactory factory;
    private ImageViewerPanel imageViewerPanel;

    public ImageViewerPanel getImageViewerPanel() {
        return imageViewerPanel;
    }

    public ApplicationFrame(ActionListenerFactory factory) throws HeadlessException {
        super("Image Viewer");
        this.factory = factory;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1024,600);
        this.createComponents();
        this.setVisible(true);
    }

   private void createComponents() {
        this.add(createToolbarPanel(), BorderLayout.SOUTH);
        this.add(createImagePanel(), BorderLayout.CENTER);
    }

    private JButton createPrevButt() {
        JButton button = new JButton("Prev");
        button.addActionListener(factory.createActionListener("Prev"));
        return button;
    }

    private JButton createNextButt() {
        JButton button = new JButton("Next");
        button.addActionListener(factory.createActionListener("Next"));
        return button;
    }

    private JPanel createImagePanel() {
        ImageViewerPanel panel = new ImageViewerPanel();
        this.imageViewerPanel = panel;
        return panel;
    }

    private JPanel createToolbarPanel() {
        JPanel panel = new JPanel();
        panel.add(createPrevButt());
        panel.add(createNextButt());
        return panel;
    }
}
