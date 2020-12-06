<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <div class="searchtop">
        <h3>検索</h3>
        <form method="GET" action="<c:url value='/searchs/search' />">
            <c:import url="_form.jsp" />
        </form>
        <h3 class="searchtop_search">検索結果一覧</h3>
        <div id="searchtop_comment">
        <c:choose>
            <c:when test="${searchs != null}">

                <table id="searchtop_table">
                    <tbody>
                        <tr>
                            <th>氏名</th>
                            <th>投稿日時</th>
                            <th>内容</th>
                            <th>ソースコード</th>
                            <th>操作</th>
                        </tr>
                        <c:forEach var="search" items="${searchs}" varStatus="status">

                            <tr>
                                <td><c:out value="${search.employee.name}" /></td>
                                <td>
                                    <fmt:formatDate value="${search.created_at}" pattern="yyyy-MM-dd HH:mm:ss" />
                                </td>
                                <td><c:out value="${search.content}"></c:out></td>
                                <td><c:out value="${search.source_code}"></c:out></td>
                                <td class="report_action"><a href="<c:url value='/post/show?id=${search.id}' />">詳細を見る</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:when>
            <c:otherwise>
                <h2>データが存在しません。</h2>
            </c:otherwise>
        </c:choose>
        </div>
        <p><a href="<c:url value='/index.html' />">トップページに戻る</a></p>
        </div>
    </c:param>
</c:import>