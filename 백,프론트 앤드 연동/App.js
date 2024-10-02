import logo from './logo.svg';
import Todo from './Todo'; // Todo 컴포넌트를 import
//import Count from './Count';
import React, { useState,useEffect } from 'react';
import { Container, List, Paper } from "@mui/material";
import './App.css';
import AddTodo from './AddTodo'
import { call } from './service/ApiService';

//컴포넌트
//페이지에 렌더링할 React 엘리먼트를 반환하는 작고 재사용 가능한 코드조각
function App() {
  const [items, setItems] = useState([])


  useEffect(() =>{
  //백엔드에게 요청하기
    call("/todo","GET")
    .then(result => setItems(result.data))
  },[])

  //추가
  //전체 데이터를 App.js에서 관리하기 때문에 함수를
  //App.js에 작성함
  const addItem = (item) => {
    call("/todo","POST",item)
    .then(result => setItems(result.data))
  }

  //내용 수정
  const editItem = (item) => {
   call("/todo","PUT",item)
   .then(result => setItems(result.data))
  }

  //삭제
  const deleteItem = (item) => {
   call("/todo","DELETE",item)
   .then(result => setItems(result.data))
  }
  //App.js에서 Todo에 deleteItem 연결하기


  //map() -> 반복문 안에 들어있는 내용을 하나씩 꺼내서 처리한다.
  //key : 요소의 리스트를 만들 때, React에서 컴포넌트를 렌더링 했을 때
  //어떤 아이템이 변경되었는지 빠르게 감지하기 위해 사용한다.
  //만약 key가 설정되지 않았다면 가상DOM을 순차적으로 비교하면서 감지하기 때문에
  //KEY가 없을때보다 속도가 느리다.
  let todoItems = items.length > 0 && (
    <Paper style={{ margin: 16 }}>
      <List>
        {items.map((item) => (
          <Todo item={item} key={item.id} deleteItem={deleteItem} editItem={editItem}/>
        ))}
      </List>
    </Paper>
  );
  //JSX문법 : 자바스크립트 코드 안에 HTML코드가 들어가는것
  //Babel : JSX로 작성된 자바스크립트를 순수 자바스크립트로 만들어주는 라이브러리
  return (
    <div className="App">
      <Container maxWidth="md">
        <AddTodo addItem={addItem} />
        {/* props를 컴포넌트에 전달하기
      이름={useState값} */}
        <div className="TodoList">
          {todoItems}
        </div>
      </Container>
    </div>
  );
}

//해당 파일에서는 하나의 컴포넌트만을 내보낸다.
//export default 구문을 사용해 내보낸 컴포넌트는 중괄호({})를 사용하지 않고
//불러올 수 있으며, 이름 또한 원하는 이름으로 바꿔서 불러올 수 있다.
export default App;
