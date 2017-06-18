import React, { Component } from 'react';
import { connect } from 'react-redux';
import {login_close} from '../actions/action';

class Bottom extends Component {

  constructor(props)
  {
    super(props);
  }

  componentDidMount = () =>{        
        this.timer = setInterval(this.tick, 1000);
  }

  componentWillUnmount = () =>{
        clearInterval(this.timer);
  }

  tick=() =>{

    if(this.props.loged){
       let f1 = new Date(); 
       if( f1 - this.props.dateLastLogin > 60000*5) //After 5 minutes your session will be closed!
          this.props.closeSession();
    }
  }

  render() {
    return (
      <p >React With Java API Rest Project</p>
    );
  }
}


const mapStateToProps = (state, ownProps) => {
  return { 
           loged: state.loged,
           dateLastLogin: state.dateLastLogin
            }
}

const mapDispatchToProps = (dispatch, ownProps) => {
  return {
    closeSession: () => { dispatch(login_close()) }
  }
}

const B_Bottom = connect(
  mapStateToProps,
  mapDispatchToProps
)(Bottom);




export default B_Bottom;