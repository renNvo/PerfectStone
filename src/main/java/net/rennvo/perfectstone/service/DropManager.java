package net.rennvo.perfectstone.service;

import net.rennvo.perfectstone.model.drop.IDropItem;

import java.util.ArrayList;
import java.util.List;

/**
 * @author renNvo on 14:06, 30.08.2021
 */

public class DropManager {

    private final List<IDropItem> dropItemList = new ArrayList<>();

    public List<IDropItem> getDropItemList() {
        return dropItemList;
    }
}
