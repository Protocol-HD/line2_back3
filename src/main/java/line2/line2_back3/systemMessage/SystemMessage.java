package line2.line2_back3.systemMessage;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class SystemMessage {
    private int code;
    private String message;
}
