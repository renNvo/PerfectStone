package net.rennvo.perfectstone.model.drop;

import org.bukkit.Material;

public interface IDropItem {

    public Material getMaterial();

    public double getChance();

    public int getExp();

}
