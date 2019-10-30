import React from 'react';
import { Modal } from "./Modal";

interface PageProps {
};

interface PageState {

};

export class Page1 extends React.Component<PageProps, PageState> {

    public render() {
        return (
            <div className="bgred">
                <span>Data goes here</span>
                <Modal />
                <div> More text is going here <br /> with breaks in it and more text and maybe a <button /> because why not </div>s 
            </div>);
    }

}


