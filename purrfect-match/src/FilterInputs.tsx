import React from 'react';
import "./Filter.css"

interface optionProps {
    prompt: string;
    options: string[];
    onchange?: (newVal: string) => void;
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

        return (
            <div className="unclicked">
                <select onChange={this.handleChange} >
                    <option disabled selected> {this.props.prompt} </option>
                    {optionArray}
                </select>
            </div>
        );
    }
}

interface inputProps {
    prompt: string;
    error?: string;
    onchange?: (newVal: string) => void;
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
        return (
            <div className="searchElem">
                <span className="label">
                    {this.props.prompt} 
                </span>
                <div className="searchField">
                    <input type="text" name="fname" className="textBox" onChange={this.handleChange} />
                </div>
            </div>
        );
    }
}