package com.petsimulator;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.*;

public class PetSimulatorBot extends TelegramLongPollingBot {
    private final Map<Long, String> userStates = new HashMap<>();
    private final Map<String, String> referralLinks = new HashMap<>();

    @Override
    public String getBotUsername() {
        return "Legendary_PET_Simulator_Bot";
    }

    @Override
    public String getBotToken() {
        return "7601262240:AAFRCMbhqzZx1xDjVPeu9sFW-NyLzlJ9QrU";
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();
            String username = update.getMessage().getFrom().getFirstName();

            try {
                switch (messageText) {
                    case "/start":
                        sendMainMenu(chatId, username);
                        break;
                    case "🎮 Play":
                    case "/play":
                        sendPlayMessage(chatId);
                        break;
                    case "🔗 Referral Link":
                        sendReferralLink(chatId, username);
                        break;
                    case "👨‍💻 Author":
                        sendAuthorInfo(chatId);
                        break;
                    case "💱 Trade":
                        sendTradeMessage(chatId);
                        break;
                    case "🚪 Log Out":
                        handleLogout(chatId);
                        break;
                    case "❓ Need Help?":
                        sendHelpMessage(chatId);
                        break;
                    case "← Back":
                        sendMainMenu(chatId, username);
                        break;
                    default:
                        handleDefaultMessage(chatId);
                }
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    private void sendMainMenu(long chatId, String username) throws TelegramApiException {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("👋 Hi " + username + "!\n\n" +
                "🎮 Welcome to Pet Collector!\n" +
                "This game project was built using Java and TypeScript,\n" +
                "implementing algorithms like Bubble Sort and Heap Sort.\n" +
                "Try out my commands! 🚀");

        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboard = new ArrayList<>();
        
        KeyboardRow row1 = new KeyboardRow();
        row1.add("🎮 Play");
        
        KeyboardRow row2 = new KeyboardRow();
        row2.add("💱 Trade");
        row2.add("🔗 Referral Link");
        
        KeyboardRow row3 = new KeyboardRow();
        row3.add("👨‍💻 Author");
        row3.add("❓ Need Help?");
        
        KeyboardRow row4 = new KeyboardRow();
        row4.add("🚪 Log Out");

        keyboard.add(row1);
        keyboard.add(row2);
        keyboard.add(row3);
        keyboard.add(row4);

        keyboardMarkup.setKeyboard(keyboard);
        keyboardMarkup.setResizeKeyboard(true);
        message.setReplyMarkup(keyboardMarkup);

        execute(message);
    }

    private void sendPlayMessage(long chatId) throws TelegramApiException {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("🎮 Opening Pet Simulator game...\n🐾 Collect pets and trade with other players!");
        execute(message);
    }

    private void sendReferralLink(long chatId, String username) throws TelegramApiException {
        String referralLink = "https://t.me/Legendary_PET_Simulator_Bot?start=" + username.toLowerCase();
        referralLinks.put(username.toLowerCase(), referralLink);

        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("🔗 Here's your referral link:\n" + referralLink + 
                "\n\n✨ Share this link with friends to earn rewards!");

        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add("← Back");
        keyboard.add(row);
        keyboardMarkup.setKeyboard(keyboard);
        keyboardMarkup.setResizeKeyboard(true);
        message.setReplyMarkup(keyboardMarkup);

        execute(message);
    }

    private void sendAuthorInfo(long chatId) throws TelegramApiException {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("👨‍💻 The author of this game is: [Your Name]\n" +
                "Created as a school project implementing various sorting algorithms.");

        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add("← Back");
        keyboard.add(row);
        keyboardMarkup.setKeyboard(keyboard);
        keyboardMarkup.setResizeKeyboard(true);
        message.setReplyMarkup(keyboardMarkup);

        execute(message);
    }

    private void sendHelpMessage(long chatId) throws TelegramApiException {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("❓ Need help? Here's how to play:\n\n" +
                "1. 🎮 Click 'Play' to start collecting pets\n" +
                "2. 💱 Use 'Trade' to exchange pets with others\n" +
                "3. 🔗 Share your referral link to earn rewards\n\n" +
                "Still need assistance? Contact our support team!");

        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add("← Back");
        keyboard.add(row);
        keyboardMarkup.setKeyboard(keyboard);
        keyboardMarkup.setResizeKeyboard(true);
        message.setReplyMarkup(keyboardMarkup);

        execute(message);
    }

    private void sendTradeMessage(long chatId) throws TelegramApiException {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("💱 Opening trading market...\n🤝 Trade your pets with other players!");
        execute(message);
    }

    private void handleLogout(long chatId) throws TelegramApiException {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("👋 You have successfully logged out!");

        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add("/start");
        keyboard.add(row);
        keyboardMarkup.setKeyboard(keyboard);
        keyboardMarkup.setResizeKeyboard(true);
        message.setReplyMarkup(keyboardMarkup);

        execute(message);
    }

    private void handleDefaultMessage(long chatId) throws TelegramApiException {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("❌ I don't understand that command. Please use the menu buttons.");
        execute(message);
    }
}