public class EmployeeBook {
    private final Employee[] employees = new Employee[10];//Создайте класс EmployeeBook c полем типа Employee[10], которое будет выполнять роль хранилища для записей о сотрудниках.

    //Конструктор
    public EmployeeBook(Employee... employeeList) {
        for (int i = 0; i < employeeList.length && i < employees.length; i++) { //Заполнение employees
            employees[i] = employeeList[i];
        }
    }

    //Методы для вывода в консоль.
    //Получить список всех сотрудников со всеми данными о них, вывести в консоль значения всех полей, кроме Null.
    //Используйте цикл for each и toString.
    public void getEmployeeList() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    //Подсчитать среднее значение зарплат.
    public float averageSalary() {
        int summ = 0;
        int i = 0;
        for (Employee employee : employees) {
            if (employee == null) {
                break;//В качестве количества сотрудников для подсчета среднего используйте количество полей до ПЕРВОГО null.
            }
            summ += employee.getSalary();
            i++;
        }
        if (i == 0) {
            return 0;
        }
        return (float) summ / i;
    }

    //Вывести значения налогов
    public void getTaxList(String optionString) {//В метод нужно передавать строку
        int option = 0;
        final int PROPORTIONAL = 1;
        final int PROGRESSIVE = 2;
        if(optionString == null){
            return;
        }
        if (optionString.equals("PROPORTIONAL")) {
            option = PROPORTIONAL;
        } else if (optionString.equals("PROGRESSIVE")) {
            option = PROGRESSIVE;
        }
        switch (option) { //Примените switch для выбора формулы расчета зарплаты.
            case (PROPORTIONAL)://Если в метод передать строкой тип расчета PROPORTIONAL, то налог всегда 13%.
                for (Employee employee : employees) {
                    if (employee != null) {
                        float tax = employee.getSalary() * 0.13f;
                        System.out.println("Налог " + tax + " для сотрудника " + employee.getLastFirstMiddleName());
                    }
                }
                break;
            case (PROGRESSIVE):
                for (Employee employee : employees) {
                    if (employee != null) {
                        int salary = employee.getSalary();
                        int taxPercent;
                        if (salary <= 150) {
                            taxPercent = 13;//13% для зарплаты до 150
                        } else if (salary <= 350) {
                            taxPercent = 17;//17% для зарплаты до 350
                        } else {
                            taxPercent = 21;//21% для зарплаты выше 350
                        }
                        float tax = salary * (float) taxPercent / 100;
                        System.out.println("Налог " + tax + " для сотрудника " + employee.getLastFirstMiddleName());
                    }
                }
                break;
            default:
                System.out.println("Неизвестный тип. Существуют \"PROPORTIONAL\", \"PROGRESSIVE\"");
        }
    }

    //Получить в качестве параметра номер отдела (1–5) и проиндексировать зарплату всех сотрудников отдела на процент, который приходит в качестве параметра (то есть вызвать изменение зарплаты у всех сотрудников на величину аргумента в процентах).
    public void indexSalaries(int department, int percent) {
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            if (employee.getDepartment() != department) {
                continue;//Примените continue для пропуска сотрудников, зарплата которых не меняется.
            }
            int salary = employee.getSalary();
            salary += (salary * percent) / 100;
            employee.setSalary(salary);
        }
    }

    //Получить в качестве параметра номер отдела (1–5) и цифру зарплаты и вывести первого сотрудника этого отдела с зарплатой больше указанной вместе с порядковым номером в списке.
    public void findFirstEmployeeWithHigherSalary(int department, int salary) {
        int counter = -1;
        for (Employee employee : employees) { //Используйте for
            counter++;
            if (employee == null) {
                continue;
            }
            if (employee.getDepartment() != department) {
                continue;
            }
            int employeeSalary = employee.getSalary();
            if (employeeSalary > salary) {
                System.out.print("Порядковый номер в списке = " + counter + ", ");
                employee.printShortInfo();
                break;//Используйте break
            }
        }
    }

    //Получить в качестве параметра цифру зарплаты wage и число сотрудников employeeNumber и вывести первые employeeNumber сотрудников с зарплатой меньше wage.
    public void findEmployeesWithLowerWage(int wage, int employeeNumber) {
        int counter = -1;
        while(counter < employees.length - 1){//Используйте для поиска цикл while
            counter++;

            if(employeeNumber <= 0){
                break;//Используйте оператор break
            }

            if(employees[counter] == null){
                continue;
            }

            int employeeWage = employees[counter].getSalary();

            if(employeeWage < wage){
                employeeNumber--;
                employees[counter].printShortInfo();
            }

        }
        if(employeeNumber > 0){
            System.out.println("Не найдено достаточно сотрудников, не хватает "+employeeNumber);
        }
    }

    //Получить в качестве параметра объект сотрудника и вернуть boolean, есть ли такой сотрудник в массиве с точки зрения бухгалтерского учета (по зарплате) или нет.
    public boolean isThereEmployeeWithSimilarSalary (Employee employee){
        if(employee == null){
            return false;
        }
        for (Employee employeeFromList: employees){
            if(employee.equals(employeeFromList)){//В equals есть проверка на 0
                return true;
            }
        }
        return false;
    }

    //Добавьте метод наполнения EmployeeBook метод должен найти свободную ячейку в массиве и положить в нее данные нового сотрудника.
    public boolean addEmployee(Employee employee){
        if(employee == null){
            return false;
        }
        int firstFree = -1;
        for (int i = 0; i < employees.length; i++) {
            if(firstFree == -1 && employees[i] == null){
                firstFree = i;//Запоминание первой свободной ячейки
            }
            if(employees[i]==employee){//Проверка на объект который уже есть в списке
                return false;
            }
        }
        if(firstFree > -1){
            employees[firstFree]=employee;
            return true;
        }
        return false;
    }

    //Метод для получения сотрудника по id
    public Employee findEmployeeById(int id){
        for(Employee employee: employees){
            if(employee == null){
                continue;
            }
            if(employee.getId() == id){
                return employee;
            }
        }
        return null;
    }
}
