package com.miguelmora.tiendo_api.tenant;

import com.miguelmora.tiendo_api.tenant.dtos.PublicTenantResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/public/tenants")
@RestController
@RequiredArgsConstructor
public class PublicTenantController {
    private final TenantService tenantService;

    @GetMapping("/{slug}")
    public ResponseEntity<PublicTenantResponse> findBySlug(@PathVariable String slug){
        return ResponseEntity.ok(tenantService.findBySlug(slug));
    }
}
