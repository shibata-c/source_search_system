<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:if test="${errors != null}">
    <div id="flush_error">
        入力内容にエラーがあります。<br />
        <c:forEach var="error" items="${errors}">
            ・<c:out value="${error}" /><br />
        </c:forEach>

    </div>
</c:if>
<label for="title">投稿タイトル</label><br />
<input type="text" name="title" value="${post.title}" />
<br /><br />

<label for="content">投稿内容</label><br />
<textarea name="content" rows="10" cols="50">${post.content}</textarea>
<br /><br />

<label for="source_code">ソースコード</label><br />
<textarea name="source_code"rows="10"cols="50">${post.source_code}</textarea>

<input type="hidden" name="_token" value="${_token}" />
<br />
<button type="submit">投稿</button>