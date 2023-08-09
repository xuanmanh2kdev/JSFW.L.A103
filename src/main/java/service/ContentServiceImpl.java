package service;

import dao.ContentDao;
import dao.ContentDaoImpl;
import entity.Content;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class ContentServiceImpl implements ContentService{
    ContentDao contentDao = new ContentDaoImpl();


    @Override
    public boolean create(Content content) {
        try{
            content.setDeleted(false);
            content.setCreatedDate(LocalDate.now());
            contentDao.create(content);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public List<Content> findAllByAuthorId(Long authorID) {
        return contentDao.findAllByAuthorId(authorID);
    }

    @Override
    public boolean update(Content content) {
        try{
            content.setUpdateTime(LocalDate.now());
            contentDao.update(content);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public Optional<Content> findById(Long id) {
        return contentDao.findById(id);
    }

    @Override
    public boolean delete(Long id) {
        Optional<Content> contentOptional = contentDao.findById(id);
        Content content = contentOptional.orElseThrow(() -> new RuntimeException("Content not found"));
        content.setDeleted(true);
        return update(content);
    }
}
