INSERT INTO FILES(id, name, media_type, size, timestamp)
VALUES ('7d548300-c876-49a6-bc8f-a372731220be', 'GeorgeOrwellAnimalFarm.jpg', 'image/jpeg', 38747,
        '2022-09-30 14:58:35.513747'),
       ('05e845ef-4256-414f-9ec0-0264f237c075', 'OsamuDazaiDonalKeene.jpg', 'image/jpeg', 12578,
        '2022-09-21 20:00:14.002617'),
       ('55b55bac-2bc5-44a8-9079-85e79ef652dc', 'KhaledHosseiniAThousandSplendidSuns.jpg', 'image/jpeg', 996735,
        '2022-09-30 10:24:41.151156'),
       ('d2a4219d-dcc9-4dc4-bd74-e3070690df5a', 'AdamKayThisIsGoingToHurt.jpg', 'image/jpeg', 107010,
        '2022-09-30 14:04:57.164106'),
       ('0bc5dec2-f4b4-4619-bc94-5d76980a7136', 'YuvalNoahHarariSapiens.jpg', 'image/jpeg', 204154,
        '2022-09-30 14:09:19.608276'),
       ('e601077b-9de7-4663-931f-6fe6134267ce', 'RayBradburyFahrenhei.jpg', 'image/jpeg', 22967,
        '2022-09-30 14:17:34.31463');

INSERT INTO BOOKS(id, title, author, description, genre, pages, language, first_publication, publication, publisher,
                  isbn, file_id)
VALUES ('48a95af7-8b83-4a08-8001-0f865db8ea26', 'Animal Farm', 'George Orwell',
        'A farm is taken over by its overworked, mistreated animals. With flaming idealism and stirring slogans, they set out to create a paradise of progress, justice, and equality. Thus the stage is set for one of the most telling satiric fables ever penned –a razor-edged fairy tale for grown-ups that records the evolution from revolution against tyranny to a totalitarianism just as terrible. When Animal Farm was first published, Stalinist Russia was seen as its target. Today it is devastatingly clear that wherever and whenever freedom is attacked, under whatever banner, the cutting clarity and savage comedy of George Orwell’s masterpiece have a meaning and message still ferociously fresh.',
        'Classic', 122, 'English', '1945-08-17', '2003-05-06', 'NAL', '9780452284241',
        '7d548300-c876-49a6-bc8f-a372731220be'),
       ('48a95af7-8b83-4a08-8001-0f865db8ea21', 'No Longer Human', 'Osamu Dazai',
        'Portraying himself as a failure, the protagonist of No Longer Human narrates a seemingly normal life even while he feels incapable of understanding human beings. Oba Yozo''s attempts to reconcile himself to the world around him begin in early childhood, continue through high school, where he becomes a "clown" to mask his alienation, and eventually lead to a failed suicide attempt as an adult. Without sentimentality, he records the casual cruelties of life and its fleeting moments of human connection and tenderness.',
        'Fiction', 176, 'English', '1948-01-01', '2001-01-01', 'Directions Publishing', '9780451526342',
        '05e845ef-4256-414f-9ec0-0264f237c075'),
       ('48a95af7-8b83-4a08-8001-0f865db8ea22', 'A Thousand Splendid Suns', 'Khaled Hosseini',
        'Mariam is only fifteen when she is sent to Kabul to marry the troubled and bitter Rasheed, who is thirty years her senior. Nearly two decades later, in a climate of growing unrest, tragedy strikes fifteen-year-old Laila, who must leave her home and join Mariam''s unhappy household. Laila and Mariam are to find consolation in each other, their friendship to grow as deep as the bond between sisters, as strong as the ties between mother and daughter.',
        'Fiction', 372, 'English', '2007-01-01', '2007-06-01', 'Riverhead Books', '9781594489501',
        '55b55bac-2bc5-44a8-9079-85e79ef652dc'),
       ('48a95af7-8b83-4a08-8001-0f865db8ea23', 'This is Going to Hurt: Secret Diaries of a Junior Doctor', 'Adam Kay',
        'Welcome to 97-hour weeks. Welcome to life and death decisions. Welcome to a constant tsunami of bodily fluids. Welcome to earning less than the hospital parking meter. Wave goodbye to your friends and relationships. Welcome to the life of a first-year doctor.',
        'Nonfiction', 288, 'English', '20017-09-07', '20019-12-03', 'Little, Brown Spark', '9780316426725',
        'd2a4219d-dcc9-4dc4-bd74-e3070690df5a'),
       ('48a95af7-8b83-4a08-8001-0f865db8ea24', 'Sapiens: A Brief History of Humankind', 'Yuval Noah Harari',
        'Most books about the history of humanity pursue either a historical or a biological approach, but Dr. Yuval Noah Harari breaks the mold with this highly original book that begins about 70,000 years ago with the appearance of modern cognition. From examining the role evolving humans have played in the global ecosystem to charting the rise of empires, Sapiens integrates history and science to reconsider accepted narratives, connect past developments with contemporary concerns, and examine specific events within the context of larger ideas.',
        'Nonfiction', 464, 'English', '20011-01-01', '20018-05-15', 'Harper Perennial', '9780062316110',
        '0bc5dec2-f4b4-4619-bc94-5d76980a7136'),
       ('48a95af7-8b83-4a08-8001-0f865db8ea25', 'Fahrenheit 451', 'Ray Bradbury',
        'Guy Montag is a fireman. His job is to destroy the most illegal of commodities, the printed book, along with the houses in which they are hidden. Montag never questions the destruction and ruin his actions produce, returning each day to his bland life and wife, Mildred, who spends all day with her television “family.” But when he meets an eccentric young neighbor, Clarisse, who introduces him to a past where people didn’t live in fear and to a present where one sees the world through the ideas in books instead of the mindless chatter of television, Montag begins to question everything he has ever known.',
        'Fiction', 249, 'English', '1953-10-19', '20013-08-13', 'Simon & Schuster', '9781451673319',
        'e601077b-9de7-4663-931f-6fe6134267ce');

