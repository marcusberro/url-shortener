--
-- Sample dataset containing shorten urls and redirection.
--

-- =================================================================================================
-- SHORTEN URLS

insert into shorten_url(id, code, url, creationDate, hits) values (1,'AAA', 'http://google.com', '2015-10-24 01:11:23', 1)
insert into redirection(id, redirectDate, shortenUrlId, sourceInfoId) values (1, '2015-10-24 02:11:23', 1, 1)
insert into source_info(id, userAgent, sourceHost, sourceRequestDate) values (1,'Firefox','localhost','2015-10-24 01:11:23')