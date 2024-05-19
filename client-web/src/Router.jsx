import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Login from './pages/Login';
import AfterLogin from './pages/AfterLogin';


function Router() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Login />} />
        <Route path="/afterLogin" element={<AfterLogin />} />
      </Routes>
    </BrowserRouter>
  );
}

export default Router;