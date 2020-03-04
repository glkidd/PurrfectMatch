import React from 'react';
import { Redirect } from "react-router-dom";
import { Card } from './Card';
import { Link } from "react-router-dom";


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

    public render() {
        return (
            <div>
                <div className="Hero">
                    <div className="PetSelectionBox">
                        <div className="Cards">
                            <h2>Find your perfect companion from the comfort of your own home.</h2>
                            <h2>Choose which type of animal you would like to start with:</h2>
                            <div className="CardGroup">
                                <div>
                                    <h1>Dog</h1>
                                    <Link to="dog">
                                        <Card image={require('../pictures/dog-homepage.jpg')} />
                                    </Link>
                                    
                                </div>
                                <div>

                                    <h1>Cat</h1>
                                    <Link to="cat">
                                        <Card image={require('../pictures/cat-homepage.jpg')} />
                                    </Link>


                                </div>
                                <div>
                                    <h1>Other</h1>
                                    <Link to="other">
                                        <Card image={require('../pictures/other-animal-homepage.jpg')} />
                                    </Link>
                                    
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


