package mate.academy.jvreviewanalyzer.repository;

import mate.academy.jvreviewanalyzer.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
