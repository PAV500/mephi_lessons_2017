/**
 * Created by Александр on 23.10.2017.
 */
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Bot extends TelegramLongPollingBot {

    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new Bot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "User_time_bot";
    }

    @Override
    public String getBotToken() {
        return "479432803:AAGzKtCQSh9tseX4Glb0MLAuLWRfCjJHHqA";
    }

    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        try {
                if ( message != null && message.hasText()) {
                    while (true) {
                        String dateFromServer = "2017-11-03-16-00";
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm");
                        Date date = sdf.parse(dateFromServer);
                        Date curDate = new Date();
                        if (curDate.getTime() == date.getTime()) {
                            sendMsg(message, "Через 15 минут начнется пара по < Теории информационных процессов и систем >");
                            try {
                                TimeUnit.DAYS.sleep(14);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            } catch(ParseException e){
                e.printStackTrace();
            }

    }

    private void sendMsg(Message message, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(text);
        try {
            sendMessage(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

}