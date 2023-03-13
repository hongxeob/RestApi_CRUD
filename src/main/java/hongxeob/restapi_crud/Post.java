package hongxeob.restapi_crud;

import hongxeob.restapi_crud.request.PostConvert;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;

    @Builder
    public Post(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public PostConvert toConvert() {
        return PostConvert.builder()
                .title(title)
                .content(content)
                .build();
    }

    public void update(PostConvert postConvert) {
        this.title= postConvert.getTitle();
        this.content = postConvert.getContent();
    }
}
