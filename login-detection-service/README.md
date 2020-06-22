#Login Detection Service

## Database
    1. cd src/main/resources/database/
    2. psql -U <DATABASE_USER> -d <DATABASE_NAME> -f database.sql
    
## Test Application
    1. Start the service in any editior 
    2. GET API:- http://localhost:4004/api/v1/detection/ping
    3. After executing the API, you should see the entry in database table.
