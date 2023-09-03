<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Instagram</title>
    <link rel="stylesheet" href="/static/css/style.css">
    <link rel="stylesheet" href="/static/css/feed.css">
    <link rel="shortcut icon" href="/static/images/insta.svg">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
          integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous" />
</head>
    <body>
        <main class="main">
            <section class="container">
                <!--전체 리스트 시작-->
                <section class="container">
                    <!--전체 리스트 시작-->
                    <article class="story-list" id="feed_list">
                        <c:forEach var="image" items="${images}">
                            <!--피드 박스-->
                            <div class="story-list__item">

                                <!--리스트 아이템 헤더영역-->
                                <div class="sl__item__header">
                                    <div>
                                        <img src="../../../static/upload/${principal.profileImage}" alt="">
                                        <svg viewbox="0 0 110 110">
                                            <circle cx="55" cy="55" r="53" />
                                        </svg>
                                    </div>
                                    <div>${image.userInfo.name}</div>
                                </div>
                                <!--헤더영역 end-->

                                <!--게시물이미지 영역-->
                                <div class="sl__item__img">
                                    <img src="../../../static/upload/${image.postImageUrl}" alt="">
                                </div>

                                <!--게시물 내용 + 댓글 영역-->
                                <div class="sl__item__contents">
                                    <!-- 하트모양 버튼 박스 -->
                                    <div class="sl__item__contents__icon">
                                        <button onclick="clickBtn()">
                                            <i class="far fa-heart"></i>
                                        </button>
                                    </div>
                                    <!-- 하트모양 버튼 박스 end -->

                                    <!--좋아요-->
                                    <span class="like"><b>1</b>likes</span>
                                    <!--좋아요end-->

                                    <!--태그박스-->
                                    <div class="sl__item__contents__tags">
                                        <p>${image.tagName}</p>
                                    </div>
                                    <!--태그박스end-->

                                    <!--게시글내용-->
                                    <div class="sl__item__contents__content">
                                            <%--                            <p>${image.caption}</p>--%>

                                    </div>
                                    <!--게시글내용end-->

                                    <!--댓글박스-->
                                    <div>
                                        <div class="sl__item__contents__comment">
                                            <p>
                                                <b>${image.userInfo.name}</b> ${image.content}
                                            </p>
                                            <button>
                                                <i class="fas fa-times"></i>
                                            </button>
                                        </div>
                                    </div>
                                    <!--댓글박스end-->

                                    <!--댓글입력박스-->
                                    <div class="sl__item__input">
                                        <input type="text" placeholder="댓글 달기...">
                                        <button>게시</button>
                                    </div>
                                    <!--댓글달기박스end-->
                                </div>
                            </div>
                        </c:forEach>

                    </article>
                </section>
            </section>
        </main>
        <script src="/js/image.js"></script>
        <script src="/js/comment.js"></script>
        <script src="/js/like.js"></script>

    </body>
</html>
