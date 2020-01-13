import { SuccessStoryInfo, SUCCESS_STORY_PAGE_SIZE } from "./Definitions";
import { RecentlyAdoptedInfo, NUM_RECENTLY_ADOPTED } from "./Definitions";

/*
    This class is used for whenever we need to get data from the server. 
*/
export class Api {
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

    public static submitContactInfo = (firstName: string, lastName: string, subject: string, email: string, shelterEmployee: string, message: string): Promise<void> => {
        // Normally, we'd actually submit to the backend and resolve or reject the promise based off of the response (was there an error submitting?)
        return Promise.resolve();
    }
}