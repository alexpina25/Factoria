package es.factoria;

/**
 * @since 11-12-2020
 * @version 1.0
 * @author Alejandro Pina
 */
public class Salesman extends Worker {

    private double salesMonth; // Importe de las ventas hechas por el Salesman durante este mes
    private final double COMISSION = 5; // Constante que representa la comisión de un Salesman
    private final double SALARYBASE = 1300; // Constante que epresenta el salary base de un Salesman
    private Executive executive; // Indica cuál es el executive responsable del Salseman

    /**
     * Constructor de la clase Salesman
     *
     * @param pName Nombre del Salseman
     * @param pAddress Dirección del Salseman
     * @param pDni DNI del Salesman
     */
    public Salesman(String pName, String pAddress, String pDni) {
        super(pName, pAddress, pDni);
    }

    /**
     * Método para calcular el salary específico del Salseman
     *
     * @return Salary específico del Salseman
     */
    @Override
    public double computeSalary() {
        double salary = SALARYBASE + (Math.round(salesMonth) * COMISSION / 100);
        this.setSalary(salary);
        return salary;
    }

    /**
     * Método que incrementa el importe del total vendido en el mes
     *
     * @param pSale Importe de la nueva venta a añadir
     */
    public void newSale(double pSale) {
        this.salesMonth += pSale;
    }

    /**
     * Accesor de lectura del total de ventas en el mes actual del Salesman
     *
     * @return Importe del total de ventas del mes actual del Salseman
     */
    public double getSales() {
        return this.salesMonth;
    }

    /**
     * Método para reiniciar las ventas ya que se cambia de mes
     */
    public void changeMonth() {
        salesMonth = 0;
    }

    /**
     * Accesor de lectura del atributo executive
     *
     * @return Executive asignado al Salesman
     */
    public Executive getExecutive() {
        return executive;
    }

    /**
     * Accesor de escritura del atributo executive
     *
     * @param executive Executive a asignar al Salseman
     */
    public void setExecutive(Executive executive) {
        this.executive = executive;
    }

    /**
     * Método que indica si el Salseman tiene Executive asignado
     *
     * @return True si tiene executive asignado, false si no lo tiene asignado
     */
    public boolean hasExecutive() {
        if (this.getExecutive() == null) {
            return false;
        } else {
            return true;
        }

    }
}
