import React from 'react';
import { Modal } from "./Modal";
import { Redirect } from "react-router-dom";

interface tipsProps {
    title: string;
    content: string;
};

interface tipsState {
    modalOpen: boolean;
};

export class TipsSideBar extends React.Component<tipsProps, tipsState> {
   
    constructor(props: any) {
        super(props);

        this.state = {
            modalOpen: false
        };
    }

    public render() {
        return (
            <div>
                <button className="sideBarContainer" onClick={() => { this.setState({ modalOpen: true }) }}>
                    <h1 className="sideBarTitle">
                        {this.props.title}
                    </h1>
                    <p>
                        {this.props.content}
                    </p>
                </button>
                
                <Modal display={this.state.modalOpen} onClose={() => this.setState({ modalOpen: false })}>
                    <div id="searchResultsPageText">
                        <h2 className="sideBarTitle">
                            {this.props.title}
                        </h2>
                        <p> 
                            {this.props.content}
                        </p>
                    </div>
                </Modal>
            </div>
        )
    }

}