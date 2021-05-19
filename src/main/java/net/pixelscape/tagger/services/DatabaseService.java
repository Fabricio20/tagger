package net.pixelscape.tagger.services;

import lombok.extern.slf4j.Slf4j;
import net.pixelscape.tagger.models.TagFolder;

import java.io.File;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Slf4j
public class DatabaseService {

    public DatabaseService() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            log.error("Failed to initialize database drivers");
            System.exit(1);
        }
    }

    public Connection open(TagFolder folder) throws SQLException {
        String rawPath = folder.getPath();
        return this.open(new File(rawPath).toPath());
    }

    public Connection getSettings() throws SQLException {
        Path path = new File(System.getProperty("user.home") + File.pathSeparator + "settings.db").toPath();
        return this.open(path);
    }

    private Connection open(Path path) throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:" + path.toString());
    }

}
