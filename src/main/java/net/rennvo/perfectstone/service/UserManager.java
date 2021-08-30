package net.rennvo.perfectstone.service;

import net.rennvo.perfectstone.model.user.IUser;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author renNvo on 14:02, 30.08.2021
 */

public class UserManager {

    private final Map<UUID, IUser> userMap = new ConcurrentHashMap<>();

    public IUser get(UUID uniqueId) {
        return this.userMap.get(uniqueId);
    }

    public void put(IUser user) {
        this.userMap.put(user.getUniqueId(), user);
    }

    public void remove(UUID uniqueId) {
        this.userMap.remove(uniqueId);
    }

}
