package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * @author sumitdeo
 * @projectName spring5webapp
 * @package guru.springframework.spring5webapp.repositories
 * @date 9/16/20
 * @comment:
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
