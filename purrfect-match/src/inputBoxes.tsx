import React from 'react';
import "./ContactPage.css"

interface inputProps {
    prompt: string;
    error?: string;
    onchange?: (newVal: string) => void;
}

interface optionProps {
    prompt: string;
    options: string[];
    error?: string;
    onchange?: (newVal: string) => void;
}

interface SubmitProps {
    className?: string | undefined;
    onclick?: () => void;
}

export class Input extends React.Component<inputProps, {}> {
    constructor(props: any) {
        super(props);

        this.state = {

        }
    }

    handleChange = (event: any) => {
        if (this.props.onchange) {
            if (event && event.target && event.target.value) {
                this.props.onchange(event.target.value);
            } else {
                this.props.onchange("");
            }
        }
    }

    public render() {
        let errorDiv = this.props.error ? <div className="inputError">{this.props.error}</div> : <div />;
        return (
            <div className="inputElem">
                <div className="label">
                    {this.props.prompt} 
                </div>
                <div className="inputField">
                    <input type="text" name="fname" className="textBox" onChange={this.handleChange} />
                </div>
                {errorDiv}
            </div>
        );
    }
}

export class Select extends React.Component<optionProps, {}> {

    constructor(props : any) {
        super(props);
    }

    handleChange = (event: any) => {
        if (this.props.onchange) {
            if (event && event.target && event.target.value) {
                this.props.onchange(event.target.value);
            } else {
                this.props.onchange("");
            }
        }
    }

    public render() {
        let optionArray = this.props.options.map((option) => <option>{option}</option>);
        let errorDiv = this.props.error ? <div className="inputError">{this.props.error}</div> : <div />;

        return (
            <div className="inputElem">
                <div className="label">
                    {this.props.prompt} 
                </div>
                <select style={{ width: "150px", height: "1.5em" }} onChange={this.handleChange} >
                    <option disabled selected> Select an option </option>
                    {optionArray}
                </select>
                {errorDiv}
            </div>
        );
    }
}

export class Message extends React.Component<inputProps, {}> {

    handleChange = (event: any) => {
        if (this.props.onchange) {
            if (event && event.target && event.target.value) {
                this.props.onchange(event.target.value);
            } else {
                this.props.onchange("");
            }
        }
    }

    public render() {
        let errorDiv = this.props.error ? <div className="inputError">{this.props.error}</div> : <div />;
        return (
            <div className="inputElem">
                <div className="label">
                    {this.props.prompt}
                </div>
                <div className="inputField">
                    <textarea rows={20} cols={60} className="textBox message" placeholder="Type your message here..." onChange={this.handleChange} />
                </div>
                {errorDiv}
            </div>
        );
    }
}

export class Send extends React.Component<SubmitProps, {}> {

    constructor(props: any) {
        super(props);

        this.state = {

        };
    }
    handleSubmit = (event: any) => {
        if (this.props.onclick) {
            this.props.onclick();
        }
    }

    public render() {
        return (
            <div className="inputElem">
                <button onClick={this.handleSubmit} className={this.props.className}> 
                    Submit
                </button>
            </div>
        );
    }
}