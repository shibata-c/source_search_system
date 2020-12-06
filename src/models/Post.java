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

@Table(name = "posts")
@NamedQueries({
    @NamedQuery(
            name = "getAllPosts",
            query = "SELECT p FROM Post AS p ORDER BY p.id DESC"
            ),
    @NamedQuery(
            name = "getPostsCount",
            query = "SELECT COUNT(p) FROM Post AS p"
            ),
    @NamedQuery(
            name = "getMyAllPosts",
            query = "SELECT p FROM Post AS p WHERE p.employee = :employee ORDER BY p.id DESC"
            ),
    @NamedQuery(
            name = "getMyPostsCount",
            query = "SELECT COUNT(p) FROM Post AS p WHERE p.employee = :employee"
            ),
    @NamedQuery(
            name="getSearchPosts",
            query="SELECT p FROM Post AS p WHERE p.title like :search or p.content like :search"
            )
})
@Entity
public class Post {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @Column(name = "post_date", nullable = false)
    private Date post_date;

    @Column(name = "title", length = 255, nullable = false)
    private String title;

    @Lob
    @Column(name = "content", nullable = false)
    private String content;

    @Lob
    @Column(name = "source_code", nullable = false)
    private String source_code;

    @Lob
    @Column(name="code",nullable=true)
    private String code;

    @Column(name = "created_at", nullable = false)
    private Timestamp created_at;

    @Column(name = "updated_at", nullable = false)
    private Timestamp updated_at;

    @Column(name = "iine_count", nullable = true)
    private Integer iine_count = 0;


    public Integer getIine_count() {
        return iine_count;
    }

    public void setIine_count(Integer iine_count) {
        this.iine_count = iine_count;
    }

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

    public Date getPost_date() {
        return post_date;
    }

    public void setPost_date(Date post_date) {
        this.post_date = post_date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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