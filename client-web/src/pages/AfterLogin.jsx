import React from 'react'
import { instance } from '../config/axios'
import { useLocation } from 'react-router-dom';

const AfterLogin = () => {
  const query = new URLSearchParams(useLocation().search);
  const code = query.get('code');


  const receivePlatformAuthCode = async (code) => {
    const res = await instance.get(`/login`);
    console.log(res.data);
  }

  return (
    <div>
      <h1>인가코드를 받아온 뒤 화면</h1>
      <button onClick={() => receivePlatformAuthCode(code)}>플랫폼 코드 전달하기</button>
    </div>
  )
}

export default AfterLogin