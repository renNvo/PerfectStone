package net.rennvo.perfectstone.model.drop;

import org.bukkit.Material;

/**
 * @author renNvo on 14:04, 30.08.2021
 */

public class DropItemImpl implements IDropItem {

    private Material material;
    private double   chance;

    public DropItemImpl(Material material, double chance) {
        this.material = material;
        this.chance = chance;
    }

    @Override
    public Material getMaterial() {
        return material;
    }

    @Override
    public double getChance() {
        return chance;
    }
}
