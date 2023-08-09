package dao;

import entity.Member;

import java.util.List;
import java.util.Optional;

public interface MemberDao {
    void create(Member member);

    List<Member> findAll();

    void update(Member member);

    void deleteById(Long id);

    Optional<Member> findById(Long id);

    Member findMemberByEmail(String email);

    Optional<Member> getMember(String account, String password);

    Member findByAccount(String account);



}
