

CREATE TABLE   movies
(
    id int primary key not null,
    title varchar2(255) not null,
    release_date DATE not null,
    duration int not null,
    score int not null
) ;

CREATE TABLE  genres
(
    id int primary key not null,
    name varchar2(255) not null
);

CREATE TABLE  asstab
(
    movieId int not null,
    genreId int not null,
    FOREIGN KEY (genreId) REFERENCES genres(id),
    FOREIGN KEY (movieId) REFERENCES movies(id)
);

CREATE  TABLE actors(
    movieId int not null,
    name varchar2(255) not null,
     FOREIGN KEY (movieId) REFERENCES movies(id)
);

CREATE  TABLE directors(
    movieId int not null,
    name varchar2(255) not null,
    FOREIGN KEY (movieId) REFERENCES movies(id)
);



