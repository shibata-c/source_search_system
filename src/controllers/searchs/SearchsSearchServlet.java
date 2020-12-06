package controllers.searchs;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Post;
import utils.DBUtil;

/**
 * Servlet implementation class SearchsSearchServlet
 */
@WebServlet("/searchs/search")
public class SearchsSearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchsSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        String d = request.getParameter("keyword");
        List<Post> p = em.createNamedQuery("getSearchPosts",Post.class).setParameter("search","%"+d+"%" ).getResultList();
        em.close();
        request.setAttribute("searchs", p);


        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/searchs/searchTop.jsp");
        rd.forward(request, response);

    }
}
