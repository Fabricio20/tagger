package net.pixelscape.tagger;

import lombok.Getter;
import net.pixelscape.tagger.services.DatabaseService;
import net.pixelscape.tagger.services.FolderService;
import net.pixelscape.tagger.ui.MainUI;

@Getter
public class Tagger {

    private final DatabaseService database;
    private final FolderService folders;
    private final MainUI ui;

    private static Tagger instance;

    public Tagger() {
        instance = this;
        this.database = new DatabaseService();
        this.folders = new FolderService(this.database);
        this.ui = new MainUI(this);
    }

    public void onInit() {
        this.ui.show();
    }

    public void onExit() {
        System.exit(0);
    }

}
