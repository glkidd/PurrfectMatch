import React from 'react';
import { Redirect } from "react-router-dom";

interface SearchPageProps {
};

interface SearchPageState {
};

export class SearchPage extends React.Component<SearchPageProps, SearchPageState> {

    constructor(props: any) {
        super(props);

        this.state = {
        };
    }

    public render() {

        return (
            <div>
                Search and results page.
            </div>
        );
    }

}