import React from 'react';
import PurrfectMenu from './PurrfectMenu/PurrfectMenu';
import Card from './HomePage/Card';

import logo from './PurrfectMenu/logo.png';

class App extends React.Component {
  render() {
    let links = [
      { label: 'Success Stories', link: '#success-stories', active: true },
      { label: 'Contact Us', link: '#contact-us' },
    ];

    return (
      <div>
        <div className="container center">
          <PurrfectMenu links={links} logo={logo} />
        </div>

        <div className="Cards">
          <div className="CardGroup">
            <Card
              title="Cat"
              image={require('./images/Cat_1.png')} />
            <Card
              title="Dog"
              image={require('./images/Dog_1.png')} />
            <Card
              title="Other"
              image={require('./images/Hamster_1.png')} />
          </div>
        </div>
      </div>
    );
  }
}

export default App;
