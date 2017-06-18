import React, { Component } from 'react';
import { Button } from 'react-bootstrap';
import Login from './Login';
import { connect } from 'react-redux';
import {login_close} from '../actions/action'; 

class Top extends Component {

  constructor(props)
  {
    super(props);
    
    
  }

  chooseOpenLoginDialog=()=>{
        this.props.closeSession();
  }

  render() {
    return (
      <div>
        <Button onClick={this.chooseOpenLoginDialog} >{!this.props.loged ? 'Login': 'Logout'} </Button>
        <Login onLoginSetup={this.login_setup_ok}   />
      </div>
    );
  }
}

const mapStateToProps = (state, ownProps) => {
  return { userName: state.userName,
           loged: state.loged,
           login_completed: state.login_completed }
}

const mapDispatchToProps = (dispatch, ownProps) => {
  return {
    closeSession: () => { dispatch(login_close()) }
  }
}

const T_Top = connect(
  mapStateToProps,
  mapDispatchToProps
)(Top);

export default T_Top;
