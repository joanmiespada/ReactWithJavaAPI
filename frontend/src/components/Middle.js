import React, { Component } from 'react';
import { Panel,Tabs,Tab } from 'react-bootstrap';
import { connect } from 'react-redux';
import Content from './Content'

class Middle extends Component {

  handleSelect = (key) =>{

  }  

  render() {
    return (
      <div>
        <Panel header="Welcome" bsStyle="primary">
            <p>Hola {this.props.userName}, your roles: {this.props.roles} </p>
            <Tabs defaultActiveKey={1} onSelect={this.handleSelect} id="controlled-tab-example">
                <Tab eventKey={1} title="Page1"><Content rolesAllowed="page1" /></Tab>
                <Tab eventKey={2} title="Page2"><Content rolesAllowed="page2" /></Tab>
                <Tab eventKey={3} title="Page3"><Content rolesAllowed="page3" /></Tab>
                <Tab eventKey={4} title="admin"><Content rolesAllowed="admin" /></Tab>
            </Tabs>
        </Panel>
      </div>
    );
  }
}

const mapStateToProps = (state, ownProps) => {
  return { userName: state.userName,
           loged: state.loged,
           roles: state.userRoles
            }
}

const M_Middle = connect(
  mapStateToProps,
  //mapDispatchToProps
)(Middle)

export default M_Middle;