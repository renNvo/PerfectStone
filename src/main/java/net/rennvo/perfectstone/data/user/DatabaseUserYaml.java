package net.rennvo.perfectstone.data.user;

import net.rennvo.perfectstone.configuration.Configuration;
import net.rennvo.perfectstone.data.Database;
import net.rennvo.perfectstone.model.user.IUser;
import net.rennvo.perfectstone.model.user.UserImpl;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author renNvo on 12:24, 01.09.2021
 */

public class DatabaseUserYaml implements Database<IUser, UUID> {

    private final Configuration configuration;
    private final File dataFolder;

    public DatabaseUserYaml(Configuration configuration, File folder) {
        this.configuration = configuration;
        this.dataFolder = folder;

        if(!dataFolder.exists()) {
            dataFolder.mkdir();
        }
    }

    @Override
    public void saveAll() {

    }

    @Override
    public void save(IUser data) {
        File file = new File(dataFolder, data.getUniqueId().toString() + ".yml");

        try {
            if(!file.exists()) {
                file.createNewFile();
            }

            YamlConfiguration yaml = YamlConfiguration.loadConfiguration(file);

            yaml.set("uniqueId", data.getUniqueId().toString());
            yaml.set("name", data.getName());
            yaml.set("level", data.getLevel());
            yaml.set("exp", data.getExp());

            yaml.save(file);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public IUser load(UUID key) {
        File file = new File(dataFolder, key.toString() + ".yml");

        if(!file.exists()) {
            return null;
        }

        final YamlConfiguration yaml = YamlConfiguration.loadConfiguration(file);

        final int level = yaml.getInt("level");

        return new UserImpl(
                UUID.fromString(yaml.getString("uniqueId")),
                yaml.getString("name"),
                level,
                yaml.getInt("exp"),
                configuration.needConfiguration.getNeed(level)
        );
    }
}
