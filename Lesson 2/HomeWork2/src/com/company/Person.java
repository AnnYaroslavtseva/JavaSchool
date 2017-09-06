package com.company;



public abstract class Person {
    public String name;
    public String surname;
    public int timeLunch;
   // public abstract void goToBank();
   //public abstract void work();


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Person(String name, String surname, int timeLunch){
        this.name = name;
        this.surname = surname;
        this.timeLunch = timeLunch;
    }

    public abstract void Inform();


}

class Employee extends Person implements GoToBank,Lanch {

    private String bank;

    @Override
    public String goToBank() {
        String str = " работает в банке";
        return str;
    } //зачем идет в банк

    @Override
    public String lanch(int time) {
        String str;
        if (time == 12) {
            str = " Идет на обед";
        } else {
            str = " Еще не время обеда";
        }
        return str;

    } //зачем идет в банк


    public Employee(String name, String surname, String company, int timeLunch) {

        super(name, surname, timeLunch);
        this.bank = company;


    }


    public void Inform() {

        System.out.println("Имя: " + super.getName() + " Фамилия: "
                + super.getSurname() + goToBank() + ": " + bank);
        System.out.println(" Что насчет обеда? "+ lanch(timeLunch));
    }
}


    class Client extends Person implements GoToBank, Lanch {
        private String bank;

        @Override

            public String goToBank() {
                String str = " клиент банка";
                return str;
            } //зачем идет в банк
        @Override
        public String lanch(int time) {
            String str =" Уже пообедал ";
            return str;}



        public Client(String name, String surname, String company, int timeLunch){

            super(name, surname, timeLunch);
            this.bank = company;

        }

        public void Inform() {

            System.out.println("Имя: " + super.getName() + " Фамилия: "
                    + super.getSurname() + goToBank() + ": " + bank);
            System.out.println(" Что насчет обеда? "+ lanch(timeLunch));
        }
    }




