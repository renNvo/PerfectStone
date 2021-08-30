package net.rennvo.perfectstone.model.user;

import java.util.UUID;

/**
 * @author renNvo on 14:01, 30.08.2021
 */

public class UserImpl implements IUser {

    private final UUID uniqueId;
    private final String name;

    public UserImpl(UUID uniqueId, String name) {
        this.uniqueId = uniqueId;
        this.name = name;
    }

    @Override
    public UUID getUniqueId() {
        return uniqueId;
    }

    @Override
    public String getName() {
        return name;
    }
}
