
package live.switchly.api.controller;

import live.switchly.api.model.Flag;
import live.switchly.api.service.FlagService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/projects/{projectId}/flags")
public class FlagController {

    private final FlagService flagService;

    public FlagController(FlagService flagService) {
        this.flagService = flagService;
    }

    @PostMapping
    public Flag create(
            @PathVariable("projectId") UUID projectId,
            @RequestBody Flag flag) {

        return flagService.create(
                projectId,
                flag.getKey(),
                flag.isEnabled()
        );
    }

    @GetMapping
    public List<Flag> getAll(
            @PathVariable("projectId") UUID projectId) {

        return flagService.findAllByProjectId(projectId);
    }

    @GetMapping("/{flagId}")
    public Flag getById(
            @PathVariable("projectId") UUID projectId,
            @PathVariable("flagId") UUID flagId) {

        return flagService.findById(flagId);
    }

    @PatchMapping("/{flagId}")
    public Flag updateState(
            @PathVariable("projectId") UUID projectId,
            @PathVariable("flagId") UUID flagId,
            @RequestParam("enabled") boolean enabled) {

        return flagService.updateState(flagId, enabled);
    }
}
