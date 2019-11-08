import React from 'react';
import './ContactPage.css';
import { Input, Message, Send } from './inputBoxes';

const ContactPage: React.FC = () => {
  return (
    <div>
      <div>
      CONTACT US PLS :)
      </div>
      <div className = "float">
      <Input 
        prompt = "First Name:">
      </Input> 
      </div>
      <div className = "float">
      <Input 
        prompt = "Last Name:">
      </Input>
      </div>
      <Input 
        prompt = "Email Address:">
      </Input> 
      <div className = "float">
      <Input 
        prompt = "Subject:">
      </Input> 
      </div>
      <div className = "float">
      <Input 
        prompt = "Shelter employee?">
      </Input>
      </div>
      <Message
        prompt = " ">
      </Message>
      <Send>
      </Send>
    </div>
  );
}

export default ContactPage;
