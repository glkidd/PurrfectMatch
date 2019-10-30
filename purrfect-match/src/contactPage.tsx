import React from 'react';
import "./ContactPage.css"

interface inputProps {
    prompt: string;
}

export class Input extends React.Component<inputProps, {}> {
    
    public render() {
        return (
        <div class="row">
            {this.props.prompt} 
            <div>
                <input type="text" name="fname" class="textBox small"/>
            </div>
        </div>
        );
    }
}

export class Message extends React.Component<inputProps, {}> {
    
    public render() {
        return (
        <div class="row">
            {this.props.prompt} 
            <div>
                <textarea name="message" rows="20" cols="40" class="textBox message">Type your message here...
                </textarea>
            </div>
        </div>
        );
    }
}

export class Send extends React.Component<{},{}> {

    public render() {
        return (
            <button id="send">Send</button>
        );
    }
}