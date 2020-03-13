import React from "react";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import { SuccessStoryPage } from "SuccessStoryPage";
import { ContactPage } from "ContactPage";
import { HomePage } from "HomePage/HomePage";
import { SearchPage } from "SearchPage";
import { NavigationMenu } from "NavigationMenu/NavigationMenu";
import Footer from "Footer/Footer";
import {UnderConstruction} from "UnderConstruction/UnderConstruction";
import dog from 'pictures/dog-homepage.jpg';
import other from 'pictures/other-animal-homepage.jpg';


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
                <div className="topBar" />
                <Switch>
                    <Route path="/contact">
                        <ContactPage />
                    </Route>
                    <Route path="/success">
                        <SuccessStoryPage />
                    </Route>
                    <Route path="/cat">
                        <SearchPage />
                    </Route>
                    <Route path="/dog">
                        <UnderConstruction logo = {dog}/>
                    </Route>
                    <Route path="/other">
                        <UnderConstruction logo ={other} />
                    </Route>
                    <Route path="/">
                        <HomePage />
                    </Route>
                </Switch>
                <Footer />
            </Router>
        );
    }
}