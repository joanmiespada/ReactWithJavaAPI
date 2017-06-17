import React, { Component } from 'react';
import { Panel } from 'react-bootstrap';

class Middle extends Component {
  render() {
    return (
      <div>
        
        <Panel header="Welcome" bsStyle="primary">
            <p>Hola {} </p>
        </Panel>
      </div>
    );
  }
}

export default Middle;