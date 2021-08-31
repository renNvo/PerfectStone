package net.rennvo.perfectstone.model.user;

import java.util.UUID;

/**
 * @author renNvo on 14:01, 30.08.2021
 */

public class UserImpl implements IUser {

    private final UUID   uniqueId;
    private final String name;

    private int level;
    private int exp;
    private int need;

    public UserImpl(UUID uniqueId, String name) {
        this.uniqueId = uniqueId;
        this.name = name;

        this.level = 1;
        this.exp = 0;
        this.need = 100; //TODO
    }

    @Override
    public UUID getUniqueId() {
        return uniqueId;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public int getExp() {
        return exp;
    }

    @Override
    public void setExp(int exp) {
        this.exp = exp;
    }

    @Override
    public int getNeed() {
        return need;
    }

    @Override
    public void setNeed(int need) {
        this.need = need;
    }
}
