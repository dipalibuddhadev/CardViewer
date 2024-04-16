# CardViewer

CardViewer is an Android application that fetches credit card data from a remote API and displays it in a list.

## Features

- Fetches credit card data from the provided API endpoint.
- Displays credit card information including card type, card number, and expiry date.
- Uses RecyclerView to efficiently display the list of credit cards.
- Handles network errors and API failures gracefully.

## Installation

To run the app, follow these steps:

1. Clone this repository to your local machine.
2. Open the project in Android Studio.
3. Build and run the app on an Android device or emulator.

## Usage

Upon launching the app, it will fetch credit card data from the API and display it in a list. Each list item shows the card type, card number, and expiry date.

## API Used

The app uses the following API to fetch credit card data:
- API Endpoint: [https://random-data-api.com/api/v2/credit_cards?size=100](https://random-data-api.com/api/v2/credit_cards?size=100)

## Dependencies

The project uses the following dependencies:

- Retrofit: For handling network requests.
- Gson: For parsing JSON responses.
- RecyclerView: For displaying the list of credit cards.

## Assumptions and Decisions

- The app assumes a stable internet connection for fetching data from the API.
- Error handling is implemented to display appropriate messages in case of network errors or API failures.
- The app does not include any authentication mechanisms since the API does not require authentication for fetching credit card data.
- The UI design is kept simple and functional, focusing on displaying the credit card information clearly.

## Contributing

Contributions are welcome! If you find any issues or have suggestions for improvements, feel free to open an issue or submit a pull request.



