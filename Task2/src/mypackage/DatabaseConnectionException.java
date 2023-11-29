package mypackage;

//Custom Database Connection Exception
class DatabaseConnectionException extends Exception {
 public DatabaseConnectionException(String message) {
     super(message);
 }
}
