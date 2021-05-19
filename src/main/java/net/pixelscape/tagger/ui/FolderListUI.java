package net.pixelscape.tagger.ui;

import net.pixelscape.tagger.framework.UI;
import net.pixelscape.tagger.models.TagFolder;
import net.pixelscape.tagger.services.FolderService;
import net.pixelscape.tagger.ui.mixins.FolderItemMixin;
import org.jdesktop.swingx.VerticalLayout;

import javax.swing.*;
import java.awt.*;

public class FolderListUI extends UI {

    private final FolderService service;
    private final JFrame frame;

    public FolderListUI(FolderService service) {
        this.service = service;
        this.frame = new JFrame();
    }

    @Override
    public void build() {
        this.frame.setSize(500, 250);
        this.frame.setTitle("Tagger :: Folder Manager");

        JPanel list = new JPanel();
        list.setLayout(new VerticalLayout());
        for (int i = 0; i < 25; i++) {
            TagFolder folder = new TagFolder();
            folder.setName("example" + i);
            list.add(new FolderItemMixin(folder));
        }

        JScrollPane scroller = new JScrollPane(list);
        scroller.getVerticalScrollBar().setUnitIncrement(8);
        this.frame.getContentPane().add(BorderLayout.CENTER, scroller);

        JButton add = new JButton("New Folder");

        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, add, new JButton("Ok"));
        split.setDividerLocation(0.9d);
        //split.setDividerSize(0);
        this.frame.getContentPane().add(BorderLayout.SOUTH, split);
    }

    @Override
    public JFrame getFrame() {
        return this.frame;
    }

}
