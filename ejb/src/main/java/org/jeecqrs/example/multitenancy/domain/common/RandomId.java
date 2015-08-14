package org.jeecqrs.example.multitenancy.domain.common;

import org.jeecqrs.common.AbstractId;

/**
 * Represents a random commit id.
 */
public class RandomId extends AbstractId<RandomId> {

    private RandomId() { }

    public static RandomId get() {
        return new RandomId();
    }

}
