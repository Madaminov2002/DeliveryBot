package bot.handler;

import delivery.*;
import menu.BeveragesHandler;
import menu.BurgersHnadler;
import menu.SaladsHandler;
import model_repo.BasketRepo;
import model_repo.ProductModel;
import model_repo.ProductRepo;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TextHandler {
    public static void handle(Message message, TelegramLongPollingBot bot) throws TelegramApiException {
        Steps steps = Maps.USER_STEPS.get(message.getChatId());
        if (message.getText().equals("Menu")) {
            menuButtons(message, bot);
            Maps.USER_STEPS.put(message.getChatId(), Steps.MENU);
        } else if (message.getText().equals("Burgers \uD83C\uDF54")) {
            buregerButtons(message, bot);
            Maps.USER_STEPS.put(message.getChatId(), Steps.BURGERS);
        } else if (message.getText().equals("Salads \uD83E\uDD57")) {
            saladButtons(message, bot);
            Maps.USER_STEPS.put(message.getChatId(), Steps.SALADS);
        } else if (message.getText().equals("Beverages \uD83E\uDD42")) {
            beverageButtons(message, bot);
            Maps.USER_STEPS.put(message.getChatId(), Steps.BEVERAGES);
        } else if (message.getText().equals("Back ◀\uFE0F") && steps == Steps.MENU) {
            CommandHandler.commondStart(message, bot);

            BasketRepo.BASKET_MAP = new HashMap<>();

        } else if (message.getText().equals("Back ◀\uFE0F") && (steps == Steps.BEVERAGES || steps == Steps.SALADS || steps == Steps.BURGERS)) {
            menuButtons(message, bot);
            Maps.USER_STEPS.put(message.getChatId(), Steps.MENU);
        } else if (message.getText().equals("Klassik burger")) {
            BurgersHnadler.klassikBurger(message, bot);
        } else if (message.getText().equals("Chiken chiz")) {
            BurgersHnadler.chizBurger(message, bot);
        } else if (message.getText().equals("Barbekyu burger")) {
            BurgersHnadler.barbekyuBurger(message, bot);
        } else if (message.getText().equals("Dabl chiken chiz")) {
            BurgersHnadler.dablBurger(message, bot);
        } else if (message.getText().equals("Caesar")) {
            SaladsHandler.sezarSalad(message, bot);
        } else if (message.getText().equals("Greek")) {
            SaladsHandler.greekSalad(message, bot);
        } else if (message.getText().equals("Sezam")) {
            SaladsHandler.sezamSalad(message, bot);
        } else if (message.getText().equals("Montella")) {
            BeveragesHandler.montella(message, bot);
        } else if (message.getText().equals("Fanta")) {
            BeveragesHandler.fanta(message, bot);
        } else if (message.getText().equals("Sprite")) {
            BeveragesHandler.sprite(message, bot);
        }
        else if (message.getText().equals("My basket \uD83D\uDDD1")) {
            String data = "";
            int price =0;
            Map<Long, Integer> longIntegerMap = BasketRepo.BASKET_MAP.get(message.getChatId());
            Set<Long> keys = longIntegerMap.keySet();
            for (Long key : keys) {
                ProductModel byId = ProductRepo.getById(key);
                Integer quantity = longIntegerMap.get(byId.getId());
                data += byId.getName() + "Quentity:" + quantity +" , "+"Price: "+byId.getPrice() * quantity+" sum"+ "\n\n";
                price+= (int) (byId.getPrice()*quantity);
            }
                bot.execute(new SendMessage(message.getChatId().toString(), data+"\n"+"All sum: "+price + " sum"));
        }
    }

    private static void saladButtons(Message message, TelegramLongPollingBot bot) throws TelegramApiException {
        ReplyKeyboardMarkup build = ReplyKeyboardMarkup.builder()
                .keyboardRow(new KeyboardRow(List.of(
                        KeyboardButton.builder().text("Caesar").build(),
                        KeyboardButton.builder().text("Greek").build())))
                .keyboardRow(new KeyboardRow(List.of(
                        KeyboardButton.builder().text("Sezam").build())))
                .keyboardRow(new KeyboardRow(List.of(KeyboardButton.builder().text("Back ◀\uFE0F").build()))).build();
        build.setResizeKeyboard(true);
        SendMessage sendMessage = new SendMessage(message.getChatId().toString(), "Salads");
        sendMessage.setReplyMarkup(build);
        bot.execute(sendMessage);
    }

    public static void buregerButtons(Message message, TelegramLongPollingBot bot) throws TelegramApiException {
        ReplyKeyboardMarkup build = ReplyKeyboardMarkup.builder()
                .keyboardRow(new KeyboardRow(List.of(
                        KeyboardButton.builder().text("Klassik burger").build(),
                        KeyboardButton.builder().text("Chiken chiz").build())))
                .keyboardRow(new KeyboardRow(List.of(
                        KeyboardButton.builder().text("Barbekyu burger").build(),
                        KeyboardButton.builder().text("Dabl chiken chiz").build())))
                .keyboardRow(new KeyboardRow(List.of(KeyboardButton.builder().text("Back ◀\uFE0F").build()))).build();
        build.setResizeKeyboard(true);
        SendMessage sendMessage = new SendMessage(message.getChatId().toString(), "Burgers");
        sendMessage.setReplyMarkup(build);
        bot.execute(sendMessage);
    }

    public static void beverageButtons(Message message, TelegramLongPollingBot bot) throws TelegramApiException {
        ReplyKeyboardMarkup build = ReplyKeyboardMarkup.builder()
                .keyboardRow(new KeyboardRow(List.of(
                        KeyboardButton.builder().text("Montella").build(),
                        KeyboardButton.builder().text("Fanta").build())))
                .keyboardRow(new KeyboardRow(List.of(
                        KeyboardButton.builder().text("Sprite").build())))
                .keyboardRow(new KeyboardRow(List.of(KeyboardButton.builder().text("Back ◀\uFE0F").build()))).build();
        build.setResizeKeyboard(true);
        SendMessage sendMessage = new SendMessage(message.getChatId().toString(), "Beverages");
        sendMessage.setReplyMarkup(build);
        bot.execute(sendMessage);
    }

    public static void menuButtons(Message message, TelegramLongPollingBot bot) throws TelegramApiException {
        ReplyKeyboardMarkup build = ReplyKeyboardMarkup.builder()
                .keyboardRow(new KeyboardRow(List.of(KeyboardButton.builder().text("Burgers \uD83C\uDF54").build(),
                        KeyboardButton.builder().text("Salads \uD83E\uDD57").build())))
                .keyboardRow(new KeyboardRow(
                        List.of(KeyboardButton.builder().text("Beverages \uD83E\uDD42").build(),
                                KeyboardButton.builder().text("Back ◀\uFE0F").build())))
                .keyboardRow(new KeyboardRow(List.of(KeyboardButton.builder().text("My basket \uD83D\uDDD1").build()))).build();
        build.setResizeKeyboard(true);
        SendMessage sendMessage = new SendMessage(message.getChatId().toString(), "Menu");
        sendMessage.setReplyMarkup(build);
        bot.execute(sendMessage);
    }
}
