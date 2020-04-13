package module.dev.DAO;

import module.dev.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MailDAO extends JpaRepository<Email, Long> {
}
