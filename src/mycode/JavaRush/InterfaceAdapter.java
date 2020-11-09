package mycode.JavaRush;

/*
Адаптация нескольких интерфейсов
*/

import java.util.HashMap;
import java.util.Map;

public class InterfaceAdapter {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {

    }

    public static void main(String[] args) {

    }

    public static class IncomeDataAdapter implements Customer, Contact{
        private IncomeData data;

        public IncomeDataAdapter(IncomeData data) {
            this.data = data;
        }

        @Override
        public String getCompanyName() {
            return null;
        }

        @Override
        public String getCountryName() {
            return null;
        }

        @Override
        public String getName() {
            return null;
        }

        @Override
        public String getPhoneNumber() {
            return null;
        }
    }


    public static interface IncomeData {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        int getCountryPhoneCode();      //For example: 38

        int getPhoneNumber();           //For example: 501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67
    }
}
