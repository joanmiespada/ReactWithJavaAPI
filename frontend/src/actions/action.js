
import axios from 'axios'

export const LOGIN_START ='LOGIN_START';

function login_start_ready(usr)
{
    return { type: LOGIN_START, user:usr }
}

export function login_start(usr,pwd)
{
    return dispatch => {
        dispatch(login_start_ready(usr))
        return axios.get('http://localhost:8000/login',{ params:{ user:usr, pass:pwd } })
            .then( response=>{
                dispatch( login_end(response.data ) )
                
               }).catch( error=>{
                   console.log(error)
                   dispatch( login_error(error ) )
                } )
    };
}

export const LOGIN_END ='LOGIN_END';

function login_end(payload)
{
    let usrId = payload.id;
    let roles = payload.roles;
    return { type: LOGIN_END, userId:usrId, userRoles:roles }
}

export const LOGIN_ERROR ='LOGIN_ERROR';

export function login_error(error)
{
    return { type: LOGIN_ERROR, error:error}
}

export const LOGIN_CLOSE ='LOGIN_CLOSE';

export function login_close()
{
    return { type: LOGIN_CLOSE}
}



