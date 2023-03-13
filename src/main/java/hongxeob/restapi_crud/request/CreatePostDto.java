package hongxeob.restapi_crud.request;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CreatePostDto {
    private String title;
    private String content;

    @Builder
    public CreatePostDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
