package ru.taksebe.telegram.writeRead.api.dictionaries;

import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import ru.taksebe.telegram.writeRead.exceptions.DictionaryTooBigException;
import ru.taksebe.telegram.writeRead.model.Dictionary;
import ru.taksebe.telegram.writeRead.model.Word;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DictionaryAdditionService {
    private final DictionaryRepository repository;

    public void addUserDictionary(String userId, File file) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            repository.save(
                    Dictionary.builder()
                            .id(userId)
                            .wordList(createDictionary(new XSSFWorkbook(fileInputStream)))
                            .build()
            );
        }
    }

    public void addDefaultDictionary(String dictionaryId, XSSFWorkbook workbook) {
        repository.save(Dictionary.builder().id(dictionaryId).wordList(createDictionary(workbook)).build());
    }

    private List<Word> createDictionary(XSSFWorkbook workbook) {
        XSSFSheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();

        List<Word> result = new ArrayList<>();
        while (rowIterator.hasNext()) {
            result.add(createDictionaryWord(rowIterator.next()));
        }
        result.remove(0);

        if (result.size() > 1000) {
            throw new DictionaryTooBigException();
        }
        return result;
    }

    private Word createDictionaryWord(Row row) {
        Iterator<Cell> cellIterator = row.iterator();

        List<String> line = new ArrayList<>();
        while (cellIterator.hasNext()) {
            line.add(cellIterator.next().getStringCellValue());
        }

        String key = line.get(0);
        line.remove(0);

        return new Word(key, new HashSet<>(line));
    }
}