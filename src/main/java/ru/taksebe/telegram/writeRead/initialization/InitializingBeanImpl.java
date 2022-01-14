package ru.taksebe.telegram.writeRead.initialization;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import ru.taksebe.telegram.writeRead.api.dictionaries.DictionaryAdditionService;
import ru.taksebe.telegram.writeRead.utils.ResourceLoader;

import java.util.Map;

/**
 * Загрузчик в БД словарей по умолчанию при инициализации приложения
 */
@Component
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class InitializingBeanImpl implements InitializingBean {
    DictionaryAdditionService dictionaryAdditionService;
    ResourceLoader resourceLoader;

    @Override
    public void afterPropertiesSet() {
        Map<String, XSSFWorkbook> defaultDictionaryMap = resourceLoader.getDefaultDictionaries();
        for (Map.Entry<String, XSSFWorkbook> pair : defaultDictionaryMap.entrySet()) {
            dictionaryAdditionService.addDefaultDictionary(pair.getKey(), pair.getValue());
        }
    }
}