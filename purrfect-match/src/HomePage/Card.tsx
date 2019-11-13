import React from 'react';
import './Card.css';

interface CardProps {
  title: string;
  text?: string;
  image: string;
}

interface CardState {
};

class Card extends React.Component<CardProps, CardState> {
  constructor(props: any) {
    super(props);

    this.state = {
    };
  }

  public render() {
    return (
      <div className="Card">
        <img src={this.props.image} />
        <h3>{this.props.title}</h3>
        <p>{this.props.text}</p>
      </div>
    )
  }
}

export default Card;