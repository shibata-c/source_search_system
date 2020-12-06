<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <c:if test="${flush != null}">
            <div id="flush_success">
                <c:out value="${flush}"></c:out>
            </div>
        </c:if>
        <div class="index">
        <img class="backgroud" src='<c:url value='/img/top_img.jpg' />'>
        <h3 class="overview">webサイト概要</h3>
        <p class="overview">このウェブサイトでは様々な目的用途に沿ったソースコードを簡単に検索できるよう、実装したい動作やソースコードの一部から目的に沿ったソースコードを検索するためのシステムです。
また、ログイン登録を行い実装できないソースを質問し、それを回答した方には実績を付与し、質問された方はその内容と実行可能になったソースコードを投稿することで実績が付与されます。</p>
       <div id="index_comment">
        <table>
            <tbody>
                <tr>
                    <th class="report_name">氏名</th>
                    <th class="report_date">日付</th>
                    <th class="report_title">タイトル</th>
                    <th class="report_iine">いいね！</th>
                    <th class="report_action">操作</th>

                </tr>
                <c:forEach var="post" items="${posts}" varStatus="status">
                    <tr class="index_table">
                        <td class="post_name"><c:out value="${post.employee.name}" /></td>
                        <td class="post_date"><fmt:formatDate value='${post.post_date}' pattern='yyyy-MM-dd' /></td>
                        <td class="post_title">${post.title}</td>

                        <td class="post_iine"><!-- いいね！ボタンの追加 -->
                            <a href="#!" onclick="confirmIine(${status.count-1});"><img width=5px class="iine_image"alt="いいね！" src="data:image/png;base64,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"></a>
                            :<c:out value="${post.iine_count}"/>
                            <form method="POST" action="${pageContext.request.contextPath}/top/page/iine">
                            <!-- csrf対策 -->
                            <input type="hidden" name="id"value="${post.id}">
                            <input type="hidden" name="_token" value="${_token}" />
                            </form>

                            <script>
                            function confirmIine(count){
                                if(confirm("いいね！しますか？"))
                                    document.forms[count].submit();
                                }
                            </script>
                        </td>
                        <td class="report_action"><a href="<c:url value='/posts/show?id=${post.id}' />">詳細を見る</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        </div>
        </div>

        <ul>
            <li class="index_source"><a href="<c:url value='/searchs/index' />"><img class="img_index" src='<c:url value='/img/search_logo.jpg' />'></a></li>
            <li class="index_question"><a href="<c:url value='/question/new' />"><img class="img_index" src='<c:url value='/img/question_logo.jpg' />'></a></li>
            <li class="index_post"><a href="<c:url value='/posts/new' />"><img class="img_index" src='<c:url value='/img/post_logo.jpg' />'></a></li>
            <li class="index_user"><a href="<c:url value='/employees/show?id=${sessionScope.login_employee.id}' />"><img class="img_index" src='<c:url value='/img/user_logo.jpg' />'></a></li>
        </ul>
    </c:param>
</c:import>