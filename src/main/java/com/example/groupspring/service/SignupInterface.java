package peter.student.services;

import peter.student.model.Signup;

public interface SignupInterface {
    public Signup saveAccount(Signup signup);
    public Signup findAccount(String password);
    public boolean userCheck(String email, String password );
}
