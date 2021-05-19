create table folders
(
    id   int
        constraint folders_pk primary key,
    name varchar(255) not null,
    path varchar(512) not null
);
