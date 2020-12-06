package controllers.posts;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Employee;
import models.Post;
import models.validators.PostValidator;
import utils.DBUtil;

/**
 * Servlet implementation class PostsCreateServlet
 */
@WebServlet("/posts/create")
public class PostsCreateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostsCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _token = (String)request.getParameter("_token");
        if(_token != null && _token.equals(request.getSession().getId())) {
            EntityManager em = DBUtil.createEntityManager();

            Post p = new Post();

            p.setEmployee((Employee)request.getSession().getAttribute("login_employee"));

            Date post_date = new Date(System.currentTimeMillis());
            String rd_str = request.getParameter("post_date");
            if(rd_str != null && !rd_str.equals("")) {
                post_date = Date.valueOf(request.getParameter("post_date"));
            }
            p.setPost_date(post_date);

            p.setTitle(request.getParameter("title"));
            p.setContent(request.getParameter("content"));
            p.setSource_code(request.getParameter("source_code"));
            Timestamp currentTime = new Timestamp(System.currentTimeMillis());
            p.setCreated_at(currentTime);
            p.setUpdated_at(currentTime);

            Employee login_employee = (Employee)request.getSession().getAttribute("login_employee");
            List<Post> posts = em.createNamedQuery("getMyAllPosts", Post.class)
                    .setParameter("employee", login_employee)
                    .getResultList();


            List<String> errors = PostValidator.validate(p);
            if(errors.size() > 0) {
                em.close();

                request.setAttribute("_token", request.getSession().getId());
                request.setAttribute("post", p);
                request.setAttribute("errors", errors);
                request.setAttribute("posts", posts);

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/posts/postTop.jsp");
                rd.forward(request, response);
            } else {
                em.getTransaction().begin();
                em.persist(p);
                em.getTransaction().commit();
                em.close();
                request.getSession().setAttribute("flush", "登録が完了しました。");
                request.setAttribute("posts", posts);

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/posts/postTop.jsp");
                rd.forward(request, response);
            }
        }
    }

}
