# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table account (
  id                            bigserial not null,
  first_name                    varchar(255),
  last_name                     varchar(255),
  email                         varchar(255),
  display_name                  varchar(255),
  password                      varchar(255),
  dob                           varchar(255),
  constraint pk_account primary key (id)
);

create table post (
  id                            bigserial not null,
  user_id                       integer,
  content                       varchar(255),
  status                        integer,
  timestamp                     varchar(255),
  constraint pk_post primary key (id)
);


# --- !Downs

drop table if exists account cascade;

drop table if exists post cascade;

