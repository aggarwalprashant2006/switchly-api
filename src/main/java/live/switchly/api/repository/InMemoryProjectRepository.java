
package live.switchly.api.repository;

import live.switchly.api.model.Project;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryProjectRepository
        implements ProjectRepository {

    private final Map<UUID, Project> store =
            new ConcurrentHashMap<>();

    @Override
    public Project save(Project project) {
        store.put(project.getId(), project);
        return project;
    }

    @Override
    public Optional<Project> findById(UUID id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Project> findAllByOrgId(UUID orgId) {
        List<Project> projects = new ArrayList<>();

        for (Project project : store.values()) {
            if (project.getOrgId().equals(orgId)) {
                projects.add(project);
            }
        }

        return projects;
    }
}
