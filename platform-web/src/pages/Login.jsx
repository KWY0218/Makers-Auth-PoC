import React from "react";
import axios from "axios";
import { useEffect } from 'react';
import { useLocation } from 'react-router-dom';

function Login() {
    const query = new URLSearchParams(useLocation().search);
    const clientId = query.get('clientId');
    const redirectUri = query.get('redirectUri');

    const successCase = async () => {
        try {
            const response = await axios.get("http://localhost:8080/authorize200", {
                params: {
                    code: "1234",
                    clientId: clientId,
                    redirectUri: redirectUri
                },
                headers: {
                    'Content-Type': 'application/json'
                }
            });
            if (response.status === 200) {
                console.log('Login successful:', response.data);
                window.location.href = `${redirectUri}?code=${response.data.platformCode}`;
            } else {
                alert('로그인에 실패했습니다.');
            }
        } catch (error) {
            console.error("Error during login", error);
            if (error.response && error.response.status === 404) {
                alert('404 에러: 요청한 페이지를 찾을 수 없습니다.');
            } else {
                alert('로그인에 실패했습니다.');
            }
        }
    };

    const failCase = () => {
        alert('로그인에 실패했습니다.');
    };

    return (
        <div className="login-container">
            <h1>플랫폼 로그인</h1>
            <button onClick={() => successCase()}>소셜로그인 성공</button>
            <button onClick={() => failCase()}>소셜로그인 실패</button>
        </div>
    );
}

export default Login;
