package es.factoria;

/**
 * @since 11-12-2020
 * @version 1.0
 * @author Alejandro Pina
 */
public class Secretary extends Worker {

    private Executive executive; // Atributo que indica cuál es el Executive del Secretay
    private final double SALARYBASE = 1200; // Constante que representa el salary base de un Secretary

    /**
     * Constructor de la clase Secretary
     *
     * @param pName Nombre del Secretary
     * @param pAddress Dirección del Secretary
     * @param pDni DNI del Secretary
     */
    public Secretary(String pName, String pAddress, String pDni) {
        super(pName, pAddress, pDni);
        super.setSalary(SALARYBASE);
    }

    /**
     * Método para calcular el salary específico del Secretary
     *
     * @return Salary específico del Secretary
     */
    @Override
    public double computeSalary() {
        return this.SALARYBASE;
    }

    /**
     * Accesor de lectura del atributo Executive
     *
     * @return El Executive del Secretary
     */
    public Executive getExecutive() {
        return executive;
    }

    /**
     * Accesor de escritura del atributo executive
     *
     * @param pExecutive Executive a asignar al Secretary
     */
    public void setExecutive(Executive pExecutive) {
        this.executive = pExecutive;
    }

    /**
     * Método que indica si el Secretary tiene Executive
     *
     * @return true si tiene Executive asignado y false si no
     */
    public boolean hasExecutive() {
        return this.getExecutive() != null;
    }
}
