export interface Sorter {
    risk: boolean,
    time: boolean,
    ageAsc: boolean,
    ageDesc: boolean
}

export interface Filters {
    risk: boolean,
    age: string,
    gender: string,
    location: string
};

export interface SearchPageResults {
    name: string;
    breed: string;
    age: string;
    gender: string;
    bio: string;
    daysInShelter: number;
    daysLeft: number | undefined;
    shelterName: string;
    photo: string;
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

export interface ShelterAccountInfo {
    email: string;
    shelterName: string;
    street: string;
    city: string;
    state: string;
    zipCode: number;
    phoneNumber: number;
    website: string; 
    id: number;
}

export let SUCCESS_STORY_PAGE_SIZE: number = 10;

export let NUM_RECENTLY_ADOPTED: number = 5;