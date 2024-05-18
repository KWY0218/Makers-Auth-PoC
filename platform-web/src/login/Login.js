import React from "react"

function Login() {

    const successCase = () => {
        window.location.href = "http://localhost:8080/authorize?code=1234&client_id=client_id&redirect_url=http://localhost:3001";
    };
    const failCase = () => {
        window.location.href = "http://localhost:8080/authorize?code=1&client_id=client_id&redirect_url=http://localhost:3001";
    };

    return (
        <div className="login-container">
            <h1>플랫폼 로그인</h1>
            <button onClick={() => successCase()}>소셜로그인 성공</button>
            <button onClick={() => failCase()}>소셜로그인 실패</button>
        </div>
    )
}

export default Login;
