package hongxeob.restapi_crud.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import hongxeob.restapi_crud.Post;
import hongxeob.restapi_crud.repository.PostRepository;
import hongxeob.restapi_crud.request.UpdatePostDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PostControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    PostRepository postRepository;
    @Autowired
    ObjectMapper objectMapper;

    @BeforeEach
    void clean() throws Exception {
        postRepository.deleteAll();
    }

    @Test
    @DisplayName("게시물_저장")
    void create() throws Exception {
        Post post = Post.builder()
                .title("제목")
                .content("내용")
                .build();

        mockMvc.perform(post("/posts")
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(post)))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    @DisplayName("게시물_단건_조회")
    void findOne() throws Exception {
        //given
        Post post = Post.builder()
                .title("제목")
                .content("내용")
                .build();
        postRepository.save(post);
        //when
        mockMvc.perform(get("/posts/{id}", post.getId())
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("제목"))
                .andExpect(jsonPath("$.content").value("내용"))
                .andDo(print());
    }

    @Test
    @DisplayName("게시물_전체_조회")
    void findAll() throws Exception {
        //given
        for (int i = 1; i <= 5; i++) {
            postRepository.save(Post.builder()
                    .title("제목" + i)
                    .content("내용" + i)
                    .build());
        }
        //when
        mockMvc.perform(get("/posts")
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk()).andDo(print());
    }

    @Test
    @DisplayName("게시물_수정")
    void update() throws Exception {
        //given
        Post post = Post.builder()
                .title("제목")
                .content("내용")
                .build();
        postRepository.save(post);
        UpdatePostDto updatePostDto = UpdatePostDto.builder().title("제목수정").content("내용수정").build();
        //when
        mockMvc.perform(patch("/posts/{id}", post.getId()).contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatePostDto)))
                .andExpect(status().isOk()).andDo(print());
    }

    @Test
    @DisplayName("게시물_삭제")
    void deleteTest() throws Exception {
        Post post = Post.builder()
                .title("제목")
                .content("내용")
                .build();

        postRepository.save(post);

        mockMvc.perform(delete("/posts/{id}", post.getId()))
                .andExpect(status().isOk())
                .andDo(print());
    }
}