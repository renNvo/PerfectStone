package net.rennvo.perfectstone.model.drop;

import org.bukkit.Material;

/**
 * @author renNvo on 14:04, 30.08.2021
 */

public class DropItemImpl implements IDropItem {

    private final Material material;
    private final double   chance;
    private final int      exp;

    public DropItemImpl(Material material, double chance, int exp) {
        this.material = material;
        this.chance = chance;
        this.exp = exp;
    }

    @Override
    public Material getMaterial() {
        return material;
    }

    @Override
    public double getChance() {
        return chance;
    }

    @Override
    public int getExp() {
        return exp;
    }
}
