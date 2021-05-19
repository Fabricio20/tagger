package net.pixelscape.tagger.services;

import lombok.extern.slf4j.Slf4j;
import net.pixelscape.tagger.models.TagFolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class FolderService {

    private final DatabaseService database;

    public FolderService(DatabaseService database) {
        this.database = database;
    }

    public List<TagFolder> getFolders() {
        List<TagFolder> folders = new ArrayList<>();
        try (Connection connection = this.database.getSettings()) {
            PreparedStatement ps = connection
                    .prepareStatement("SELECT * FROM folders");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TagFolder folder = new TagFolder();
                folder.setId(rs.getLong("id"));
                folder.setName(rs.getString("name"));
                folder.setPath(rs.getString("path"));
                folders.add(folder);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            log.error("Failed to list folders", ex);
        }
        return folders;
    }

    public void save(TagFolder folder) {
        try (Connection connection = this.database.getSettings()) {
            PreparedStatement ps;
            if (folder.getId() == 0) {
                folder.setId(System.currentTimeMillis());
                ps = connection.prepareStatement("INSERT INTO folders (name, path, id) VALUES (?, ?, ?)");
            } else {
                ps = connection.prepareStatement("UPDATE folders SET name = ?, path = ? WHERE id = ?");
            }
            ps.setString(1, folder.getName());
            ps.setString(2, folder.getPath());
            ps.setLong(3, folder.getId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            log.error("Failed to save folder");
        }
    }

}
