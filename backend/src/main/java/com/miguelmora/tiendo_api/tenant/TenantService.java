package com.miguelmora.tiendo_api.tenant;

import com.miguelmora.tiendo_api.common.error.ResourceNotFoundException;
import com.miguelmora.tiendo_api.tenant.dtos.PublicTenantResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TenantService {
    private final TenantRepository tenantRepository;


    public PublicTenantResponse findBySlug(String slug){
        Tenant tenant = tenantRepository.findBySlugAndDisabledAtIsNull(slug).orElseThrow(
                () -> new ResourceNotFoundException("Store not found")
        );

        return PublicTenantResponse.from(tenant);
    }
}
