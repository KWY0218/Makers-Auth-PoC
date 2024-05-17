import React from "react"

function Login() {
    const SUCCESS_URL = "http://localhost:8080/authorize?code=1234&client_id=client_id&redirect_url=http://localhost:3001";
    const FAIL_URL = "http://localhost:8080/authorize?code=1&client_id=client_id&redirect_url=http://localhost:3001";
    const getAuthorizeCode = (url) => {
        fetch(url)
            .then(response => response.json())
            .then(data => {
                console.log(data);
                // 여기서 data를 처리합니다.
            })
            .catch(error => {
                console.error('Error:', error);
            });
    };

    return (
        <div className="login-container">
            <h1>플랫폼 로그인</h1>
            <button onClick={() => getAuthorizeCode(SUCCESS_URL)}>소셜로그인 성공</button>
            <button onClick={() => getAuthorizeCode(FAIL_URL)}>소셜로그인 실패</button>
        </div>
    )
}

export default Login;
