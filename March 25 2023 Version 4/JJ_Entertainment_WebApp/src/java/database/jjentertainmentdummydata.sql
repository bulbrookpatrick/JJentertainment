-- -----------------------------------------------------
-- Populate Manager
-- -----------------------------------------------------
INSERT INTO ROLE VALUES (1, 'manager');
INSERT INTO ROLE VALUES (2, 'client');
-- -----------------------------------------------------
-- Populate Performer
-- -----------------------------------------------------
INSERT INTO PERFORMER VALUES (null, 'KurtPerformer', 'kurtperformer@email.com', 'password', 'Kurt', 'Performer', '123456'); 
INSERT INTO PERFORMER VALUES (null, 'RoxannePerformer', 'roxanneperformer@email.com', 'password', 'Roxanne', 'Performer', '123456'); 
INSERT INTO PERFORMER VALUES (null, 'PatrickPerformer', 'patrickperformer@email.com', 'password', 'Patrick', 'Performer', '123456'); 
-- -----------------------------------------------------
-- Populate Category
-- -----------------------------------------------------
INSERT INTO CATEGORY (`category_name`, `category_description`, `category_rate`, `min_number_of_participants`, `min_number_of_performers`) VALUES ('Face Painting', 'Face paint for kids.', 60, 10, 1);
INSERT INTO CATEGORY (`category_name`, `category_description`, `category_rate`, `min_number_of_participants`, `min_number_of_performers`) VALUES ('Balloons', 'Balloons for decoration', 60, 10, 1);
INSERT INTO CATEGORY (`category_name`, `category_description`, `category_rate`, `min_number_of_participants`, `min_number_of_performers`) VALUES ('Photography', 'Photograph memories.', 45, 20, 1);
INSERT INTO CATEGORY (`category_name`, `category_description`, `category_rate`, `min_number_of_participants`, `min_number_of_performers`) VALUES ('Henna Tattoos', 'Tattoos that are not actual tattoos.', 80, 8, 1);
INSERT INTO CATEGORY (`category_name`, `category_description`, `category_rate`, `min_number_of_participants`, `min_number_of_performers`) VALUES ('Glitter Tattoos', 'Tattoos that are glitter.', 45, 8, 1);
-- -----------------------------------------------------
-- Populate Performer Specialty
-- -----------------------------------------------------
INSERT INTO PERFORMER_SPECIALTY VALUES (1, 1, 'Face Painting');
INSERT INTO PERFORMER_SPECIALTY VALUES (2, 1, 'Balloons');
INSERT INTO PERFORMER_SPECIALTY VALUES (3, 1, 'Photography');

INSERT INTO PERFORMER_SPECIALTY VALUES (2, 2, 'Balloons');
INSERT INTO PERFORMER_SPECIALTY VALUES (3, 2, 'Photography');
INSERT INTO PERFORMER_SPECIALTY VALUES (5, 2, 'Glitter Tattoos');

