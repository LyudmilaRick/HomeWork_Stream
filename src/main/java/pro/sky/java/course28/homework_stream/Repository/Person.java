package pro.sky.java.course28.homework_stream.Repository;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import pro.sky.java.course28.homework_stream.Exception.EmployeeNotVerify;

public class Person {
    private final String lastName;       // Фамилия
    private final String firstName;      // Имя

    /**
     * Конструктор нового экземпляра класса  Полное имя (Ф.И.).
     *
     * @param lastName  // Фамилия
     * @param firstName // Имя
     */
    public Person(String lastName, String firstName) {
        this.firstName = normalize(firstName);
        this.lastName = normalize(lastName);
    }

    /**
     * Нормализовать строку имени.
     * Значение {@code null} заменяестся на пустую строку.
     * Убираются лишние пробелы из имени.
     * Все символы, кроме первого, преобразуются в нижний регистр.
     * Первый символ имени преобразуется верхний регистр.
     * в переданной строке нет чисел и других запрещенных символов.
     * @param str Исходная строка имени.
     * @return Нормализованная строка имени.
     */
    protected final String normalize(String str) {
        // в переданной строке нет чисел и других запрещенных символов.
        if (StringUtils.isAlpha(str)) {

            if (StringUtils.isEmpty(str)) {
                return " ";
            }
            if (str.length() == 1) {
                return StringUtils.upperCase(str);
            }
            String res = StringUtils.replace(str, " ", "");
            return Character.toUpperCase(res.charAt(0)) + res.substring(1).toLowerCase();
        }
        throw new EmployeeNotVerify("Verification failed");
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFullName() {
        return String.join(" ", lastName, firstName).trim();
    }

    @Override
    public String toString() {
        return String.join(" ", lastName, firstName).trim();
    }

    /**
     * Возвращает хэш-код для полного имени (Ф.И.О.).
     *
     * @return значение хэш-кода для этого объекта.
     */
    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return lastName.equals(person.lastName) && firstName.equals(person.firstName);
    }
}

