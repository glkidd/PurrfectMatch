import React from 'react';

interface TestProps {
};

interface TestState {

};

export class Modal extends React.Component<TestProps, TestState> {

    public render() {
        return (<div className="modal-overlay">
            <div className="modal">
                text here
            </div>
        </div>);
    }

}


