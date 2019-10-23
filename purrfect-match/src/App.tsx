import React from 'react';
import './App.css';
import { Test } from "./TestComponent";

const App: React.FC = () => {
    return (
        <div className="App">
            <Test data="hi" />
            <Test data={"5"} />
        </div>
    );
}

export default App;
