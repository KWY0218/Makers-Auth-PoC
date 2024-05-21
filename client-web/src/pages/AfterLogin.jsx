import React from 'react'
import { useLocation } from 'react-router-dom';

const AfterLogin = () => {
  const query = new URLSearchParams(useLocation().search);
  const code = query.get('code');


  const receivePlatformAuthCode = async (code) => {
    window.location.href = `http://localhost:8081/login?grantType=authorizationCode&code=${code}&clientId=clientId&redirectUri=redirectUri`;

  }

  return (
    <div>
      <h1>인가코드를 받아온 뒤 화면</h1>
      <button onClick={() => receivePlatformAuthCode(code)}>플랫폼 코드 전달하기</button>
    </div>
  )
}

export default AfterLogin