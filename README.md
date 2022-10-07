# Nuwe-CSV-To-JSON
Nuwe challenge in preparation for Barcelona Digital Talent Hackathon. This repository contains a Spring application that exposes an API providing a .csv file to JSON conversion microservice.

## Installation

The project can be downloaded as a .zip file and run in your preferred IDE.

## Usage

The service may be used by executing a POST request on http://localhost:8080/api/csvtojson, appending a .csv file to the body of the request (make sure that the key is 'file', the value is your .csv file, and the type has been set to 'file' instead of the default 'text').

## Design

The package structure is the following:

- Controller: provides the endpoint that exposes the underlying service.
- Exception: defines custom exceptions and holds the controller advice class for exception handling.
- Response: has a custom message response POJO.
- Service: parses the .csv file and returns a JSON.
- Utils: has the .csv parser, which reads the .csv file, extracts its header, and parses its contents into a JSON String. It also has a couple of private helper methods.

## Tests with Postman

The repository includes a json file that can be imported into Postman to test the service. It also has an example .csv file to include in the test.
