# Hotel-Management-System
Hotel Management System for reception use - using Spring Boot, React.js, MySQL


CREATE TABLE guests (
    id BIGINT,
    name char,
    date_of_birth char,
    state char,
    city char,
    column3 char,
    permanent_address char,
    current_address char,
	phone_number char,
	email char,
    id_type char,
    id_document char
);

CREATE TABLE rooms (
        id BIGINT;
	room_no char,
room_type_code char,
floor char,
front_face char,
ac char,
price char
);

CREATE TABLE room_types (
        id BIGINT;
	code char,
noOfBeds char,
price char
);

CREATE TABLE bookings (
        id BIGINT;
booking_id char;
booking_date char;
guest_name char;
no_of_adults char;
no_of_children char;
room_type_code char;
fornt_face char;
ac char;
room_no char;
extra_bed char;
check_in char;
check_out char;
total_amount char;
payment_mode char;
payment_id char;
payment_status char
);



INSERT INTO `hotel_management_system`.`rooms` (`id`, `ac`, `floor`, `front_face`, `price`, `room_no`, `room_type_code`) VALUES ('1', 'Yes', '2', 'Yes', '2100', '201', 'Single Bed');
