import React from 'react';
import { useLocation } from 'react-router-dom';
import { instance } from '../config/axios';


const AfterLogin = () => {
  const query = new URLSearchParams(useLocation().search);
  const code = query.get('code');

  const receivePlatformAuthCode = async (code) => {
    try {
      const response = await instance.get('/login', {
        params: {
          grantType: 'authorizationCode',
          code: code,
          clientId: process.env.REACT_APP_CLIENT_ID,
          redirectUri: process.env.REACT_APP_REDIRECT_URI,
        }
      });
      console.log('Response:', response.data);
      // 필요한 후속 작업을 여기에 추가합니다.
    } catch (error) {
      console.error('Error during the request:', error);
    }
  }

  return (
    <div>
      <h1>인가코드를 받아온 뒤 화면</h1>
      <button onClick={() => receivePlatformAuthCode(code)}>플랫폼 코드 전달하기</button>
    </div>
  );
}

export default AfterLogin;
