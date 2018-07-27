package edu.inconcept.netflix.service.impl;

import edu.inconcept.netflix.service.model.ImdbcsvRecord;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.*;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ImdbCSVParserService {


    public List<ImdbcsvRecord> parseImdbCsv(String csvPath) throws IOException {
       Path paths = Paths.get(csvPath);
       List<Path> fileList = Files.list(paths)
               .filter(Files::isRegularFile)
               .filter(f->!f.endsWith(".csv"))
               .collect(Collectors.toList());
       List<ImdbcsvRecord> allRecords = new ArrayList<>();
       for (Path path : fileList){
           allRecords.addAll(parseImdbCsvFile(path));
       }
       return allRecords;
    }

    private List<ImdbcsvRecord> parseImdbCsvFile(Path filePath) throws IOException {
        List<ImdbcsvRecord> imdbcsvRecordList = new ArrayList<>();
        Reader reader = Files.newBufferedReader(filePath);
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                .withFirstRecordAsHeader()
                .withIgnoreHeaderCase()
                .withTrim());

        for (CSVRecord csvRecord : csvParser) {
            if (csvRecord.isConsistent()) {
                String position = csvRecord.get("position").trim();
                String constant = csvRecord.get("const").trim();
                String created = csvRecord.get("created").trim();
                String title = csvRecord.get("title").trim();
                String titleTypeName = csvRecord.get("title type").trim();
                String directors = csvRecord.get("directors").trim();
                String imdbRating = csvRecord.get("IMDb rating").trim();
                String accountRating = csvRecord.get(8).trim();
                String runtim = csvRecord.get("runtime (mins)").trim();
                String genres = csvRecord.get("genres").trim();
                String numberVotes = csvRecord.get("num. votes").trim();
                String releaseDate = csvRecord.get("Release Date (month/day/year)").trim();
                String url = csvRecord.get("url").trim();

                String path = filePath.getFileName().toString();
                String fileName = path.substring(0, path.lastIndexOf("."));
                Long imdbAccountId = Long.parseLong(fileName);



                Double imdbRated = Double.parseDouble(imdbRating.equals("") ? "0.0" : imdbRating);
                Integer runtime = Integer.parseInt(runtim.equals("") ? "0" : runtim);
                Long numVotes = Long.parseLong(numberVotes.equals("") ? "0" : numberVotes);
                Date releseDate = parseDate(releaseDate);
                Date creatdeDate = parseJavaUtilDate(created);
                Integer accountRated = Integer.parseInt(accountRating.equals("") ? "0" : accountRating);
                String[] genreName = Arrays.stream(genres.split(",")).map(String::trim).toArray(String[]::new);
                List<String> genresList = Arrays.asList(genreName);
                String[] directorName = Arrays.stream(directors.split(",")).map(String::trim).toArray(String[]::new);
                List<String> directorsList = Arrays.asList(directorName);

                imdbcsvRecordList.add(new ImdbcsvRecord(constant, creatdeDate, title, titleTypeName, directorsList,
                        accountRated, imdbRated, runtime, genresList,
                        numVotes, releseDate, url, imdbAccountId));
            }
        }
        return imdbcsvRecordList;
    }



    private static java.util.Date parseDate(String date){
        SimpleDateFormat dateTime = new SimpleDateFormat("yyyy-MM-dd",Locale.US);
        try {
            return  dateTime.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }
    private static java.util.Date parseJavaUtilDate(String dateString) {
        SimpleDateFormat dateTime = new SimpleDateFormat("EEE MMM dd HH:mm:ss yyyy", Locale.US);
        try {
            return dateTime.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
