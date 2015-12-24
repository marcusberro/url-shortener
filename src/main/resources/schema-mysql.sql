--alter table shorten_url drop foreign key UK_CODE;
--alter table redirection drop foreign key FK_SHORTEN_URL;
--alter table redirection drop foreign key FK_SOURCE_INFO;

--drop table if exists redirection;
--drop table if exists shorten_url;
--drop table if exists source_info;

CREATE TABLE source_info (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  source_host varchar(255) DEFAULT NULL,
  source_request_date datetime DEFAULT NULL,
  user_agent varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE shorten_url (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  code varchar(255) DEFAULT NULL,
  creation_date datetime NOT NULL,
  hits bigint(20) DEFAULT NULL,
  url varchar(255) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE redirection (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  redirect_date datetime NOT NULL,
  shorten_url_id bigint(20) NOT NULL,
  source_info_id bigint(20) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

alter table shorten_url add constraint UK_CODE unique (code);
alter table redirection add constraint FK_SHORTEN_URL foreign key (shorten_url_id) references shorten_url (id);
alter table redirection add constraint FK_SOURCE_INFO foreign key (source_info_id) references source_info (id);