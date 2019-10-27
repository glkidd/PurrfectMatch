import React, { Component } from 'react';
import PurrfectMenu from './PurrfectMenu';

import logo from './logo.png';

class App extends Component {
  render() {
    let links = [
      { label: 'Success Stories', link: '#portfolio', active: true },
      { label: 'Contact Us', link: '#contact-us' },
    ];

    return (
      <div className="container center">
        <PurrfectMenu links={links} logo={logo} />
      </div>
    );
  }
}

export default App;
