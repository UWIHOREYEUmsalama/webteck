package peter.student.services.StudentServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peter.student.dao.userAuthentication;
import peter.student.model.Signup;
import peter.student.repository.SignupRepository;
import peter.student.services.SignupInterface;
@Service
public class SignupImp implements SignupInterface {
  userAuthentication  dao=new userAuthentication();
    @Autowired
    SignupRepository signupRepository;

    public SignupImp() {
    }

    @Override
    public Signup saveAccount(Signup signup) {
        return signupRepository.save(signup);
    }

    @Override
    public Signup findAccount(String password) {
        return signupRepository.findById(password).get();
    }

    @Override
    public boolean userCheck(String email, String password) {

        return dao.loginUser(email, password);
    }
}
