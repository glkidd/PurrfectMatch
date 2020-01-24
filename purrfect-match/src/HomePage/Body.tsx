import React from 'react';
import './Body.css';

interface BodyProps {
};

interface BodyState {
};

export default class Body extends React.Component<BodyProps, BodyState> {
  constructor(props: any) {
    super(props);

    this.state = {
    };
  }

  public render() {
    return (
      <div>
        <div className="body-wrapper">
          <div className="feature-1">
            <h1 className="feature-header">Lorem ipsum dolor</h1>
            <p className="paragraph-header">Lorem ipsum dolor, Lorem ipsum dolor</p>
          </div>
          <div className="feature-2">
            <h1 className="feature-header">Lorem ipsum dolor</h1>
            <p className="paragraph-header">Lorem ipsum dolor, Lorem ipsum dolor</p>
          </div>
          <div className="feature-3">
            <h1 className="feature-header">Lorem ipsum dolor</h1>
            <p className="paragraph-header">Lorem ipsum dolor, Lorem ipsum dolor</p>
          </div>
        </div>
      </div >
    )
  }
}

