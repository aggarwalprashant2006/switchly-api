
package live.switchly.api.service;

import live.switchly.api.model.Flag;
import live.switchly.api.repository.FlagRepository;
import live.switchly.api.repository.ProjectRepository;
import live.switchly.api.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FlagService {

    private final FlagRepository flagRepository;
    private final ProjectRepository projectRepository;

    public FlagService(
            FlagRepository flagRepository,
            ProjectRepository projectRepository) {
        this.flagRepository = flagRepository;
        this.projectRepository = projectRepository;
    }

    public Flag create(UUID projectId, String key, boolean enabled) {

        projectRepository.findById(projectId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Project not found with id: " + projectId));

        Flag flag = new Flag(projectId, key, enabled);

        return flagRepository.save(flag);
    }

    public List<Flag> findAllByProjectId(UUID projectId) {

        projectRepository.findById(projectId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Project not found with id: " + projectId));

        return flagRepository.findAllByProjectId(projectId);
    }

    public Flag findById(UUID flagId) {

        return flagRepository.findById(flagId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Flag not found with id: " + flagId));
    }

    public Flag updateState(UUID flagId, boolean enabled) {

        Flag flag = findById(flagId);

        flag.setEnabled(enabled);

        return flagRepository.save(flag);
    }
}
