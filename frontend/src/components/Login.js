import React, { Component } from 'react';
import { Button, Modal,FormGroup,ControlLabel,FormControl,HelpBlock } from 'react-bootstrap';
import { connect } from 'react-redux';
import {login_start} from '../actions/action';

function FieldGroup({ id, label, help, ...props }) {
  return (
    <FormGroup controlId={id}>
      <ControlLabel>{label}</ControlLabel>
      <FormControl {...props} />
      {help && <HelpBlock>{help}</HelpBlock>}
    </FormGroup>
  );
}


class Login extends Component {

  constructor(props) {
      super(props);
      //this.state = {showModal: true};
  }

  /*close= ()=> {
    this.setState({ showModal: false });
  }

  open= ()=> {
    this.setState({ showModal: true });
  }*/

  loginReady=()=>{
     let userName = this.name.value;
     let userPass = this.pwd.value;
     this.props.login(userName,userPass);
  }

  render() {
    return (
      <div>
        <Modal show={!this.props.loged} >
            <Modal.Header>
                <Modal.Title>Login</Modal.Title>
            </Modal.Header>

            <Modal.Body>
                <form>
                    <FieldGroup
                        id="formControlsText"
                        type="text"
                        label="Nombre"
                        placeholder="Escribe aquí tu nombre"
                        inputRef={(ref) => {this.name = ref}}
                        defaultValue="Jhon"
                        />
                    <FieldGroup
                        id="formControlsPassword"
                        label="Password"
                        type="password"
                        defaultValue="123456"
                        inputRef={(ref) => {this.pwd = ref}}
                        />
                </form>
            </Modal.Body>

            <Modal.Footer>
                <Button bsStyle="primary" onClick={this.loginReady}>Login</Button>
            </Modal.Footer>

        </Modal>
      </div>
    );
  }
}


const mapStateToProps = (state, ownProps) => {
  return { userName: state.userName,
           loged: state.loged,
            }
}

const mapDispatchToProps = (dispatch, ownProps) => {
  return {
    login: (user,pass) => { dispatch(login_start(user,pass)) }
  }
}

const L_Login = connect(
  mapStateToProps,
  mapDispatchToProps
)(Login)


export default L_Login;