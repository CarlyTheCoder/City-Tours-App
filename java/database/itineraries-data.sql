INSERT INTO itineraries (user_id, name, starting_point, trip_date)
VALUES (1, 'My trip to Detroit', 1, '2022/01/01'),
       (2, 'Motorcity trip', 5, '2023/02/02'),
       (2, 'Empty Test Itinerary', 8, '2021/12/25');
       
INSERT INTO itineraries_landmarks (landmark_id, itinerary_id, order_position)
VALUES (5, 1, 1), (1, 1, 2), (7, 1, 3), (2, 2, 1), (9, 2, 2);
