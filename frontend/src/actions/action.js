
export const LOGIN_START ='LOGIN_START';
export const LOGIN_END ='LOGIN_END';

export function login_start(usr, pass)
{
    return { type: LOGIN_START, user:usr, password:pass }
}

export function login_end(usrId, roles)
{
    return { type: LOGIN_END, userId:usrId, userRoles:roles }
}

