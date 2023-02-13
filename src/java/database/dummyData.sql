-- -----------------------------------------------------
-- Populate Manager
-- -----------------------------------------------------
INSERT INTO MANAGER VALUES ('JaneManager', 'manager@email.com', 'password', 'Jane', 'Admin', 123456);
-- -----------------------------------------------------
-- Populate Performer
-- -----------------------------------------------------
INSERT INTO PERFORMER VALUES ('KurtPerformer', 'kurtperformer@email.com', 'password', 'Kurt', 'Performer', 123456, 'JaneManager'); 
INSERT INTO PERFORMER VALUES ('RoxannePerformer', 'roxanneperformer@email.com', 'password', 'Roxanne', 'Performer', 123456, 'JaneManager'); 
INSERT INTO PERFORMER VALUES ('PatrickPerformer', 'patrickperformer@email.com', 'password', 'Patrick', 'Performer', 123456, 'JaneManager'); 
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
INSERT INTO PERFORMER_SPECIALTY VALUES (1, 'KurtPerformer');
INSERT INTO PERFORMER_SPECIALTY VALUES (2, 'KurtPerformer');
INSERT INTO PERFORMER_SPECIALTY VALUES (3, 'KurtPerformer');
INSERT INTO PERFORMER_SPECIALTY VALUES (4, 'KurtPerformer');
INSERT INTO PERFORMER_SPECIALTY VALUES (5, 'KurtPerformer');

INSERT INTO PERFORMER_SPECIALTY VALUES (1, 'RoxannePerformer');
INSERT INTO PERFORMER_SPECIALTY VALUES (2, 'RoxannePerformer');
INSERT INTO PERFORMER_SPECIALTY VALUES (3, 'RoxannePerformer');
INSERT INTO PERFORMER_SPECIALTY VALUES (4, 'RoxannePerformer');
INSERT INTO PERFORMER_SPECIALTY VALUES (5, 'RoxannePerformer');

INSERT INTO PERFORMER_SPECIALTY VALUES (1, 'PatrickPerformer');
INSERT INTO PERFORMER_SPECIALTY VALUES (2, 'PatrickPerformer');
INSERT INTO PERFORMER_SPECIALTY VALUES (3, 'PatrickPerformer');
INSERT INTO PERFORMER_SPECIALTY VALUES (4, 'PatrickPerformer');
INSERT INTO PERFORMER_SPECIALTY VALUES (5, 'PatrickPerformer');
-- -----------------------------------------------------
-- Populate Client
-- -----------------------------------------------------
INSERT INTO CLIENT VALUES ('JonCustomer', 'joncustomer@email.com', 'password', 'Jon', 'Customer', 123456, 0);
INSERT INTO CLIENT VALUES ('NathanCustomer', 'nathancustomer@email.com', 'password', 'Nathan', 'Customer', 123456, 0);
INSERT INTO CLIENT VALUES ('AlexCustomer', 'alexcustomer@email.com', 'password', 'Alex', 'Customer', 123456, 0);
-- -----------------------------------------------------
-- Populate EVENT
-- -----------------------------------------------------
INSERT INTO EVENT (`event_start_date`, `event_end_date`, `event_location`, `event_status`, `event_interest`, `event_reservation_cost`, `CLIENT_client_username`) VALUES ('2023-02-01', '2023-02-03', 'Calgary Zoo', 0, 0.10, 0.10, 'JonCustomer');
INSERT INTO EVENT (`event_start_date`, `event_end_date`, `event_location`, `event_status`, `event_interest`, `event_reservation_cost`, `CLIENT_client_username`) VALUES ('2023-02-04', '2023-02-06', 'Calgary Mall', 0, 0.10, 0.10, 'NathanCustomer');
INSERT INTO EVENT (`event_start_date`, `event_end_date`, `event_location`, `event_status`, `event_interest`, `event_reservation_cost`, `CLIENT_client_username`) VALUES ('2023-02-08', '2023-02-12', 'Calgary Park', 0, 0.10, 0.10, 'AlexCustomer');
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
INSERT INTO SERVICE_ASSIGN VALUES ('KurtPerformer', 1);
INSERT INTO SERVICE_ASSIGN VALUES ('KurtPerformer', 2);
INSERT INTO SERVICE_ASSIGN VALUES ('KurtPerformer', 3);

INSERT INTO SERVICE_ASSIGN VALUES ('RoxannePerformer', 3);
INSERT INTO SERVICE_ASSIGN VALUES ('RoxannePerformer', 2);
INSERT INTO SERVICE_ASSIGN VALUES ('RoxannePerformer', 1);

INSERT INTO SERVICE_ASSIGN VALUES ('PatrickPerformer', 2);
INSERT INTO SERVICE_ASSIGN VALUES ('PatrickPerformer', 1);
INSERT INTO SERVICE_ASSIGN VALUES ('PatrickPerformer', 3);
-- -----------------------------------------------------