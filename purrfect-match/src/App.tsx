import React from 'react';
import './App.css';
import logo from "pictures/doglogo.png";
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";
import { SuccessStoryPage } from "SuccessStoryPage";
import { ContactPage } from 'ContactPage';
import { HomePage } from "HomePage/HomePage";
import { SearchPage } from "SearchPage";
import { DonatePage } from "DonatePage";
import NavigationMenu from "NavigationMenu/NavigationMenu";

interface AppState {
    page: JSX.Element | null;
}

export class App extends React.Component<{}, AppState> {

    constructor(props: any) {
        super(props);
        this.state = {
            page: null
        };
    }

    public render() {
        let links = [
            { label: 'Success Stories', link: '#success-stories',},
            { label: 'Contact Us', link: '#contact-us',  },
          ];
        
        return (
          
             
            
           



            <Router>
                <h1 className="topBar">   
                    <Link to=""><img id="logo" src={logo} alt="Purrfect Match Logo" /><span>Purrfect Match</span></Link>

                    <div className="topBarLinks">
                            <Link to="search">Search</Link><br />
                            <Link to="success">Success Stories</Link><br />
                            <Link to="contact">Contact Page</Link><br />
                            <Link to="donate">Donation page</Link><br />
                    </div>

                </h1>
                <Switch>
                    <Route path="/contact">
                        <ContactPage />
                    </Route>
                    <Route path="/success">
                        <SuccessStoryPage />
                    </Route>
                    <Route path="/search">
                        <SearchPage />
                    </Route>
                    <Route path="/donate">
                        <DonatePage />
                    </Route>
                    <Route path="/">
                        <HomePage />
                    </Route>
                </Switch>
            </Router>
        );
    }
}
