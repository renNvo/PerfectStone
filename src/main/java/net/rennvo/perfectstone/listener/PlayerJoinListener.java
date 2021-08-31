package net.rennvo.perfectstone.listener;

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

    public PlayerJoinListener(UserManager userManager) {
        this.userManager = userManager;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        final Player player = event.getPlayer();

        IUser user = userManager.get(player.getUniqueId());

        if(user == null) {
            user = new UserImpl(player.getUniqueId(), player.getName());
            userManager.put(user);
        }
    }
}
