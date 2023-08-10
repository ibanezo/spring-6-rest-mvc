package guru.springframework.spring6restmvc.service;

import com.opencsv.bean.CsvToBeanBuilder;
import guru.springframework.spring6restmvc.model.BeerCSVRecord;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.processing.Filer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@Service
public class BeerCsvServiceImpl implements BeerCsvService {
    @Override
    public List<BeerCSVRecord> convertCSV(File csvFile) {
        try {
            List<BeerCSVRecord> beerCSVRecords = new CsvToBeanBuilder<BeerCSVRecord>(new FileReader(csvFile))
                    .withType(BeerCSVRecord.class)
                    .build().parse();
            return beerCSVRecords;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
