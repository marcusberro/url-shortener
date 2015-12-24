--
-- Sample dataset containing shorten urls and redirection.
--

-- =================================================================================================
-- SHORTEN URLS

drop table redirection if exists;
drop table shorten_url if exists;
drop table source_info if exists;
create table redirection (id bigint generated by default as identity, redirect_date timestamp, shorten_url_id bigint, source_info_id bigint, primary key (id));
create table shorten_url (id bigint generated by default as identity, code varchar(255), creation_date timestamp, hits bigint, url varchar(255), primary key (id));
create table source_info (id bigint generated by default as identity, source_host varchar(255), source_request_date timestamp, user_agent varchar(255), primary key (id));
alter table shorten_url add constraint UK_CODE unique (code);
alter table redirection add constraint FK_SHORTEN_URL foreign key (shorten_url_id) references shorten_url;
alter table redirection add constraint FK_SOURCE_INFO foreign key (source_info_id) references source_info;

CREATE SEQUENCE IF NOT EXISTS URL_CODE START WITH 1 INCREMENT BY 1 MINVALUE 1 MAXVALUE 4294967295 NOCYCLE NOCACHE;

insert into shorten_url values (1,'aaa', '2015-10-24 01:11:23', 1, 'http://google.com');
insert into source_info values (1,'localhost','2015-10-24 01:11:23','Firefox');
insert into redirection values (1, '2015-10-24 02:11:23', 1, 1);