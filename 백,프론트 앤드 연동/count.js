import React,{useState} from "react";

function Example(){

    //배열 구조분해
    const[count,setCount] = useState(0);
    
    // let countArray = useState(0);
    // let count = countArray[0];
    // let setCount = countArray[1];

    return(
        <div>
            <p> click {count} times</p>
            {/* 버튼을 누르면 count값을 변화시키고 Example 컴포넌트에 넘기며
            재렌더링을 한다. */}
            <button onClick={()=> setCount(count+1)}>Click me</button>
        </div>
    )
}
export default Example;