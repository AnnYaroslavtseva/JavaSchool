package com.company;




public class Main  {

    public static void main(String[] args) {
	Employee emp = new Employee("Пётр","Петров", "Тинькофф", 11);
	Client cl = new Client("Иван","Иванов","Тинькофф",11);
	Employee emp2 = new Employee("Дмитрий", "Дмитров", "Сбербанк",12);
	emp.Inform();
	emp2.Inform();
	cl.Inform();
    }
}
