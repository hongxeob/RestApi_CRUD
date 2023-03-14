package hongxeob.restapi_crud.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class PostListResponse {
    List<PostResponse> postList;

    @Builder
    public PostListResponse(List<PostResponse> postList) {
        this.postList = postList;
    }
}
