package com.Schibsted.api.Models;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by joanmi on 16/6/17.
 */
public class User  extends Model{

    @Getter @Setter private String Name;
    @Getter @Setter private String Roles;
}
