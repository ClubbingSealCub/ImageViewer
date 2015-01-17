package imagebrowser.application;

import imagebrowser.control.ActionListenerFactory;
import imagebrowser.control.Command;
import imagebrowser.control.NextImageCommand;
import imagebrowser.control.PrevImageCommand;
import imagebrowser.ui.ImageViewer;
import imagebrowser.model.Image;
import imagebrowser.persistence.ImageListLoader;
import imagebrowser.ui.ImageViewerPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    
    private static final String file= "C:\\Users\\Daniel\\Pictures";
    private Map<String, Command> commandMap;
    private ApplicationFrame frame;
    
    public static void main(String[] args) {
        System.out.println(file);
        new Main().execute();
    }
    
    private void execute() {
        List<Image> images = new ImageListLoader(file).load();
        frame = createApplicationFrame();
        frame.getImageViewerPanel().setImage(images.get(0));
        createCommands();
        frame.setVisible(true);
    }
    
    private ImageViewer createImageViewer(Image image){
        ImageViewer viewer = new ImageViewerPanel();
        viewer.setImage(image);
        return viewer;
    }
    
    private ApplicationFrame createApplicationFrame(){
        return new ApplicationFrame(new ActionListenerFactory() {

            @Override
            public ActionListener createActionListener(final String action) {
                return new ActionListener(){

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Command command = commandMap.get(action);
                        if (command==null) {
                            return;
                        }
                        command.execute();
                    }
                };
            }
        });
    }
    
    private void createCommands(){
        commandMap = new HashMap<>();
        commandMap.put("Prev", new PrevImageCommand(frame.getImageViewerPanel()));
        commandMap.put("Next", new NextImageCommand(frame.getImageViewerPanel()));
    }
}

