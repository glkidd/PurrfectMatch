import React, { Component } from 'react';
import './NavigationMenu.css';
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";

interface MenuProps {
    
    logo : string;
};



interface MenuState {
    showForm : boolean;
};

class NavigationMenu extends Component<MenuProps, MenuState> {
    constructor(props : any) {
        super(props);

        this.state = {
            showForm: false
        };
    }

    showForm() {
        this.setState({
            showForm: !this.state.showForm
        });
    }

    render() {
      

        

        return (
      
            <nav className="menu">
                <h1 style={{
                backgroundImage: 'url(' + this.props.logo + ')'
                }} className="menu__logo"></h1>
                
                

                <div className="menu__right ">
                    
                <div className="menu__logos">
                <h1>PurrfectMatch </h1>
                </div>
               
                
                
               
                    
                    <ul className="menu__link ">
                            <Link to="search">Search</Link>
                            <Link to="success"> SuccessStories</Link>
                            <Link to="contact"> ContactUs</Link>
                            <Link to="donate"> Donate</Link> 
                    </ul>


                </div>
            </nav>
        );
    }
}

export default NavigationMenu;
