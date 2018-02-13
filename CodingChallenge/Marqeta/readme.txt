# Batch processing excercise
Given a fixed length batch file to process.
Design a data model out of the specs and parse the sample data using the data model
Write the file processing code as efficient as possible considering the file may contain
billions of lines

# Specifications
The batch file contains airline transactions and metadata.
A single transaction comprises of 2 or 1 row(s) in the file. 
- A Detail Transaction Record (DTR = 06)
- A Supplementary Detail Record (SDR = 07)
-
Each row is a fixed length line (64 bytes)
More details on the record descriptions below

## Detail Transaction Record (Record Type = 06) REQUIRED LINE
Record Type - 2 bytes - ALNUM - position 1-2
Transaction Code - 4 bytes - ALNUM - position 3-6
Card Number - 19 bytes - ALNUM - position 7-25
Merchant Category Code - 4 bytes  - ALNUM - position 26-29
Filler - 15 bytes - ALNUM - position 30 - 44
Original Transaction Date - 8 bytes - ALNUM - position 57-64, format: CCYYMMDD
Transaction Amount - 12 bytes - SIGNED NUMERIC - position 45 - 56, 2 decimals implied

## Supplementary Data Record (Record Type = 07) OPTINAL LINE
Record Type - 2 bytes - ALNUM - position 1-2
Transaction Code - 4 bytes - ALNUM - position 3-6
Card Number - 19 bytes - ALNUM - position 7-25
SDR Description - 39 bytes - position 26-64

## Data to process
Below are sample data in a file and write code to parse these data from a file using the data models created

0617456111111111111111   5918               00000000895720170101
0717456111111111111111   01Marriot Hotel       180 Grand Ave. CA
0617256121111111111111   5542               00000000046820170104
0617206121111111111111   3000               00000000046820170104
0717206121111111111111   02Hilton Hotel        1st Street, NY   


# Assumptions
An existing parser library that given a line outputs a String array of the fields e.g.
String[] fields = Parser.parse(line);
fields[0] - record type
fields[N] - last field

An existing transaction processing module that takes your data model and returns a success/fail response e.g.
Response response = TransactionProcessor.process(Model)

