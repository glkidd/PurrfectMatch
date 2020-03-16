import React from 'react';
import { CompactSearch } from "./CompactSearch"
import { TipsSideBar } from "./TipsSideBar";
import { Api } from "./Api";
import { Select, Input } from './FilterInputs';
import { SearchPageResults, Filters } from './Definitions';
import { Spinner } from './Spinner';

const aboutCats = "Cats make great pets. They’re nowhere near as loud as dogs and they can curl up in your lap, helping you to relax after a hard day.";

const interestedIn = "Litter boxes, cat food, toys, cat nip, string, and more!";

const AGE_OPTION_ARRAY = ["< 1 year", "1-3 years", "4 years", "any"];

const GENDER_OPTION_ARRAY = ["Male", "Female", "N/A"];


interface SearchPageProps {
};

interface SearchPageState {
    modalOpen: boolean;
    filter: Filters;
    sort: string;
    searchResults: SearchPageResults[] | undefined;
};

export class SearchPage extends React.Component<SearchPageProps, SearchPageState> {

    constructor(props: any) {
        super(props);

        this.state = {
            modalOpen: false,
            filter: {
                risk: true,
                age: '',
                gender: '',
                location: ''
            },
            sort: "",
            searchResults: undefined
        };
    }

    private getSearchResults(filter: Filters, sort: string) {
        Api.getSearchResults("CAT", filter, sort).then((searchResults: SearchPageResults[]) => {
            this.setState( { searchResults: searchResults } ); 
        });
    }

    sortByRisk(){
        let sort = this.state.sort;
        
        if (sort && sort === "risk") {
            sort = "";
        }
        else {
            sort = "risk"
        }
        this.getSearchResults(this.state.filter, sort);
        this.setState({sort: sort});
    }

    sortByDays(){
        let sort = this.state.sort;
        
        if (sort && sort === "time") {
            sort = "";
        }
        else {
            sort = "time"
        }
        this.getSearchResults(this.state.filter, sort);
        this.setState({sort: sort});
    }

    sortByAgeAsc(){
        let sort = this.state.sort;
        
        if (sort && sort === "ageAsc") {
            sort = "";
        }
        else {
            sort = "ageAsc"
        }
        this.getSearchResults(this.state.filter, sort);
        this.setState({sort: sort});
    }

    sortByAgeDesc(){
        let sort = this.state.sort;
        
        if (sort && sort === "ageDesc") {
            sort = "";
        }
        else {
            sort = "ageDesc"
        }
        this.getSearchResults(this.state.filter, sort);
        this.setState({sort: sort});
    }

    filterByRisk(){
        let filter = this.state.filter;
        if (this.state.filter.risk) {
            filter.risk = false;
        }
        else {
            filter.risk = true;
        }
        this.getSearchResults(filter, this.state.sort);
        this.setState({filter: filter});
    }

    filterByAge(ageRange: string){
        let filter = this.state.filter;
        if (ageRange === "any") {
            filter.age = "";
        }
        else {
            filter.age = ageRange;
        }
        this.getSearchResults(filter, this.state.sort);
        this.setState({filter: filter});
    }

    filterByGender(gender: string){
        let filter = this.state.filter;
        if (gender === "N/A") {
            filter.gender = "";
        }
        else {
            filter.gender = gender;
        }
        this.getSearchResults(filter, this.state.sort);
        this.setState({filter: filter});
    }

    filterByLocation(location: string){
        let filter = this.state.filter;
        if (location) {
            filter.location = location;
        }
        else {
            filter.location = "";
        }
        this.getSearchResults(filter, this.state.sort);
        this.setState({filter: filter});
    }

    componentDidMount = () => {this.getSearchResults(this.state.filter, this.state.sort)};

    
    public render() {

        let toDisplay = <div className="searchSpinner"> <Spinner/> </div>;

        if (this.state.searchResults !== undefined) {
            toDisplay = <ul> { this.state.searchResults.map( (result: SearchPageResults) => {
                return ( <li> <CompactSearch 
                    name={result.name}
                    breed={result.breed}
                    age={result.age}
                    gender={result.gender}
                    bio={result.bio}
                    daysLeft={result.daysLeft}
                    photo={result.photo}
                    shelterId={result.shelterId}
                /> </li> ) } ) } 
            </ul>;
        };

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
                            <button className={this.state.filter.risk ? 'clicked' : 'unclicked'} onClick={()=> this.filterByRisk()}>At Risk</button>
                        </li>

                        <li>
                            <Select
                                prompt="Age"
                                options={AGE_OPTION_ARRAY}
                                onchange={(newValue: any) => this.filterByAge(newValue)}
                            />
                        </li>
                        <li>
                            <Select
                                prompt="Gender"
                                options={GENDER_OPTION_ARRAY}
                                onchange={(newValue: any) => this.filterByGender(newValue)}
                            />
                        </li>
                        <li>
                            <Input
                                prompt="Location:"
                                onchange={(newValue: string) => this.filterByLocation(newValue)}/>
                        </li>
                    </ul>
                </div>
                <div className = "sortHolder">
                    <ul>
                        <li className="filterText">
                            Sort:
                        </li>
                        <li>
                            <button className={this.state.sort === "risk" ? 'clicked' : 'unclicked'} onClick={()=> this.sortByRisk()}>Risk Status</button>
                        </li>
                        <li>
                            <button className={this.state.sort === "time" ? 'clicked' : 'unclicked'}  onClick={() => this.sortByDays()}>Time in Shelter</button>
                        </li>
                        <li>
                            <button className={this.state.sort === "ageAsc" ? 'clicked' : 'unclicked'} onClick={()=> this.sortByAgeAsc()}>Age Asc</button>
                        </li>
                        <li>
                            <button className={this.state.sort === "ageDesc" ? 'clicked' : 'unclicked'} onClick={()=> this.sortByAgeDesc()}>Age Desc</button>
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
                    <div id="tips">
                        <div id="headerTwo">
                            Tips and Tricks!
                        </div>
                        <ul>
                            <li>
                                <TipsSideBar title="What to Know About Cats" content={aboutCats}></TipsSideBar>
                            </li>
                            <li>
                                <TipsSideBar title="You might be interested in..." content={interestedIn}></TipsSideBar>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>);
    }
}