import React from 'react';
import { Redirect } from "react-router-dom";
import { Card } from './Card';
import Footer from 'Footer/Footer';
import axios from "axios";


interface HomePageProps {
};

interface HomePageState {
};

export class HomePage extends React.Component<HomePageProps, HomePageState> {
    constructor(props: any) {
        super(props);

        this.state = {
        };
    }

    // TODO: remove. This is purely for testing purposes.
    private clickHandler = async () => {
        axios({
            method: "post",
            url: "http://localhost:8080/shelter_accounts/new",
            data: {

            }
        }).then((response) => {
            console.log("\n\nfinished request.");
            console.log(response.data);
            console.log("\n\n");
        }).catch((e) => {
            console.log("\n\nerror request.");
            console.log(e.response);
            console.log("\n\n");
        });
    }

    public render() {
        return (
            <div>
                <div className="Hero">
                    <div className="PetSelectionBox">
                        <div className="Cards">
                            <h2>Find your perfect companion from the comfort of your own home.</h2>
                            <h2>Choose which type of animal you would like to start with:</h2>
                            <div className="CardGroup" onClick={this.clickHandler}>
                                <div>
                                    <h1>Dog</h1>
                                    <Card image={require('../pictures/dog-homepage.jpg')} />
                                </div>
                                <div>

                                    <h1>Cat</h1>
                                    <Card image={require('../pictures/cat-homepage.jpg')} />
                                </div>
                                <div>
                                    <h1>Other</h1>
                                    <Card image={require('../pictures/other-animal-homepage.jpg')} />
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div className="heroSpacer" />
            </div>
        );
    }
}


