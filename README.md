# Katalon OpenWeatherMap API Test

This project contains automated tests for the OpenWeatherMap API using Katalon Studio.

## Project Structure

The project is organized as follows:

-   **`Test Cases/`**: Contains individual test case files (`.tc`) for various API functionalities.
    -   `Common/TC_Validate_Config.tc`: Likely used for validating general API configurations or connection.
    -   `Get5DayForecast/TC_Get5DayForecast.tc`: Test case for fetching a 5-day weather forecast.
    -   `GetAirPollution/TC_GetAirPollution.tc`: Test case for fetching air pollution data.
-   **`Profiles/`**: Stores global variable profiles used across test cases.
    -   `default.glbl`: Contains global variables such as `BASE_URL` for the API, `LAT` (latitude), `LON` (longitude), and `API_KEY` for authentication.

## Setup

1.  **Katalon Studio:** Ensure you have Katalon Studio installed. This project is designed to be opened and executed within Katalon Studio.
2.  **Set the Environment Variable** Ensure the API_KEY variable is exported in your bash session. You can add this to your .bashrc or .zshrc for persistence.

## Running Tests

Tests can be executed directly from Katalon Studio:

1.  Open the `Test Cases` folder in the Project Explorer.
2.  Select the desired test case (e.g., `TC_Get5DayForecast`).
3.  Click the "Run" button (play icon) in the toolbar.
4.  Alternatively, you can create a `Test Suite` in the `Test Suites/` folder (if one doesn't exist or to group tests) and run the Test Suite.

## Getting Reports

Test execution results are automatically generated and saved in the **`Reports/`** directory.

-   After running a test case or a test suite, Katalon Studio will create a new report folder within `Reports/` (e.g., `Reports/20260402_103000/`).
-   Inside these report folders, you will find detailed HTML reports that include test steps, status, and logs. Open the `index.html` file in a web browser to view the report.
-   The `Self-healing` sub-directory might contain data related to automated healing of broken test objects.
