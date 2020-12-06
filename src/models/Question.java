package models;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "questions")
@NamedQueries({
    @NamedQuery(
            name = "getAllQuestions",
            query = "SELECT q FROM Question AS q ORDER BY q.id DESC"
            ),
    @NamedQuery(
            name = "getQuestionsCount",
            query = "SELECT COUNT(q) FROM Question AS q"
            ),
    @NamedQuery(
            name = "getMyAllQuestions",
            query = "SELECT q FROM Post AS q WHERE q.employee = :employee ORDER BY q.id DESC"
            ),
    @NamedQuery(
            name = "getMyQuestionsCount",
            query = "SELECT COUNT(q) FROM Question AS q WHERE q.employee = :employee"
            )
})
@Entity
public class Question {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @Column(name = "question_date", nullable = false)
    private Date question_date;

    @Lob
    @Column(name = "content", nullable = true)
    private String content;

    @Lob
    @Column(name = "source_code", nullable = true)
    private String source_code;

    @Lob
    @Column(name="code",nullable=true)
    private String code;

    @Column(name = "created_at", nullable = false)
    private Timestamp created_at;

    @Column(name = "updated_at", nullable = false)
    private Timestamp updated_at;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getQuestion_date() {
        return question_date;
    }

    public void setQuestion_date(Date question_date) {
        this.question_date = question_date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    public String getSource_code() {
        return source_code;
    }

    public void setSource_code(String source_code) {
        this.source_code = source_code;
    }
}
