package net.rennvo.perfectstone;

import net.rennvo.perfectstone.listener.AsyncPlayerChatListener;
import net.rennvo.perfectstone.listener.BlockBreakListener;
import net.rennvo.perfectstone.service.DropManager;
import net.rennvo.perfectstone.service.UserManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author renNvo on 15:11, 27.08.2021
 */

public class PerfectStonePlugin extends JavaPlugin {

    private UserManager userManager;
    private DropManager dropManager;

    @Override
    public void onEnable() {
        this.userManager = new UserManager();
        this.dropManager = new DropManager();

        Bukkit.getPluginManager().registerEvents(new BlockBreakListener(userManager, dropManager), this);
        Bukkit.getPluginManager().registerEvents(new AsyncPlayerChatListener(userManager), this);
    }

    @Override
    public void onDisable() {

    }
}
