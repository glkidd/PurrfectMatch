import React from 'react';
import { Modal } from "./Modal";
import { Redirect } from "react-router-dom";
import cat from "./pictures/cat5.jpg";

interface SuccessStoryCompactViewProps {
    
};

interface SuccessStoryCompactViewState {
    modalOpen: boolean;
};

export class SuccessStoryCompactView extends React.Component<SuccessStoryCompactViewProps, SuccessStoryCompactViewState> {
   
    constructor(props: any) {
        super(props);

        this.state = {
            modalOpen: false
        };
    }

    public render() {
        return (
            <div className="compactView">
                <img id="animalImage" src={cat} alt="Image of animal"/>

            </div>

        )
    }

}
