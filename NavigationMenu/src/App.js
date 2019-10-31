import React, { Component } from 'react';
import PurrfectMenu from './PurrfectMenu';

import logo from './logo.png';

class App extends Component {
  render() {
    let links = [
      { label: 'Success Stories', link: '#Success-Stories', active: true },
      { label: 'Contact Us', link: '#Contact-Us' },
    ];

    return (
      <div className="container center">
        <PurrfectMenu links={links} logo={logo} />
      </div>
    );
  }
}

export default App;
