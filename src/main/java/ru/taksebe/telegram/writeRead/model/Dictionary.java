package ru.taksebe.telegram.writeRead.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.List;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Getter
@RedisHash("dictionary")
@Builder
public class Dictionary {

    /**
     * Идентификатор - для пользовательских словарей это id чата с пользователем в Telegram, для предзагруженных -
     * элементы перечисления путей до словарей по умочанию (пакет constants)
     */
    @Id
    String id;

    /**
     * Список словарных слов
     */
    List<Word> wordList;
}