import React from 'react';
import { Modal } from "./Modal";
import { Input, Select, Message, Send } from './inputBoxes';
import { ShelterPetInfo } from "./Definitions";


interface shelterPetEditModalProps {
    edit: boolean;
    cat: boolean;
    dog: boolean;
    otherAnimal: boolean;
    animalInfo: ShelterPetInfo;
};

interface shelterPetEditModalState {
    modalOpen: boolean;
};

export class ShelterPetEditModal extends React.Component<shelterPetEditModalProps, shelterPetEditModalState> {

    constructor(props: any) {
        super(props); // this includes a boolean to determine the title of pop up

        this.state = {
            modalOpen: false
        };
    }

    public render() {

        const aType = this.props.cat ? "Cat" : this.props.dog ? "Dog" : "Other Animal";

        return (
            <div>
                <button className="submissionBoxButton" onClick={() => { this.setState({ modalOpen: true}) }} >
                    <div> Edit pet </div>
                </button>

                <Modal display={this.state.modalOpen} onClose={() => this.setState({ modalOpen: false }) } >
                    <div className="submissionBoxContent"> 
                        <div id="submissionBoxHeader">
                            {this.props.edit ? <p> Edit {aType} </p> : <p> View {aType} </p>}
                            <br />
                        </div>

                        <div id="submissionBoxInputs">
                            <Input prompt="Pet's name:"></Input>
                            insert dropdowns for month day year
                            insert drop down for breed + dropdown for Gender
                            insert dropDown for fur length
                            insert dro down for mdy (date arrived)
                            insert drop down for mdy (euthanasia date)
                            <Message prompt="Bio:"></Message>
                        </div>
                    </div>


                </Modal>

            </div>


        )

    }


}