import React from 'react';
import "./ContactPage.css"

interface inputProps {
    prompt: string;
}

interface optionProps{
    prompt: string;
    options: string[];
}

export class Input extends React.Component<inputProps, {}> {
    
    public render() {
        return (
        <div className="row">
            <div className="label">
                {this.props.prompt} 
            </div>
            <div>
                <input type="text" name="fname" className="textBox"/>
            </div>
        </div>
        );
    }
}

export class Select extends React.Component<optionProps, {}> {

    constructor(props : any) {
        super(props);
    }
    
    public render() {
        let optionArray = this.props.options.map(function(option) {
                                return <option> {option} </option>;
                            }
                        );
        return (
        <div className="row">
            <div className="searchLabel">
                {this.props.prompt} 
            </div>
            <select name="Shelter Employee" style={{width:"150px", height:"1.5em"}}>
                <option disabled selected> Select an option </option>
                {optionArray}
            </select>
        </div>
        );
    }
}

export class Message extends React.Component<inputProps, {}> {
    
    public render() {
        return (
        <div className="row">
            {this.props.prompt}
            <div>
                <textarea name="message" rows={20} cols={40} className="textBox message" placeholder = "Type your message here...">
                </textarea>
            </div>
        </div>
        );
    }
}

export class Send extends React.Component<{},{}> {
    
    handleSubmit(event : any) {
    }

    public render() {
        return (
            <button onClick={this.handleSubmit} id="send"> 
            <div className="sendText"> Send </div>
            </button>
        );
    }
}