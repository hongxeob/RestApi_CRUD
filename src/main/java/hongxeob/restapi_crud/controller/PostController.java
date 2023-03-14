package hongxeob.restapi_crud.controller;

import hongxeob.restapi_crud.request.CreatePostDto;
import hongxeob.restapi_crud.request.UpdatePostDto;
import hongxeob.restapi_crud.response.PostListResponse;
import hongxeob.restapi_crud.response.PostResponse;
import hongxeob.restapi_crud.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping("/posts")
    public void create(@RequestBody CreatePostDto createPostDto) {
        postService.create(createPostDto);
    }

    @GetMapping("/posts")
    public PostListResponse findAll() {
        return postService.findAll();
    }

    @GetMapping("/posts/{id}")
    public PostResponse findOne(@PathVariable Long id) {
        return postService.findOne(id);
    }

    @PatchMapping("/posts/{id}")
    public void update(@PathVariable Long id, @RequestBody UpdatePostDto updatePostDto) {
        postService.update(id, updatePostDto);
    }

    @DeleteMapping("/posts/{id}")
    public void delete(@PathVariable Long id) {
        postService.delete(id);
    }
}
