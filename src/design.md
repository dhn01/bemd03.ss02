### 1. Lấy toàn bộ danh sách công việc, người dùng.

GET /api/v1/tasks
GET /api/v1/users

### 2. Tạo mới công việc, tạo mới người dùng.

POST /api/v1/tasks
POST /api/v1/users

### 3. Cập nhật trạng thái một công việc, cập nhật vai trò của người dùng.

PUT /api/v1/tasks/{id}
PUT /api/v1/users/{id}

### 4. Xóa một công việc, xóa một người dùng khỏi hệ thống.

DELETE /api/v1/tasks/{id}
DELETE /api/v1/users/{id}

### 5. Tìm các công việc có mức độ ưu tiên là "high".

GET /api/v1/tasks?priority="high"

### 6. Tìm các công việc có độ ưu tiên là "high" và được giao cho người dùng với id là 1.

GET /api/v1/tasks?priority="high"&userId=1

### 7. Liệt kê toàn bộ công việc của 1 người dùng.

GET /api/v1/tasks?userId=1

### 8. Gắn công việc cho người dùng.

PATCH /api/v1/tasks/{