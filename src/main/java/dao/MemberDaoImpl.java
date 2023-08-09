package dao;

import entity.Member;
import org.hibernate.Session;
import utils.HibernateConnectionConfig;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class MemberDaoImpl implements MemberDao {

    @Override
    public void create(Member member) {
        try (Session session = HibernateConnectionConfig.getSession()) {
            session.beginTransaction();
            member.setCreatedDate(LocalDate.now());
            session.persist(member);
            session.getTransaction().commit();
            session.flush();
            session.close();
        }
    }

    @Override
    public List<Member> findAll() {
        try (Session session = HibernateConnectionConfig.getSession()) {
            return session.createQuery("select m from Member m", Member.class).getResultList();
        }
    }

    @Override
    public void update(Member member) {
        try (Session session = HibernateConnectionConfig.getSession()) {
            session.beginTransaction();
            session.merge(member);
            session.getTransaction().commit();
        }

    }

    @Override
    public void deleteById(Long id) {
        try (Session session = HibernateConnectionConfig.getSession()) {
            session.beginTransaction();
            Member member = session.get(Member.class, id);
            member.setDeleted(true);
            session.merge(member);
            session.getTransaction().commit();
        }

    }

    @Override
    public Optional<Member> findById(Long id) {
        try (Session session = HibernateConnectionConfig.getSession()) {
            return Optional.ofNullable(session.get(Member.class, id));
        }
    }

    @Override
    public Member findMemberByEmail(String email) {
        try (Session session = HibernateConnectionConfig.getSession()) {
            Member member = session.createQuery("from Member m where m.email =: email", Member.class)
                    .setParameter("email", email)
                    .uniqueResultOptional().orElse(null);
            return member;
        }

    }

    @Override
    public Optional<Member> getMember(String account, String password) {
        try (Session session = HibernateConnectionConfig.getSession()) {
            Member member = session.createQuery("from Member m where m.userName =: account and m.password=: password", Member.class)
                    .setParameter("account", account)
                    .setParameter("password", password)
                    .getSingleResult();
            return Optional.ofNullable(member);
        }
    }

    @Override
    public Member findByAccount(String account) {
        try (Session session = HibernateConnectionConfig.getSession()) {
            Member member = session.createQuery("from Member m where m.userName =: account", Member.class)
                    .setParameter("account", account)
                    .getSingleResult();
            return member;
        }
    }
}
