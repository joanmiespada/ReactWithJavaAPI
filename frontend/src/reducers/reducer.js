    import {
        LOGIN_START, LOGIN_END
    } from '../actions/action'

    function reducer(state=[], action)
    {
        switch(action.type)
        {
            case LOGIN_START: 
                return [...state,{ login_completed: false, user: action.user, password: action.password}]
            case LOGIN_END:
                return [...state, {login_completed: true, userId: action.userId, userRoles: action.userRoles}]
            default:
                return state;
        }
    }

    export default reducer; 