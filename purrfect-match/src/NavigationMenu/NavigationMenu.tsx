import * as React from "react";
import './NavigationMenu.css';
import { Link } from "react-router-dom";
import logo from "pictures/doglogo.png";

interface MenuProps {  
};

interface MenuState{
    hasScrolled:boolean;
}

const TOPBAR_COLOR_CHANGE_LOCATION = 50;

export class NavigationMenu extends React.Component< MenuProps,MenuState> {
    constructor(props:any) {
        super(props)
        this.state = {
            hasScrolled: false
        }
    }
    componentDidMount() {
        window.addEventListener('scroll', this.handleScroll)
    }
    handleScroll = (event:any) => {
        const scrollTop = window.pageYOffset
        this.setState({ hasScrolled: scrollTop > TOPBAR_COLOR_CHANGE_LOCATION });
    }

    render() {
        return (
            <nav className={this.state.hasScrolled ? 'Header HeaderScrolled' : 'Header'}>
                <div className="HeaderGroup ">
                    <Link to="/">
                        <div><img id="logo" src={logo} alt="Purrfect Match Logo" /></div>
                        <div><p className="purrfectMatch">Purrfect&nbsp;Match</p></div>
                    </Link>  
                    <button>
                        <Link to="success">Success&nbsp;Stories</Link>
                    </button> 
                    <button>
                        <Link to="contact">Contact&nbsp;Us</Link>
                    </button> 
                </div>
            </nav>
        );
    }
}

