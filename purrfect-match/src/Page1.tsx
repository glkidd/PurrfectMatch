import React from 'react';
import { Modal } from "./Modal";

interface PageProps {
};

interface PageState {
    modalOpen: boolean;
};

export class Page1 extends React.Component<PageProps, PageState> {

    constructor(props: any) {
        super(props);

        this.state = {
            modalOpen: false
        };
    }
    public render() {
        return (
            <div className="bgred">
                <span>Data goes here</span>
                <Modal display={this.state.modalOpen} onClose={() => this.setState({ modalOpen: false })}>
                    This is a modal. It can have arbitrary content in it. 
                </Modal>
                <div> More text is going here <br /> with line breaks in it and more text and a <button onClick={() => { this.setState({ modalOpen: true }) }}>button</button> to open the modal </div>
            </div>);
    }

}


