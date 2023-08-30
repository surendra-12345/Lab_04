class Employee:
    def __init__(self, employee_id, name, age, salary):
        self.employee_id = employee_id
        self.name = name
        self.age = age
        self.salary = salary

    def __str__(self):
        return f"{self.employee_id} {self.name} {self.age} {self.salary}"

class EmployeeTable:
    def __init__(self):
        self.employees = []

    def add_employee(self, employee):
        self.employees.append(employee)

    def search_by_age(self, age):
        result = []
        for employee in self.employees:
            if employee.age == age:
                result.append(employee)
        return result

    def search_by_name(self, name):
        result = []
        for employee in self.employees:
            if employee.name == name:
                result.append(employee)
        return result

    def search_by_salary(self, operator, salary):
        result = []
        for employee in self.employees:
            if operator == '>':
                if employee.salary > salary:
                    result.append(employee)
            elif operator == '<':
                if employee.salary < salary:
                    result.append(employee)
            elif operator == '>=':
                if employee.salary >= salary:
                    result.append(employee)
            elif operator == '<=':
                if employee.salary <= salary:
                    result.append(employee)
        return result

employee_table = EmployeeTable()
employee_table.add_employee(Employee('161E90', 'Raman', 41, 56000))
employee_table.add_employee(Employee('161F91', 'Himadri', 38, 67500))
employee_table.add_employee(Employee('161F99', 'Jaya', 51, 82100))
employee_table.add_employee(Employee('171E20', 'Tejas', 30, 55000))
employee_table.add_employee(Employee('171G30', 'Ajay', 45, 44000))

search_parameter = input("Enter search parameter [1. Age, 2. Name, 3. Salary (>, <, <=, >=)]: ")
if search_parameter == '1':
    age = int(input("Enter age: "))
    results = employee_table.search_by_age(age)
elif search_parameter == '2':
    name = input("Enter name: ")
    results = employee_table.search_by_name(name)
elif search_parameter == '3':
    operator = input("Enter operator (>, <, <=, >=): ")
    salary = int(input("Enter salary: "))
    results = employee_table.search_by_salary(operator, salary)

for result in results:
    print(result)