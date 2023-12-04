package menu;

import bot.handler.CommandHandler;
import model_repo.ProductRepo;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;

public class BurgersHnadler {
    public static void klassikBurger(Message message, TelegramLongPollingBot bot) throws TelegramApiException {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setReplyMarkup(CommandHandler.productMurkup(1,1));
        sendPhoto.setChatId(message.getChatId());
        sendPhoto.setPhoto(new InputFile(new File("src/main/resources/Burgers/telegram-cloud-photo-size-2-5361993595491568046-x.jpg")));
        sendPhoto.setCaption(
                ProductRepo.PRODUCT_LIST.get(0).getName()+
                ProductRepo.PRODUCT_LIST.get(0).getDescription()+
                "sum: " + ProductRepo.PRODUCT_LIST.get(0).getPrice()
        );
        bot.execute(sendPhoto);
    }

    public static void chizBurger(Message message, TelegramLongPollingBot bot) throws TelegramApiException {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setReplyMarkup(CommandHandler.productMurkup(1,2));
        sendPhoto.setChatId(message.getChatId());
        sendPhoto.setPhoto(new InputFile(new File("src/main/resources/Burgers/telegram-cloud-photo-size-2-5361768401766305298-x.jpg")));
        sendPhoto.setCaption(
                ProductRepo.PRODUCT_LIST.get(1).getName()+
                ProductRepo.PRODUCT_LIST.get(1).getDescription()+
                "sum: " + ProductRepo.PRODUCT_LIST.get(1).getPrice()
        );
        bot.execute(sendPhoto);
    }

    public static void barbekyuBurger(Message message, TelegramLongPollingBot bot) throws TelegramApiException {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setReplyMarkup(CommandHandler.productMurkup(1,3));
        sendPhoto.setChatId(message.getChatId());
        sendPhoto.setPhoto(new InputFile(new File("src/main/resources/Burgers/telegram-cloud-photo-size-2-5361768401766305297-x.jpg")));
        sendPhoto.setCaption(
                ProductRepo.PRODUCT_LIST.get(2).getName()+
                ProductRepo.PRODUCT_LIST.get(2).getDescription()+
                "sum: " + ProductRepo.PRODUCT_LIST.get(2).getPrice()
        );
        bot.execute(sendPhoto);
    }

    public static void dablBurger(Message message, TelegramLongPollingBot bot) throws TelegramApiException {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setReplyMarkup(CommandHandler.productMurkup(1,4));
        sendPhoto.setChatId(message.getChatId());
        sendPhoto.setPhoto(new InputFile(new File("src/main/resources/Burgers/telegram-cloud-photo-size-2-5361993595491568039-x.jpg")));
        sendPhoto.setCaption(
                ProductRepo.PRODUCT_LIST.get(3).getName()+
                ProductRepo.PRODUCT_LIST.get(3).getDescription()+
                "sum: " + ProductRepo.PRODUCT_LIST.get(3).getPrice()
        );
        bot.execute(sendPhoto);
    }
}
