package bot.handler;

import bot.handler.menu.BeveragesHandler;
import bot.handler.menu.BurgersHnadler;
import bot.handler.menu.SaladsHandler;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class CallbackQueryHandler {
    public static void handle(final CallbackQuery callbackQuery, final TelegramLongPollingBot bot) throws TelegramApiException {
        if (callbackQuery.getData().equals("klassik")) {
            BurgersHnadler.klassikBurger(callbackQuery.getMessage(), bot);
        } else if (callbackQuery.getData().equals("chiz")) {
            BurgersHnadler.chizBurger(callbackQuery.getMessage(), bot);
        } else if (callbackQuery.getData().equals("barbekyu")) {
            BurgersHnadler.barbekyuBurger(callbackQuery.getMessage(),bot);
        } else if (callbackQuery.getData().equals("dabl")) {
            BurgersHnadler.dablBurger(callbackQuery.getMessage(),bot);
        } else if (callbackQuery.getData().equals("sezr")) {
            SaladsHandler.sezarSalad(callbackQuery.getMessage(),bot);
        } else if (callbackQuery.getData().equals("greek")) {
            SaladsHandler.greekSalad(callbackQuery.getMessage(),bot);
        } else if (callbackQuery.getData().equals("sezam")) {
            SaladsHandler.sezamSalad(callbackQuery.getMessage(),bot);
        } else if (callbackQuery.getData().equals("montella")) {
            BeveragesHandler.montella(callbackQuery.getMessage(),bot);
        } else if (callbackQuery.getData().equals("fanta")) {
            BeveragesHandler.fanta(callbackQuery.getMessage(),bot);
        } else if (callbackQuery.getData().equals("sprite")) {
            BeveragesHandler.sprite(callbackQuery.getMessage(),bot);
        }
    }




}
