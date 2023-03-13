package hongxeob.restapi_crud.repository;

import hongxeob.restapi_crud.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
