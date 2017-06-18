import {
    LOGIN_START, LOGIN_END, LOGIN_ERROR, LOGIN_CLOSE
} from '../actions/action'


const initialState = {  
  userName: '',
  userId:'',
  userRoles:'',
  dateLastLogin: undefined,
  login_completed: false,
  loged:false
}

function reducer(state=initialState, action)
{
    switch(action.type)
    {
        case LOGIN_START: 
            return Object.assign({}, state, {login_completed: false, userName: action.user })
        case LOGIN_END:
            return Object.assign({}, state, {login_completed: true, 
                                            userId: action.userId, 
                                            userRoles: action.userRoles, 
                                            loged:true,
                                            dateLastLogin: Date.now() })
        case LOGIN_ERROR:
            return Object.assign({}, state,{ login_completed:false,
                                            userId: '', 
                                            userRoles: '', 
                                            loged:false,
                                            dateLastLogin: undefined })
        case LOGIN_CLOSE:
            return Object.assign({}, state,{ login_completed:false,
                                            userId: '', 
                                            userRoles: '', 
                                            loged:false,
                                            dateLastLogin: undefined })
        default:
            return state;
    }
}

export default reducer; 