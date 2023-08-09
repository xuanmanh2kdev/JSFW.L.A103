package service;

import entity.Content;

import java.util.List;
import java.util.Optional;

public interface ContentService {
    List<Content> findAllByAuthorId(Long authorID);

    boolean create(Content content);

    boolean update(Content content);


    Optional<Content> findById(Long id);

    boolean delete(Long id);
}
