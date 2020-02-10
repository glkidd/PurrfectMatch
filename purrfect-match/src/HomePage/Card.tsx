import React from 'react';
import './Card.css';

interface CardProps {
  image: string;
}

interface CardState {
};

export class Card extends React.Component<CardProps, CardState> {
  constructor(props: any) {
    super(props);

    this.state = {
    };
  }

  public render() {
    return (
      <div className="Card">
        <img src={this.props.image} />
      </div>
    )
  }
}