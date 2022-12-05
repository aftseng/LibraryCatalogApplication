--
-- PostgreSQL database dump
--

-- Dumped from database version 14.5 (Debian 14.5-1.pgdg100+1)
-- Dumped by pg_dump version 14.5 (Debian 14.5-1.pgdg100+1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: authentication_system; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.authentication_system (
    userid character varying(255) NOT NULL,
    password character varying(255)
);


--
-- Name: book; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.book (
    author character varying(255),
    title character varying(255),
    reservationstatus character varying(255),
    isbn character varying(20) NOT NULL,
    genre character varying(255),
    publisherid character varying(255)
);


--
-- Name: publisher; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.publisher (
    name character varying(255),
    publisherid character varying(255) NOT NULL,
    year character varying(4)
);


--
-- Name: reservation; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.reservation (
    reserve_date character varying(255) NOT NULL,
    due_date character varying(255),
    return_date character varying(255),
    userid character varying(255) NOT NULL,
    isbn character varying(255) NOT NULL
);


--
-- Name: search_feature; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.search_feature (
    publisher character varying(255),
    isbn character varying(20) NOT NULL,
    booktitle character varying(255),
    author character varying(255),
    genre character varying(255)
);


--
-- Name: users; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.users (
    first_name character varying(255),
    last_name character varying(255),
    userid character varying(255) NOT NULL,
    email character varying(255),
    phone_number character varying(12)
);





--
-- Name: book book_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.book
    ADD CONSTRAINT book_pkey PRIMARY KEY (isbn);


--
-- Name: publisher publisher_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.publisher
    ADD CONSTRAINT publisher_pkey PRIMARY KEY (publisherid);


--
-- Name: reservation reservation_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.reservation
    ADD CONSTRAINT reservation_pkey PRIMARY KEY (reserve_date);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (userid);


--
-- Name: authentication_system authentication_system_userid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.authentication_system
    ADD CONSTRAINT authentication_system_userid_fkey FOREIGN KEY (userid) REFERENCES public.users(userid);


--
-- Name: book book_publisherid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.book
    ADD CONSTRAINT book_publisherid_fkey FOREIGN KEY (publisherid) REFERENCES public.publisher(publisherid);


--
-- Name: reservation reservation_isbn_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.reservation
    ADD CONSTRAINT reservation_isbn_fkey FOREIGN KEY (isbn) REFERENCES public.book(isbn);


--
-- Name: reservation reservation_userid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.reservation
    ADD CONSTRAINT reservation_userid_fkey FOREIGN KEY (userid) REFERENCES public.users(userid);


--
-- Name: search_feature search_feature_isbn_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.search_feature
    ADD CONSTRAINT search_feature_isbn_fkey FOREIGN KEY (isbn) REFERENCES public.book(isbn);


--
-- PostgreSQL database dump complete
--

