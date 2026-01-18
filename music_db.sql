create sequence account_sequence

    Start with 100000
    Increment by 1
    Cache 50;

create sequence songs_id_sequence

    Start with 100000
    Increment by 1
    Cache 50;

create table account(
    id       bigint not null default nextval('songs_id_sequence'),
    name     varchar (25) not null,

----------------------------------------------------------------------------------------------------------------------------
    constraint account_pk primary key (id)
);

insert into account (name) values ('иван');
insert into account (name) values ('анна');
insert into account (name) values ('петр');
insert into account (name) values ('иван');
insert into account (name) values ('саша');
insert into account (name) values ('катя');


SELECT * FROM account;

create table songs(
    id       bigint not null default nextval('account_id_sequence'),
    title    varchar (100) not null,
    length   int,
    aftor    bigint not null default 0,
----------------------------------------------------------------------------------------------------------------------------
    constraint songs_pk primary key (id),
    constraint songs_aftor_fk foreign key (aftor) references account(id)
);

SELECT * FROM songs;

insert into songs (title, length, aftor) values ('Song A', 120, 100000);
DELETE FROM songs WHERE id = 100050;
insert into songs (title, length, aftor) values ('Song B', 240, 100002);
insert into songs (title, length, aftor) values ('Song C', 240, 100000);
insert into songs (title, length, aftor) values ('Song D', 240, 100004);
insert into songs (title, length, aftor) values ('Song E', 240, 100003);
insert into songs (title, length, aftor) values ('Song F', 240, 100001);
insert into songs (title, length, aftor) values ('Song G', 240, 100002);
DELETE FROM songs WHERE id = 100053;

select * from
             account
left join songs s on account.id = s.aftor
where account.name = 'катя';

create table subsriptins(
    account_id bigint default 0 not null,
    song_id bigint default 0 not null,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
-----------------------------------------------------------------------------------------------------
    constraint subsriptins_pk primary key (account_id, song_id)
);

insert  into subsriptins (account_id, song_id, created_at) values (100000, 100056, CURRENT_TIMESTAMP);
insert  into subsriptins (account_id, song_id, created_at) values (100003, 100058, CURRENT_TIMESTAMP);
insert  into subsriptins (account_id, song_id, created_at) values (100001, 100056, CURRENT_TIMESTAMP);

SELECT
    listener.name as "Имя пользователя",     -- listener = account в роли подписчика
    s.title as "Название песни",
    author.name as "Имя автора"              -- author = account в роли автора
FROM subsriptins sub
         JOIN account listener ON sub.account_id = listener.id   -- ❗Здесь account назван listener
         JOIN songs s ON sub.song_id = s.id
         JOIN account author ON s.aftor = author.id        -- ❗Здесь account назван author
         WHERE listener.name = 'иван';
