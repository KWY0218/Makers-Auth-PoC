import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Login from './pages/Login';
import AfterLogin from './pages/AfterLogin';
import MainPage from "./pages/MainPage";


function Router() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Login />} />
        <Route path="/afterLogin" element={<AfterLogin />} />
        <Route path="/mainPage" element={<MainPage />} />
      </Routes>
    </BrowserRouter>
  );
}

export default Router;