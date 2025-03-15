# Flights API

API for: https://github.com/tmcg1/flights-app

Run program from DemoApplication file.

API has 2 endpoints:

**/flights** -> returns all flights that can be filtered by from/to/departure/price params. Right now does not have db support, it is something to be done.

**/seats/:id** -> returns seats, getting them by id is not implemented yet because does not have db support. Right now 100 seats are generated and whether they are available or not is generated randomly (50:50). Since we have plane with 4 seats in a row, the seats by the window are divisible by 4 (i % 4 == 0 || (i - 1) % 4 == 0). Suggested seat is the first available seat. It is possible to get suggestions by the window seat and select how many seats you want to select.

Since available seats are generated randomly, it means when selecting filters the available seats change each time - in real world where it comes from db the seats do not change.
