public class Employee {

    //Поля. Создайте класс Employee с информацией о Ф. И. О., отделе и зарплате сотрудника.
    //Скройте прямой доступ к полям класса Employee
    private final String lastFirstMiddleName;
    private int department;
    private int salary;
    private static int counter = 1; //Добавьте статическую переменную-счетчик, которая будет отвечать за id, переменная внутри класса
    private final int id; //id переменная внутри объекта

    //Конструктор
    public Employee(String lastFirstMiddleName, int department, int salary) {
        this.lastFirstMiddleName = lastFirstMiddleName;
        this.department = department;
        this.salary = salary;
        id = counter++; //Добавьте в класс Employee поле id. Она переносится из счетчика, и затем счетчик увеличивает свое значение.
    }

    //добавьте возможность получать значения полей (геттеры)
    public int getId() {
        return id;
    }

    public int getSalary() {
        return salary;
    }

    public int getDepartment() {
        return department;
    }

    public String getLastFirstMiddleName() {
        return lastFirstMiddleName;
    }

    //и устанавливать значения полей отдела и зарплаты (сеттеры)

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    //Реализуйте в классе Employee контракт equals
    @Override
    public boolean equals(Object object){
        if (object == this){ //Проверка на равенство объектов
            return true;
        }
        if (object == null || object.getClass() != getClass()){ //Проверка на пустой объект и неравенство классов
            return false;
        }
        Employee employee = (Employee) object;
        return employee.salary == salary; //Для бухгалтерского учета сравнение должно проходить только по значению зарплаты.
    }
    //Реализуйте в классе Employee методы вывода информации о сотруднике. Вывод всех данных — через переопределение метода toString
    @Override
    public String toString(){
        return "Ф. И. О. - "+lastFirstMiddleName+", департамент - "+department+", зарплата - "+salary+", id - "+id;
    }
    //вывод только имени и зарплаты — через вызов System.out.println в отдельном методе public void printShortInfo().
    public void printShortInfo(){
        System.out.println("Ф. И. О. - "+lastFirstMiddleName+", зарплата - "+salary);//выводит Ф. И. О. и зарплату в читаемом и структурированном формате.
    }


}
