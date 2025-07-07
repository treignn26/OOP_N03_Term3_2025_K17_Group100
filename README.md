# Group 100 Project: Hệ thống quản lí cửa hàng thú cưng

# Giới thiệu:

   Hệ thống quản lý cửa hàng thú cưng là một phần mềm hỗ trợ chủ cửa hàng trong việc theo dõi và điều hành hoạt động kinh doanh như: quản lý thú cưng, sản phẩm, đơn hàng, khách hàng và dịch vụ chăm sóc. Hệ thống giúp tối ưu hoá quy trình làm việc, tiết kiệm thời gian và nâng cao hiệu quả phục vụ khách hàng.

# Tính năng chính:

-	Giao diện Java Spring Boot.
  
-	Chức năng quản lý Thú cưng
  
	+  Thêm, sửa, xóa Thú cưng (pets)
	+ Liệt kê thông tin về Thú cưng, có thể lọc ra các Thú cưng theo tên, loài, giống, tuổi, tình trạng sức khỏe…

-	Chức năng quản lý Khách hàng (Customer):
  
	+  Thêm, sửa, xóa Chủ nuôi (Customer)
	+ Có chức năng gán Thú cưng (pets) cho Chủ nuôi (Customer).

-	Chức năng quản lý Sản phẩm (Product):
  
	+ Thêm, sửa, xóa Sản phẩm (Product)
	+ Liệt kê thông tin về Sản phẩm
- 	Chức năng quản lí Nhân viên(Employee):
	+ Thêm nhân viên, sửa tên nhân viên, xoá nhân viên
	+ Hiển thị danh sách nhân viên
- Chức năng quản lí Dịch vụ:
	+ Thêm dịch vụ, sửa thông tin dịch vụ, xoá dịch vụ
	+ Hiển thị danh sách dịch vụ

-	Dữ liệu được lưu trữ xuống file nhị phân.
  
	+ Cần tạo các lớp liên quan đến đối tượng Thú cưng (pets), đối tượng Chủ nuôi (owner), đối tượng Hồ sơ (record) để đọc, ghi xu ống 1 hay nhiều file.

-	Khi làm việc với dữ liệu trong bộ nhớ, dữ liệu cần được lưu trữ dưới dạng các Collection tùy chọn như ArrayList, LinkedList, Map,….
# Các đối tượng trong hệ thống:

1. Thú cưng(Pet)
	+ Lưu trữ thông tin của thú cưng, bao gồm: mã ID thú cưng(duy nhất), tên thú cưng, giống loài, giới tính, tuổi(tháng), giá bán.
Thuộc tính: 
	+ Code (Mã thú cưng)
	+ Name (Tên thú cưng)
	+ Species (Loài)
	+ Gender (Giới tính)
	+ Age (Tuổi/Tháng)
	+ Price (Giá)

2. Khách hàng (Customer)
	+ Lưu trữ thông tin của khách hàng, bao gồm: mã khách hàng, tên khách hàng, số điện thoại, email, địa chỉ
Thuộc tính:
	+ khcode (Mã khách hàng)
	+ fullname (Họ tên khách hàng)
	+ email (email của khách hàng)
	+ phone (Số điện thoại khách hàng)
	+ address (Địa chỉ khách hàng)

3. Sản phẩm (Product)
	+ Lưu trữ thông tin của sản phẩm, bao gồm: mã sản phẩm, tên sản phẩm, giá sản phẩm, thông tin sản phẩm, số lượng sản phẩm
Thuộc tính:
	+ productid (mã sản phẩm)
	+ name (tên sản phẩm)
	+ price (giá sản phẩm)
	+ description (thông tin sản phẩm)
	+ quantity (số lượng sản phẩm)

4. Dịch vụ
	+ Lưu trữ thông tin các dịch vụ cung cấp cho khách hàng tiêu dùng, bao gồm: mã dịch vụ, tên dịch vụ, loại dịch vụ, giá dịch vụ
Thuộc tính:
	+ dvuid (mã dịch vụ)
	+ name (tên dịch vụ)
	+ type (loại dịch vụ)
	+ price (giá dịch vụ)

5. Nhân viên (Employee)
	+ Lưu trữ thông tin của nhân viên, bao gồm: mã nhân viên, tên nhân viên, số điện thoại, email, vai trò
Thuộc tính: 
	+ nvid (mã nhân viên)
	+ name (tên nhân viên)
	+ phone (số điện thoại nhân viên)
	+ email
	+ role (vai trò nhân viên)

## Sơ đồ Class Diagram:
<img src="images/sodoclassdiagram.jpg" alt="Sơ đồ Class Diagram" width="500"/>

## Sơ đồ hành vi:
<img src="images/sodohanhvi.jpg" alt="Sơ đồ hành vi" width="500"/>

# Lưu đồ thuật toán:
<img src="images/lưuđồ (2).png" alt="Lưu đồ thuật toán" width="500"/>

# Phân chia công việc:
	Đào Thu Trang - 23010630 : Xây dựng logic cốt lõi của việc lọc và hiển thị lịch hẹn
		- Miêu tả phương thức:
			-Phương thức filterAppointmentsByDate trong AppointmentList sẽ lọc các lịch hẹn theo ngày.
			- Tương tác: Phương thức này thể hiện mối quan hệ sử dụng (uses-a):
				AppointmentList sử dụng các đối tượng Appointment để duyệt và lọc.
			- Khi hiển thị thông tin lịch hẹn, AppointmentList (hoặc một lớp hiển thị) sẽ tương tác với PetList bằng cách gọi phương thức getPetDetails(petId) để lấy thông tin chi tiết của thú cưng tương ứng với petId trong lịch hẹn. Điều này cho phép kết hợp thông tin từ hai lớp dữ liệu khác nhau.
	Trần Thảo Vy - 23010588 :Phát triển và hoàn thiện các lớp dữ liệu cần thiết.
		- Class Pet đại diện cho thông tin một thú cưng (ID, tên, loài, tên chủ sở hữu).
		- Class Appointment đại diện cho một lịch hẹn (ID lịch hẹn, ID thú cưng, ngày hẹn, lý do khám).
		- Tương tác: Mặc dù Pet và Appointment là các lớp riêng biệt, chúng tương tác thông qua petId. Appointment chứa petId như một "khóa ngoại" để chỉ ra lịch hẹn này thuộc về thú cưng nào. Lớp PetList sẽ "chứa" các đối tượng Pet, thể hiện mối quan hệ tổng hợp (composition).
	Nguyễn Ngọc Minh - 23010623: Kiểm thử tổng thể và tài liệu hóa.
		- Tương tác: Phương thức main() đóng vai trò là "điều phối viên", nó khởi tạo các đối tượng PetList và AppointmentList, sau đó gọi các phương thức của chúng để thực hiện các tác vụ (thêm dữ liệu, lấy ngày hiện tại, lọc lịch hẹn). Cuối cùng, nó kết hợp thông tin từ cả hai danh sách (PetList và AppointmentList) để hiển thị kết quả cuối cùng cho người dùng. Đây là điểm mà tất cả các đối tượng và chức năng nhỏ hợp tác (collaborate) để đạt được mục tiêu cuối cùng của ứng dụng.
# Công nghệ sử dụng:
 -	 Ngôn ngữ: Java
# Thành viên nhóm:

	1.Đào Thu Trang 

	2.Nguyễn Ngọc Minh

	3.Trần Thảo Vy