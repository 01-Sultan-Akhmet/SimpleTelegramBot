import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


public class simpleBot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        BurgerClass burgerClass = new BurgerClass();
        FrenchFriesClass frenchFriesClass = new FrenchFriesClass();
        DrinksClass drinksClass = new DrinksClass();
        StartingClass startingClass = new StartingClass();

        int total = 0;
        String[] myOrderMenu = new String[10];
        int[] myorderPrice = new int[10];
        int myOrderNumbers = 1;
        System.out.println(update.getMessage().getText());
        SendMessage responce = new SendMessage();
        responce.setChatId(update.getMessage().getChatId().toString());

//        System.out.println(update.getMessage().getDate());
//        SendMessage responce2 = new SendMessage();
//        responce2.setChatId(String.valueOf(update.getMessage().getChatId().intValue()));


        String commands = update.getMessage().getText();
        if (commands.equals("/start")) {
            responce.setText("Choose one number: ");
            try {
                execute(responce);
            } catch (TelegramApiException E) {
                E.printStackTrace();
            }
            for (int i = 1; i < startingClass.getStartingMenu().length; i++) {
                responce.setText(i + ". " + startingClass.getStartingMenu()[i]);
                try {
                    execute(responce);
                } catch (TelegramApiException E) {
                    E.printStackTrace();
                }
            }
            //String StartsCommand = update.getMessage().getText();

//            responce.setText(""+StartsCommand);
//            try {
//                execute(responce);
//            } catch (TelegramApiException E) {
//                E.printStackTrace();
//            }

            int StartsCommand = update.getMessage().getDate();

            do {
                //if (StartsCommand.equals("1") || StartsCommand.equals("2") || StartsCommand.equals("3")) {
                if (StartsCommand == 1 || StartsCommand == 2 || StartsCommand == 3) {
                    // menu
                    //if (StartsCommand.equals("1")) {
                    if (StartsCommand == 1) {
                        responce.setText("Choose one number: ");
                        try {
                            execute(responce);
                        } catch (TelegramApiException E) {
                            E.printStackTrace();
                        }
                        for (int i = 1; i < startingClass.getMenu().length; i++) {
                            responce.setText(i + ". " + startingClass.getMenu()[i]);
                            try {
                                execute(responce);
                            } catch (TelegramApiException E) {
                                E.printStackTrace();
                            }
                        }
                        //String menuCommand = update.getMessage().getText();
                        int menuCommand = update.getMessage().getDate();

                        // burger
                        //if (menuCommand.equals("1")) {
                        if (menuCommand == 1){
                            for (int i = 1; i < burgerClass.getBurgerMenu().length; i++) {
                                responce.setText(i + ". " + burgerClass.getBurgerMenu()[i]);
                                try {
                                    execute(responce);
                                } catch (TelegramApiException E) {
                                    E.printStackTrace();
                                }
                            }
                            String burgerCommand = update.getMessage().getText();
                            if (burgerCommand.equals("1") || burgerCommand.equals("2") || burgerCommand.equals("3") || burgerCommand.equals("4")) {
                                int burgerCommandInt = 0;
                                if (burgerCommand.equals("1"))
                                    burgerCommandInt = 1;
                                if (burgerCommand.equals("2"))
                                    burgerCommandInt = 2;
                                if (burgerCommand.equals("3"))
                                    burgerCommandInt = 3;
                                if (burgerCommand.equals("4"))
                                    burgerCommandInt = 4;
                                myOrderMenu[myOrderNumbers] = burgerClass.getBurgerMenu()[burgerCommandInt];
                                myorderPrice[myOrderNumbers] = burgerClass.getBurgerPrice()[burgerCommandInt];
                                myOrderNumbers += 1;
                                total += burgerClass.getBurgerPrice()[burgerCommandInt];
                            }
                        }

                        //French fries
                        //if (menuCommand.equals("2")) {
                        if (menuCommand == 2){
                            for (int i = 1; i < frenchFriesClass.getFriesMenu().length; i++) {
                                responce.setText(i + ". " + frenchFriesClass.getFriesMenu()[i]);
                                try {
                                    execute(responce);
                                } catch (TelegramApiException E) {
                                    E.printStackTrace();
                                }
                            }
                            String friesCommand = update.getMessage().getText();
                            if (friesCommand.equals("1") || friesCommand.equals("2") || friesCommand.equals("3")) {
                                int friesCommandInt = 0;
                                if (friesCommand.equals("1"))
                                    friesCommandInt = 1;
                                if (friesCommand.equals("2"))
                                    friesCommandInt = 2;
                                if (friesCommand.equals("3"))
                                    friesCommandInt = 3;
                                myOrderMenu[myOrderNumbers] = frenchFriesClass.getFriesMenu()[friesCommandInt];
                                myorderPrice[myOrderNumbers] = frenchFriesClass.getFriesPrice()[friesCommandInt];
                                myOrderNumbers += 1;
                                total += frenchFriesClass.getFriesPrice()[friesCommandInt];
                            }
                        }

                        //drinks
                        //if (menuCommand.equals("3")) {
                        if (menuCommand == 3){
                            for (int i = 1; i < drinksClass.getDrinksMenu().length; i++) {
                                responce.setText(i + ". " + drinksClass.getDrinksMenu()[i]);
                                try {
                                    execute(responce);
                                } catch (TelegramApiException E) {
                                    E.printStackTrace();
                                }
                            }
                            String drinksCommand = update.getMessage().getText();
                            if (drinksCommand.equals("1") || drinksCommand.equals("2") || drinksCommand.equals("3") || drinksCommand.equals("4") || drinksCommand.equals("5")) {
                                int drinksCommandInt = 0;
                                if (drinksCommand.equals("1"))
                                    drinksCommandInt = 1;
                                if (drinksCommand.equals("2"))
                                    drinksCommandInt = 2;
                                if (drinksCommand.equals("3"))
                                    drinksCommandInt = 3;
                                if (drinksCommand.equals("4"))
                                    drinksCommandInt = 4;
                                if (drinksCommand.equals("5"))
                                    drinksCommandInt = 5;
                                myOrderMenu[myOrderNumbers] = drinksClass.getDrinksMenu()[drinksCommandInt];
                                myorderPrice[myOrderNumbers] = drinksClass.getDrinksPrice()[drinksCommandInt];
                                myOrderNumbers += 1;
                                total += drinksClass.getDrinksPrice()[drinksCommandInt];
                            }
                        }

                    }
                    //if (StartsCommand.equals("2")) {
                    if (StartsCommand == 2) {
                        for (int i = 1; i < myOrderMenu.length; i++) {
                            responce.setText(i + ". " + myOrderMenu[i] + "-" + myorderPrice[i] + " tg");
                            try {
                                execute(responce);
                            } catch (TelegramApiException E) {
                                E.printStackTrace();
                            }
                        }
                        responce.setText("Total: " + total);
                        try {
                            execute(responce);
                        } catch (TelegramApiException E) {
                            E.printStackTrace();
                        }
                    }
                    //if (StartsCommand.equals("3")) {
                    if (StartsCommand == 3) {
                        myOrderMenu = new String[10];
                        myorderPrice = new int[10];
                        myOrderNumbers = 1;
                    }

                    responce.setText("Choose one number: ");
                    try {
                        execute(responce);
                    } catch (TelegramApiException E) {
                        E.printStackTrace();
                    }
                    for (int i = 1; i < startingClass.getStartingMenu().length; i++) {
                        responce.setText(i + ". " + startingClass.getStartingMenu()[i]);
                        try {
                            execute(responce);
                        } catch (TelegramApiException E) {
                            E.printStackTrace();
                        }
                    }
                    StartsCommand = update.getMessage().getDate();
                }
            //} while (StartsCommand.equals("4"));
            } while (StartsCommand != 4);
        }

    }

    @Override
    public String getBotUsername() {
        // TODO
        return "By_Erlan_Sultan_bot";
    }

    @Override
    public String getBotToken() {
        // TODO
        return "2101637212:AAH4I4GQxMsJco-ak7YCiNIhPu1wcDnBpGw";
    }
}
