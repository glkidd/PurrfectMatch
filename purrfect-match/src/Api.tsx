import { SuccessStoryInfo, SUCCESS_STORY_PAGE_SIZE,ContactPageInfo } from "./Definitions";
import { RecentlyAdoptedInfo, NUM_RECENTLY_ADOPTED } from "./Definitions";
import { SearchPageResults } from "./Definitions";
import axios from 'axios';



/*
    This class is used for whenever we need to get data from the server. 
*/

 
        
export class Api {



    // will initialize and either resolve or reject a promise depending on the status code returned by the server
    private static safeFetch = (endpoint: string, method: string, body: JSON) : Promise<Object> => {
        //insert safeFetch function here
        // will use regular "fetch" function, plus BASE_URL
        // since our front end runs on 3000, let's use 3001 for our backend while running locally
        //const BASE_URL = "http://localhost:3001/";
        
        return Promise.resolve({}); //temporary value, will either reject with an error or resolve with the proper data
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
    
    //should eventually connect up to safeFetch via Api.get
    public static getSearchResults = (filter: Object, sort: string) : Promise<SearchPageResults[]> => {
        //temporary values for sake of front end, but would normally call Api.get --> safeFetch will handle promises
        //would use input filter and sort info for "getting" the search results/will get sorted/filtered info from backend

        const SEARCH_RESULTS: SearchPageResults[] = [
            {
                name:"Ollie",
                breed: "American Shorthair",
                age: "5 years",
                gender: "Male",
                bio: "insert bio here",
                daysInShelter: 1,
                daysLeft: 30
            },
            {
                name: "Meowasaurus",
                breed: "American Shorthair",
                age: "3.5 years", gender: "Male",
                bio: "insert bio here",
                daysInShelter: 5,
                daysLeft: Infinity
            },
            {
                name: "Fuzzles",
                breed:"American Shorthair",
                age: "4 years", gender:"Female",
                bio:"insert bio here",
                daysInShelter: 36,
                daysLeft: 20
            },
            {
                name: "Mr. Meef",
                breed: "American Shorthair",
                age: "5 months",
                gender: "Male",
                bio: "insert bio here",
                daysInShelter: 25,
                daysLeft: 40
            },
            {
                name: "Poof",
                breed: "American Shorthair",
                age:"6 years",
                gender: "Female",
                bio: "insert bio here",
                daysInShelter: 0,
                daysLeft: 105
            },
            {
                name: "Rex",
                breed: "American Shorthair",
                age: "1 year",
                gender: "Male",
                bio: "insert bio here",
                daysInShelter: 4,
                daysLeft: Infinity
            },
            {
                name: "Socks",
                breed: "American Shorthair",
                age: "8 years",
                gender: "Male",
                bio: "insert bio here",
                daysInShelter: 3,
                daysLeft: Infinity
            },
            {
                name: "Midnight",
                breed: "American Shorthair",
                age: "8 months",
                gender: "Female",
                bio: "insert bio here",
                daysInShelter: 32,
                daysLeft: 2
            }
        ];

        return Promise.resolve(SEARCH_RESULTS); // in actuality, will be returning resolve or reject from safeFetch via Api.get

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
        
       return axios({
            method: 'post',
            url: 'http://localhost:8080/contact',
            data: {
              firstName: 'Finn',
              lastName: 'Williams',
              subject: 'Complaint',
              email: 'ajcjjr@yahoo.com',
              shelterEmployee: 'no',
              message: 'Takes in'
            }
          }).catch((e)=>{
              console.log("Hello");
              console.log(e.message);
          });


          /*
        axios({
            method: 'post',
            url: 'http://localhost:8080/contact',
            data: {
              firstName: firstName,
              lastName: lastName,
              subject: 'Complaint',
              email: 'ajcjjr@yahoo.com',
              shelterEmployee: 'no',
              message: 'Takes in'
            }
          }).catch((e)=>{
              console.log("Hello");
              console.log(e.message);
          });
          */
          
        // Normally, we'd actually submit to the backend and resolve or reject the promise based off of the response (was there an error submitting?)
        //return Promise.resolve();
    }
}