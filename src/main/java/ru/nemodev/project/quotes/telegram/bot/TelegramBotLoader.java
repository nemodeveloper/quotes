package ru.nemodev.project.quotes.telegram.bot;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.generics.BotSession;

import java.util.ArrayList;
import java.util.List;

public class TelegramBotLoader
{
    private static final Logger LOGGER = LoggerFactory.getLogger(TelegramBotLoader.class);

    private final List<TelegramLongPollingBot> longPollingBots;
    private final TelegramBotsApi telegramBotsApi;

    private List<BotSession> botSessions;

    public TelegramBotLoader(List<TelegramLongPollingBot> longPollingBots)
    {
        this.longPollingBots = longPollingBots;
        this.telegramBotsApi = new TelegramBotsApi();
    }

    public void start()
    {
        LOGGER.info("Запуск Telegram bots...");
        botSessions = new ArrayList<>(longPollingBots.size());
        longPollingBots.forEach(bot ->
        {
            try
            {
                botSessions.add(
                        telegramBotsApi.registerBot(bot));
                LOGGER.info(String.format("Bot - %s запущен!", bot.getBotUsername()));
            }
            catch (TelegramApiRequestException e)
            {
                LOGGER.error(String.format("Ошибка регистрации Telegram bot - %s", bot.getBotUsername()), e);
            }
        });
        LOGGER.info("Зупуск Telegram bots успешно завершен!");
    }

    public void stop()
    {
        botSessions.forEach(botSession ->
        {
            try
            {
                botSession.stop();
            }
            catch (Exception e)
            {
                LOGGER.error("Ошибка остановки сессии бота!", e);
            }
        });
        LOGGER.info("Работа Telegram bots завершена!");
    }
}
