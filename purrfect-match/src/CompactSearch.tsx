import React from 'react';
import { Modal } from "./Modal";
import { Redirect } from "react-router-dom";

interface compactSearchProps {
    name: string;
    breed: string;
    age: string;
    gender: string;
    bio: string;
    daysLeft: number | undefined;
    photo: string;
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
        if (this.props.daysLeft) {
            compactClass += " compactRisk";
        }
        
        return (
            <div>
                <button className={compactClass} onClick={() => { this.setState({ modalOpen: true }) }}>
                    <img id="animalImage" src={this.props.photo} alt="Image of animal"/>
                    <h1 id="animalName">
                        {this.props.name}
                    </h1>
                    <p id="animalInfo">
                        Breed: {this.props.breed}
                        <br/> Age: {this.props.age} 
                        <br/> Gender: {this.props.gender}
                    </p>
        { compactClass === "compactSearch" ? '' : <p className='risk'>!</p> }
                </button>
                
                <Modal display={this.state.modalOpen} onClose={() => this.setState({ modalOpen: false })}>
                    <img id="successStoryPageImage" src={this.props.photo} alt="Cat"/> 
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