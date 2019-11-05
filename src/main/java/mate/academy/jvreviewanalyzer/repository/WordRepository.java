package mate.academy.jvreviewanalyzer.repository;
 
import java.util.List;
import mate.academy.jvreviewanalyzer.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
 
public interface WordRepository extends JpaRepository<Word, Long> {
    @Query(value = "SELECT text FROM word GROUP BY text"
            + " ORDER BY COUNT(text) DESC", nativeQuery = true)
    List<Word> find1000MostUsedWords();
}