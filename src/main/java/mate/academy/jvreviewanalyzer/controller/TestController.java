package mate.academy.jvreviewanalyzer.controller;

import java.util.List;
import mate.academy.jvreviewanalyzer.entity.Review;
import mate.academy.jvreviewanalyzer.entity.Word;
import mate.academy.jvreviewanalyzer.repository.ReviewRepository;
import mate.academy.jvreviewanalyzer.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/index")
public class TestController {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private WordRepository wordRepository;

    @GetMapping("/review")
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @GetMapping("/word")
    public List<Word> getAllWords() {
        List<Word> mostUsedWords = wordRepository.find1000MostUsedWords();
        return mostUsedWords;
    }
}
