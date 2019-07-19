insert into posts (title, content, created_on) values
    ('Post 1', 'This is post 1', '2017-01-03'),
    ('Post 2', 'This is post 2', '2017-01-05'),
    ('Post 3', 'This is post 3', '2017-01-07');

insert into comments (post_id, name, email, content, created_on) values
    (1, 'User1', 'user1@gmail.com', 'This is comment 1 on post 1', '2019-01-01'),
    (1, 'User2', 'user2@gmail.com', 'This is comment 2 on post 1', '2019-01-01'),
    (2, 'User1', 'user1@gmail.com', 'This is comment 1 on post 2', '2019-01-01');