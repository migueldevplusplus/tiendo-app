package com.miguelmora.tiendo_api.tenant.dtos;

import com.miguelmora.tiendo_api.tenant.Tenant;

public record PublicTenantResponse(
    String name,
    String phoneNumber,
    String slug,
    String address,
    String logoUrl
) {
    public static PublicTenantResponse from(Tenant tenant){
        return new PublicTenantResponse(
                tenant.getName(),
                tenant.getPhoneNumber(),
                tenant.getSlug(),
                tenant.getAddress(),
                tenant.getLogoUrl()
        );
    }
}
