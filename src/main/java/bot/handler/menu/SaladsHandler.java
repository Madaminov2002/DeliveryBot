package bot.handler.menu;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;

public class SaladsHandler {
    public static void sezarSalad(Message message, TelegramLongPollingBot bot) throws TelegramApiException {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(message.getChatId());
        sendPhoto.setPhoto(new InputFile(new File("src/main/resources/Salads/telegram-cloud-photo-size-2-5362056615546703391-x.jpg")));
        sendPhoto.setCaption("Цезарь \n" +
                "\n" +
                "Куриное филе (Halal), сыр пармезан, помидоры черри, сухари, салатные листья айсберг, соус цезарь \n" +
                "\n" +
                "Цена: 26 000  сум");
        bot.execute(sendPhoto);
    }

    public static void greekSalad(Message message, TelegramLongPollingBot bot) throws TelegramApiException {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(message.getChatId());
        sendPhoto.setPhoto(new InputFile(new File("src/main/resources/Salads/telegram-cloud-photo-size-2-5361623506749607620-x.jpg")));
        sendPhoto.setCaption("Греческий \n" +
                "\n" +
                "Салат из сочных салатных листьев, помидоров, маслин, свежих огурцов и сыра фетакса, приправленный лимонным соусом и соусом базилик \n" +
                "\n" +
                "Цена: 25 000  сум");
        bot.execute(sendPhoto);
    }

    public static void sezamSalad(Message message, TelegramLongPollingBot bot) throws TelegramApiException {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(message.getChatId());
        sendPhoto.setPhoto(new InputFile(new File("src/main/resources/Salads/telegram-cloud-photo-size-2-5359449961240057609-x.jpg")));
        sendPhoto.setCaption("Сезам \n" +
                "\n" +
                "Сочные листья салата айсберг и кусочки нежнейшего куриного филе (Halal), посыпанные кунжутом, в аппетитном соусе терияки \n" +
                "\n" +
                "Цена: 22 000  сум\n" +
                "\n" +
                "Греческий \n" +
                "...");
        bot.execute(sendPhoto);
    }


}