INSERT INTO USERS(id, name, surname, username, email, phone, password)
VALUES ('97591abe-5108-4bc2-afaa-6bc6a339619c', 'test_user', 'test_user', 'Simona', 'user@gmail.com', '+37065285774', '{bcrypt}$2a$10$AsRCsrfh4423vjPr0xKpZeNpYixVcNtDpiGdM5xcIejUXOttH2jcu'), /*USER*/
       ('1c6eb4cd-b644-4932-8d88-ec97b3ba0b7b', 'test_admin', 'test_admin', 'admin', 'admin@gmail.com', '+37065285666', '{bcrypt}$2a$10$9Ox9WgR8X5SD04lLSdCwJ.AITH/cAZmcZ9tMkqJUFYSc0krItXT9W'); /*admin*/

INSERT INTO COMMENTS (id, text, date, book_id, user_id)
VALUES ('18a95af7-8b83-4a08-8001-0f865db8ea26', 'Hello!!!!!', '2022-08-10', '48a95af7-8b83-4a08-8001-0f865db8ea26', '97591abe-5108-4bc2-afaa-6bc6a339619c'),
       ('12a95af7-8b83-4a08-8001-0f865db8ea26', ':)', '2022-08-11', '48a95af7-8b83-4a08-8001-0f865db8ea26', '97591abe-5108-4bc2-afaa-6bc6a339619c');

INSERT INTO ITEMS(id, status, book_id, date)
VALUES ('0d4666ea-659f-431c-bdc7-b16e71f01e26', 0, '48a95af7-8b83-4a08-8001-0f865db8ea26',
        '2022-09-22 15:05:46.354893'),
       ('d11651e9-06fa-493b-9ce6-77f0558b12fe', 0, '48a95af7-8b83-4a08-8001-0f865db8ea21',
        '2022-09-22 15:05:46.354893'),
       ('0d4666ea-659f-431c-bdc7-b16e71f01e27', 0, '48a95af7-8b83-4a08-8001-0f865db8ea26',
        '2022-09-23 15:05:46.354893');


INSERT INTO RATINGS(id, rate, book_id, user_id)
VALUES ('ec3cec92-b682-4823-9474-cae10bb17bff', 2, '48a95af7-8b83-4a08-8001-0f865db8ea26', '97591abe-5108-4bc2-afaa-6bc6a339619c');


INSERT INTO ROLES(id, name)
VALUES ('7f74bb02-9f14-43ce-8b28-8c0c889d1558', 'USER'),
       ('25dde1c9-f740-46a7-a598-d62f37126950', 'ADMIN');

INSERT INTO USERS_ROLES(user_id, role_id)
VALUES ('97591abe-5108-4bc2-afaa-6bc6a339619c', '7f74bb02-9f14-43ce-8b28-8c0c889d1558'),
       ('1c6eb4cd-b644-4932-8d88-ec97b3ba0b7b', '7f74bb02-9f14-43ce-8b28-8c0c889d1558'),
       ('1c6eb4cd-b644-4932-8d88-ec97b3ba0b7b', '25dde1c9-f740-46a7-a598-d62f37126950');




