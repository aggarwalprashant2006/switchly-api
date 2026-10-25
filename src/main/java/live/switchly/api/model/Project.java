
package live.switchly.api.model;

import java.time.Instant;
import java.util.UUID;

public class Project {

    private UUID id;
    private UUID orgId;
    private String name;
    private Instant createdAt;

    public Project() {
    }

    public Project(UUID orgId, String name) {
        this.id = UUID.randomUUID();
        this.orgId = orgId;
        this.name = name;
        this.createdAt = Instant.now();
    }

    public UUID getId() {
        return id;
    }

    public UUID getOrgId() {
        return orgId;
    }

    public String getName() {
        return name;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}
