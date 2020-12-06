<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="../layout/app.jsp">
    <c:param name="content">
    <div id="questiontop">
        <form class="question_top" method="POST" action="<c:url value='/questions/create' />">
            <c:import url="_form.jsp" />
        </form>
            <h3 class="questiontop_question">質問一覧</h3>
            <div id="question_comment">
                <table class="questiontop_table">
                <c:forEach var="question" items="${question}" varStatus="status">
                    <tbody>
                           <tr><td><c:out value="${question.employee.name}" /></td></tr>
                           <tr><td><fmt:formatDate value="${question.created_at}" pattern="yyyy-MM-dd HH:mm:ss" /></td></tr>
                           <tr><td><c:out value="${question.content}"></c:out></td></tr>
                    </tbody>
                </c:forEach>
                </table>
            </div>
        <p><a href="<c:url value='/index.html' />">トップページに戻る</a></p>
        </div>
    </c:param>
</c:import>