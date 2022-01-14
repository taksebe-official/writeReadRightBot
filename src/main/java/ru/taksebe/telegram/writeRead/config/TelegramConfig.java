package ru.taksebe.telegram.writeRead.config;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TelegramConfig {
    @Value("${telegram.webhook-path}")
    String webHookPath;
    @Value("${telegram.user}")
    String userName;
    @Value("${telegram.token}")
    String botToken;
}