package bot.handler.menu;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;

public class BurgersHnadler {
    public static void klassikBurger(Message message, TelegramLongPollingBot bot) throws TelegramApiException {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(message.getChatId());
        sendPhoto.setPhoto(new InputFile(new File("src/main/resources/Burgers/telegram-cloud-photo-size-2-5361993595491568046-x.jpg")));
        sendPhoto.setCaption("Классик \n" +
                "\n" +
                "Мягкая булочка, нежное куриное филе (Halal) в фирменной панировке, свежие помидоры, маринованные огурцы, салатные листья, соусы майонез и кетчуп \n" +
                "\n" +
                "Цена: 22 000  сум");
        bot.execute(sendPhoto);
    }

    public static void chizBurger(Message message, TelegramLongPollingBot bot) throws TelegramApiException {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(message.getChatId());
        sendPhoto.setPhoto(new InputFile(new File("src/main/resources/Burgers/telegram-cloud-photo-size-2-5361768401766305298-x.jpg")));
        sendPhoto.setCaption("Чикен Чиз \n" +
                "\n" +
                "Мягкая булочка, сочная куриная котлета (Halal), сыр чеддер, свежие помидоры, салатные листья айсберг, соусы майонез и кетчуп \n" +
                "\n" +
                "Цена: 23 000  сум");
        bot.execute(sendPhoto);
    }
    public static void barbekyuBurger(Message message,TelegramLongPollingBot bot) throws TelegramApiException {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(message.getChatId());
        sendPhoto.setPhoto(new InputFile(new File("src/main/resources/Burgers/telegram-cloud-photo-size-2-5361768401766305297-x.jpg")));
        sendPhoto.setCaption("Барбекю бургер \n" +
                "\n" +
                "Мягкая булочка, сочная куриная котлета (Halal) в фирменной панировке, свежие помидоры, салатные листья айсберг, соус майонез и аппетитный соус Барбекю \n" +
                "\n" +
                "Цена: 24 000  сум");
        bot.execute(sendPhoto);
    }
    public static void dablBurger(Message message, TelegramLongPollingBot bot) throws TelegramApiException {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(message.getChatId());
        sendPhoto.setPhoto(new InputFile(new File("src/main/resources/Burgers/telegram-cloud-photo-size-2-5361993595491568039-x.jpg")));
        sendPhoto.setCaption("Дабл чикен чиз \n" +
                "\n" +
                "Мягкая булочка, две сочные куриные котлеты (Halal), сыр чеддер, свежие помидоры, маринованные огурцы, салатные листья айсберг, соусы майонез и кетчуп \n" +
                "\n" +
                "Цена: 30 000  сум");
        bot.execute(sendPhoto);
    }
}
