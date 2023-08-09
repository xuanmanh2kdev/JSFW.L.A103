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
import java.util.Optional;

@WebServlet(name = "LoginController", urlPatterns = "/login")
public class LoginController extends HttpServlet {
    MemberService MemberService = new MemberServiceImpl();



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/Auth/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        if (MemberService.getMember(account, password)==true) {
            Member loggedinMember = MemberService.findByAccount(account);
            req.getSession().setAttribute("loggedInMember", loggedinMember);
            resp.sendRedirect(req.getContextPath() + "/view");
        } else {
            req.setAttribute("errorInvalidAccount", "Account or password is invalid");
            req.getRequestDispatcher("/WEB-INF/Auth/login.jsp").forward(req, resp);
        }
    }
}
