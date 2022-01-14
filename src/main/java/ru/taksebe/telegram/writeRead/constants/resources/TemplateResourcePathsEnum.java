package ru.taksebe.telegram.writeRead.constants.resources;

/**
 * Расположение файлов шаблонов в resources
 */
public enum TemplateResourcePathsEnum {
    TEMPLATE_TASKS("templates/Template.docx"),
    TEMPLATE_DICTIONARY("templates/Template.xlsx");

    private final String filePath;

    TemplateResourcePathsEnum(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }
}