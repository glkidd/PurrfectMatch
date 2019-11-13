import React from 'react';
import { Redirect } from "react-router-dom";
import Card from './Card';


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
            <div className="Cards">
                <div className="CardGroup">
                    <Card
                        title="Cat"
                        image={require('../pictures/Cat_1.png')} />
                    <Card
                        title="Dog"
                        image={require('../pictures/Dog_1.png')} />
                    <Card
                        title="Other"
                        image={require('../pictures/Hamster_1.png')} />
                </div>
            </div>
        );
    }

}


