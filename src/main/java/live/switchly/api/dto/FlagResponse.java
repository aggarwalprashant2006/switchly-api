
package live.switchly.api.dto;

import java.time.Instant;
import java.util.UUID;

public record FlagResponse(
        UUID id,
        UUID projectId,
        String key,
        boolean enabled,
        Instant createdAt
) {
}
