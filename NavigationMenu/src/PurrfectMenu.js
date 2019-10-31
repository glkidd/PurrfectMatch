import React, { Component } from 'react';
import './PurrfectMenu.css';


class PurrfectMenu extends Component {
    constructor() {
        super();

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
      

        let linksMarkup = this.props.links.map((link, index) => {
            let linkMarkup = link.active ? (
                <a className="menu__link menu__link--active" href={link.link}>{link.label}</a>
            ) : (
                <a className="menu__link" href={link.link}>{link.label}</a>
            );

            return (
                <li key={index} className="menu__list-item">
                    {linkMarkup}
                </li>
            );
        });

        return (
            //This has Purrfect Match Text
            <nav className="menu">
                <h1 style={{
                backgroundImage: 'url(' + this.props.logo + ')'
                }} className="menu__logo">Purrfect</h1>
                

                <div className="menu__right">
                <h1> Match </h1>
               
                    
                    <ul className="menu__list">
                        {linksMarkup}
                    </ul>


                </div>
            </nav>
        );
    }
}

export default PurrfectMenu;
