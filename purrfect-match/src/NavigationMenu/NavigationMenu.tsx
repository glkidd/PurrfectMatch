import * as React from "react";
import './NavigationMenu.css';
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";
import logo from "pictures/doglogo.png";


interface MenuProps {
    
  
};


interface MenuState{
  hasScrolled:boolean;

}




class NavigationMenu extends React.Component< MenuProps,MenuState> {
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
    this.setState({ hasScrolled: scrollTop > 50 });
  }

 

  render() {
    return (
      <nav className={this.state.hasScrolled ? 'Header HeaderScrolled' : 'Header'}>
        <div className="HeaderGroup ">
        
        <Link to="home"><img id="logo"src={logo} alt="Purrfect Match Logo"/></Link>
        
       
         
        <h1>PurrfectMatch </h1>
        <button>
        <Link to="success"> Success Stories</Link>
        </button>
        
        <button>
        <Link to="contact"> Contact Us</Link>
        </button>
        
        </div>
    
      </nav>
    );
  }
}

export default NavigationMenu