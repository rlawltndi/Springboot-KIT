import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App'; // App 컴포넌트 import
import reportWebVitals from './reportWebVitals';

//react18 부터 react.render()가 아닌 createRoot()를 먼저 사용
//<컴포넌트 명/>을 이용해 컴포넌트를 사용
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(//reactDOM이 내부 컴포넌트들을 'root'엘리먼드에 render 함
  <React.StrictMode>
    <App />
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
