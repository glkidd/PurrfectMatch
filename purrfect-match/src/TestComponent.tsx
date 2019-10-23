import React from 'react';

// Interfaces here act like structs in C: they just define what data will appear in them
interface TestProps {
    // data: string; means we have a variable named data, of type string.
    data: string;
    // Using a ? at the end of a variable name makes it optional, so extra doesn't need to be passed in, but can be.
    extra?: string;
};

interface TestState {

};

// Create a new component definition.
export class Test extends React.Component<TestProps, TestState> {

    public render() {
        // Render shouldn't change state or rely on anything outside the state, or else you'll get weird behavior.
        if (Math.random() > 0.5) {
            return (<div>Oh no!</div>);
        }
        // Display something, using some of the data passed in. 
        return (<div>Child component test: the data passed in was {this.props.data} </div>);
    }

}