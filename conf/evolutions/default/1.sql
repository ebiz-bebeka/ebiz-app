# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table shoes_color (
  id                            serial not null,
  name                          varchar(255),
  constraint pk_shoes_color primary key (id)
);

create table shoes_manufacturer (
  id                            serial not null,
  name                          varchar(255),
  country                       varchar(255),
  constraint pk_shoes_manufacturer primary key (id)
);

create table shoes_model (
  id                            serial not null,
  user_category_id              integer,
  type_id                       integer,
  manufacturer_id               integer,
  color_id                      integer,
  size                          float,
  price                         float,
  high_heel                     boolean,
  genuine_leather               boolean,
  months_of_warranty            integer,
  pieces_available              integer,
  image_filename                varchar(255),
  constraint pk_shoes_model primary key (id)
);

create table shoes_model_type (
  id                            serial not null,
  name                          varchar(255),
  constraint pk_shoes_model_type primary key (id)
);

create table shoes_user_category (
  id                            serial not null,
  name                          varchar(255),
  constraint pk_shoes_user_category primary key (id)
);

alter table shoes_model add constraint fk_shoes_model_user_category_id foreign key (user_category_id) references shoes_user_category (id) on delete restrict on update restrict;
create index ix_shoes_model_user_category_id on shoes_model (user_category_id);

alter table shoes_model add constraint fk_shoes_model_type_id foreign key (type_id) references shoes_model_type (id) on delete restrict on update restrict;
create index ix_shoes_model_type_id on shoes_model (type_id);

alter table shoes_model add constraint fk_shoes_model_manufacturer_id foreign key (manufacturer_id) references shoes_manufacturer (id) on delete restrict on update restrict;
create index ix_shoes_model_manufacturer_id on shoes_model (manufacturer_id);

alter table shoes_model add constraint fk_shoes_model_color_id foreign key (color_id) references shoes_color (id) on delete restrict on update restrict;
create index ix_shoes_model_color_id on shoes_model (color_id);


# --- !Downs

alter table if exists shoes_model drop constraint if exists fk_shoes_model_user_category_id;
drop index if exists ix_shoes_model_user_category_id;

alter table if exists shoes_model drop constraint if exists fk_shoes_model_type_id;
drop index if exists ix_shoes_model_type_id;

alter table if exists shoes_model drop constraint if exists fk_shoes_model_manufacturer_id;
drop index if exists ix_shoes_model_manufacturer_id;

alter table if exists shoes_model drop constraint if exists fk_shoes_model_color_id;
drop index if exists ix_shoes_model_color_id;

drop table if exists shoes_color cascade;

drop table if exists shoes_manufacturer cascade;

drop table if exists shoes_model cascade;

drop table if exists shoes_model_type cascade;

drop table if exists shoes_user_category cascade;

