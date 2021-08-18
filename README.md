# Cinema-Room-REST-Service
Simple spring boot app to handle `GET` AND `POST` of HTTP requests.

HTTP users can:
* Purchase a ticket by adding row and column index in the request body.
* Return purchased ticket by adding a token to request body which is a unique identifier for each bought ticket.
* Display all available seats in the theatre and it's price.
* Display statistics of theatre room (number of available seats, purchased tickets and total income).

## Example output
```
POST /purchase with body:
{
    "row": 5,
    "column": 9
}

response:
{
    "token": "2a7d7f8f-1642-4a86-82f7-68a743fc3d0b",
    "ticket": {
        "row": 5,
        "column": 9,
        "price": 8
    }
}

------------------------------------------------------------------------------------------------------------------------

POST /stats with query parameters: /stats?password=super_secret

response:
{
    "current_income": 8,
    "number_of_purchased_tickets": 1,
    "number_of_available_seats": 80
}

------------------------------------------------------------------------------------------------------------------------

POST /return with body:
{
    "token": "2a7d7f8f-1642-4a86-82f7-68a743fc3d0b"
}

response:
{
    "returned_ticket": {
        "row": 5,
        "column": 9,
        "price": 8
    }
}

------------------------------------------------------------------------------------------------------------------------
POST /return with invalid body:
{
    "token": "2a7d7f8f-1642-4a86-82f7-68a743fasdb"
}

response:
{
    "error": "Wrong token!"
}
```
