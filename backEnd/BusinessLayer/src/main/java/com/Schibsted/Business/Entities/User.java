package com.Schibsted.Business.Entities;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by joanmi on 15/6/17.
 */
@ToString(callSuper=true, includeFieldNames=true)
public class User {

    @Getter @Setter private String Name;
    @Getter @Setter private Integer  Id;
    @Getter @Setter private String Password;
    @Getter @Setter private String Roles; //will be implemented as ACL -> https://en.wikipedia.org/wiki/Access_control_list

}
