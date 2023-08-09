package controller;

import dao.MemberDao;
import dao.MemberDaoImpl;
import entity.Member;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MemberService;
import service.MemberServiceImpl;

import java.io.IOException;

@WebServlet(name = "RegisterController", value = "/register")
public class RegisterController extends HttpServlet {
    MemberService memberService = new MemberServiceImpl();
    MemberDao memberDao = new MemberDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/Auth/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");
        if (!password.equals(confirmPassword)) {
            req.setAttribute("message", "Password and confirm password is not match");
            req.getRequestDispatcher("/WEB-INF/Auth/register.jsp").forward(req, resp);
        } else {
            String email = req.getParameter("email");
            if (memberDao.findMemberByEmail(email) != null) {
                req.setAttribute("message", "Email is already exist");
                req.getRequestDispatcher("/WEB-INF/Auth/register.jsp").forward(req, resp);
            } else {
                Member member = new Member();
                member.setUserName(username);
                member.setPassword(password);
                member.setEmail(email);
                memberService.create(member);

                req.getRequestDispatcher("/WEB-INF/Auth/login.jsp").forward(req, resp);
            }
        }

    }
}
