import React from 'react';
import { Redirect } from "react-router-dom";
import { ShelterAddPetModal } from 'ShelterAddPetModal';

interface ShelterHomeProps {
};

interface ShelterHomeState {
};

var shelterName = "Woods Humane Society";

export class ShelterHomePage extends React.Component<ShelterHomeProps, ShelterHomeState> {
    constructor(props: any) {
        super(props);

        this.state = {
        };
    }

    public render() {
        return (
            <div className="centered">
                <h1>
                    Welcome: {shelterName}
                </h1>
                <ShelterAddPetModal cat={true} dog={false} otherAnimal={false} animalInfo={null}/>
                <ShelterAddPetModal cat={false} dog={true} otherAnimal={false} animalInfo={null}/>
                <ShelterAddPetModal cat={false} dog={false} otherAnimal={true} animalInfo={null}/>

            </div>
        );
    }
}


