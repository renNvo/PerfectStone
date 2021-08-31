package net.rennvo.perfectstone.model.user;

import java.util.UUID;

public interface IUser {

    public UUID getUniqueId();

    public String getName();

    public int getLevel();

    public void setLevel(int level);

    public int getExp();

    public void setExp(int exp);

    public int getNeed();

    public void setNeed(int need);

}
