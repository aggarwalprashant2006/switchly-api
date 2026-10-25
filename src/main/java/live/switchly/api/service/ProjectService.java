
package live.switchly.api.service;

import live.switchly.api.model.Project;
import live.switchly.api.repository.ProjectRepository;
import live.switchly.api.repository.OrganizationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final OrganizationRepository organizationRepository;

    public ProjectService(
            ProjectRepository projectRepository,
            OrganizationRepository organizationRepository) {
        this.projectRepository = projectRepository;
        this.organizationRepository = organizationRepository;
    }

    public Project create(UUID orgId, String name) {
        organizationRepository.findById(orgId)
                .orElseThrow(() ->
                        new RuntimeException("Organization not found"));

        Project project = new Project(orgId, name);
        return projectRepository.save(project);
    }

    public List<Project> findAllByOrgId(UUID orgId) {
        organizationRepository.findById(orgId)
                .orElseThrow(() ->
                        new RuntimeException("Organization not found"));

        return projectRepository.findAllByOrgId(orgId);
    }

    public Project findById(UUID projectId) {
        return projectRepository.findById(projectId)
                .orElseThrow(() ->
                        new RuntimeException("Project not found"));
    }
}
