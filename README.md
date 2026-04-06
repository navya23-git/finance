User Management Endpoints (Admin Only)

Base URL: http://localhost:8082/users
Authentication: Basic Auth → username: admin, password: admin123

a) Create User
Method: POST
URL: /users
Body (JSON):
{
  "name": "John Doe",
  "email": "john@example.com",
  "password": "password123",
  "role": "ANALYST"
}
Expected Response: 200 OK, returns created user with id and active=true
b) Get All Users
Method: GET
URL: /users
Expected Response:
[
  {
    "id": 1,
    "name": "John Doe",
    "email": "john@example.com",
    "role": "ANALYST",
    "active": true
  },
  ...
]
c) Update User Info
Method: PUT
URL: /users/{id}
Body (JSON):
{
  "name": "John Smith",
  "email": "johnsmith@example.com",
  "role": "VIEWER"
}
Expected Response: Updated user JSON
d) Activate/Deactivate User
Method: PATCH
URL: /users/{id}/status?active=false
Expected Response: User JSON with updated active status
2️⃣ Financial Records Endpoints

Base URL: http://localhost:8082/records
Authentication: Basic Auth → username: analyst or admin

a) Create Record
Method: POST
URL: /records
Body (JSON):
{
  "amount": 500.0,
  "type": "income",
  "category": "Salary",
  "date": "2026-04-06",
  "notes": "April salary"
}
Expected Response: 200 OK, created record JSON with id
b) Get All Records
Method: GET
URL: /records
Expected Response:
[
  {
    "id": 1,
    "amount": 500.0,
    "type": "income",
    "category": "Salary",
    "date": "2026-04-06",
    "notes": "April salary"
  }
]
c) Update Record
Method: PUT
URL: /records/{id}
Body (JSON):
{
  "amount": 550.0,
  "type": "income",
  "category": "Salary",
  "date": "2026-04-06",
  "notes": "Updated April salary"
}
Expected Response: Updated record JSON
d) Delete Record
Method: DELETE
URL: /records/{id}
Expected Response: 200 OK, empty body
3️⃣ Dashboard Summary Endpoint

Base URL: http://localhost:8082/dashboard/summary
Authentication: Basic Auth → username: viewer, analyst, or admin

Method: GET
URL: /dashboard/summary
Expected Response:
{
  "totalIncome": 500.0,
  "totalExpense": 0.0,
  "netBalance": 500.0
}
