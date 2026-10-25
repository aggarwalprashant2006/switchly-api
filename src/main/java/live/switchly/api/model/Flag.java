
package live.switchly.api.model;

import java.time.Instant;
import java.util.UUID;

public class Flag {

    private UUID id;
    private UUID projectId;
    private String key;
    private boolean enabled;
    private Instant createdAt;

    public Flag() {
    }

    public Flag(UUID projectId, String key, boolean enabled) {
        this.id = UUID.randomUUID();
        this.projectId = projectId;
        this.key = key;
        this.enabled = enabled;
        this.createdAt = Instant.now();
    }

    public UUID getId() {
        return id;
    }

    public UUID getProjectId() {
        return projectId;
    }

    public String getKey() {
        return key;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
