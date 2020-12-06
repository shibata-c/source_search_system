package controllers.questions;

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
import models.Question;
import models.validators.questionValidator;
import utils.DBUtil;

/**
 * Servlet implementation class QuestionCreateServlet
 */
@WebServlet("/questions/create")
public class QuestionCreateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionCreateServlet() {
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

            Question q = new Question();

            q.setEmployee((Employee)request.getSession().getAttribute("login_employee"));

            Date post_date = new Date(System.currentTimeMillis());
            String rd_str = request.getParameter("post_date");
            if(rd_str != null && !rd_str.equals("")) {
                post_date = Date.valueOf(request.getParameter("post_date"));
            }
            q.setQuestion_date(post_date);

            q.setContent(request.getParameter("content"));
            Timestamp currentTime = new Timestamp(System.currentTimeMillis());
            q.setCreated_at(currentTime);
            q.setUpdated_at(currentTime);

            List<String> errors = questionValidator.validate(q);
            if(errors.size() > 0) {
                em.close();

                request.setAttribute("_token", request.getSession().getId());
                request.setAttribute("post", q);
                request.setAttribute("errors", errors);

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/posts/postTop.jsp");
                rd.forward(request, response);
            } else {
                em.getTransaction().begin();
                em.persist(q);
                em.getTransaction().commit();
                em.close();
                request.getSession().setAttribute("flush", "登録が完了しました。");

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/questions/questionTop.jsp");
                rd.forward(request, response);
            }
        }
    }

}
