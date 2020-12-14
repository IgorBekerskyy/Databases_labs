package com.bekerskyy.view;


import com.bekerskyy.controller.*;
import com.bekerskyy.model.*;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MainView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private final BonusAccountController bonusAccountController ;
    private final CityController cityController ;
    private final ClientController clientController;
    private final GoodController goodController ;
    private final OrderController orderController ;
    private final PackagingController packagingController ;
    private final SalonController salonController;


    private final Map<String, Printable> menu = new LinkedHashMap<>();


    public MainView(){
        this.bonusAccountController = new BonusAccountController();
        this.cityController = new CityController();
        this.clientController = new ClientController();
        this.goodController = new GoodController();
        this.orderController = new OrderController();
        this.packagingController = new PackagingController();
        this.salonController = new SalonController();


        menu.put("11", this::getAllBonusAccounts);
        menu.put("12", this::getBonusAccountById);
        menu.put("13", this::createBonusAccount);
        menu.put("14", this::updateBonusAccount);
        menu.put("15", this::deleteBonusAccount);

        menu.put("21", this::getAllCities);
        menu.put("22", this::getCityById);
        menu.put("23", this::createCity);
        menu.put("24", this::updateCity);
        menu.put("25", this::deleteCity);

        menu.put("31", this::getAllClients);
        menu.put("32", this::getClientById);
        menu.put("33", this::createClient);
        menu.put("34", this::updateClient);
        menu.put("35", this::deleteClient);

        menu.put("41", this::getAllGoods);
        menu.put("42", this::getGoodById);
        menu.put("43", this::createGood);
        menu.put("44", this::updateGood);
        menu.put("45", this::deleteGood);

        menu.put("51", this::getAllOrders);
        menu.put("52", this::getOrderById);
        menu.put("53", this::createOrder);
        menu.put("54", this::updateOrder);
        menu.put("55", this::deleteOrder);

        menu.put("61", this::getAllPackagings);
        menu.put("62", this::getPackagingById);
        menu.put("63", this::createPackaging);
        menu.put("64", this::updatePackaging);
        menu.put("65", this::deletePackaging);

        menu.put("71", this::getAllSalons);
        menu.put("72", this::getSalonById);
        menu.put("73", this::createSalon);
        menu.put("74", this::updateSalon);
        menu.put("75", this::deleteSalon);





    }

    public void displayMenu() {
        System.out.println("=======================================================================");
        System.out.println("                 Enter XY to choose the option, where:");
        System.out.println("=======================================================================");
        System.out.println("X - entity number:               |          Y - CRUD number:");
        System.out.println("  1 - bonus_account              |          1 - GET ALL");
        System.out.println("  2 - city                       |          2 - GET ONE");
        System.out.println("  3 - client                     |          3 - CREATE");
        System.out.println("  4 - good                       |          4 - UPDATE");
        System.out.println("  5 - order                      |          5 - DELETE");
        System.out.println("  6 - packaging");
        System.out.println("  7 - salon");
        System.out.println("=======================================================================");
    }

    public final void show() {
        String input;
        displayMenu();
        System.out.println("\nChoose your fighter:\n");
        do {
            try {
                input = SCANNER.next();
                menu.get(input).print();
            } catch (Exception ignored) {
            }
        } while (SCANNER.hasNext());
    }

    private void getAllBonusAccounts() throws SQLException {
        System.out.println("\n[BonusAccount / GET]");
        System.out.println(bonusAccountController.getAll() + "\n");
    }

    private void getBonusAccountById() throws SQLException {
        System.out.println("\n[BonusAccount / GET] Enter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(bonusAccountController.getById(id) + "\n");
    }

    private BonusAccount getBonusAccountsInputs() {
        System.out.println("\nEnter type: ");
        String type = SCANNER.next();
        System.out.println("\nEnter promocode: ");
        String promocode = SCANNER.next();

        return new BonusAccount(type, promocode);
    }

    private void createBonusAccount () throws SQLException {
        System.out.println("\n[BonusAccount / CREATE]");
        BonusAccount bonusAccount = getBonusAccountsInputs();
        bonusAccountController.create(bonusAccount);
        System.out.println("BonusAccount successfully created\n");
    }

    private void updateBonusAccount () throws SQLException {
        System.out.println("\n[BonusAccount/ UPDATE] Enter ID: ");
        Integer id = SCANNER.nextInt();
        BonusAccount bonusAccount = getBonusAccountsInputs();
        bonusAccount.setId(id);

        bonusAccountController.update(bonusAccount.getId(), bonusAccount);
        System.out.println("BonusAccount with ID=" + id + " successfully updated\n");
    }

    private void deleteBonusAccount() throws SQLException {
        System.out.println("\n[BonusAccount / DELETE] Enter ID: ");
        int id = SCANNER.nextInt();

        bonusAccountController.delete(id);
        System.out.println("BonusAccount ID=" + id + " successfully deleted\n");
    }


    private void getAllCities() throws SQLException {
        System.out.println("\n[Cities / GET]");
        System.out.println(cityController.getAll() + "\n");
    }

    private void getCityById() throws SQLException {
        System.out.println("\n[Cities / GET] Enter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(cityController.getById(id) + "\n");
    }


    private City getCitiesInputs() {
        System.out.println("Enter name: ");
        String name = SCANNER.next();
        System.out.println("Enter region_name: ");
        String region_name = SCANNER.next();

        return new City(name, region_name);
    }

    private void createCity () throws SQLException {
        System.out.println("\n[City / CREATE]");
        City city = getCitiesInputs();
        cityController.create(city);
        System.out.println("City successfully created\n");
    }

    private void updateCity () throws SQLException {
        System.out.println("\n[City/ UPDATE] Enter ID: ");
        Integer id = SCANNER.nextInt();
        City city =  getCitiesInputs();
        city.setId(id);

        cityController.update(city.getId(), city);
        System.out.println("City with ID=" + id + " successfully updated\n");
    }

    private void deleteCity() throws SQLException {
        System.out.println("\n[City / DELETE] Enter ID: ");
        int id = SCANNER.nextInt();

        cityController.delete(id);
        System.out.println("city with ID=" + id + " successfully deleted\n");
    }


    private void getClientById() throws SQLException {
        System.out.println("\n[Client / GET] Enter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(clientController.getById(id) + "\n");
    }


    private void getAllClients() throws SQLException {
        System.out.println("\n[Client / GET]");
        System.out.println(clientController.getAll() + "\n");
    }

    private Client getClientsInputs() {
        System.out.println("Enter surname: ");
        String surname = SCANNER.next();
        System.out.println("Enter name: ");
        String name = SCANNER.next();
        System.out.println("Birthday Id: ");
        String birthday = SCANNER.next();
        System.out.println("Gender: ");
        String gender = SCANNER.next();
        System.out.println("Enter adresse: ");
        String adresse = SCANNER.next();
        System.out.println("Enter native_language: ");
        String native_language = SCANNER.next();
        System.out.println("Zip_Code: ");
        String zip_code = SCANNER.next();
        System.out.println("Phone: ");
        String phone = SCANNER.next();
        System.out.println("Enter email: ");
        String email = SCANNER.next();
        System.out.println("Enter bonus_account_id: ");
        String bonus_account_id = SCANNER.next();

        return new Client(surname, name, birthday, gender, adresse, native_language, zip_code, phone, email, bonus_account_id );
    }

    private void createClient () throws SQLException {
        System.out.println("\n[Client / CREATE]");
        Client client = getClientsInputs();
        clientController.create(client);
        System.out.println("Client successfully created\n");
    }

    private void updateClient () throws SQLException {
        System.out.println("\n[Client/ UPDATE] Enter ID: ");
        Integer id = SCANNER.nextInt();
        Client client = getClientsInputs();
        client.setId(id);

        clientController.update(client.getId(), client);
        System.out.println("Client with ID=" + id + " successfully updated\n");
    }

    private void deleteClient() throws SQLException {
        System.out.println("\n[Client / DELETE] Enter ID: ");
        int id = SCANNER.nextInt();

        clientController.delete(id);
        System.out.println("Client with ID=" + id + " successfully deleted\n");
    }


    private void getGoodById() throws SQLException {
        System.out.println("\n[Good / GET] Enter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(goodController.getById(id) + "\n");
    }


    private void getAllGoods() throws SQLException {
        System.out.println("\n[Good / GET]");
        System.out.println(goodController.getAll() + "\n");
    }


    private Good getGoodsInputs() {
        System.out.println("Enter name: ");
        String name = SCANNER.next();
        System.out.println("Enter firm: ");
        String firm = SCANNER.next();
        System.out.println("Description: ");
        String description = SCANNER.next();
        System.out.println("Guarantee_in_months: ");
        String guarantee_in_months = SCANNER.next();
        System.out.println("Enter response: ");
        String response = SCANNER.next();
        System.out.println("In_stock: ");
        Boolean in_stock = Boolean.valueOf(SCANNER.next());

        return new Good(name, firm, description, guarantee_in_months, response, in_stock );
    }

    private void createGood () throws SQLException {
        System.out.println("\n[Good / CREATE]");
        Good good = getGoodsInputs();
        goodController.create(good);
        System.out.println("Good successfully created\n");
    }

    private void updateGood () throws SQLException {
        System.out.println("\n[Good / UPDATE] Enter ID: ");
        Integer id = SCANNER.nextInt();
        Good good = getGoodsInputs();
        good.setId(id);
        goodController.update(good.getId(), good);
        System.out.println("Good with ID=" + id + " successfully updated\n");
    }

    private void deleteGood() throws SQLException {
        System.out.println("\n[Good / DELETE] Enter ID: ");
        int id = SCANNER.nextInt();

        goodController.delete(id);
        System.out.println("Good with ID=" + id + " successfully deleted\n");
    }


    private void getOrderById() throws SQLException {
        System.out.println("\n[Order / GET] Enter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(orderController.getById(id) + "\n");
    }


    private void getAllOrders() throws SQLException {
        System.out.println("\n[Order / GET]");
        System.out.println(orderController.getAll() + "\n");
    }


    private Order getOrderInputs() {
        System.out.println("Enter client_id: ");
        String client_id = SCANNER.next();
        System.out.println("Enter salon_id: ");
        String salon_id = SCANNER.next();
        System.out.println("Enter packaging_id: ");
        String packaging_id = SCANNER.next();
        System.out.println("Enter delivery_in_days: ");
        String delivery_in_days = SCANNER.next();
        System.out.println("Enter good_id: ");
        String good_id = SCANNER.next();



        return new Order(client_id, salon_id, packaging_id, delivery_in_days, good_id);
    }

    private void createOrder () throws SQLException {
        System.out.println("\n[Order / CREATE]");
        Order order = getOrderInputs();
        orderController.create(order);
        System.out.println("Order successfully created\n");
    }

    private void updateOrder () throws SQLException {
        System.out.println("\n[Order / UPDATE] Enter ID: ");
        Integer id = SCANNER.nextInt();
        Order order = getOrderInputs();
        order.setId(id);
        orderController.update(order.getId(), order);
        System.out.println("Order with ID=" + id + " successfully updated\n");
    }

    private void deleteOrder() throws SQLException {
        System.out.println("\n[Order / DELETE] Enter ID: ");
        int id = SCANNER.nextInt();

        orderController.delete(id);
        System.out.println("Order with ID=" + id + " successfully deleted\n");
    }

    private void getPackagingById() throws SQLException {
        System.out.println("\n[Packaging / GET] Enter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(packagingController.getById(id) + "\n");
    }


    private void getAllPackagings() throws SQLException {
        System.out.println("\n[Packaging / GET]");
        System.out.println(packagingController.getAll() + "\n");
    }


    private Packaging getPackagingInputs() {
        System.out.println("Enter Name: ");
        String name = SCANNER.next();
        System.out.println("For_a_gift: ");
        Boolean for_a_gift = Boolean.valueOf(SCANNER.next());


        return new Packaging(name, for_a_gift);
    }

    private void createPackaging () throws SQLException {
        System.out.println("\n[packaging / CREATE]");
        Packaging packaging =  getPackagingInputs();
        packagingController.create(packaging);
        System.out.println("Packaging successfully created\n");
    }

    private void updatePackaging () throws SQLException {
        System.out.println("\n[Packaging / UPDATE] Enter ID: ");
        Integer id = SCANNER.nextInt();
        Packaging packaging =  getPackagingInputs();
        packaging.setId(id);
        packagingController.update(packaging.getId(), packaging);
        System.out.println("Packaging with ID=" + id + " successfully updated\n");
    }

    private void deletePackaging() throws SQLException {
        System.out.println("\n[Packaging / DELETE] Enter ID: ");
        int id = SCANNER.nextInt();

        packagingController.delete(id);
        System.out.println("Packaging with ID=" + id + " successfully deleted\n");
    }

    private void getSalonById() throws SQLException {
        System.out.println("\n[Salon / GET] Enter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(salonController.getById(id) + "\n");
    }


    private void getAllSalons() throws SQLException {
        System.out.println("\n[Salon  / GET]");
        System.out.println(salonController.getAll() + "\n");
    }


    private Salon getSalonsInputs() {
        System.out.println("Enter name: ");
        String name = SCANNER.next();
        System.out.println("Enter  phone: ");
        String phone = SCANNER.next();
        System.out.println("Enter salon_head: ");
        String salon_head = SCANNER.next();
        System.out.println("Enter city_id: ");
        String city_id = SCANNER.next();
        System.out.println("Enter  street_adress: ");
        String street_adress = SCANNER.next();


        return new Salon(name, phone, salon_head, city_id, street_adress);
    }

    private void createSalon () throws SQLException {
        System.out.println("\n[Salon / CREATE]");
        Salon salon = getSalonsInputs();
        salonController.create(salon);
        System.out.println("Salon successfully created\n");
    }

    private void updateSalon () throws SQLException {
        System.out.println("\n[Salon / UPDATE] Enter ID: ");
        Integer id = SCANNER.nextInt();
        Salon salon = getSalonsInputs();
        salon.setId(id);
        salonController.update(salon.getId(), salon);
        System.out.println("Salon with ID=" + id + " successfully updated\n");
    }

    private void deleteSalon() throws SQLException {
        System.out.println("\n[Salon / DELETE] Enter ID: ");
        int id = SCANNER.nextInt();

        salonController.delete(id);
        System.out.println("Salon with ID=" + id + " successfully deleted\n");
    }





}
