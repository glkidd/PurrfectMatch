import React from 'react';
import { Modal } from "./Modal";
import { Input, Select, Message, Send } from './inputBoxes';


interface submissionBoxProps {

};

interface submissionBoxState {
    modalOpen: boolean;
};

export class SubmissionBox extends React.Component<submissionBoxProps, submissionBoxState> {

    constructor(props: any) {
        super(props);

        this.state = {
            modalOpen: false
        };
    }

    public render() {
        return (
            <div>
                <button className="submissionBoxButton" onClick={() => { this.setState({ modalOpen: true }) }} >
                    <div>
                        Add a success story
                    </div>
                </button>

                <Modal display={this.state.modalOpen} onClose={() => this.setState({ modalOpen: false })} >
                    <div className="submissionBoxContent">
                        <div id="submissionBoxHeader">
                            <p> Tell us the story of how you found your purrfect match! </p>
                            <p> Help inspire others by sharing anything you'd like about using our website to find your pet, the adoption process or any fun stories you may have about your new four-legged family member. </p>

                        </div>

                        <div id="submissionBoxInputs">
                            <Input id="nameField" prompt="Name:"></Input>
                            <Input id="petNameField" prompt="Pet's name:"></Input>
                            <Input id="breedField" prompt="Breed:"></Input>
                            <Input id="ageField" prompt="Age:"></Input>
                            <Input id="genderField" prompt="Gender:"></Input>
                            <Input id="dateOfAdoptionField" prompt="Date of adoption:"></Input>
                            <Message id="storyField" prompt="Share your story:"></Message>
                        </div>
                    </div>


                </Modal>

            </div>


        )

    }


}

