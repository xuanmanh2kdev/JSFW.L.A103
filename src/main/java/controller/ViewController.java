package controller;

import entity.Content;
import entity.Member;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ContentService;
import service.ContentServiceImpl;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "viewController", value = "/view")
public class ViewController extends HttpServlet {
    ContentService contentService = new ContentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Member memberLogin = (Member) req.getSession().getAttribute("loggedInMember");
        if (memberLogin == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }
        List<Content> contentList = contentService.findAllByAuthorId(memberLogin.getId());
        req.setAttribute("contents", contentList);
        req.getRequestDispatcher("/WEB-INF/Content/View.jsp")
                .forward(req, resp);
    }


}
