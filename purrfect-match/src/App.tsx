import React from 'react';
import './App.css';
import { Page1 } from "./Page1";

interface AppState {
    page: JSX.Element | null;
}

class App extends React.Component<{}, AppState> {

    constructor(props: any) {
        super(props);
        this.state = {
            page: null
        };
    }

    public render() {
        if (this.state.page === null) {
            return (
                <div className="App">
                    <button
                        onClick={() => {
                            this.setState({ page: (<Page1 />) });
                        }}
                    >Test Page 1</button>
                </div>
            );
        }
        return this.state.page;
    }
}

export default App;
