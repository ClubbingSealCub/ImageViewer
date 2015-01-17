package imagebrowser.control;

import imagebrowser.ui.ImageViewer;
import java.awt.event.ActionEvent;

public class NextImageCommand implements Command {
    
    private final ImageViewer imageViewer;

    public NextImageCommand(ImageViewer viewer) {
        this.imageViewer = viewer;
    }

    @Override
    public void execute() {
        this.imageViewer.setImage(this.imageViewer.getImage().getNext());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        execute();
    }
    
    

}
