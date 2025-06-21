package com.example.users.users_service.Security;
import com.google.firebase.auth.FirebaseToken;

public record FirebaseTokenHolder(FirebaseToken token) {
    public String getUid()      { return token.getUid(); }
    public String getEmail()    { return token.getEmail(); }
    public String getName()     { return (String) token.getClaims().get("name"); }
    public String getPicture()  { return (String) token.getClaims().get("picture"); }
}
