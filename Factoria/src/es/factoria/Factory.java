package es.factoria;

import java.util.ArrayList;
import java.util.List;

/**
 * @since 11-12-2020
 * @version 1.0
 * @author Alejandro Pina
 */
public class Factory {

    private String name; // Indica el nombre de la Factory
    private List<Worker> workers; // Lista de Workers de la Factory

    /**
     * Constructor de Factory sin nombre concreto, pero inicializa la lista de
     * workers
     */
    public Factory() {
        workers = new ArrayList();
    }

    /**
     * Constructor de Factory
     *
     * @param pName Nombre de la Factory
     */
    public Factory(String pName) {
        this();
        this.name = pName;
    }

    /**
     * Accesor de lectura del nombre de la Factory
     *
     * @return Nombre de la Factory
     */
    public String getName() {
        return name;
    }

    /**
     * Accesor de escritura del nombre de la Factory
     *
     * @param name Nombre de la Factory
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Método que añade un nuevo Worker a la Factory
     *
     * @param pNewWorker Worker a añadir a la Factory
     */
    public void addWorker(Worker pNewWorker) {
        if (!workers.contains(pNewWorker)) {
            workers.add(pNewWorker);
        }
    }

    /**
     * Accesor de lectura de los Workers de la Factory
     *
     * @return Workers de la Factory
     */
    public Worker getWorkers() {
        return (Worker) workers;
    }

    /**
     * Accesor de lectura de un Worker concreto de la Factory
     *
     * @param pDni DNI del Worker a devolver
     * @return Worker Worker con el mismo DNI pasado por el parámetro
     * @throws NotFoundException Error al no coincidir ningún DNI con el
     * parámetro
     */
    public Worker getWorker(String pDni) throws NotFoundException {
        Worker worker = null;
        for (Worker w : workers) {
            if (w.getDni().equals(pDni)) {
                worker = w;
            }
        }
        if (worker == null) {
            throw new NotFoundException("Worker no existe");
        }
        return worker;
    }

    /**
     * Método que construye un String con el listado de todos los Workers de la
     * Factory y su salary
     *
     * @return Listado de los Workers de la Factory y su salary
     */
    public String listSalaryWorkers() {
        StringBuilder lista = new StringBuilder();
        for (Worker w : workers) {
            w.computeSalary();
            lista.append(w.getName()).append(" ").append(w.getDni()).append(" ").append(w.getSalary()).append("\n");
        }
        return lista.toString();
    }

    /*
    @Override
    public String toString() {
        return name;
    }
     */
}
