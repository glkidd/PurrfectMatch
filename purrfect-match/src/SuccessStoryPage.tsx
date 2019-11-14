import React from 'react';
import { Modal } from "./Modal";
import { CompactView } from "./CompactView";
import cat from "./pictures/cat.jpg";
import { Redirect } from "react-router-dom";

// interfaces = structs
interface SuccessStoryPageProps {
};

interface SuccessStoryPageState {
    modalOpen: boolean;
};

export class SuccessStoryPage extends React.Component<SuccessStoryPageProps, SuccessStoryPageState> {

    // if state is nonempty we want to have state stuff in constructor
    constructor(props: any) {
        super(props);

        this.state = {
            modalOpen: false
        };
    }

    // react components need to have render function
    public render() {
        return (
            <div>
                <div className="welcomeMessage">
                    Did you adopt a pet using our site? Click here to add a success story about your new pet!
                </div>

                <div className="successStoryHeaders">
                    <div id="headerOne"> 
                        Success Stories
                    </div>
                    <div id="headerTwo">
                        Recently adopted!
                    </div>
                </div>
                

                <CompactView name="Ollie" breed="American Shorthair" age="5 years" gender="Male"></CompactView>

            </div>);
    }
}








