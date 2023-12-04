package bot.handler;

import model_repo.BasketRepo;
import delivery.Maps;
import delivery.Steps;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


public class CallbackQueryHandler {
    public static void handle(CallbackQuery callbackQueryHandler, TelegramLongPollingBot bot) throws TelegramApiException {
        if (callbackQueryHandler.getData().startsWith("+")) {
            incrementQuantity(callbackQueryHandler, bot);
        } else if (callbackQueryHandler.getData().startsWith("-")) {
            decrementQuantity(callbackQueryHandler, bot);
        } else if (callbackQueryHandler.getData().startsWith("basket")) {

            String[] split = callbackQueryHandler.getData().split(";");
            BasketRepo.add(callbackQueryHandler.getMessage().getChatId(), Long.parseLong(split[1]), Integer.parseInt(split[2]));

            bot.execute(new SendMessage(callbackQueryHandler.getMessage().getChatId().toString(), "Successfully added ✅"));

            TextHandler.menuButtons(callbackQueryHandler.getMessage(), bot);
            Maps.USER_STEPS.put(callbackQueryHandler.getMessage().getChatId(), Steps.MENU);
        }
    }

    private static void incrementQuantity(CallbackQuery callbackQuery, TelegramLongPollingBot bot) throws TelegramApiException {
        String[] split = callbackQuery.getData().split(";");
        InlineKeyboardMarkup inlineKeyboardMarkup = CommandHandler.productMurkup(Integer.parseInt(split[1]) + 1
                , Long.parseLong(split[2]));
        EditMessageReplyMarkup build = EditMessageReplyMarkup.builder()
                .replyMarkup(inlineKeyboardMarkup)
                .chatId(callbackQuery.getMessage().getChatId())
                .messageId(callbackQuery.getMessage().getMessageId())
                .build();
        bot.execute(build);


    }

    private static void decrementQuantity(CallbackQuery callbackQuery, TelegramLongPollingBot bot) throws TelegramApiException {
        String[] split = callbackQuery.getData().split(";");
        if (!split[1].equals("1")) {
            InlineKeyboardMarkup inlineKeyboardMarkup = CommandHandler.productMurkup(Integer.parseInt(split[1]) - 1
                    , Long.parseLong(split[2]));

            EditMessageReplyMarkup build = EditMessageReplyMarkup.builder()
                    .replyMarkup(inlineKeyboardMarkup)
                    .chatId(callbackQuery.getMessage().getChatId())
                    .messageId(callbackQuery.getMessage().getMessageId())
                    .build();
            bot.execute(build);


        }
    }

}
