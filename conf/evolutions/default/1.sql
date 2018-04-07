# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table task (
  id                            bigint auto_increment not null,
  description                   varchar(255),
  priority                      integer,
  done                          boolean,
  constraint ck_task_priority check ( priority in (0,1,2)),
  constraint pk_task primary key (id)
);


# --- !Downs

drop table if exists task;

