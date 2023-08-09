package controller;

import dao.ContentDao;
import dao.ContentDaoImpl;
import entity.Content;
import entity.Member;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.ContentService;
import service.ContentServiceImpl;
import service.MemberService;
import service.MemberServiceImpl;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@WebServlet(name = "FormController", value = "/form")
public class FormController extends HttpServlet {
    ContentService contentService = new ContentServiceImpl();
    MemberService memberService = new MemberServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/Content/Add.jsp")
                .forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Member loggedInUser = (Member) req.getSession().getAttribute("loggedInMember");
        String id = req.getParameter("id");
        String title = req.getParameter("title");
        String brief = req.getParameter("brief");
        String contentStr = req.getParameter("content");
        LocalDate createdDate = req.getParameter("createdDate") == null ? LocalDate.now() : LocalDate.parse(req.getParameter("createdDate"));

        Content content = null;
        if (id == null || id.isBlank()) {
            content = new Content();
        } else {
            Optional<Content> eventOptional = contentService.findById(Long.parseLong(id));
            content = eventOptional.orElseThrow(() -> new IllegalArgumentException("Invalid event Id:" + id));
        }
        if (loggedInUser.getContent() == null) {
            loggedInUser.setContent(new HashSet<>());
        }



        content.setTitle(title);
        content.setBrief(brief);
        content.setContent(contentStr);
        content.setCreatedDate(createdDate);
        content.setMember(loggedInUser);
        contentService.create(content);


        Set<Content> contentSet = loggedInUser.getContent();
        if (contentSet == null) {
            contentSet = new HashSet<>();
        }else {
            contentSet = new HashSet<>(contentSet);
        }
        contentSet.add(content);

        loggedInUser.setContent(contentSet);
        memberService.update(loggedInUser);
        resp.sendRedirect(req.getContextPath() + "/view");


    }
}
