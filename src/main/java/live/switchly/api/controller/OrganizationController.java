
package live.switchly.api.controller;

import live.switchly.api.model.Organization;
import live.switchly.api.service.OrganizationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/orgs")
public class OrganizationController {

    private final OrganizationService organizationService;

    public OrganizationController(
            OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @PostMapping
    public Organization create(@RequestBody CreateOrganizationRequest request) {
        return organizationService.create(request.name());
    }

    @GetMapping
    public List<Organization> findAll() {
        return organizationService.findAll();
    }

    @GetMapping("/{orgId}")
    public Organization findById(@PathVariable UUID orgId) {
        return organizationService.findById(orgId)
                .orElseThrow(() ->
                        new RuntimeException("Organization not found"));
    }

    public record CreateOrganizationRequest(String name) {}
}
