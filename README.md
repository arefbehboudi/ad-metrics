# Advertising Metrics Processor

## Overview
This Java application processes advertisement impression and click events from JSON files to generate analytical reports. It calculates key metrics for different dimensions and provides recommendations for the top-performing advertisers.

## Features
- Reads impression and click event data from JSON files.
- Validates and processes input data.
- Computes the following metrics per `app_id` and `country_code`:
    - Total impressions
    - Total clicks
    - Total revenue
- Recommends the top 5 advertisers per `app_id` and `country_code` based on revenue per impression.
- Outputs results in structured JSON files.

## Input Data Format

### `impressions.json`
```json
[
  {
    "id": "a1b2c3d4-e5f6-7890-1234-56789abcdef0",
    "app_id": 101,
    "country_code": "US",
    "advertiser_id": 5001
  }
]
```

### `clicks.json`
```json
[
  {
    "impression_id": "a1b2c3d4-e5f6-7890-1234-56789abcdef0",
    "revenue": 1.25
  }
]
```

## Output Data Format

### `metrics_output.json`
```json
[
  {
    "app_id": 101,
    "country_code": "US",
    "impressions": 100,
    "clicks": 20,
    "revenue": 25.50
  }
]
```

### `recommendations_output.json`
```json
[
  {
    "app_id": 101,
    "country_code": "US",
    "recommended_advertiser_ids": [5001, 5003, 5004]
  }
]
```

## Setup & Installation

### Prerequisites
- Java 21
- Maven (if using as build tool)

### Build the Project
```sh
mvn clean install
```

### Run the Application
```sh
java -jar target/advertising-metrics-1.0.jar
```

## Configuration
- Ensure input JSON files are placed in the correct directory.
- Output JSON files will be generated in the `output.json` file.

## Error Handling
- If input files are missing or incorrect, the program logs the errors and exits.
- If output directories do not exist, they are created automatically.

## Future Improvements
- Implement database storage for historical analysis.
- Add support for real-time data processing.
- Improve performance by parallelizing data processing.

## License
This project is licensed under the MIT License.

## Contact
For questions or suggestions, reach out to `your.email@example.com`.

