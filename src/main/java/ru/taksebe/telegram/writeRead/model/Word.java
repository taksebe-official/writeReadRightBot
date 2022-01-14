package ru.taksebe.telegram.writeRead.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.Set;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("word")
public class Word {

    /**
     * Словарное слово
     */
    @Id
    String word;

    /**
     * Ошибочные варианты написания
     */
    Set<String> mistakes;

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Word word = (Word) obj;
        return this.word.equals(word.getWord());
    }

    @Override
    public int hashCode() {
        return this.word.hashCode();
    }
}