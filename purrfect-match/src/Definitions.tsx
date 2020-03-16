export interface Filters {
    risk: boolean,
    age: string,
    gender: string,
    location: string
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


export interface SearchPageResults {
    name: string;
    breed: string;
    age: string;
    gender: string;
    bio: string;
    daysInShelter: number;
    daysLeft: number | undefined;
    photo: string;
    shelterId: number;
};

export interface ShelterPetInfo {
    name: string;
    breed: string;
    age: string;
    gender: number; // will map to an enum
    furLength: number; // will map to an enum
    bio: string;
    dateArrived: Date;
    euthanizeDate: Date | undefined;
    photo: string;
    spayNeut: boolean;
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