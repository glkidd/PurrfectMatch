import React from 'react';
import './UnderConstruction.css';

interface compactViewProps {
  logo: any;
}


export class UnderConstruction extends React.Component<compactViewProps>{

  public render() {
    return (
      <div className="UnderConstruction">
        <header className="UnderConstruction-header">
          <img src={this.props.logo} className="UnderConstruction-logo" alt="logo" />
          <p>
            Under Construction
        </p>
        </header>
      </div>
    );
  }
}
