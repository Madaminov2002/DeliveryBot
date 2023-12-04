package bot.handler;

import delivery.DeliveryBot;
import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

public class CommandHandler {
    @SneakyThrows
    public static void handle(final Message message, final TelegramLongPollingBot bot) {
        switch (CommandEnum.of(message.getText())){
            case START: commondStart(message,bot);

        }
    }

    public static void commondStart(Message message, TelegramLongPollingBot bot) throws TelegramApiException {
        ReplyKeyboardMarkup replyKeyboardMarkup = ReplyKeyboardMarkup.builder()
                .keyboardRow(new KeyboardRow(List.of(
                        KeyboardButton.builder().text("Menu").build()))).build();
        replyKeyboardMarkup.setResizeKeyboard(true);
        SendMessage sendMessage = new SendMessage(message.getChatId().toString(), "Delivery \uD83D\uDE9A");
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        bot.execute(sendMessage);
    }
    public static InlineKeyboardMarkup productMurkup(int quantity, long prductId){
        InlineKeyboardMarkup build = InlineKeyboardMarkup.builder()
                .keyboardRow(List.of(
                        InlineKeyboardButton.builder().text("-").callbackData("-;" + quantity +";"+ prductId).build()
                        , InlineKeyboardButton.builder().text(String.valueOf(quantity)).callbackData("num").build()
                        , InlineKeyboardButton.builder().text("+").callbackData("+;" + quantity +";"+ prductId).build()))
                .keyboardRow(List.of(InlineKeyboardButton.builder().text("Add to basket ✅").callbackData("basket;" +prductId+";"+quantity).build()))
                .build();
        return build;
    }
}
