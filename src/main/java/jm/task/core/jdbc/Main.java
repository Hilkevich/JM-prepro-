package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {

         /*
         Создание таблицы User(ов)
         Добавление 4 User(ов) в таблицу с данными на свой выбор. После каждого добавления должен быть вывод в консоль ( User с именем – name добавлен в базу данных )
         Получение всех User из базы и вывод в консоль (должен быть переопределен toString в классе User)
         Очистка таблицы User(ов)
         Удаление таблицы
         */


        Util.myDbConnectionHibernate();
        UserServiceImpl userServiceImpl = new UserServiceImpl();

        userServiceImpl.createUsersTable();
        userServiceImpl.saveUser("Jack", "Black", (byte) 30);
        userServiceImpl.saveUser("Joe", "White", (byte) 35);
        userServiceImpl.saveUser("Bob", "Ferry", (byte) 40);
        userServiceImpl.saveUser("Natan", "Jones", (byte) 45);
        userServiceImpl.getAllUsers();
        userServiceImpl.cleanUsersTable();
        userServiceImpl.dropUsersTable();
    }
}

