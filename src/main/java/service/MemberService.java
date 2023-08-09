package service;

import entity.Member;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface MemberService {
    List<Member> findAll();

    boolean create(Member member);

    boolean update(Member member);


    Optional<Member> findById(Long id);

    boolean getMember(String account, String password);

    Member findByAccount(String account);
}
