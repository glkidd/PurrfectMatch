import React from 'react';
import { Modal } from "./Modal";
import { Redirect } from "react-router-dom";
import { ShelterAccountInfo } from "./Definitions";
import { Spinner } from "./Spinner";
import { Api } from 'Api';

interface compactSearchProps {
    name: string;
    breed: string;
    age: string;
    gender: string;
    bio: string;
    daysLeft: number | undefined;
    photo: string;
    shelterId: number;
};

interface compactSearchState {
    modalOpen: boolean;
    shelterAccount: ShelterAccountInfo | undefined;
};

export class CompactSearch extends React.Component<compactSearchProps, compactSearchState> {
   
    constructor(props: any) {
        super(props);

        this.state = {
            modalOpen: false,
            shelterAccount: undefined
        };
    }

    private getShelterAccountInfo(shelterId: number) {
        Api.getShelterAccountInfo(shelterId).then((shelterAccount: ShelterAccountInfo) => {
            this.setState( {shelterAccount: shelterAccount} );
        });
    }

    public render() {

        var compactClass = "compactSearch";
        if (this.props.daysLeft) {
            compactClass += " compactRisk";
        }

        let shelterDisplay = <div className="searchSpinner"> <Spinner/> </div>;
        if (this.state.shelterAccount !== undefined) {
            shelterDisplay =
                (<div className="shelterInfo"> 
                    Shelter: {this.state.shelterAccount.shelterName}
                    <br />Phone: {this.state.shelterAccount.phoneNumber}
                    <br />Website: {this.state.shelterAccount.website}
                    <br />Email: {this.state.shelterAccount.email}
                    <br />Address: 
                    <br />{this.state.shelterAccount.street}
                    <br />{this.state.shelterAccount.city}, {this.state.shelterAccount.state} {this.state.shelterAccount.zipCode}
                    <br />
                </div>);
        }
        
        return (
            <div>
                <button className={compactClass} onClick={() => { this.setState({ modalOpen: true }); this.getShelterAccountInfo(this.props.shelterId); }}>
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
                            <br  /> <div className="redText" > {this.props.daysLeft ? "At risk for euthanasia!" : ""} </div>
                            <br />Find this animal here:
                            <br /> {shelterDisplay}
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