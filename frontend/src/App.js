import React, { Component } from 'react';
import Top from './components/Top';
import Middle from './components/Middle';
import Bottom from './components/Bottom';
import {Grid, Row, Col} from 'react-bootstrap';

class App extends Component {
  render() {
    return (
      <Grid>
        <Row className="show-grid">
          <Col xs={6} md={4}></Col>
          <Col xs={6} md={4}><Top/><Middle/><Bottom/></Col>
          <Col xsHidden md={4}></Col>
        </Row>
      </Grid>    
    );
  }
}

export default App;
