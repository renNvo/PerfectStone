package net.rennvo.perfectstone.utilities;

import org.bukkit.ChatColor;

/**
 * @author renNvo on 14:10, 30.08.2021
 */

public class ChatUtilities {

    public static String colored(String content) {
        return ChatColor.translateAlternateColorCodes('&', content);
    }
}
