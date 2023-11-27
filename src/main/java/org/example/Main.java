package org.example;

import delivery.DeliveryBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, TelegramApiException {
        TelegramBotsApi botsApi=new TelegramBotsApi(DefaultBotSession.class);
        botsApi.registerBot(new DeliveryBot());
    }
}
