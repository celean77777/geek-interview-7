create table students(
                         id bigserial primary key,
                         name varchar(255),
                         age int

);

insert into students(name, age)
values
    ('Bob', 22),
    ('Bill', 23),
    ('Sofia', 20),
    ('John', 21),
    ('Liza', 21),
    ('Fred', 25);
