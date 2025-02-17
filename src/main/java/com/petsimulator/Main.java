package com.petsimulator;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
    public static void main(String[] args) {
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new PetSimulatorBot());
            System.out.println("Pet Simulator Bot is running!");
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}