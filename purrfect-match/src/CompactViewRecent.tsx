import React from 'react';
import { Modal } from "./Modal";
import { RecentlyAdoptedInfo } from "Definitions"
import cat from "./pictures/cat5.jpg";

interface compactViewProps {
    info: RecentlyAdoptedInfo;
};

interface compactViewState {
    modalOpen: boolean;
};

export class CompactViewRecent extends React.Component<compactViewProps, compactViewState> {
   
    constructor(props: any) {
        super(props);

        this.state = {
            modalOpen: false
        };
    }

    public render() {
        return (
            <div>
                <button className="compactView" onClick={() => { this.setState({ modalOpen: true }) }}>
                    <img id="animalImage" src={cat} alt="Image of animal"/>
                    <h1 id="animalName">
                        {this.props.info.name}
                    </h1>
                    <p id="animalInfo">
                        Breed: {this.props.info.breed}
                        <br/> Age: {this.props.info.age} 
                        <br/> Gender: {this.props.info.gender}
                    </p>
                </button>
                
                <Modal display={this.state.modalOpen} onClose={() => this.setState({ modalOpen: false })}>
                    <img id="successStoryPageImage" src={cat} alt="Cat"/> 
                    <div id="successStoryPageText">
                        <h1> 
                            Name: {this.props.info.name} 
                            <br />Age: {this.props.info.age}
                            <br />Breed: {this.props.info.breed}
                            <br />Adopted: {this.props.info.adoptionDate}
                            <br />
                        </h1>
                    </div>
                </Modal>
            </div>
        )
    }

}
