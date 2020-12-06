<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <div class="posttop">
        <h2>投稿ホーム</h2>
        <form method="POST" action="<c:url value='/posts/create' />">
            <c:import url="_form.jsp" />
        </form>
        <h3 class="posttop_post">投稿一覧</h3>
            <div id="posttop_comment">
                <table id="posttop_table">
                    <tbody >
                        <tr>
                            <th>氏名</th>
                            <th>投稿日時</th>
                            <th>内容</th>
                            <th>ソースコード</th>
                        </tr>
                        <c:forEach var="post" items="${posts}" varStatus="status">

                            <tr>
                                <td><c:out value="${post.employee.name}" /></td>
                                <td>
                                    <fmt:formatDate value="${post.created_at}" pattern="yyyy-MM-dd HH:mm:ss" />
                                </td>
                                <td><c:out value="${post.content}"></c:out></td>
                                <td><c:out value="${post.source_code}"></c:out></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        <p><a href="<c:url value='/index.html' />">トップページに戻る</a></p>
        </div>
    </c:param>
</c:import>