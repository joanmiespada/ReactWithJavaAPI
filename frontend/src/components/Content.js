import React, { Component } from 'react';
import { connect } from 'react-redux';


class Content extends Component {
  render() {

    let text ='';
    if(this.props.roles.indexOf( this.props.rolesAllowed) === -1)
        text='no enought privilegies';
    else
        text='you can see this content'

    return (
        <div>
            <p>{text}</p>
        </div>
    );
  }
}

const mapStateToProps = (state, ownProps) => {
  return { 
           roles: state.userRoles
            }
}

const C_Content = connect(
  mapStateToProps,
  //mapDispatchToProps
)(Content)


export default C_Content;