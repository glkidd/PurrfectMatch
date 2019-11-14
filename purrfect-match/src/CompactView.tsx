import React from 'react';
import { Modal } from "./Modal";
import { Redirect } from "react-router-dom";
import cat from "./pictures/cat5.jpg";

interface compactViewProps {
    name: string;
    breed: string;
    age: string;
    gender: string;
};

interface compactViewState {
    modalOpen: boolean;
};

export class CompactView extends React.Component<compactViewProps, compactViewState> {
   
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
                    Name: Ollie
                    <br />Age: 3 years
                    <br />Breed: American Shorthair
                    <br />Adopted: 10/24/2019
                    <br />
                    <br />
                    A message from Ollie's owner, Bob:
                </h1>
                <p> 
                    Ollie has been a real friend! Coming home from a crazy day at work, I get to look forward to this goofball greeting me with lots of purring and cuddles. I found Ollie through Purrfect Match. I couldn’t go to my local shelter without first knowing if I had a specific pet in mind, because I can’t be away from work for very long during business hours. Perrfect Match helped me find Ollie, and I’m so happy he’s in my life! He’s a cutie, and I can’t imagine not having found him.
                </p>
            </div>
            </Modal>
            
            </div>
        )
    }

}
