package peter.student.dao;



import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import peter.student.model.Signup;

import java.util.List;

public class userAuthentication {
    public boolean loginUser(String email, String password) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Signup so WHERE so.email = :email AND so.password = :password", Signup.class)
                    .setParameter("email", email)
                    .setParameter("password", password)
                    .getResultStream()
                    .findFirst()
                    .isPresent();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