INSERT INTO PERFORMER_SPECIALTY VALUES (3, 3, 'Photography');
INSERT INTO PERFORMER_SPECIALTY VALUES (4, 3, 'Henna Tattoos');
INSERT INTO PERFORMER_SPECIALTY VALUES (5, 3, 'Glitter Tattoos');
-- -----------------------------------------------------
-- Populate Client
-- -----------------------------------------------------
INSERT INTO USER VALUES (null, 'JaneManager', 'janemanager@email.com', 'password', 'Jane', 'Manager', '123456', 0, 1);
INSERT INTO USER VALUES (null, 'JonCustomer', 'joncustomer@email.com', 'password', 'Jon', 'Customer', '123456', 0, 2);
INSERT INTO USER VALUES (null, 'NathanCustomer', 'nathancustomer@email.com', 'password', 'Nathan', 'Customer', '123456', 0, 2);
INSERT INTO USER VALUES (null, 'AlexCustomer', 'alexcustomer@email.com', 'password', 'Alex', 'Customer', '123456', 0, 2);
-- -----------------------------------------------------
-- Populate EVENT
-- -----------------------------------------------------
INSERT INTO EVENT (`event_start_date`, `event_end_date`, `event_location`, `event_status`, `event_interest`, `event_reservation_cost`, `USER_user_username`, `event_price`, `event_total`) VALUES ('2023-02-01', '2023-02-03', 'Calgary Zoo', 0, 0.10, 0.10, 'JonCustomer', 50, 50);
INSERT INTO EVENT (`event_start_date`, `event_end_date`, `event_location`, `event_status`, `event_interest`, `event_reservation_cost`, `USER_user_username`, `event_price`, `event_total`) VALUES ('2023-02-04', '2023-02-06', 'Calgary Mall', 0, 0.10, 0.10, 'NathanCustomer', 50, 50);
INSERT INTO EVENT (`event_start_date`, `event_end_date`, `event_location`, `event_status`, `event_interest`, `event_reservation_cost`, `USER_user_username`, `event_price`, `event_total`) VALUES ('2023-02-08', '2023-02-12', 'Calgary Park', 0, 0.10, 0.10, 'AlexCustomer', 50, 50);
-- -----------------------------------------------------
-- Populate Service
-- -----------------------------------------------------
INSERT INTO SERVICE (service_start_date, service_end_date, number_of_participants, CATEGORY_category_id, EVENT_event_id) VALUES ('2023-02-01 8:30', '2023-02-01 9:30', 10, 1, 1);
INSERT INTO SERVICE (service_start_date, service_end_date, number_of_participants, CATEGORY_category_id, EVENT_event_id) VALUES ('2023-02-01 8:30', '2023-02-01 9:30', 10, 3, 1);
INSERT INTO SERVICE (service_start_date, service_end_date, number_of_participants, CATEGORY_category_id, EVENT_event_id) VALUES ('2023-02-01 9:30', '2023-02-01 10:30', 10, 5, 1);

INSERT INTO SERVICE (service_start_date, service_end_date, number_of_participants, CATEGORY_category_id, EVENT_event_id) VALUES ('2023-02-04 8:30', '2023-02-04 11:30', 10, 4, 2);
INSERT INTO SERVICE (service_start_date, service_end_date, number_of_participants, CATEGORY_category_id, EVENT_event_id) VALUES ('2023-02-05 8:30', '2023-02-05 11:30', 10, 2, 2);
INSERT INTO SERVICE (service_start_date, service_end_date, number_of_participants, CATEGORY_category_id, EVENT_event_id) VALUES ('2023-02-06 8:30', '2023-02-06 11:30', 10, 1, 2);

INSERT INTO SERVICE (service_start_date, service_end_date, number_of_participants, CATEGORY_category_id, EVENT_event_id) VALUES ('2023-02-08 11:30', '2023-02-08 9:30', 10, 5, 3);
INSERT INTO SERVICE (service_start_date, service_end_date, number_of_participants, CATEGORY_category_id, EVENT_event_id) VALUES ('2023-02-10 14:00', '2023-02-10 16:00', 10, 3, 3);
INSERT INTO SERVICE (service_start_date, service_end_date, number_of_participants, CATEGORY_category_id, EVENT_event_id) VALUES ('2023-02-12 15:30', '2023-02-10 19:30', 10, 2, 3);
-- -----------------------------------------------------
-- Populate Performer Schedule
-- -----------------------------------------------------
INSERT INTO SERVICE_ASSIGN VALUES (1, 1);
INSERT INTO SERVICE_ASSIGN VALUES (1, 2);
INSERT INTO SERVICE_ASSIGN VALUES (1, 3);

INSERT INTO SERVICE_ASSIGN VALUES (2, 3);
INSERT INTO SERVICE_ASSIGN VALUES (2, 2);
INSERT INTO SERVICE_ASSIGN VALUES (2, 1);

INSERT INTO SERVICE_ASSIGN VALUES (3, 2);
INSERT INTO SERVICE_ASSIGN VALUES (3, 1);
INSERT INTO SERVICE_ASSIGN VALUES (3, 3);
-- -----------------------------------------------------