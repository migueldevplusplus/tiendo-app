package com.miguelmora.tiendo_api.tenant;

import com.miguelmora.tiendo_api.common.error.ResourceNotFoundException;
import com.miguelmora.tiendo_api.tenant.dtos.PublicTenantResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TenantServiceTest {

    @Mock
    private TenantRepository tenantRepository;

    @InjectMocks
    private TenantService tenantService;

    @Test
    public void findBySlug_shouldReturnTenantWhenExistsAndActive() {
        Tenant tenant = new Tenant("Darxus", "04121314493", "darxus-pzo");
        when(tenantRepository.findBySlugAndDisabledAtIsNull("el-patio"))
                .thenReturn(Optional.of(tenant));

        PublicTenantResponse result = tenantService.findBySlug("el-patio");

        assertNotNull(result);
        assertEquals("darxus-pzo", result.slug());
        assertEquals("Darxus", result.name());
    }

    @Test
    public void findBySlug_shouldThrowWhenSlugNotFound(){
        when(tenantRepository.findBySlugAndDisabledAtIsNull("non-existent")).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> tenantService.findBySlug("non-existent"));
    }
}
