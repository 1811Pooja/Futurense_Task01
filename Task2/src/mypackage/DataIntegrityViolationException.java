package mypackage;

import java.sql.*;

//Custom Data Integrity Violation Exception
class DataIntegrityViolationException extends Exception {
 public DataIntegrityViolationException(String message) {
     super(message);
 }
}
