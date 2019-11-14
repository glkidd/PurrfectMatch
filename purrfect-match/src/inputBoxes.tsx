import React from 'react';
import "./ContactPage.css"

interface inputProps {
    prompt: string;
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

export class Select extends React.Component<inputProps, {}> {
    
    public render() {
        return (
        <div className="row">
            <div className="searchLabel">
                {this.props.prompt} 
            </div>
            <select name="Shelter Employee" style={{width:"150px", height:"1.5em"}}>
                <option value="select"></option>
                <option value="yes">Yes, I am!</option>
                <option value="no">No, I am not.</option>
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
            <button onClick={this.handleSubmit} id="send"> Send </button>
        );
    }
}