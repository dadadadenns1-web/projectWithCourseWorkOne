//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Для простоты назовите отделы от 1 до 5. Зарплату задайте в интервале 50–450.
        Employee employeeOne = new Employee("Михайлова Варвара Владимировна", 2, 120);
        Employee employeeTwo = new Employee("Мельникова Полина Игоревна", 1, 100);
        Employee employeeThree = new Employee("Родионова Таисия Денисовна", 3, 50);
        Employee employeeFour = new Employee("Новиков Михаил Владимирович", 4, 200);
        Employee employeeFive = new Employee("Сорокина Надежда Гордеевна", 5, 450);
        Employee employeeSix = new Employee("Дроздова Амина Александровна", 4, 300);
        Employee employeeSeven = new Employee("Фомина Виктория Фёдоровна", 2, 200);
        Employee employeeEight = new Employee("Сомина Галина Владимировна", 2, 190);

        System.out.println("\nПроверка equals");
        System.out.println("employeeOne.equals(employeeFive) = " + employeeOne.equals(employeeFive));
        System.out.println("employeeFour.equals(employeeSeven) = " + employeeFour.equals(employeeSeven));

        System.out.println("\nПроверка toString");
        System.out.println(employeeFive);
        System.out.println(employeeSeven);

        System.out.println("\nПроверка printShortInfo");
        employeeOne.printShortInfo();
        employeeTwo.printShortInfo();


        //Создание списка.
        EmployeeBook employeeList = new EmployeeBook();
        employeeList.EmployeeBook(employeeOne);
        employeeList.EmployeeBook(employeeTwo);
        employeeList.EmployeeBook(employeeThree);
        employeeList.EmployeeBook(employeeFour);
        employeeList.EmployeeBook(employeeFive);
        employeeList.EmployeeBook(employeeSix);
        employeeList.EmployeeBook(employeeSeven);
        employeeList.EmployeeBook(employeeEight);
        employeeList.EmployeeBook(employeeEight);

        //Пустой список
        EmployeeBook employeeEmptyList = new EmployeeBook();

        System.out.println("\nПроверка метода для получения всех значений из списка");
        employeeList.getEmployeeList();
        System.out.println("Пустой список");
        employeeEmptyList.getEmployeeList();
        System.out.println("\nСредняя зарплата всех - " + employeeList.averageSalary());
        System.out.println("\nСредняя зарплата всех пустого массива - " + employeeEmptyList.averageSalary());
        System.out.println("\nНалог PROPORTIONAL");
        employeeList.getTaxList("PROPORTIONAL");
        System.out.println("\nНалог PROGRESSIVE");
        employeeList.getTaxList("PROGRESSIVE");
        System.out.println("\nНеверное значение");
        employeeList.getTaxList("CONSTANT");

        System.out.println("Налог для пустого массива PROGRESSIVE");
        employeeEmptyList.getTaxList("PROGRESSIVE");

        //Индексирование зарплат
        employeeList.indexSalaries(2, 10);
        System.out.println("\nПроверка после индексирования зарплат");
        employeeList.getEmployeeList();

        System.out.println("\nПоиск первого сотрудника с большей зарплатой в департаменте");
        System.out.println("Департамент 2, зарплата больше 150 в основном списке");
        employeeList.findFirstEmployeeWithHigherSalary(2, 150);
        System.out.println("Департамент 1, зарплата больше 300 в пустом списке");
        employeeEmptyList.findFirstEmployeeWithHigherSalary(1,300);

        System.out.println("\nПоиск с меньшими зарплатами");
        employeeList.findEmployeesWithLowerWage(120, 3);
        System.out.println("Поиск в пустом массиве");
        employeeEmptyList.findEmployeesWithLowerWage(100,10);

        //Поиск сотрудника
        Employee employeeNine = new Employee("Антонова Елена Николаевна", 3, 250);
        System.out.println();
        System.out.println("Есть ли сотрудник с зарплатой " + employeeNine.getSalary() + " в списке. " + employeeList.isThereEmployeeWithSimilarSalary(employeeNine));
        System.out.println("Есть ли сотрудник с зарплатой " + employeeEight.getSalary() + " в списке. " + employeeList.isThereEmployeeWithSimilarSalary(employeeEight));

        //Добавление сотрудника
        System.out.println("\nДобавление сотрудника");
        System.out.println("employeeList.EmployeeBook(employeeNine) = " + employeeList.EmployeeBook(employeeNine));
        System.out.println("Проверка");
        employeeList.getEmployeeList();
        System.out.println("Десятый сотрудник и 11 сотрудники");
        Employee employeeTen = new Employee("Тарасова Таисия Тимофеевна", 5, 290);
        Employee employeeEleven = new Employee("Столярова Анастасия Васильевна", 5, 310);
        System.out.println("employeeList.EmployeeBook(employeeTen) = " + employeeList.EmployeeBook(employeeTen));
        System.out.println("employeeList.EmployeeBook(employeeEleven) = " + employeeList.EmployeeBook(employeeEleven));
        System.out.println("Проверка");
        employeeList.getEmployeeList();

        System.out.println("\nПоиск по id");
        System.out.println(employeeList.findEmployeeById(11));
        System.out.println(employeeList.findEmployeeById(10));
        System.out.println(employeeList.findEmployeeById(5));

        System.out.println("\nПроверка setDepartment");
        System.out.println(employeeFive);
        employeeFive.setDepartment(4);
        System.out.println(employeeFive);
    }
}