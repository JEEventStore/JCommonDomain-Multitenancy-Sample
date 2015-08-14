package org.jeecqrs.example.multitenancy.domain.common;

import org.jeecqrs.common.AbstractId;

/**
 * Uniquely identifies a tenant.
 */
public class TenantId extends AbstractId<TenantId> {

    private TenantId(String tenantId) {
        super(tenantId);
    }

    public static TenantId fromString(String tenantId) {
        return new TenantId(tenantId);
    }

}
