package bot.handler.menu;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;

public class BeveragesHandler {
    public static void montella(Message message, TelegramLongPollingBot bot) throws TelegramApiException {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(message.getChatId());
        sendPhoto.setPhoto(new InputFile(new File("src/main/resources/beverages/telegram-cloud-photo-size-2-5361781866488779041-x.jpg")));
        sendPhoto.setCaption("Montella \n" +
                "\n" +
                " \n" +
                "\n" +
                "Цена: 3 000  сум");
        bot.execute(sendPhoto);
    }

    public static void sprite(Message message, TelegramLongPollingBot bot) throws TelegramApiException {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(message.getChatId());
        sendPhoto.setPhoto(new InputFile(new File("src/main/resources/beverages/telegram-cloud-photo-size-2-5362030042584042889-x.jpg")));
        sendPhoto.setCaption("SPRITE \n" +
                "\n" +
                " \n" +
                "\n" +
                "Цена: 8 000  сум");
        bot.execute(sendPhoto);
    }

    public static void fanta(Message message, TelegramLongPollingBot bot) throws TelegramApiException {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(message.getChatId());
        sendPhoto.setPhoto(new InputFile(new File("src/main/resources/beverages/telegram-cloud-photo-size-2-5359758593294978755-x.jpg")));
        sendPhoto.setCaption("FANTA \n" +
                "\n" +
                " \n" +
                "\n" +
                "Цена: 8 000  сум\n" +
                "\n" +
                "SPRITE \n" +
                "...");
        bot.execute(sendPhoto);
    }
}
