import React from 'react';
import { Modal } from "./Modal";
import { CompactSearch } from "./CompactSearch"
import { TipsSideBar } from "./TipsSideBar";
import cat from "./pictures/cat.jpg";
import { Redirect } from "react-router-dom";
import { Input, Select, Message, Send } from './inputBoxes';


const loremIpsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur eu varius nulla. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur eu varius nulla.";

const rawResults = [{name: "Ollie", breed: "American Shorthair", age: "5 years", gender: "Male", bio: "insert bio here", daysInShelter: 1, daysLeft: 30},
{name: "Meowasaurus", breed: "American Shorthair", age: "3.5 years", gender: "Male", bio: "insert bio here", daysInShelter: 5, daysLeft: Infinity},
{name: "Fuzzles", breed:"American Shorthair", age: "4 years", gender:"Female", bio:"insert bio here", daysInShelter: 36, daysLeft: 20},
{name: "Mr. Meef", breed: "American Shorthair", age: "5 months", gender: "Male", bio: "insert bio here", daysInShelter: 25, daysLeft: 40},
{name: "Poof", breed: "American Shorthair", age:"6 years", gender: "Female", bio: "insert bio here", daysInShelter: 0, daysLeft: 105},
{name: "Rex", breed: "American Shorthair", age: "1 year", gender: "Male", bio: "insert bio here", daysInShelter: 4, daysLeft: Infinity},
{name: "Socks", breed: "American Shorthair", age: "8 years", gender: "Male", bio: "insert bio here", daysInShelter: 3, daysLeft: Infinity},
{name: "Midnight", breed: "American Shorthair", age: "8 months", gender: "Female", bio: "insert bio here", daysInShelter: 32, daysLeft: 2}
];

let readyResults = [...rawResults];

let riskSortClass = "clicked";
let ageAscSortClass = "unclicked";
let ageDescSortClass = "unclicked";
let timeSortClass = "unclicked";

let riskFilterClass = "unclicked";

const OPTION_ARRAY = ["Male", "Female"];

// sort by the age of the animal

// sort by how at risk an animal is

// sort by how much time an animal has spent in that shelter

// interfaces = structs
interface SearchPageProps {
};

interface SearchPageState {
    modalOpen: boolean;
    filter: string;
    sort: string;
    riskSort: boolean;
    timeSort: boolean;
    ageAscSort: boolean;
    ageDescSort: boolean;
    riskFilter: boolean;
};

export class SearchPage extends React.Component<SearchPageProps, SearchPageState> {

    // if state is nonempty we want to have state stuff in constructor
    constructor(props: any) {
        super(props);

        this.state = {
            modalOpen: false,
            filter: "",
            sort: "",
            riskSort: true,
            timeSort: false,
            ageAscSort: false,
            ageDescSort: false,
            riskFilter: false
        };
    }

    // react components need to have render function
    sortByRisk(){
        if (this.state.riskSort) {
            riskSortClass = "unclicked";
            readyResults = rawResults;
            this.setState({riskSort: false});
        }
        else {
            riskSortClass = "clicked";
            timeSortClass = "unclicked";
            ageAscSortClass = "unclicked";
            ageDescSortClass = "unclicked";
            this.setState({riskSort: true,
                           ageAscSort: false,
                           ageDescSort: false,
                           timeSort: false});
        }
    }

    sortByDays(){
        if (this.state.timeSort) {
            timeSortClass = "unclicked";
            readyResults = rawResults;
            this.setState({timeSort: false});
        }
        else {
            timeSortClass = "clicked";
            riskSortClass = "unclicked";
            ageAscSortClass = "unclicked";
            ageDescSortClass = "unclicked";
            this.setState({riskSort: false,
                           ageAscSort: false,
                           ageDescSort: false,
                           timeSort: true});
        }
    }

    sortByAgeAsc(){
        if (this.state.ageAscSort) {
            ageAscSortClass = "unclicked";
            readyResults = rawResults;
            this.setState({ageAscSort: false});
        }
        else {
            ageAscSortClass = "clicked";
            riskSortClass = "unclicked";
            timeSortClass = "unclicked";
            ageDescSortClass = "unclicked";
            this.setState({riskSort: false,
                           ageAscSort: true,
                           ageDescSort: false,
                           timeSort: false});
        }
    }

    sortByAgeDesc(){
        if (this.state.ageDescSort) {
            ageDescSortClass = "unclicked";
            readyResults = rawResults;
            this.setState({ageDescSort: false});
        }
        else {
            ageDescSortClass = "clicked";
            riskSortClass = "unclicked";
            timeSortClass = "unclicked";
            ageAscSortClass = "unclicked";
            this.setState({riskSort: false,
                           ageAscSort: false,
                           ageDescSort: true,
                           timeSort: false});
        }
    }


    
    public render() {

        let readyResults = [...rawResults];

        if (this.state.timeSort) {
            readyResults.sort((a, b) => (a.daysInShelter < b.daysInShelter) ? 1 : -1);
        }
        else if (this.state.riskSort) {
            readyResults.sort((a, b) => (a.daysLeft > b.daysLeft) ? 1 : -1);
        }
        else if (this.state.ageAscSort) {
            readyResults.sort((a, b) => (a.age > b.age) ? 1 : -1);
        }
        else if (this.state.ageDescSort) {
            readyResults.sort((a, b) => (a.age < b.age) ? 1 : -1);
        }

        var toDisplay = readyResults.map((resObj, index) =>
            <li key={index}>
                <CompactSearch name={resObj.name} breed={resObj.breed} age={resObj.age} gender={resObj.gender} bio={resObj.bio} daysLeft={resObj.daysLeft}></CompactSearch>
            </li>
        );

        return (
            <div>
                <div className="welcomeMessage">
                    Find you purrfect cat!
                </div>
                <div className = "filterHolder">
                    <ul>
                        <li className="filterText">
                            Filter:
                        </li>
                        <li>
                            <button className="unclicked">Risk Status</button>
                        </li>
                        <li>
                            <button className="unclicked">Age</button>
                        </li>
                        <li>
                            <button className="unclicked">Gender</button>
                        </li>
                        <li>
                            <button className="unclicked">Location</button>
                        </li>
                    </ul>
                </div>
                <div className = "sortHolder">
                    <ul>
                        <li className="filterText">
                            Sort:
                        </li>
                        <li>
                            <button className={riskSortClass} onClick={()=> this.sortByRisk()}>Risk Status</button>
                        </li>
                        <li>
                            <button className={timeSortClass}  onClick={() => this.sortByDays()}>Time in Shelter</button>
                        </li>
                        <li>
                            <button className={ageAscSortClass} onClick={()=> this.sortByAgeAsc()}>Age Asc</button>
                        </li>
                        <li>
                            <button className={ageDescSortClass} onClick={()=> this.sortByAgeDesc()}>Age Desc</button>
                        </li>
                    </ul>
                </div>

                <br></br>

                <div className="successStoryHolder">
                    <div id="successStories">
                        <div id="headerOne">
                            Search Results
                        </div>
                        <ul>
                            {toDisplay}
                        </ul>
                    </div>
                    <div id="recentlyAdopted">
                        <div id="headerTwo">
                            Tips and Tricks!
                        </div>
                        <ul>
                            <li>
                                <TipsSideBar title="What to Know About Cats" content={loremIpsum}></TipsSideBar>
                            </li>
                            <li>
                                <TipsSideBar title="You might be interested in..." content={loremIpsum}></TipsSideBar>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>);
    }
}