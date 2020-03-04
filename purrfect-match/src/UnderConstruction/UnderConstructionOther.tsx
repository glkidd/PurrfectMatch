import React from 'react';
import logo from '../pictures/other-animal-homepage.jpg';
import './UnderConstructionDog.css';



export class UnderConstructionOther extends React.Component{

  public render() {
    return (
      <div className="UnderConstruction">
        <header className="UnderConstruction-header">
          <img src={logo} className="UnderConstruction-logo" alt="logo" />
          <p>
            Under Construction
        </p>
        </header>
      </div>
    );
  }
}


