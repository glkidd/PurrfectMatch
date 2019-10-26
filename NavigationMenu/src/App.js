import React, { Component } from 'react';
import PurrfectMenu from './PurrfectMenu';

import logo from './logo.png';

class App extends Component {
  render() {
    let links = [
      { label: 'Find a Pet', link: '#home', active: true },
      { label: 'Our Match', link: '#about' },
      { label: 'Success Stories', link: '#portfolio' },
      { label: 'Contact Us', link: '#contact-us' },
      { label: 'Donate', link: '#contact-us' },
    ];

    return (
      <div className="container center">
        <PurrfectMenu links={links} logo={logo} />
      </div>
    );
  }
}

export default App;
