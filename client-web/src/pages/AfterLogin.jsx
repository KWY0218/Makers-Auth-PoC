import React, {useEffect} from 'react';
import { useLocation } from 'react-router-dom';
import { instance } from '../config/axios';


const AfterLogin = () => {
  const query = new URLSearchParams(useLocation().search);
  const code = query.get('code');

  const receivePlatformAuthCode = async (code) => {
    try {
      const params = new URLSearchParams();
      params.append('grantType', 'authorizationCode')
      params.append('code', code)
      params.append('clientId', process.env.REACT_APP_CLIENT_ID)
      params.append('redirectUri', process.env.REACT_APP_REDIRECT_URI)

      const response = await instance.post('/token', params);
      console.log('Response:', response.data);
      localStorage.setItem('accessToken', JSON.stringify(response.data));
      // 필요한 후속 작업을 여기에 추가합니다.
      window.location.href = 'http://localhost:3001/mainPage';
    } catch (error) {
      console.error('Error during the request:', error);
    }
  }

  useEffect(() => {
    if (code) {
      receivePlatformAuthCode(code);
    }
  }, [code]);

  return (
    <div>
      <h1>인가코드를 받아온 뒤 화면</h1>
    </div>
  );
}

export default AfterLogin;
