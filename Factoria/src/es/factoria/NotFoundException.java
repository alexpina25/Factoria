package es.factoria;

/**
 * @since 11-12-2020
 * @version 1.0
 * @author Alejandro Pina
 */
public class NotFoundException extends Exception {

    NotFoundException(String error) {
        super(error);
    }

}
