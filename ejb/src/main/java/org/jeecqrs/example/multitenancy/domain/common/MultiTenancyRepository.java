package org.jeecqrs.example.multitenancy.domain.common;

import org.jeecqrs.common.Identity;

public interface MultiTenancyRepository<T, ID extends Identity> {

    /**
     * Retrieves the object with the given identity.
     * Must exist.
     * 
     * @param tenantId  the tenantId of the object to retrieve
     * @param id  the id of the object to retrieve
     * @return    the object with the given id
     */
    T ofIdentity(TenantId tenantId, ID id);

    /**
     * Adds an object to the repository.
     *
     * @param object  the object to add
     * @param commitId  unique id for this commit
     */
    void add(T object, Identity commitId);

    /**
     * Saves an instance of the object to the repository.
     * 
     * @param object the object to save
     * @param commitId  unique id for this commit
     */
    void save(T object, Identity commitId);
    
}