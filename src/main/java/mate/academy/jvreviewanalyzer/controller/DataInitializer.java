package mate.academy.jvreviewanalyzer.controller;

import com.opencsv.CSVReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import mate.academy.jvreviewanalyzer.entity.Review;
import mate.academy.jvreviewanalyzer.entity.Word;
import mate.academy.jvreviewanalyzer.repository.ReviewRepository;
import mate.academy.jvreviewanalyzer.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private WordRepository wordRepository;

    @PostConstruct
    public void initData() throws Exception {
        List<String[]> strings = readCsv();
        for (String[] string : strings) {
            Review review = new Review(string[1], string[3], string[9]);
            reviewRepository.save(review);
            String[] s = string[9].replaceAll("[^a-zA-Z\\s]", "").trim().split(" ");
            for (String s1 : s) {
                Word word = new Word(s1);
                wordRepository.save(word);
            }
        }
    }

    private List<String[]> readCsv() throws Exception {
        Reader reader = Files.newBufferedReader(Paths.get(
                ClassLoader.getSystemResource("Reviews.csv").toURI()));
        return readAll(reader);
    }

    private List<String[]> readAll(Reader reader) throws Exception {
        CSVReader csvReader = new CSVReader(reader);
        List<String[]> list = csvReader.readAll();
        reader.close();
        csvReader.close();
        return list;
    }
}
