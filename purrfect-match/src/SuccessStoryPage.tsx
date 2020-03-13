import React from 'react';
import { Modal } from "./Modal";
import { CompactView } from "./CompactView";
import { CompactViewRecent } from "./CompactViewRecent";
import { SubmissionBox } from "./SubmissionBox";
import { Redirect } from "react-router-dom";
import { SuccessStoryInfo } from "Definitions";
import { RecentlyAdoptedInfo } from "Definitions";
import { Spinner } from "Spinner";
import { Api } from "Api";
import cat from "./pictures/cat.jpg";

interface SuccessStoryPageProps {
};

interface SuccessStoryPageState {
    stories: SuccessStoryInfo[] | undefined
    recentAdopt: RecentlyAdoptedInfo[] | undefined; 
};

export class SuccessStoryPage extends React.Component<SuccessStoryPageProps, SuccessStoryPageState> {

    constructor(props: any) {
        super(props);

        this.state = {
            stories: undefined,
            recentAdopt: undefined
        };
    }

    public componentWillMount() {
        Api.getSuccessStories(0).then((successStories: SuccessStoryInfo[]) => {
            this.setState( { stories: successStories } ); 
        });

        Api.getRecentlyAdopted(0).then((recentlyAdopted: RecentlyAdoptedInfo[]) => {
            this.setState( { recentAdopt: recentlyAdopted} );
        });
    }

    public render() {
        let successStories = <div className="storiesSpinner"> <Spinner/> </div>;
        let recentlyAdopted = <div className="storiesSpinner"> <Spinner/> </div>;

        if (this.state.stories !== undefined) {
            successStories = <ul> { this.state.stories.map( (story: SuccessStoryInfo) => {
                return ( <li> <CompactView info={story}/> </li> ) } ) } 
            </ul>;
        }

        if (this.state.recentAdopt !== undefined) {
            recentlyAdopted = <ul id="recentAdoptList" > { this.state.recentAdopt.map( (animal: RecentlyAdoptedInfo) => {
                return ( <li> <CompactViewRecent info={animal} /> </li> ) } ) }
            </ul>;
        }

        return (
            <div>
                <div className="welcomeMessage">
                    Did you adopt a pet using our site? Share your story here!
                </div>

                <div>
                    <SubmissionBox/>
                </div>

                <div className="successStoryHolder">
                    <div id="successStories">
                        <div id="headerOne">
                            Success Stories
                        </div>
                        { successStories }
                    </div>
                    <div id="recentlyAdopted">
                        <div id="headerTwo">
                            Recently adopted!
                        </div>
                        { recentlyAdopted } 
                    </div>
                </div>
            </div>);
    }
}



