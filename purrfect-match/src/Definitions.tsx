export interface SearchPageResults {
    name: string;
    breed: string;
    age: number;
    gender: string;
    bio: string;
    daysInShelter: number;
    daysLeft: number;
};

export interface SuccessStoryInfo {
    image: string;
    name: string;
    age: string; 
    storyText: string;
    breed: string;
    gender: string;
    adoptionDate: string;
    owner: string;
};

export interface RecentlyAdoptedInfo {
    image: string;
    name: string;
    age: string;
    breed: string;
    gender: string;
    adoptionDate: string;
    owner: String;
};

export let SUCCESS_STORY_PAGE_SIZE: number = 10;

export let NUM_RECENTLY_ADOPTED: number = 5;