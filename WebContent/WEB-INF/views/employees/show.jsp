<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <div id="usershow">
        <c:choose>
            <c:when test="${employee != null}">
                <h2> ${employee.name} さんの詳細ページ</h2>
                <table class="user_show">
                    <tbody>
                        <tr>
                            <th>USER ID</th>
                            <td><c:out value="${employee.id}" /></td>
                        </tr>
                        <tr>
                            <th>氏名</th>
                            <td><c:out value="${employee.name}" /></td>
                        </tr>
                        <tr>
                            <th>登録日時</th>
                            <td>
                                <fmt:formatDate value="${employee.created_at}" pattern="yyyy-MM-dd HH:mm:ss" />
                            </td>
                        </tr>
                    </tbody>
                </table>

                <p class="user_show"><a href="<c:url value='/employees/edit?id=${employee.id}' />">この個人情報を編集する</a></p>
            </c:when>
            <c:otherwise>
                <h2>お探しのデータは見つかりませんでした。</h2>
            </c:otherwise>
        </c:choose>
        <br /><br /><br />

        <h2 class="user_post">投稿一覧</h2>
        <div id="user_posttop_comment">
                <table id="user_posttop_table">
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

        <h2 class="user_question_list">質問一覧</h2>
        <div id="user_question_comment">
            <table class="user_questiontop_table">
                <c:forEach var="question" items="${question}" varStatus="status">
                    <tbody>
                           <tr><td><c:out value="${question.employee.name}" /></td></tr>
                           <tr><td><fmt:formatDate value="${question.created_at}" pattern="yyyy-MM-dd HH:mm:ss" /></td></tr>
                           <tr><td><c:out value="${question.content}"></c:out></td></tr>
                    </tbody>
                </c:forEach>
            </table>
        </div>
</div>

        <p><a href="<c:url value='/index.html' />">トップページに戻る</a></p>
        <p><a href="<c:url value='/employees/index' />">USER 一覧</a></p>
    </c:param>
</c:import>