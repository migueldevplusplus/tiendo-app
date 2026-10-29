package com.miguelmora.tiendo_api.tenant;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TenantTest {

    @Test
    public void disable_shouldDeactivateTenant(){
        Tenant tenant = new Tenant("Darxus", "04121314493", "darxus-pzo");

        tenant.disable();

        assertFalse(tenant.isActive());
        assertNotNull(tenant.getDisabledAt());
    }

    @Test
    public void disable_calledTwice_shouldStayDisabled() {
        Tenant tenant = new Tenant("Darxus", "04121314493", "darxus-pzo");

        tenant.disable();
        tenant.disable();

        assertFalse(tenant.isActive());
        assertNotNull(tenant.getDisabledAt());
    }

    @Test
    public void enable_shouldActivateTenant(){
        Tenant tenant = new Tenant("Darxus", "04121314493", "darxus-pzo");

        tenant.enable();

        assertTrue(tenant.isActive());
        assertNull(tenant.getDisabledAt());
    }
}
