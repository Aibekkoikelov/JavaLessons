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
                    createPerson(args);
                }
                break;
            case "-u":
                synchronized (allPeople) {
                    updatePerson(args);
                }
                break;
            case "-d":
                synchronized (allPeople) {
                    deletePerson(args);
                }
                break;
            case "-i":
                synchronized (allPeople) {
                    printInfo(args);
                }
                break;
//            default:
//                break;
        }


    }

    public static void createPerson(String[] strList) throws ParseException {
        for (int i = 1; i < strList.length; i = i + 3) {
            addPerson(strList, i);
        }
    }

    public static void addPerson(String[] strList, int index) throws ParseException {
        Date date = formatter.parse(strList[index + 2]);
        Person person;
        if (strList[index + 1].equals("м")) {
            person = Person.createMale(strList[index], date);
        } else {
            person = Person.createFemale(strList[index], date);
        }
        allPeople.add(person);
        System.out.println(allPeople.indexOf(person));
    }


    public static void updatePerson(String[] strList) throws ParseException {
        for (int i = 1; i < strList.length; i = i + 4) {
            replacePersonData(strList, i);
        }
    }

    public static void replacePersonData (String[] strList, int index) throws ParseException {
        int id = Integer.parseInt(strList[index]);
        Date date = formatter.parse(strList[index + 3]);
        if (strList[index + 2].equals("м")) {
            allPeople.set(id, Person.createMale(strList[index + 1], date));
        } else allPeople.set(id, Person.createFemale(strList[index + 1], date));
    }


    public static void deletePerson(String[] strList) {
        Person person;
        for (int i = 1; i < strList.length; i++) {
            person = allPeople.get(i);
            person.setName(null);
            person.setBirthDate(null);
            person.setSex(null);
        }
    }

    public static void printInfo(String[] strList) {
        for (int i = 1; i < strList.length; i++) {
            System.out.println(personToString(allPeople.get(Integer.parseInt(strList[i]))));
        }
    }

    public static String personToString(Person person) {
        String newDate = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(person.getBirthDate());
        return person.getName() + " " + (person.getSex() == Sex.MALE ? "м" : "ж") + " " + newDate;
    }


}
