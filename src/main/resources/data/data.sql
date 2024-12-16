--INSERT INTO users (
--    id, user_id, first_name, last_name, email, phone, bio, reference_id, image_url,
--    created_by, updated_by, created_at, updated_at, account_non_expired, account_non_locked, enabled, mfa
--)
--VALUES (
--    0, '823a7479-e7a7-879f-3ae5-a766fe25eca9', 'System', 'System', 'system@gmail.com', '123456789',
--    'This is not a user but the system itself', '823a7479-e7a7-859f-3ae5-a766fe25eca9',
--    'https://cdn-icons-png.flaticon.com/512/149/149071.png',
--    0, 0, '2024-12-15 13:10:59.114114', '2024-12-15 13:10:59.114114',
--    TRUE, TRUE, FALSE, FALSE
--);

select count(*) from users;