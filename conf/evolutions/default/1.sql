# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table search_data (
  slug                      varchar(255) not null,
  search_text               varchar(255),
  gender_type               varchar(255),
  country                   varchar(255),
  constraint pk_search_data primary key (slug))
;

create table surfer (
  slug                      varchar(255) not null,
  name                      varchar(255),
  home                      varchar(255),
  awards                    varchar(255),
  carousel_url              longtext,
  bio_url                   longtext,
  bio                       longtext,
  surfer_type               varchar(255),
  foot                      varchar(255),
  country                   varchar(255),
  user_info_id              bigint,
  constraint pk_surfer primary key (slug))
;

create table user_info (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  email                     varchar(255),
  password                  varchar(255),
  admin                     tinyint(1) default 0,
  constraint pk_user_info primary key (id))
;

alter table surfer add constraint fk_surfer_userInfo_1 foreign key (user_info_id) references user_info (id) on delete restrict on update restrict;
create index ix_surfer_userInfo_1 on surfer (user_info_id);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table search_data;

drop table surfer;

drop table user_info;

SET FOREIGN_KEY_CHECKS=1;

