package es.factoria;

import java.util.ArrayList;
import java.util.List;

/**
 * @since 11-12-2020
 * @version 1.0
 * @author Alejandro Pina
 */
class Executive extends Worker {

    private final double COMISSION = 2; // Constante que representa la comisión del Executive
    private final double SALARYBASE; // Constante que representa el salary base de un Executive
    private final List<Salesman> salesmen; // Lista de Salseman del Executive
    private Secretary secretary; // Secretary del Executive

    /**
     * Constructor de la clase Executive
     *
     * @param pName Nombre del Executive
     * @param pAddress Dirección del Executive
     * @param pDni DNI del Executive
     */
    public Executive(String pName, String pAddress, String pDni) {
        super(pName, pAddress, pDni);
        salesmen = new ArrayList();
        this.SALARYBASE = 2500;
    }

    /**
     * Método para calcular el salary específico del Executive
     *
     * @return Salary específico del Executive
     */
    @Override
    public double computeSalary() {
        double comision = 0;
        for (Salesman s : salesmen) {
            comision += (Math.floor(s.getSales()) * COMISSION / 100);
        }
        double salary = comision + SALARYBASE;
        this.setSalary(salary);
        return salary;
    }

    /**
     * Método que añade un nuevo Salesman al Executive
     *
     * @param pNewSalesman Salesman a añadir al Executive
     */
    public void addSalesman(Salesman pNewSalesman) throws OverrideException {
        if (pNewSalesman.hasExecutive()) {
            throw new OverrideException("El Salesman " + pNewSalesman.getName() + " ya tiene asignado un Executive");
        } else {
            this.salesmen.add(pNewSalesman);
            pNewSalesman.setExecutive(Executive.this);
        }

    }

    /**
     * Método que asigna un Secretary al Executive
     *
     * @param pNewSecretary Secretary a asignar al Executive
     */
    public void setSecretary(Secretary pNewSecretary) throws OverrideException {
        if (pNewSecretary.hasExecutive()) {
            throw new OverrideException("El worker " + pNewSecretary.getName() + " ya tiene asignado un Executive");
        } else {
            this.secretary = pNewSecretary;
            pNewSecretary.setExecutive(Executive.this);
        }
    }

    /**
     * Método que devuelve un String de los Salesman del Executive
     *
     * @return String que contiene el listado de los Salesman del Executive
     */
    public String listWorkers() {
        StringBuilder lista = new StringBuilder();
        if (this.secretary == null) {
            lista.append(secretary.getName()).append(" ").append(secretary.getDni()).append(" ").append(secretary.getAddress()).append("\n");
        }
        for (Salesman s : salesmen) {
            lista.append(s.getName()).append(" ").append(s.getDni()).append(" ").append(s.getAddress()).append("\n");
        }
        return lista.toString();
    }

}
