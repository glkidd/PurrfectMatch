import React from 'react';
import './Footer.css';

interface FooterProps {
};

interface FooterState {
};

export default class Footer extends React.Component<FooterProps, FooterState> {
  constructor(props: any) {
    super(props);

    this.state = {
    };
  }

  public render() {
    return (
      <div>
        <div className="row">
          <div className="column">
            <div>
              <h3>Shelters</h3>
            </div>
            <div>
              <a className="footerLink" href="login">Shelter Login</a>
            </div>
          </div>
          <div className="column">
            <div>
              <h3>Navigation</h3>
            </div>
            <div>
              <a className="footerLink" href="">Home Page</a>
            </div>
            <div>
              <a className="footerLink" href="success">Success Stories</a>
            </div>
            <div>
              <a className="footerLink" href="contact">Contact Us</a>
            </div>
          </div>
          <div className="column">
            <div>
              <h3>Legal</h3>
            </div>
            <div>
              <a className="footerLink" href="terms">Terms of Service</a>
            </div>
            <div>
              <a className="footerLink" href="privacy">Privacy Policy</a>
            </div>
          </div>
        </div>
        <div className="copyrightStamp">
          Copyright 2020
        </div>
      </div >
    )
  }
}
