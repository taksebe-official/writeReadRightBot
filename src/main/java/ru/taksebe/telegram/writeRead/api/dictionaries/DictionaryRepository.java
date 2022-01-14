package ru.taksebe.telegram.writeRead.api.dictionaries;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.taksebe.telegram.writeRead.model.Dictionary;

@Repository
public interface DictionaryRepository  extends CrudRepository<Dictionary, String> {
}