# TrainingBooking

Some examples for Rest-api:

1. GET http://localhost:8080/api/trainings
2. GET http://localhost:8080/api/bookings
3. GET http://localhost:8080/api/training/1
4. GET http://localhost:8080/api/booking/10
5. Get http://localhost:8080/api/trainings?startdate=2020-05-04&enddate=2020-06-04
6. Post http://localhost:8080/api/training
body:
 {
        "appointments": [
            {
                "startDate": "2020-03-01",
                "endDate": "2020-03-14"
            },
            {
                "startDate": "2020-03-18",
                "endDate": "2020-04-05"
            }
        ],
        "description": "jupyter is good.",
        "name": "jupyter",
        "teachers": [
            {
                "name": "Ghavimi"
            }
        ],
        "price": "220"
 }

7. PUT http://localhost:8080/api/training/5
{
	"name": "jupyter 444"
}

8. if you placed the front-end in htdocs (apache):
http://localhost/index.html
