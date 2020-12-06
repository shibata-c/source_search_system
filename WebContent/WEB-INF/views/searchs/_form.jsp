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
<div class="search_box">
    <form class="simple_form search" action="/searchs/search"accept-charset="UTF-8"method="get">
        <div class="form-group search required search_keyword">
            <input class="form-control string search required"required="required"aria-required="true"placeholder="キーワード"type="search"name="keyword"id="search_keyword">
        </div>
        <input type="submit"name="commit"value="検索"class="btn btn-sm btn-primary btn-search"data-disable-with="検索">
        <input type="hidden" name="_token" value="${_token}" />
    </form>
</div>