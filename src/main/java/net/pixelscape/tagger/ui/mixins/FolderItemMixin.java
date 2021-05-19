package net.pixelscape.tagger.ui.mixins;

import net.pixelscape.tagger.models.TagFolder;

import javax.swing.*;
import java.awt.*;

/**
 * The renderer used for the folder list, consists of the folder name and a delete button.
 */
public class FolderItemMixin extends JPanel {

    public FolderItemMixin(TagFolder folder) {
        super();
        this.setLayout(new GridLayout());

        JLabel label = new JLabel();
        label.setText(folder.getName());
        this.add(label);

        this.add(new Box.Filler(new Dimension(0, 0), new Dimension(0, 0), new Dimension(32767, 0)));

        JButton button = new JButton();
        button.setText("X");
        this.add(button);
    }

}
