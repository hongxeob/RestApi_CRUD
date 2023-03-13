package hongxeob.restapi_crud.service;

import hongxeob.restapi_crud.Post;
import hongxeob.restapi_crud.repository.PostRepository;
import hongxeob.restapi_crud.request.CreatePostDto;
import hongxeob.restapi_crud.request.PostConvert;
import hongxeob.restapi_crud.request.UpdatePostDto;
import hongxeob.restapi_crud.response.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    //등록
    @Transactional
    public void create(@RequestBody CreatePostDto createPostDto) {
        Post post = Post.builder()
                .title(createPostDto.getTitle())
                .content(createPostDto.getContent())
                .build();
        postRepository.save(post);
    }

    //한 건 조회
    @Transactional(readOnly = true)
    public PostResponse findOne(Long id) {
        Post findPost = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("찾는 게시물이 없습니다 id " + id));
        PostResponse response = PostResponse.builder()
                .id(findPost.getId())
                .title(findPost.getTitle())
                .content(findPost.getContent())
                .build();
        return response;
    }

    //전체 게시글
    @Transactional(readOnly = true)
    public List<PostResponse> findAll() {
        return postRepository.findAll().stream().map(post -> new PostResponse(post)).collect(Collectors.toList());
    }

    @Transactional
    public void update(Long id, @RequestBody UpdatePostDto updatePostDto) {
        Post post = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("게시물을 찾을 수 없습니다 id= " + id));
        PostConvert postConvert = post.toConvert();
        postConvert.setTitle(updatePostDto.getTitle());
        postConvert.setContent(updatePostDto.getContent());
        post.update(postConvert);
    }

    @Transactional
    public void delete(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 하는 게시물이 없습니다 id= " + id));
        postRepository.deleteById(post.getId());
    }
}
