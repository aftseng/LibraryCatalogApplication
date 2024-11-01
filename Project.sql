PGDMP      !                    z            Project    14.5    14.5                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    24681    Project    DATABASE     m   CREATE DATABASE "Project" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'English_United States.1252';
    DROP DATABASE "Project";
                postgres    false            �            1259    24712    authentication_system    TABLE        CREATE TABLE public.authentication_system (
    userid character varying(255) NOT NULL,
    password character varying(255)
);
 )   DROP TABLE public.authentication_system;
       public         heap    postgres    false            �            1259    24717    book    TABLE       CREATE TABLE public.book (
    author character varying(255),
    title character varying(255),
    reservationstatus character varying(255),
    isbn character varying(20) NOT NULL,
    genre character varying(255),
    publisherid character varying(255)
);
    DROP TABLE public.book;
       public         heap    postgres    false            �            1259    24722 	   publisher    TABLE     �   CREATE TABLE public.publisher (
    name character varying(255),
    publisherid character varying(255) NOT NULL,
    year character varying(4)
);
    DROP TABLE public.publisher;
       public         heap    postgres    false            �            1259    24727    reservation    TABLE     �   CREATE TABLE public.reservation (
    reserve_date character varying(255) NOT NULL,
    due_date character varying(255),
    return_date character varying(255),
    userid character varying(255) NOT NULL,
    isbn character varying(255) NOT NULL
);
    DROP TABLE public.reservation;
       public         heap    postgres    false            �            1259    24732    search_feature    TABLE     �   CREATE TABLE public.search_feature (
    publisher character varying(255),
    isbn character varying(20) NOT NULL,
    booktitle character varying(255),
    author character varying(255),
    genre character varying(255)
);
 "   DROP TABLE public.search_feature;
       public         heap    postgres    false            �            1259    24737    users    TABLE     �   CREATE TABLE public.users (
    first_name character varying(255),
    last_name character varying(255),
    userid character varying(255) NOT NULL,
    email character varying(255),
    phone_number character varying(12)
);
    DROP TABLE public.users;
       public         heap    postgres    false                      0    24712    authentication_system 
   TABLE DATA           A   COPY public.authentication_system (userid, password) FROM stdin;
    public          postgres    false    209   �                 0    24717    book 
   TABLE DATA           Z   COPY public.book (author, title, reservationstatus, isbn, genre, publisherid) FROM stdin;
    public          postgres    false    210          	          0    24722 	   publisher 
   TABLE DATA           <   COPY public.publisher (name, publisherid, year) FROM stdin;
    public          postgres    false    211          
          0    24727    reservation 
   TABLE DATA           X   COPY public.reservation (reserve_date, due_date, return_date, userid, isbn) FROM stdin;
    public          postgres    false    212   w                 0    24732    search_feature 
   TABLE DATA           S   COPY public.search_feature (publisher, isbn, booktitle, author, genre) FROM stdin;
    public          postgres    false    213   �                 0    24737    users 
   TABLE DATA           S   COPY public.users (first_name, last_name, userid, email, phone_number) FROM stdin;
    public          postgres    false    214   8        p           2606    24743    book book_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.book
    ADD CONSTRAINT book_pkey PRIMARY KEY (isbn);
 8   ALTER TABLE ONLY public.book DROP CONSTRAINT book_pkey;
       public            postgres    false    210            r           2606    24745    publisher publisher_pkey 
   CONSTRAINT     _   ALTER TABLE ONLY public.publisher
    ADD CONSTRAINT publisher_pkey PRIMARY KEY (publisherid);
 B   ALTER TABLE ONLY public.publisher DROP CONSTRAINT publisher_pkey;
       public            postgres    false    211            t           2606    24747    reservation reservation_pkey 
   CONSTRAINT     d   ALTER TABLE ONLY public.reservation
    ADD CONSTRAINT reservation_pkey PRIMARY KEY (reserve_date);
 F   ALTER TABLE ONLY public.reservation DROP CONSTRAINT reservation_pkey;
       public            postgres    false    212            v           2606    24749    users users_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (userid);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public            postgres    false    214            w           2606    24750 7   authentication_system authentication_system_userid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.authentication_system
    ADD CONSTRAINT authentication_system_userid_fkey FOREIGN KEY (userid) REFERENCES public.users(userid);
 a   ALTER TABLE ONLY public.authentication_system DROP CONSTRAINT authentication_system_userid_fkey;
       public          postgres    false    3190    214    209            x           2606    24755    book book_publisherid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.book
    ADD CONSTRAINT book_publisherid_fkey FOREIGN KEY (publisherid) REFERENCES public.publisher(publisherid);
 D   ALTER TABLE ONLY public.book DROP CONSTRAINT book_publisherid_fkey;
       public          postgres    false    210    3186    211            y           2606    24760 !   reservation reservation_isbn_fkey    FK CONSTRAINT     ~   ALTER TABLE ONLY public.reservation
    ADD CONSTRAINT reservation_isbn_fkey FOREIGN KEY (isbn) REFERENCES public.book(isbn);
 K   ALTER TABLE ONLY public.reservation DROP CONSTRAINT reservation_isbn_fkey;
       public          postgres    false    3184    212    210            z           2606    24765 #   reservation reservation_userid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.reservation
    ADD CONSTRAINT reservation_userid_fkey FOREIGN KEY (userid) REFERENCES public.users(userid);
 M   ALTER TABLE ONLY public.reservation DROP CONSTRAINT reservation_userid_fkey;
       public          postgres    false    212    214    3190            {           2606    24770 '   search_feature search_feature_isbn_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.search_feature
    ADD CONSTRAINT search_feature_isbn_fkey FOREIGN KEY (isbn) REFERENCES public.book(isbn);
 Q   ALTER TABLE ONLY public.search_feature DROP CONSTRAINT search_feature_isbn_fkey;
       public          postgres    false    3184    210    213               (   x^K�OJ�,��,��44261�JL+�45162����� �(;         �   x^]��J�0����)��ҴMrYC���
��&=�K I���}������]�%{���p�����N32�������0\��b(KB&ɟ0�l��+�ur����]�3����u'���h?�aހK�0���P��`�s�yMhs=��<���E��J�;��5p��oC�6 K.�9�G��~/��i��jZ��>�0rwKi��8翝r]{      	   d   x^�1
�0 �9yE_ �Z�?p�:��R�-X��������=��@�%�K[RS�LE@�v8��'?A�(�����58EY��U}�s��4��	�?!��      
   S   x^%���0 u2����d&�TP؟�;q�N�TIYD(�t]�ڏޞ����f9�EH\yH���Y�Y�v�&D|�+         N   x^N���I,.�L�4�001�4263�4���,IUpK�K��JL�V���K���tL.����wL)K�+)-J����� ��q         �   x^M�;�0��������n�l���P�%�%��&�0<�7|ok�)X�pA��W����i��׌���yQV�p<	vE?%hIO轁e�œVB�zthl�B*�%��;7g�:h���w���o$k|����8���W)�7�=2�� <[     