package com.viveknaskar;

/**
 * Enum for the Field indexes
 */
public enum RedisIndex {
    USERID(0),
    TITLES(1);

    private final Integer value;

    RedisIndex(final Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
