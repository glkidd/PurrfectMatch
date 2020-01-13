import React from 'react';
import { Modal } from "./Modal";
import { CompactView } from "./CompactView";
import cat from "./pictures/cat.jpg";
import { Redirect } from "react-router-dom";
import Footer from 'Footer/Footer';

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

                <div className="successStoryHolder">
                    <div id="successStories">
                        <div id="headerOne">
                            Success Stories
                        </div>
                        <ul>
                            <li>
                                <CompactView name="Ollie" breed="American Shorthair" age="5 years" gender="Male"></CompactView>
                            </li>
                            <li>
                                <CompactView name="Meowasaurus" breed="American Shorthair" age="3.5 years" gender="Male"></CompactView>
                            </li>
                            <li>
                                <CompactView name="Fuzzles" breed="American Shorthair" age="4 years" gender="Female"></CompactView>
                            </li>
                            <li>
                                <CompactView name="Mr. Meef" breed="American Shorthair" age="5 months" gender="Male"></CompactView>
                            </li>
                            <li>
                                <CompactView name="Poof" breed="American Shorthair" age="6 years" gender="Female"></CompactView>
                            </li>
                            <li>
                                <CompactView name="Rex" breed="American Shorthair" age="1 year" gender="Male"></CompactView>
                            </li>
                            <li>
                                <CompactView name="Socks" breed="American Shorthair" age="8 years" gender="Male"></CompactView>
                            </li>
                            <li>
                                <CompactView name="Midnight" breed="American Shorthair" age="8 months" gender="Female"></CompactView>
                            </li>
                        </ul>
                    </div>
                    <div id="recentlyAdopted">
                        <div id="headerTwo">
                            Recently adopted!
                        </div>
                        <ul>
                            <li>
                                <CompactView name="Ollie" breed="American Shorthair" age="5 years" gender="Male"></CompactView>
                            </li>
                        </ul>
                    </div>

                </div>
            </div>);
    }
}



