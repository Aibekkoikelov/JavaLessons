package mycode.JavaRush;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();
    public static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        int createIndex = (args.length - 1) / 3;
        int updateIndex = (args.length - 1) / 4;

        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    for (int i = 0; i < createIndex; i++) {
                        createPerson(args, i);
                    }
                }
                    break;

            case "-u":
                synchronized (allPeople) {
                    for (int i = 0; i < updateIndex; i++) {
                        updatePerson(args, i);
                    }
                }
                break;
            case "-d":
                synchronized (allPeople) {
                    for (int i = 0; i < args.length - 1; i++) {
                        deletePerson(args, i);
                    }
                }
                break;
            case "-i":
                synchronized (allPeople) {
                    for (int i = 0; i < args.length - 1; i++) {
                        printInfo(args, i);
                    }
                }
                break;
//            default:
//                break;
        }



    }

    public static void createPerson(String[] strList, int index) throws ParseException {
        Date date = formatter.parse(strList[3 + (index * 3)]);
        if (strList[2 + (index * 3)].equals("м")) {
            Person person = Person.createMale(strList[1 + (index * 3)], date);
            allPeople.add(person);
            System.out.println(allPeople.indexOf(person));
        } else {
            Person person = Person.createFemale(strList[1 + (index * 3)], date);
            allPeople.add(person);
            System.out.println(allPeople.indexOf(person));
        }
    }

    public static void updatePerson(String[] strList, int index) throws ParseException {
        int id = Integer.parseInt(strList[1 + (index * 4)]);
        Date date = formatter.parse(strList[4 + (index * 4)]);
        if (strList[3 + (index * 4)].equals("м")) {
            allPeople.set(id, Person.createMale(strList[2 + (index * 4)], date));
        } else allPeople.set(id, Person.createFemale(strList[2 + (index * 4)], date));
    }

    public static void deletePerson(String[] strList, int deleteIndex) {
        int index = Integer.parseInt(strList[1 + deleteIndex]);
        Person person = allPeople.get(index);
        person.setName(null);
        person.setBirthDate(null);
        person.setSex(null);
    }

    public static void printInfo(String[] strList, int index) {
        System.out.println(personToString(allPeople.get(Integer.parseInt(strList[1 + index]))));
    }

    public static String personToString(Person person) {
        String newDate = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(person.getBirthDate());
        return person.getName() + " " + (person.getSex() == Sex.MALE ? "м" : "ж") + " " + newDate;
    }


}
