package bot.handler;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

public class TextHandler {
    public static void handle(Message message, TelegramLongPollingBot bot) throws TelegramApiException {
        if(message.getText().equals("Menu")){
            ReplyKeyboardMarkup build = ReplyKeyboardMarkup.builder()
                    .keyboardRow(new KeyboardRow(List.of(KeyboardButton.builder().text("Burgers \uD83C\uDF54").build(),
                            KeyboardButton.builder().text("Salads \uD83E\uDD57").build())))
                    .keyboardRow(new KeyboardRow(
                            List.of(KeyboardButton.builder().text("Beverages \uD83E\uDD42").build(),
                                    KeyboardButton.builder().text("Back ⬅\uFE0F").build()))).build();
            SendMessage sendMessage = new SendMessage(message.getChatId().toString(), "Menu");
            sendMessage.setReplyMarkup(build);
            bot.execute(sendMessage);
        } else if (message.getText().equals("Burgers \uD83C\uDF54")) {
            buregerButtons(message,bot);
        } else if (message.getText().equals("Salads \uD83E\uDD57")) {
            saladButtons(message,bot);
        } else if (message.getText().equals("Beverages \uD83E\uDD42")) {
            beverageButtons(message,bot);
        } else if (message.getText().equals("Back ⬅\uFE0F")) {
            CommandHandler.commondStart(message,bot);
        }
    }

    private static void saladButtons(Message message, TelegramLongPollingBot bot) throws TelegramApiException {
        InlineKeyboardMarkup build = InlineKeyboardMarkup.builder()
                .keyboardRow(List.of(
                        InlineKeyboardButton.builder().text("Caesar").callbackData("sezr").build(),
                        InlineKeyboardButton.builder().text("Greek").callbackData("greek").build()))
                .keyboardRow(List.of(
                        InlineKeyboardButton.builder().text("Sezam").callbackData("sezam").build())).build();
        SendMessage sendMessage = new SendMessage(message.getChatId().toString(), "Salads");
        sendMessage.setReplyMarkup(build);
        bot.execute(sendMessage);
    }

    public static void buregerButtons(Message message,TelegramLongPollingBot bot) throws TelegramApiException {
        InlineKeyboardMarkup build = InlineKeyboardMarkup.builder()
                .keyboardRow(List.of(
                        InlineKeyboardButton.builder().text("Klassik burger").callbackData("klassik").build(),
                        InlineKeyboardButton.builder().text("Chiken chiz").callbackData("chiz").build()))
                .keyboardRow(List.of(
                        InlineKeyboardButton.builder().text("Barbekyu burger").callbackData("barbekyu").build(),
                        InlineKeyboardButton.builder().text("Dabl chiken chiz").callbackData("dabl").build())).build();
        SendMessage sendMessage = new SendMessage(message.getChatId().toString(), "Burgers");
        sendMessage.setReplyMarkup(build);
        bot.execute(sendMessage);
    }
    public static void beverageButtons(Message message,TelegramLongPollingBot bot) throws TelegramApiException {
        InlineKeyboardMarkup build = InlineKeyboardMarkup.builder()
                .keyboardRow(List.of(
                        InlineKeyboardButton.builder().text("Montella").callbackData("motella").build(),
                        InlineKeyboardButton.builder().text("Fanta").callbackData("fanta").build()))
                .keyboardRow(List.of(
                        InlineKeyboardButton.builder().text("Sprite").callbackData("sprite").build())).build();
        SendMessage sendMessage = new SendMessage(message.getChatId().toString(), "Beverages");
        sendMessage.setReplyMarkup(build);
        bot.execute(sendMessage);
    }
}
