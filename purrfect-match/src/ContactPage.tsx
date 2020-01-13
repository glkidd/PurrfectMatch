import React from 'react';
import './ContactPage.css';
import { Input, Select, Message, Send } from './inputBoxes';
import { Api } from "Api";
import Footer from 'Footer/Footer';
interface ContactPageProps {
};

interface ContactPageState {
    firstName: string | undefined;
    lastName: string | undefined;
    subject: string | undefined;
    email: string | undefined;
    shelterEmployee: "Yes" | "No" | "" | undefined;
    message: string | undefined;
};

const OPTION_ARRAY = ["Yes", "No"];

export class ContactPage extends React.Component<ContactPageProps, ContactPageState> {

    constructor(props: any) {
        super(props);

        this.state = {
            firstName: undefined,
            lastName: undefined,
            subject: undefined,
            email: undefined,
            shelterEmployee: undefined,
            message: undefined
        };
    }

    fillAndValidateField = (field: keyof ContactPageState): boolean => {
        if (this.state[field] === undefined) {
            this.setState({
                [field]: ""
            } as any);
            return false;
        } else {
            return this.state[field] != "";
        }
    }

    handleSubmit = () => {
        let formValid = true;
        // Validate all fields filled
        for (let elem of ["firstName", "lastName", "subject", "email", "shelterEmployee", "message"]) {
            if (!this.fillAndValidateField(elem as keyof ContactPageState)) {
                formValid = false;
            }
        }
        if (formValid) {
            // @ts-ignore: Strict null checks, but we know they're non-null from the validation we just did
            Api.submitContactInfo(this.state.firstName, this.state.lastName, this.state.subject, this.state.email, this.state.shelterEmployee, this.state.message);
        }
    }

    checkField = (fieldVal: string | undefined, error: string): string | undefined => {
        if (fieldVal == "") {
            return error;
        }
        return undefined;
    }

    public render() {
        return (
            <div className="contactPage">
                <h2 className="header">Contact Us!</h2>
                <div className="contactBoxes">
                    <Input
                        prompt="First Name:"
                        error={this.checkField(this.state.firstName, "Provide your first name.")}
                        onchange={(newValue: string) => this.setState({ firstName: newValue })}
                    />
                    <Input
                        prompt="Last Name:"
                        error={this.checkField(this.state.lastName, "Provide your last name.")}
                        onchange={(newValue: string) => this.setState({ lastName: newValue })}
                    />
                    <Input
                        prompt="Subject:"
                        error={this.checkField(this.state.subject, "Provide a subject.")}
                        onchange={(newValue: string) => this.setState({ subject: newValue })}
                    />
                    <Input
                        prompt="Email Address:"
                        error={this.checkField(this.state.email, "Provide your email.")}
                        onchange={(newValue: string) => this.setState({ email: newValue })}
                    />
                </div>
                <div className="contactBoxes">
                    <div className="contactText">
                        <p>
                            Are you a shelter and need help with your account?<br />
                            Are you a potential pet owner with comments or<br />
                            concerns? Send us a note here! <br />
                            Or you can reach us at purrfectmatch@gmail.com
                        </p>
                    </div>
                    <Select
                        prompt="Are you a shelter employee?"
                        options={OPTION_ARRAY}
                        error={this.checkField(this.state.shelterEmployee, "Choose an option.")}
                        onchange={(newValue: any) => this.setState({ shelterEmployee: newValue })}
                    />
                </div>
                <div className="contactBoxes">
                    <Message
                        prompt="Message:"
                        error={this.checkField(this.state.message, "Please write a message.")}
                        onchange={(newValue: string) => this.setState({ message: newValue })}
                    />
                </div>
                <Send onclick={this.handleSubmit} />
            </div>
        );
    }
}
