drop table if exists comments;
drop table if exists posts;

create table posts(
    id serial,
    title varchar(200) not null,
    content text default null,
    created_on timestamp default null,
    primary key (id)
);

create table comments(
    id serial,
    post_id int,
    name varchar(200),
    email varchar(200),
    content text default null,
    created_on timestamp default null,
    primary key (id),
    foreign key (post_id) references posts (id) on delete cascade
);
