package ru.taksebe.telegram.writeRead.constants.resources;

import lombok.Getter;

/**
 * Расположение файлов словарей по умолчанию в resources
 */
public enum DictionaryResourcePathEnum {
    CLASS_1("dictionaries/разделитель1 gradeразделитель.xlsx", "1 класс"),
    CLASS_2("dictionaries/разделитель2 gradeразделитель.xlsx", "2 класс"),
    CLASS_3("dictionaries/разделитель3 gradeразделитель.xlsx", "3 класс"),
    CLASS_4("dictionaries/разделитель4 gradeразделитель.xlsx", "4 класс");

    private final String filePath;
    @Getter
    private final String buttonName;

    DictionaryResourcePathEnum(String filePath, String buttonName) {
        this.filePath = filePath;
        this.buttonName = buttonName;
    }

    public String getFilePath() {
        return filePath.replace("разделитель", "");
    }

    public String getFileName() {
        return filePath.split("разделитель")[1];
    }
}