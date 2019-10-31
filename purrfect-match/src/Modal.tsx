import React from 'react';

interface ModalProps {
    display: boolean;
    onClose: () => void
};

interface ModalState {

};

export class Modal extends React.Component<ModalProps, ModalState> {

    public render() {
        if (!this.props.display) {
            return null;
        }
        return (<div className="modal-overlay" onClick={() => this.props.onClose()}>
            <div className="modal" onClick={(e) => e.stopPropagation() }>
                <button className="modal-close" onClick={() => this.props.onClose()} >X</button>
                {this.props.children}
            </div>
        </div>);
    }

}


