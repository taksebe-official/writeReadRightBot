package ru.taksebe.telegram.writeRead.api.dictionaries;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Component;
import ru.taksebe.telegram.writeRead.utils.FileUtils;
import ru.taksebe.telegram.writeRead.utils.ResourceLoader;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class DictionaryResourceFileService {
    private final ResourceLoader resourceLoader;

    public ByteArrayResource getTemplateWorkbook() throws IOException {
        return FileUtils.createOfficeDocumentResource(
                resourceLoader.loadTemplateWorkbook(),
                "Template",
                "xlsx");
    }
}