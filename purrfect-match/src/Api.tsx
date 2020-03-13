import { SuccessStoryInfo, SUCCESS_STORY_PAGE_SIZE } from "./Definitions";
import { RecentlyAdoptedInfo, NUM_RECENTLY_ADOPTED } from "./Definitions";
import { SearchPageResults, Filters } from './Definitions';
import axios from 'axios';

/*
    This class is used for whenever we need to get data from the server. 
*/
// Purposefully not exported
let cache: any = {
    "breeds": {}
};
        
export class Api {

    // will initialize and either resolve or reject a promise depending on the status code returned by the server
    private static safeFetch = (endpoint: string, method: string, body: JSON) : Promise<Object> => {
        return Promise.resolve({});
    }

    // this will be used anytime data needs to be added to the backend (not idempotent)
    private static post = (endpoint: string, body: JSON) : Promise<Object> => {
        return Api.safeFetch(endpoint, 'POST', body);
    }
     
    // this will be used anytime data needs to be edited (idempotent)
    private static put = (endpoint: string, body: JSON) : Promise<Object> => {
        return Api.safeFetch(endpoint, 'PUT', body);
    }
     
     // this will be used anytime data needs to be retrieved from the backend (idempotent)
     // body would normally be empty
    private static get = (endpoint: string, body: JSON) : Promise<Object> => {
        return Api.safeFetch(endpoint, 'GET', body);
    }
     
    // this will be useful when allowing shelters to delete pet profiles later (idempotent)
    // body would normally be empty
    private static del = (endpoint: string, body: JSON) : Promise<Object> => {
        return Api.safeFetch(endpoint, "DELETE", body);
    }

    public static getBreed = (id: number): Promise<string> => {
        return axios({
            method: "post",
            url: "http://localhost:8080/breeds/get/" + id.toString()
        }).then((data: any) => {
            console.log(data);
            return data.data.breedName;
        });
    }

    //should eventually connect up to safeFetch via Api.get
    public static getSearchResults = (species: string, filter: Filters, sort: string): Promise<SearchPageResults[]> => {
        let sortMapping: any = {
            "": { sort: "RISK", dir: "ASC" },
            "risk": { sort: "RISK", dir: "ASC" },
            "time": { sort: "DAYS", dir: "ASC" },
            "ageAsc": { sort: "AGE", dir: "ASC" },
            "ageDesc": { sort: "AGE", dir: "DESC" }
        }

        return axios({
            method: 'post',
            url: 'http://localhost:8080/search',
            data: {
                species: species,
                filterRisk: filter.risk,
                filterAge: filter.age,
                filterGender: filter.gender == "" ? "UNSET" : filter.gender.toUpperCase(),
                filterLocation: filter.location,
                sortBy: sortMapping[sort].sort,
                sortDirection: sortMapping[sort].dir,
                page: 0
            }
        }).then((data) => {
            return data.data.body;
        }).then((data) => {
            // Check that we have all breeds cached, and fetch any we're missing
            let promises: Promise<any>[] =[];
            data.forEach((item : any) => {
                if (cache["breeds"][item.breed] === undefined) {
                    cache["breeds"][item.breed] = "";
                    promises.push(Api.getBreed(item.breed).then((breed : string) => { cache["breeds"][item.breed] = breed; }));
                }
            });

            return Promise.all(promises).then(() => { return data; });
        }).then((data) => { 
            return data.map((value : any) => {
                return {
                    name: value.name,
                    breed: cache["breeds"][value.breed],
                    age: value.bday.toString(),
                    gender: value.gender.toLowerCase(),
                    bio: value.bio,
                    daysInShelter: value.dateArrived,
                    daysLeft: value.euthanizeDate,
                    photo: value.imageName
                };
            });
        });

    }

    //should eventually connect up to safeFetch via Api.get
    public static getSuccessStories = (breakpoint?: number): Promise<SuccessStoryInfo[]> => {
        // The call to the server itself will be paginated, so which page of stories we want.
        // No value = first page. 
        if (breakpoint === undefined) {
            breakpoint = 0;
        }

        // This is pretty much all temporary code that will be replaced when we actually communicate with the server. 
        const ALL_SUCCESS_STORIES: SuccessStoryInfo[] = [
            {
                image: "cat.jpg",
                name: "Mittens",
                age: "4 years",
                storyText: "Some story about how this cat was saved from horrible living conditions and is doing much better now.",
                breed: "American shorthair",
                gender: "Female",
                adoptionDate: "10/24/19",
                owner: "Bob"
            },
            {
                image: "Cat_1.png",
                name: "Fluffy",
                age: "2 months",
                storyText: "Another success story here",
                breed: "American shorthair",
                gender: "Female",
                adoptionDate: "10/24/19",
                owner: "Bob"
            },
            {
                image: "Dog_1.png",
                name: "Mr. Woof",
                age: "10 years",
                storyText: "Okay, success stories really should be longer but eh. ",
                breed: "American shorthair",
                gender: "Female",
                adoptionDate: "10/24/19",
                owner: "Bob"

            }
        ];
        let fakeApiResult = ALL_SUCCESS_STORIES.slice(SUCCESS_STORY_PAGE_SIZE * breakpoint, SUCCESS_STORY_PAGE_SIZE * breakpoint + SUCCESS_STORY_PAGE_SIZE);
        return Promise.resolve(fakeApiResult);
    }
    
    //shouldEventually connect up to Api.get
    public static getRecentlyAdopted = (breakpoint?: number): Promise<RecentlyAdoptedInfo[]> => {
        // The call to the server itself will be paginated, so which page of stories we want.
        // No value = first page. 
        if (breakpoint === undefined) {
            breakpoint = 0;
        }

        // This is pretty much all temporary code that will be replaced when we actually communicate with the server. 
        const ALL_RECENTLY_ADOPTED: RecentlyAdoptedInfo[] = [
            {
                image: "cat.jpg",
                name: "Mittens",
                age: "4 years",
                breed: "American shorthair",
                gender: "Female",
                adoptionDate: "10/24/19",
                owner: "Bob"
            },
            {
                image: "Cat_1.png",
                name: "Fluffy",
                age: "2 months",
                breed: "American shorthair",
                gender: "Female",
                adoptionDate: "10/24/19",
                owner: "Bob"
            },
            {
                image: "Dog_1.png",
                name: "Mr. Woof",
                age: "10 years",
                breed: "American shorthair",
                gender: "Female",
                adoptionDate: "10/24/19",
                owner: "Bob"

            }
        ];
        //let fakeApiResult = ALL_RECENTLY_ADOPTED.slice(SUCCESS_STORY_PAGE_SIZE * breakpoint, SUCCESS_STORY_PAGE_SIZE * breakpoint + SUCCESS_STORY_PAGE_SIZE);
        let fakeApiResult = ALL_RECENTLY_ADOPTED;
        return Promise.resolve(fakeApiResult);
    }

    public static submitSuccessStory = (story: SuccessStoryInfo) : Promise<void> => {
        return Promise.resolve(); //will connect to Api.post
    }

    //should eventually connect up to Api.post
    public static submitContactInfo = (firstName: string, lastName: string, subject: string, email: string, shelterEmployee: string, message: string): Promise<any> => {
        // Normally, we'd actually submit to the backend and resolve or reject the promise based off of the response (was there an error submitting?)
        return axios({
            method: 'post',
            url: 'http://localhost:8080/contact',
            data: {
                firstName: firstName,
                lastName: lastName,
                subject: subject,
                email: email,
                shelterEmployee: shelterEmployee.toUpperCase(),
                message: message
            }
        });
    }
}