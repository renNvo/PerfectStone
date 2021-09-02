package net.rennvo.perfectstone.listener;

import net.rennvo.perfectstone.configuration.Configuration;
import net.rennvo.perfectstone.model.user.IUser;
import net.rennvo.perfectstone.model.user.UserImpl;
import net.rennvo.perfectstone.service.UserManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * @author renNvo on 15:12, 31.08.2021
 */

public class PlayerJoinListener implements Listener {

    private final UserManager userManager;

    private final int startNeed;

    public PlayerJoinListener(Configuration configuration, UserManager userManager) {
        this.userManager = userManager;

        this.startNeed = configuration.needConfiguration.getNeed(1);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        final Player player = event.getPlayer();

        IUser user = userManager.get(player.getUniqueId());

        if (user == null) {
            user = new UserImpl(player.getUniqueId(), player.getName(), startNeed);
            userManager.put(user);
        }
    }
}
