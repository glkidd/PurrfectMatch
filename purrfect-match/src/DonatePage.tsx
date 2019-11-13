import React from 'react';
import { Redirect } from "react-router-dom";

interface DonatePageProps {
};

interface DonatePageState {
};

export class DonatePage extends React.Component<DonatePageProps, DonatePageState> {

    constructor(props: any) {
        super(props);

        this.state = {
        };
    }

    public render() {

        return (
            <div>
                Donate page.
            </div>
        );
    }

}