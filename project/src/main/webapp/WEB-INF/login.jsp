<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<!-- 반응형 웹 설정 -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>SUPPHOTO - 로그인</title>
<link rel="stylesheet" href="./assets/css/login.css">
<!-- Font Awesome CDN -> 아이콘 사용 -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>
	<div class="login-container">
		<header class="logo">
			<h1>SUPPHOTO</h1>
			<p>얼굴만 찍어,</p>
			<p>나머진 서포토가 해줄게</p>
		</header>

		<form class="login-form">
			<div class="input-group">
				<label for="username"> <i class="fas fa-user"></i> 아이디
				</label> <input type="text" id="username" placeholder="아이디를 입력해 주세요.">
			</div>

			<div class="input-group password-group">
				<label for="password"> <i class="fas fa-lock"></i> 비밀번호
				</label>
				<div class="password-input-wrapper">
					<input type="password" id="password" placeholder="비밀번호를 입력해 주세요.">
					<button type="button" class="show-password-btn">비밀번호 표시</button>
				</div>
			</div>

			<button type="submit" class="login-btn">로그인</button>
		</form>

		<div class="link-footer">
			<a href="">아이디 찾기</a> <span>|</span> <a href="">비밀번호 찾기</a> <span>|</span>
			<a href="Gojoin.do">회원가입</a>
		</div>
		<!-- fas (solid) , fab (brands) -->
		<div class="social-login">
			<button class="social-icon naver" onclick="location.href='NaverLogin.do'">
				<img src="./assets/img/n-logo.png" alt="Naver Logo" class="social-img" style="border-radius:50%;">
			</button>
			<button class="social-icon kakao" href="KakaoLogin.do">
				<i class="fas fa-comment"></i>
			</button>
			<button class="social-icon google" href="GoogleLogin.do">
				<img src="./assets/img/g-logo.png" alt="Google Logo" class="social-img">
			</button>
			<a href=""></a>
		</div>



	</div>
	<script src="./assets/js/login.js"></script>
</body>
</html>