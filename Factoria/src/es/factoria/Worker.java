package es.factoria;

import java.util.Objects;

/**
 * @since 11-12-2020
 * @version 1.0
 * @author Alejandro Pina
 */
public abstract class Worker {

    private final String name; // Atributo que guarda el nombre del Worker
    private String address; // Atributo que guarda la dirección del Worker
    private final String dni; // Atributo que guarda el dni del Worker
    private double salary; // Atributo que guarda el salary base del Worker

    /**
     * Constructor de la clase. Asigna el dni, name u address pasados como
     * parámetros.
     *
     * @param pName Nombre del Worker
     * @param pAddress Dirección del Worker
     * @param pDni DNI del Worker
     */
    public Worker(String pName, String pAddress, String pDni) {
        this.name = pName;
        this.address = pAddress;
        this.dni = pDni;
    }

    /**
     * Método para calcular el salary específico del Worker
     *
     * @return Salary específico del Worker
     */
    public abstract double computeSalary();

    /**
     * Crea una cadena de caracteres
     *
     * @return Cadena de caracteres que contiene el name, dni y address del
     * Worker, separados por un espacio en blanco
     */
    @Override
    public String toString() {
        return name + " " + dni + " " + address;
    }

    /**
     * Accesor de lectura de name
     *
     * @return Devuelve el name del Worker
     */
    public String getName() {
        return name;
    }

    /**
     * Accesor de lectura de address
     *
     * @return Devuelve el address del Worker
     */
    public String getAddress() {
        return address;
    }

    /**
     * Accesor de lectura de dni
     *
     * @return Devuelve el dni del Worker
     */
    public String getDni() {
        return dni;
    }

    /**
     * Accesor de lectura de salary
     *
     * @return Devuelve el salary del Worker
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Accesor de escritura de salary
     *
     * @param salary Párametro a escribir en el atributo salary
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * Accesor de escritura de address
     *
     * @param address Dirección a escribir en el atributo address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Método comparador para comparar dos Workers por su DNI
     *
     * @param obj Worker pasado por parámetro para comparar
     * @return Devuelte true si el objeto pasado por parámetro es igual al
     * actual o tienen el mismo número de dni
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Worker other = (Worker) obj;
        return Objects.equals(this.dni, other.dni);
    }

}
