import React from 'react';
import './ContactPage.css';
import { Input, Select, Message, Send } from './inputBoxes';

interface ContactPageProps {
};

interface ContactPageState {
};

const OPTION_ARRAY = ["Yes", "No"];

export class ContactPage extends React.Component<ContactPageProps, ContactPageState> {

    constructor(props : any) {
        super(props);
    }

    public render() {
        return (
            <form>
                <h2 className="header"> Contact Us! </h2>
                <div className="float">
                    <Input
                        prompt="First Name:">
                    </Input>
                </div>
                <div className="rightBoxes">
                    <Input
                        prompt="Last Name:">
                    </Input>
                </div>
                <Input
                    prompt="Subject:">
                </Input>
                <div className="float">
                    <Input
                        prompt="Email Address:">
                    </Input>
                    <div className="contactText">
                        <p> Are you a shelter and need help with your account?</p>
                        <p> Are you a potential pet owner with comments or</p>
                        <p> concerns? Send us a note here! </p>
                        <p> Or you can reach us at purrfectmatch@gmail.com </p>
                </div>
                </div>
                <div className="search">
                    <Select
                        prompt="Are you a shelter employee?"
                        options= {OPTION_ARRAY}>
                    </Select>
                </div>
                <div className="label">
                    <p >Message: </p>
                </div>
                <Message
                    prompt=" ">
                </Message>
                <Send>
                </Send>
            </form>
        );
    }
}
