import { SuccessStoryInfo, SUCCESS_STORY_PAGE_SIZE } from "./Definitions";

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
                age: 4,
                storyText: "Some story about how this cat was saved from horrible living conditions and is doing much better now."
            },
            {
                image: "Cat_1.png",
                name: "Fluffy",
                age: 36,
                storyText: "Another success story here"
            },
            {
                image: "Dog_1.png",
                name: "Mr. Woof",
                age: 60,
                storyText: "Okay, success stories really should be longer but eh. "

            }
        ];
        let fakeApiResult = ALL_SUCCESS_STORIES.slice(SUCCESS_STORY_PAGE_SIZE * breakpoint, SUCCESS_STORY_PAGE_SIZE * breakpoint + SUCCESS_STORY_PAGE_SIZE);
        return Promise.resolve(fakeApiResult);
    }
}