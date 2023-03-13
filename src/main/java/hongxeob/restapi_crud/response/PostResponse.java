package hongxeob.restapi_crud.response;

import hongxeob.restapi_crud.Post;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostResponse {
    private Long id;
    private String title;
    private String content;

    @Builder
    public PostResponse(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public PostResponse(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
    }
}
