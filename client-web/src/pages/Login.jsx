import React from "react";

function Login() {
    const loginPlayground = () => {
        // 페이지 이동
        window.location.href = `http://localhost:3000/login?clientId=${process.env.REACT_APP_CLIENT_ID}&redirectUri=${process.env.REACT_APP_REDIRECT_URI}`;
    };

    return (
        <div>
            <h1>클라이언트 로그인 화면</h1>
            <button onClick={loginPlayground}>플레이그라운드 로그인</button>
        </div>
    );
}

export default Login;
