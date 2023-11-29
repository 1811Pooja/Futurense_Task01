package mypackage;

//Custom API Response Exception
class ApiResponseException extends Exception {
 public ApiResponseException(String message) {
     super(message);
 }
}
