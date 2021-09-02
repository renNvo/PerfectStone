package net.rennvo.perfectstone.configuration;

import org.apache.commons.lang.StringUtils;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;

/**
 * @author renNvo on 11:46, 01.09.2021
 */

public class Configuration {

    public NeedConfiguration needConfiguration;

    public Configuration load(Plugin plugin) {

        File file = new File(plugin.getDataFolder(), "config.yml");
        YamlConfiguration yaml = YamlConfiguration.loadConfiguration(file);

        String type = yaml.getString("need-configuration.active-type");

        if(type.equalsIgnoreCase("increase")) {

            needConfiguration = new NeedConfiguration.NeedConfigurationIncrease(
                    yaml.getInt("need-configuration.increase.value"))
                    .withStartNeed(yaml.getInt("need-configuration.increase.start"))
                    .withMaxLevel(yaml.getInt("need-configuration.increase.max"));

        } else if(type.equalsIgnoreCase("multiply")) {

            needConfiguration = new NeedConfiguration.NeedConfigurationMultiply(
                    yaml.getInt("need-configuration.multiply.value"))
                    .withStartNeed(yaml.getInt("need-configuration.multiply.start"))
                    .withMaxLevel(yaml.getInt("need-configuration.multiply.max"));

        } else if(type.equalsIgnoreCase("static")) {

            String _value = yaml.getString("need-configuration.static.value");
            String[] split = StringUtils.split(_value, ";");
            int[] value = new int[split.length];

            for (int i = 0; i < value.length; i++) {
                value[i] = Integer.parseInt(split[i]);
            }

            needConfiguration = new NeedConfiguration.NeedConfigurationStatic(value);

        } else {
            plugin.getServer().getPluginManager().disablePlugin(plugin);
        }

        return this;
    }

}
