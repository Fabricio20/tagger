package net.pixelscape.tagger.ui;

import net.pixelscape.tagger.Tagger;
import net.pixelscape.tagger.framework.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainUI extends UI {

    private final Tagger software;
    private final JFrame frame;

    public MainUI(Tagger instance) {
        this.software = instance;
        this.frame = new JFrame();
    }

    @Override
    public void build() {
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Tagger :: Main");
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                software.onExit();
            }
        });

        // Top Menu
        JMenuBar menu = new JMenuBar();

        JMenu tools = new JMenu("Tools");
        tools.add(new JMenuItem(new AbstractAction("Folder Manager") {
            @Override
            public void actionPerformed(ActionEvent e) {
                FolderListUI ui = new FolderListUI(software.getFolders());
                ui.show();
            }
        }));
        menu.add(tools);

        JPanel panel = new JPanel();
        panel.add(new JButton("test1"));
        panel.add(new JButton("test2"));

        frame.getContentPane().add(BorderLayout.NORTH, menu);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
    }

    @Override
    public JFrame getFrame() {
        return this.frame;
    }

}
