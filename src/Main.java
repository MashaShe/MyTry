


import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        Contacts contacts = new Contacts();
        MissedCalls missedCalls = new MissedCalls();
        Scanner myscan = new Scanner(System.in);
        boolean ifcontinue = true;
        contacts.addContact(new Contact("Павел", "Викторович", "777", Group.FAMILY));
        contacts.addContact(new Contact("Кристина", "Викторовна", "666", Group.FRIENDS));
        missedCalls.addMissedCall( LocalDateTime.of(2020, Month.JUNE, 17, 19, 30), "555");
        missedCalls.addMissedCall( LocalDateTime.of(2020, Month.JUNE, 17, 19, 10), "777");
        while (ifcontinue) {
            System.out.println("Меню:\n" +
                    "1. Добавить контакт\n" +
                    "2. Добавить пропущенный вызов\n" +
                    "3. Вывести все пропущенные вызовы\n" +
                    "4. Очистить пропущенные вызовы\n" +
                    "5. Удалить контакт\n" +
                    "6. Выход");
            //
            //    Необходимо создать класс Main.java, в котором после запуска программы предоставить пользователю выбор следующих методов:
            //
            //    Добавление контакта (имя, фамилия, номер телефона, группа контакта: работа, друзья, семья).
            //    Добавление пропущенного вызова.
            //    Вывод всех пропущенных вызовов с указанием фамилии и имени. Если контакта нет в списке контактов, вывести только номер телефона.
            //    Очистка пропущенных вызовов.
            //    Завершить работу программы (выход).
            //
            //Для этого нужно будет создать в классе Main.java объекты классов Contacts.java и MissedCalls.java и передавать пользовательские вызовы в эти объекты.

            String id = myscan.nextLine();

            switch (id) {
                case "1":
                    System.out.println("Введите данные контакта в формате(для завершения введите end):\n Имя, Фамилия, номер телефона, группа контакта: WORK, FRIENDS, FAMILY");
                    String inline = myscan.nextLine();
                    if (inline.equals("end")) {
                        break;
                    }
                    String[] contactinfo = inline.split(", ");
                    Contact contact = new Contact(contactinfo[0], contactinfo[1], contactinfo[2], Group.valueOf(contactinfo[3]));
                    contacts.addContact(contact);
                    break;
                case "2":
                    System.out.println("Введите данные пропущенного вызова в формате(для завершения введите end):\n yyyy-MM-dd HH:mm, номер телефона");
                    inline = myscan.nextLine();
                    if (inline.equals("end")) {
                        break;
                    }
                    String[] missedCallinfo = inline.split(", ");
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                    missedCalls.addMissedCall(LocalDateTime.parse(missedCallinfo[0], formatter), missedCallinfo[1]);

                    break;
                case "3":
                    missedCalls.returnAllMissedCalls(contacts);
                    //System.out.println(missedCalls);
                    break;
                case "4":
                    missedCalls.clearMissedCalls();
                    System.out.println("Список вызовов очищен");
                    break;
                case "5":
                    System.out.println("Для удаления контакта введите данные в формате(для завершения введите end):\n Имя, Фамилия");
                    inline = myscan.nextLine();
                    if (inline.equals("end")) {
                        break;
                    }
                    contactinfo = inline.split(", ");
                    contacts.removeContact(contactinfo[0], contactinfo[1]);
                    break;
                case "6":
                    System.out.println("Вы выбрали выход. До свидания!");
                    ifcontinue = false;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + id);
            }
        }

    }

//    public  static void printMissedCalls(Contacts contacts,MissedCalls missedCalls){
//        // System.out.println("Поиск по контактам и печать имен вместо номеров");
//// пройтись по всем дереву и напечатать ключ + контакст по номеру с помощью  searchContact
//        missedCalls.returnAllMissedCalls();
//        missedCalls.forEach((k, v)-> {
//            contacts.searchContact(missedCalls.get(k));
//        });
//    }


}
