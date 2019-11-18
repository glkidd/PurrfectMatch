import React from 'react';
import './App.css';
import { BrowserRouter as Router, Switch, Route, } from "react-router-dom";
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
      
        
        return (
          
             
            
           



            <Router>
                
                <NavigationMenu /> 
               

                <div className="topBar">
                    

                </div>
    
               
               
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
