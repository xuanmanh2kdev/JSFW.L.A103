package controller;

import dao.MemberDao;
import dao.MemberDaoImpl;
import entity.Member;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.MemberService;
import service.MemberServiceImpl;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "edit", urlPatterns = "/edit")
public class EditProfileController extends HttpServlet {
    MemberService memberService = new MemberServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id != null) {
            Optional<Member> memberOptional = memberService.findById(Long.parseLong(id));
            Member member = memberOptional.orElseThrow(() -> new IllegalArgumentException("Invalid member Id:" + id));
            req.setAttribute("member", member);
        }
        List<Member> memberList = memberService.findAll();
        req.setAttribute("members", memberList);
        req.getRequestDispatcher("/WEB-INF/Profile/Edit.jsp")
                .forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Member loggedInUser = (Member) req.getSession().getAttribute("loggedInMember");

        if (loggedInUser == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String description = req.getParameter("description");

        loggedInUser.setFirstName(firstName);
        loggedInUser.setLastName(lastName);
        loggedInUser.setEmail(email);
        loggedInUser.setPhone(Integer.parseInt(phone));
        loggedInUser.setDescription(description);

        memberService.update(loggedInUser);
        resp.sendRedirect(req.getContextPath() + "/view");
    }
}
