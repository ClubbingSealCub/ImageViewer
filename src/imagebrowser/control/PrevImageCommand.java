package imagebrowser.control;

import imagebrowser.ui.ImageViewer;
import java.awt.event.ActionEvent;

public class PrevImageCommand implements Command {
    
    private final ImageViewer imageViewer;

    public PrevImageCommand(ImageViewer viewer) {
        this.imageViewer = viewer;
    }

    @Override
    public void execute() {
        this.imageViewer.setImage(this.imageViewer.getImage().getPrev());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        execute();
    }
}
