package hongxeob.restapi_crud.request;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostConvert {
    private String title;
    private String content;

    @Builder
    public PostConvert(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
