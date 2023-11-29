package mypackage;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiHandlingExample {

    public static void makeApiCall(String apiUrl) throws TimeoutException, ApiResponseException, NetworkException {
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Simulating timeout (Set a reasonable timeout value as needed)
            connection.setConnectTimeout(100); // 5 seconds

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Process the API response 
                System.out.println("API call successful!");
                // Process API response data...
            } else {
                throw new ApiResponseException("API Response Error: " + responseCode);
            }
        } catch (java.net.SocketTimeoutException e) {
            throw new TimeoutException("Timeout Exception: " + e.getMessage());
        } catch (IOException e) {
            throw new NetworkException("Network Exception: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String apiUrl = "https://www.epfindia.gov.in/site_en/index.php";

        try {
            makeApiCall(apiUrl);
        } catch (TimeoutException e) {
            System.err.println("Error: API call exceeded the timeout limit.");
            // Handle timeout exception with specific actions or logging
        } catch (ApiResponseException e) {
            System.err.println("Error: The API returned an error response.");
            // Handle API response error with specific actions or logging
        } catch (NetworkException e) {
            System.err.println("Error: Network issue encountered during the API call.");
            // Handle network issues with specific actions or logging
        }
    }
}

