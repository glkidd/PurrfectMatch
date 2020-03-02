import React from 'react';
import './Body.css';

interface BodyProps {
};

interface BodyState {
};

export class Body extends React.Component<BodyProps, BodyState> {
  constructor(props: any) {
    super(props);

    this.state = {
    };
  }

  public render() {
    return (
      <div>
        <div className="body-wrapper">
          <div>
            <h1 className="feature-header">1. Find your perfect pet!</h1>
            <p className="paragraph-header">We've partnered with hundreds of animal shelters to help you with the process.</p>
          </div>
          <div>
            <h1 className="feature-header">2. Contact the shelter.</h1>
            <p className="paragraph-header">Each pet should have contact information for its respective shelter.</p>
          </div>
          <div>
            <h1 className="feature-header">3. Pick up your companion.</h1>
            <p className="paragraph-header">Once you pick up your companion you can leave a success story and be featured on the site.</p>
          </div>
        </div>
      </div >
    )
  }
}

