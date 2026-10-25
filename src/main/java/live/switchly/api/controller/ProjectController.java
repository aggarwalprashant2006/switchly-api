
package live.switchly.api.controller;

import live.switchly.api.model.Project;
import live.switchly.api.service.ProjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping("/api/v1/orgs/{orgId}/projects")
    public Project create(
            @PathVariable UUID orgId,
            @RequestBody CreateProjectRequest request) {
        return projectService.create(orgId, request.name());
    }

    @GetMapping("/api/v1/orgs/{orgId}/projects")
    public List<Project> findAllByOrgId(
            @PathVariable UUID orgId) {
        return projectService.findAllByOrgId(orgId);
    }

    @GetMapping("/api/v1/projects/{projectId}")
    public Project findById(@PathVariable UUID projectId) {
        return projectService.findById(projectId);
    }

    public record CreateProjectRequest(String name) {}
}
