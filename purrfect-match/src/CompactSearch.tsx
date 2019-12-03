import React from 'react';
import { Modal } from "./Modal";
import { Redirect } from "react-router-dom";
import cat from "./pictures/cat5.jpg";

interface compactSearchProps {
    name: string;
    breed: string;
    age: string;
    gender: string;
    bio: string;
    daysLeft: number;
};

interface compactSearchState {
    modalOpen: boolean;
};

export class CompactSearch extends React.Component<compactSearchProps, compactSearchState> {
   
    constructor(props: any) {
        super(props);

        this.state = {
            modalOpen: false
        };
    }

    public render() {

        var compactClass = "compactSearch";
        if (this.props.daysLeft < 31) {
            compactClass = "compactSearchRisk"
        }
        
        return (
            <div>
                <button className={compactClass} onClick={() => { this.setState({ modalOpen: true }) }}>
                    <img id="animalImage" src={cat} alt="Image of animal"/>
                    <h1 id="animalName">
                        {this.props.name}
                    </h1>
                    <p id="animalInfo">
                        Breed: {this.props.breed}
                        <br/> Age: {this.props.age} 
                        <br/> Gender: {this.props.gender}
                    </p>
                </button>
                
                <Modal display={this.state.modalOpen} onClose={() => this.setState({ modalOpen: false })}>
                    <img id="successStoryPageImage" src={cat} alt="Cat"/> 
                    <div id="successStoryPageText">
                        <h1 id="successStoryPageHeader"> 
                            Name: {this.props.name}
                            <br />Age: {this.props.age}
                            <br />Breed: {this.props.breed}
                            <br />Gender: {this.props.gender}
                            <br />
                            <br />
                            About {this.props.name}:
                        </h1>
                        <p> 
                            {this.props.bio}
                        </p>
                    </div>
                </Modal>
            </div>
        )
    }

}