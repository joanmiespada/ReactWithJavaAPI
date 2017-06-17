import React, { Component } from 'react';
import { Button } from 'react-bootstrap';
import Login from './Login';

class Top extends Component {

  constructor(props)
  {
    super(props);
    this.state={ loged:false, message:'Login'};
  }

  login_setup_ok= (obj) =>{

        if(obj.ok)
        {
            this.setState({loged:true, message:'Logout'});
        }

  }

  chooseOpenLoginDialog=()=>{

  }

  render() {
    return (
      <div>
        <Button onClick={this.chooseOpenLoginDialog} >{this.state.message}</Button>
        <Login onLoginSetup={this.login_setup_ok} stateLogin={this.state.loged}  />
      </div>
    );
  }
}

export default Top;
