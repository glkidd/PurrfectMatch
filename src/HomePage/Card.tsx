import React from 'react';
import './Card.css';

interface CardProps {
    title : string;
    text? : string;
    image : string;
}

const Card = (props : CardProps) => (
    <div className="Card">
        <img src={props.image} />
        <h3>{props.title}</h3>
        <p>{props.text}</p>
    </div>
)

export default Card