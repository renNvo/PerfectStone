package net.rennvo.perfectstone.configuration;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author renNvo on 14:44, 02.09.2021
 */

public abstract class NeedConfiguration {

    private int startNeed;
    private int maxLevel;

    public abstract int getNeed(int key);

    public NeedConfiguration withStartNeed(int start) {
        this.startNeed = start;
        return this;
    }

    public NeedConfiguration withMaxLevel(int maxLevel) {
        this.maxLevel = maxLevel;
        return this;
    }

    public int getStartNeed() {
        return startNeed;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public static class NeedConfigurationMultiply extends NeedConfiguration {

        private final int value;
        private final Map<Integer, Integer> map = new ConcurrentHashMap<>();

        public NeedConfigurationMultiply(int value) {
            this.value = value;
        }

        @Override
        public int getNeed(int level) {
            return 0;
        }
    }

    public static class NeedConfigurationIncrease extends NeedConfiguration {

        private final int value;
        private final Map<Integer, Integer> map = new ConcurrentHashMap<>();

        public NeedConfigurationIncrease(int value) {
            this.value = value;
        }

        @Override
        public int getNeed(int level) {
            return 0;
        }
    }

    public static class NeedConfigurationStatic extends NeedConfiguration {

        private final int[] need;
        private final int   max;

        public NeedConfigurationStatic(int[] _need) {
            int[] need = new int[_need.length];

            need[0] = 0;

            for (int i = 0; i <= _need.length - 1; i++) {
                need[i + 1] = _need[i];
            }

            this.need = need;
            this.max = need.length - 1;
        }

        @Override
        public int getNeed(int level) {

            if (level < max) {
                return this.need[level];
            }

            return 0;
        }
    }

}
