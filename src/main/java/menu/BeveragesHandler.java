package menu;

import bot.handler.CommandHandler;
import model_repo.ProductRepo;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;

public class BeveragesHandler {
    public static void montella(Message message, TelegramLongPollingBot bot) throws TelegramApiException {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setReplyMarkup(CommandHandler.productMurkup(1, 5));
        sendPhoto.setChatId(message.getChatId());
        sendPhoto.setPhoto(new InputFile(new File("src/main/resources/beverages/telegram-cloud-photo-size-2-5361781866488779041-x.jpg")));
        sendPhoto.setCaption(
                ProductRepo.PRODUCT_LIST.get(4).getName() +
                        ProductRepo.PRODUCT_LIST.get(4).getPrice() + " sum"
        );
        bot.execute(sendPhoto);
    }


    public static void fanta(Message message, TelegramLongPollingBot bot) throws TelegramApiException {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setReplyMarkup(CommandHandler.productMurkup(1, 6));
        sendPhoto.setChatId(message.getChatId());
        sendPhoto.setPhoto(new InputFile(new File("src/main/resources/beverages/telegram-cloud-photo-size-2-5359758593294978755-x.jpg")));
        sendPhoto.setCaption(
                ProductRepo.PRODUCT_LIST.get(5).getName() +
                        ProductRepo.PRODUCT_LIST.get(5).getPrice() + " sum"
        );
        bot.execute(sendPhoto);
    }

    public static void sprite(Message message, TelegramLongPollingBot bot) throws TelegramApiException {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setReplyMarkup(CommandHandler.productMurkup(1, 7));
        sendPhoto.setChatId(message.getChatId());
        sendPhoto.setPhoto(new InputFile(new File("src/main/resources/beverages/telegram-cloud-photo-size-2-5362030042584042889-x.jpg")));
        sendPhoto.setCaption(
                ProductRepo.PRODUCT_LIST.get(6).getName() +
                        ProductRepo.PRODUCT_LIST.get(6).getPrice() + " sum"
        );
        bot.execute(sendPhoto);
    }
}
