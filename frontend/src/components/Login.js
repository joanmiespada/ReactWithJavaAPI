import React, { Component } from 'react';
import { Button, Modal } from 'react-bootstrap';

class Login extends Component {

  constructor(props) {
      super(props);
     //this.state = {showModal: true};
  }

  close= ()=> {
    //this.setState({ showModal: false });
  }

  open= ()=> {
    //this.setState({ showModal: true });
  }

  login=()=>{
     //this.setState({ showModal: false }); 
     this.props.stateLogin=false;
  }

  render() {
    return (
      <div>
        <Modal show={this.props.stateLogin} onHide={this.close} >
            <Modal.Header>
                <Modal.Title>Login</Modal.Title>
            </Modal.Header>

            <Modal.Body>
                One fine body...
            </Modal.Body>

            <Modal.Footer>
                <Button onClick={this.close}>Close</Button>
                <Button bsStyle="primary" onClick={this.login}>Login</Button>
            </Modal.Footer>

        </Modal>
      </div>
    );
  }
}

export default Login;