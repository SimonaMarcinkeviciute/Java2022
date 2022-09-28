INSERT INTO FILES(id, name, media_type, size, timestamp)
VALUES ('54f5ac3e-2fbc-4016-ab44-05d9aa071da8', 'GeorgeOrwellAnimalFarm.jpg', 'image/jpeg', 7009,
        '2022-09-21 19:46:07.047882'),
       ('05e845ef-4256-414f-9ec0-0264f237c075', 'OsamuDazaiDonalKeene.jpg', 'image/jpeg', 12578,
        '2022-09-21 20:00:14.002617');

INSERT INTO BOOKS(id, title, author, description, genre, pages, language, first_publication, publication, publisher,
                  isbn, file_id)
VALUES ('48a95af7-8b83-4a08-8001-0f865db8ea26', 'Animal Farm', 'George Orwell',
        'A farm is taken over by its overworked, mistreated animals. With flaming idealism and stirring slogans, they set out to create a paradise of progress, justice, and equality. Thus the stage is set for one of the most telling satiric fables ever penned –a razor-edged fairy tale for grown-ups that records the evolution from revolution against tyranny to a totalitarianism just as terrible. When Animal Farm was first published, Stalinist Russia was seen as its target. Today it is devastatingly clear that wherever and whenever freedom is attacked, under whatever banner, the cutting clarity and savage comedy of George Orwell’s masterpiece have a meaning and message still ferociously fresh.',
        'Classic', 141, 'English', '1945-08-17', '1996-04-01', 'Signet Classics', '9780451526342',
        '54f5ac3e-2fbc-4016-ab44-05d9aa071da8'),
       ('48a95af7-8b83-4a08-8001-0f865db8ea21', 'No Longer Human', 'Osamu Dazai',
        'Portraying himself as a failure, the protagonist of No Longer Human narrates a seemingly normal life even while he feels incapable of understanding human beings. Oba Yozo''s attempts to reconcile himself to the world around him begin in early childhood, continue through high school, where he becomes a "clown" to mask his alienation, and eventually lead to a failed suicide attempt as an adult. Without sentimentality, he records the casual cruelties of life and its fleeting moments of human connection and tenderness.',
        'Fiction', 176, 'English', '1948-01-01', '2001-01-01', 'Directions Publishing', '9780451526342',
        '05e845ef-4256-414f-9ec0-0264f237c075');

INSERT INTO COMMENTS (id, text, date, book_id)
VALUES ('18a95af7-8b83-4a08-8001-0f865db8ea26', 'Hello!!!!!', '2022-08-10', '48a95af7-8b83-4a08-8001-0f865db8ea26'),
       ('12a95af7-8b83-4a08-8001-0f865db8ea26', ':)', '2022-08-11', '48a95af7-8b83-4a08-8001-0f865db8ea26');

INSERT INTO ITEMS(id, status, book_id, date)
VALUES ('0d4666ea-659f-431c-bdc7-b16e71f01e26', 0, '48a95af7-8b83-4a08-8001-0f865db8ea26',
        '2022-09-22 15:05:46.354893'),
       ('d11651e9-06fa-493b-9ce6-77f0558b12fe', 0, '48a95af7-8b83-4a08-8001-0f865db8ea21',
        '2022-09-22 15:05:46.354893');


INSERT INTO RATINGS(id, rate, book_id)
VALUES ('ec3cec92-b682-4823-9474-cae10bb17bff', 2, '48a95af7-8b83-4a08-8001-0f865db8ea26');

INSERT INTO USERS(id, name, surname, username, email, phone, password)
VALUES ('97591abe-5108-4bc2-afaa-6bc6a339619c', 'test_user', 'test_user', 'Simona', 'user@gmail.com', '+37065285774', '{bcrypt}$2a$10$AsRCsrfh4423vjPr0xKpZeNpYixVcNtDpiGdM5xcIejUXOttH2jcu'), /*USER*/
       ('1c6eb4cd-b644-4932-8d88-ec97b3ba0b7b', 'test_admin', 'test_admin', 'admin', 'admin@gmail.com', '+37065285666', '{bcrypt}$2a$10$9Ox9WgR8X5SD04lLSdCwJ.AITH/cAZmcZ9tMkqJUFYSc0krItXT9W'); /*admin*/

INSERT INTO ROLES(id, name)
VALUES ('7f74bb02-9f14-43ce-8b28-8c0c889d1558', 'USER'),
       ('25dde1c9-f740-46a7-a598-d62f37126950', 'ADMIN');

INSERT INTO USERS_ROLES(user_id, role_id)
VALUES ('97591abe-5108-4bc2-afaa-6bc6a339619c', '7f74bb02-9f14-43ce-8b28-8c0c889d1558'),
       ('1c6eb4cd-b644-4932-8d88-ec97b3ba0b7b', '7f74bb02-9f14-43ce-8b28-8c0c889d1558'),
       ('1c6eb4cd-b644-4932-8d88-ec97b3ba0b7b', '25dde1c9-f740-46a7-a598-d62f37126950');




