
package live.switchly.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateFlagRequest(

        @NotBlank(message = "Flag key is required")
        String key,

        @NotNull(message = "Enabled status is required")
        Boolean enabled

) {
}
