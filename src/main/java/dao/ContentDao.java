package dao;

import entity.Content;

import java.util.List;
import java.util.Optional;

public interface ContentDao {
    void create(Content content);

    List<Content> findAllByAuthorId(Long authorID);

    void update(Content content);

    void deleteById(Long id);

   Optional<Content> findById(Long id);


}
