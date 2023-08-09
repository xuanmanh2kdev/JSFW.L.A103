package service;

import dao.MemberDao;
import dao.MemberDaoImpl;
import entity.Member;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class MemberServiceImpl implements MemberService{
    MemberDao memberDao = new MemberDaoImpl();
    @Override
    public List<Member> findAll() {
        return memberDao.findAll();

    }

    @Override
    public boolean create(Member member) {
        try{
            member.setDeleted(false);
            member.setCreatedDate(LocalDate.now());
            memberDao.create(member);

        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Member member) {
        try{
            member.setUpdateTime(LocalDate.now());
            memberDao.update(member);
        }catch (Exception e){
            return false;
        }
        return true;
    }


    @Override
    public Optional<Member> findById(Long id) {
        return memberDao.findById(id);
    }

    @Override
    public boolean getMember(String account, String password) {
        if(memberDao.getMember(account, password)!=null){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Member findByAccount(String account) {
        return memberDao.findByAccount(account);
    }
}
