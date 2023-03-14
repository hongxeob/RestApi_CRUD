package hongxeob.restapi_crud.service;

import hongxeob.restapi_crud.Post;
import hongxeob.restapi_crud.repository.PostRepository;
import hongxeob.restapi_crud.request.CreatePostDto;
import hongxeob.restapi_crud.request.UpdatePostDto;
import hongxeob.restapi_crud.response.PostListResponse;
import hongxeob.restapi_crud.response.PostResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PostServiceTest {
    @Autowired
    PostService postService;
    @Autowired
    PostRepository postRepository;

    @BeforeEach
    void clean() throws Exception {
        postRepository.deleteAll();
    }

    @Test
    @DisplayName("게시물_저장")
    void create() {
        CreatePostDto post = CreatePostDto.builder().title("제목1").content("내용1").build();
        postService.create(post);
        assertThat(postRepository.findAll().size()).isEqualTo(1);
        assertThat(postRepository.findAll().get(0).getTitle()).isEqualTo("제목1");
        assertThat(postRepository.findAll().get(0).getContent()).isEqualTo("내용1");
    }

    @Test
    @DisplayName("게시물_단건_조회")
    void findOne() {
        Post post = Post.builder().title("제목1").content("내용1").build();
        Post savedPost = postRepository.save(post);
        PostResponse findPost = postService.findOne(savedPost.getId());
        assertThat(findPost.getTitle()).isEqualTo("제목1");
        assertThat(findPost.getContent()).isEqualTo("내용1");
    }

    @Test
    @DisplayName("게시물_전체_조회")
    void findAll() {
        //given
        Post post1 = Post.builder().title("제목1").content("내용1").build();
        postRepository.save(post1);
        Post post2 = Post.builder().title("제목2").content("내용2").build();
        postRepository.save(post2);
        //when
        PostListResponse findAll = postService.findAll();
        //then
        assertThat(findAll.getPostList().size()).isEqualTo(2);
        assertThat(findAll.getPostList().get(0).getTitle()).isEqualTo("제목1");
        assertThat(findAll.getPostList().get(0).getContent()).isEqualTo("내용1");
        assertThat(findAll.getPostList().get(1).getTitle()).isEqualTo("제목2");
        assertThat(findAll.getPostList().get(1).getContent()).isEqualTo("내용2");
    }

    @Test
    @DisplayName("게시물_수정")
    void update() {
        //given
        Post post = Post.builder().title("제목1").content("내용1").build();
        Post savedPost = postRepository.save(post);
        UpdatePostDto updatePostDto = UpdatePostDto.builder().title("제목바꿈").content("내용바꿈").build();
        //when
        postService.update(savedPost.getId(), updatePostDto);
        Post findPost = postRepository.findById(savedPost.getId()).get();
        //then
        assertThat(findPost.getTitle()).isEqualTo("제목바꿈");
        assertThat(findPost.getContent()).isEqualTo("내용바꿈");
    }

    @Test
    @DisplayName("게시물_삭제")
    void delete() {
        Post post = Post.builder().title("제목1").content("내용1").build();
        Post savedPost = postRepository.save(post);
        postService.delete(savedPost.getId());
        List<Post> posts = postRepository.findAll();
        assertThat(posts.size()).isEqualTo(0);
    }
}