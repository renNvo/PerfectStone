package net.rennvo.perfectstone;

import net.rennvo.perfectstone.configuration.Configuration;
import net.rennvo.perfectstone.data.Database;
import net.rennvo.perfectstone.listener.AsyncPlayerChatListener;
import net.rennvo.perfectstone.listener.BlockBreakListener;
import net.rennvo.perfectstone.model.user.IUser;
import net.rennvo.perfectstone.service.DropManager;
import net.rennvo.perfectstone.service.UserManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.UUID;

/**
 * @author renNvo on 15:11, 27.08.2021
 */

public class PerfectStonePlugin extends JavaPlugin {

    private UserManager           userManager;
    private DropManager           dropManager;
    private Database<IUser, UUID> userDatabase;

    private Configuration configuration;

    @Override
    public void onEnable() {
        this.configuration = new Configuration()
                .load(this);

        this.userManager = new UserManager();
        this.dropManager = new DropManager();

        Bukkit.getPluginManager().registerEvents(new BlockBreakListener(this, userDatabase, userManager, dropManager, configuration), this);
        Bukkit.getPluginManager().registerEvents(new AsyncPlayerChatListener(userManager), this);
    }

    @Override
    public void onDisable() {

    }
}
