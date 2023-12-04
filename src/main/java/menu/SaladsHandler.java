package menu;

import bot.handler.CommandHandler;
import model_repo.ProductRepo;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;

public class SaladsHandler {
    public static void sezarSalad(Message message, TelegramLongPollingBot bot) throws TelegramApiException {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setReplyMarkup(CommandHandler.productMurkup(1,8));
        sendPhoto.setChatId(message.getChatId());
        sendPhoto.setPhoto(new InputFile(new File("src/main/resources/Salads/telegram-cloud-photo-size-2-5362056615546703391-x.jpg")));
        sendPhoto.setCaption(
                ProductRepo.PRODUCT_LIST.get(7).getName()+ProductRepo.PRODUCT_LIST.get(7).getDescription()+ProductRepo.PRODUCT_LIST.get(7).getPrice()+" sum"
        );
        bot.execute(sendPhoto);
    }

    public static void greekSalad(Message message, TelegramLongPollingBot bot) throws TelegramApiException {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setReplyMarkup(CommandHandler.productMurkup(1,10));
        sendPhoto.setChatId(message.getChatId());
        sendPhoto.setPhoto(new InputFile(new File("src/main/resources/Salads/telegram-cloud-photo-size-2-5361623506749607620-x.jpg")));
        sendPhoto.setCaption(
                ProductRepo.PRODUCT_LIST.get(9).getName()+ProductRepo.PRODUCT_LIST.get(9).getDescription()+ProductRepo.PRODUCT_LIST.get(9).getPrice()+" sum"
        );
        bot.execute(sendPhoto);
    }

    public static void sezamSalad(Message message, TelegramLongPollingBot bot) throws TelegramApiException {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setReplyMarkup(CommandHandler.productMurkup(1,9));
        sendPhoto.setChatId(message.getChatId());
        sendPhoto.setPhoto(new InputFile(new File("src/main/resources/Salads/telegram-cloud-photo-size-2-5359449961240057609-x.jpg")));
        sendPhoto.setCaption(
                ProductRepo.PRODUCT_LIST.get(8).getName()+ProductRepo.PRODUCT_LIST.get(8).getDescription()+ProductRepo.PRODUCT_LIST.get(8).getPrice()+" sum"
        );
        bot.execute(sendPhoto);
    }


}
