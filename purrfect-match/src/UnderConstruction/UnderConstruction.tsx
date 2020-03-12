import React from 'react';
import logo from '../pictures/dog-homepage.jpg';
import logos from '../pictures/other-animal-homepage.jpg';
import './UnderConstruction.css';

interface compactViewProps {
  logo: any;
}


export class UnderConstruction extends React.Component<compactViewProps>{

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
