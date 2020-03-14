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


# --- !Downs

drop table if exists account cascade;

