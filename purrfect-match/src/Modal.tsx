import React from 'react';

interface ModalProps {
    display: boolean;
    onClose: () => void;
};

interface ModalState {

};

export class Modal extends React.Component<ModalProps, ModalState> {

    public render() {
        if (!this.props.display) {
            return null;
        }
        return (<div className="modal-overlay" onClick={() => this.props.onClose()}>
            <div className="modal" onClick={(e) => e.stopPropagation()}>
                <div><button className="modal-close" onClick={() => this.props.onClose()} >X</button></div>
                <div className="modal-content">
                    {this.props.children}
                </div>
            </div>
        </div>);
    }

}


