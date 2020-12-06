package controllers.posts;

import java.io.IOException;

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
 * Servlet implementation class PostIineShowServlet
 */
@WebServlet("/post/iine/show")
public class PostIineShowServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostIineShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        EntityManager em = DBUtil.createEntityManager();

        Post r = em.find(Post.class, Integer.parseInt(request.getParameter("id")));

        em.getTransaction().begin();

        int count = r.getIine_count();
        count++;
        r.setIine_count(count);

        em.getTransaction().commit();

        em.close();

        request.setAttribute("post", r);
        request.setAttribute("_token", request.getSession().getId());
        request.getSession().setAttribute("iine_count", r);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/posts/postShow.jsp");
        rd.forward(request, response);
    }

}
