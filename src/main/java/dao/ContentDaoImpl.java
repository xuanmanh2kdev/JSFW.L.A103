package dao;

import entity.Content;
import org.hibernate.Session;
import utils.HibernateConnectionConfig;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class ContentDaoImpl implements ContentDao{


    @Override
    public void create(Content content) {
        try (Session session = HibernateConnectionConfig.getSession()) {
            session.beginTransaction();
            session.persist(content);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }

    @Override
    public List<Content> findAllByAuthorId(Long AuthorID) {
        try(Session session = HibernateConnectionConfig.getSession()){
            return session.createQuery("from Content where member.id = :authorID", Content.class)
                    .setParameter("authorID", AuthorID)
                    .getResultList();
        }
    }

    @Override
    public void update(Content content) {
        try(Session session = HibernateConnectionConfig.getSession()){
            session.beginTransaction();
            content.setUpdateTime(LocalDate.now());
            session.merge(content);
            session.getTransaction().commit();
        }
    }

    @Override
    public void deleteById(Long id) {
        try(Session session = HibernateConnectionConfig.getSession()){
            session.beginTransaction();
            Content content = session.get(Content.class, id);
            content.setDeleted(true);
            session.merge(content);
            session.getTransaction().commit();
        }

    }

    @Override
    public Optional<Content> findById(Long id) {
        try(Session session = HibernateConnectionConfig.getSession()){
            return Optional.ofNullable(session.get(Content.class, id));
        }
    }
}
