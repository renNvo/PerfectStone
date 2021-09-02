package net.rennvo.perfectstone.listener;

import net.rennvo.perfectstone.configuration.Configuration;
import net.rennvo.perfectstone.data.Database;
import net.rennvo.perfectstone.model.drop.IDropItem;
import net.rennvo.perfectstone.model.user.IUser;
import net.rennvo.perfectstone.service.DropManager;
import net.rennvo.perfectstone.service.UserManager;
import net.rennvo.perfectstone.utilities.MathUtilities;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.util.UUID;

/**
 * @author renNvo on 14:06, 30.08.2021
 */

public class BlockBreakListener implements Listener {

    private final Plugin                plugin;
    private final Database<IUser, UUID> userDatabase;
    private final UserManager           userManager;
    private final DropManager           dropManager;
    private final Configuration         configuration;

    public BlockBreakListener(Plugin plugin, Database<IUser, UUID> userDatabase, UserManager userManager, DropManager dropManager, Configuration configuration) {
        this.plugin = plugin;
        this.userDatabase = userDatabase;
        this.userManager = userManager;
        this.dropManager = dropManager;
        this.configuration = configuration;
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.HIGH)
    public void onBlockBreak(BlockBreakEvent event) {
        final Player player = event.getPlayer();
        final Block  block  = event.getBlock();

        if (block.getType() == Material.STONE) {
            final IUser user = userManager.get(player.getUniqueId());

            for (IDropItem dropItem : dropManager.getDropItemList()) {

                if (MathUtilities.random(100.0) > dropItem.getChance()) {
                    continue;
                }

                ItemStack itemStack = new ItemStack(dropItem.getMaterial(), 1);

                user.setExp(user.getExp() + dropItem.getExp());
                player.getInventory().addItem(itemStack);
            }

            if (user.getExp() >= user.getNeed() && user.getNeed() != 0) {

                while (user.getExp() >= user.getNeed() && user.getNeed() != 0) {
                    user.setLevel(user.getLevel() + 1);
                    user.setExp(user.getExp() - user.getNeed());
                    user.setNeed(configuration.needConfiguration.getNeed(user.getLevel()));
                }

                Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> userDatabase.save(user));
            }

        }
    }
}
