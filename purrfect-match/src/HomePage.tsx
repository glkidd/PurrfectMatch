import React from 'react';
import { Redirect } from "react-router-dom";

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
                Home page.
            </div>
        );
    }

}


