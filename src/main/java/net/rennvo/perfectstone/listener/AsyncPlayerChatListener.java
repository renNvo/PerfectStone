package net.rennvo.perfectstone.listener;

import net.rennvo.perfectstone.model.user.IUser;
import net.rennvo.perfectstone.service.UserManager;
import org.apache.commons.lang.StringUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

/**
 * @author renNvo on 15:09, 31.08.2021
 */

public class AsyncPlayerChatListener implements Listener {

    private final UserManager userManager;

    public AsyncPlayerChatListener(UserManager userManager) {
        this.userManager = userManager;
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.HIGH)
    public void onAsyncPlayerChat(AsyncPlayerChatEvent event) {

        final Player player = event.getPlayer();
        final IUser  user   = userManager.get(player.getUniqueId());

        String format = event.getFormat();

        format = StringUtils.replace(format, "%D-LVL%", Integer.toString(user.getLevel()), 1);

        event.setFormat(format);
    }
}
