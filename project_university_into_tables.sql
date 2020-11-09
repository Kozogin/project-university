#password admin  555
#password all users  555

insert into user(user_id , assigned_id, password, password_confirm, email, first_name, last_name, role) values	
    (101, 'admin','$2a$10$5t0xqdEySHgCXvr8srLQhOHwECM9ptJh6r6IxPs.pQDAEnX6l43by', '$2a$10$5t0xqdEySHgCXvr8srLQhOHwECM9ptJh6r6IxPs.pQDAEnX6l43by',
    'admin@mail.com',  "Edik", "Kotovuch", "ROLE_ADMIN"),
     (102, 'admin2','$2a$10$5t0xqdEySHgCXvr8srLQhOHwECM9ptJh6r6IxPs.pQDAEnX6l43by', '$2a$10$5t0xqdEySHgCXvr8srLQhOHwECM9ptJh6r6IxPs.pQDAEnX6l43by',
    'admin2@mail.com',  "Andriy", "Adrian", "ROLE_ADMIN"),
     (103, 'ID202011814140', '$2a$10$5t0xqdEySHgCXvr8srLQhOHwECM9ptJh6r6IxPs.pQDAEnX6l43by', '$2a$10$5t0xqdEySHgCXvr8srLQhOHwECM9ptJh6r6IxPs.pQDAEnX6l43by',
    'peter@mail.com',  "Peter", "Didik", "ROLE_USER"),
     (104, 'ID202011814150', '$2a$10$5t0xqdEySHgCXvr8srLQhOHwECM9ptJh6r6IxPs.pQDAEnX6l43by', '$2a$10$5t0xqdEySHgCXvr8srLQhOHwECM9ptJh6r6IxPs.pQDAEnX6l43by',
    'nicola@mail.com',  "Nicola", "Tesla", "ROLE_USER"),
     (105, 'ID202011814160', '$2a$10$5t0xqdEySHgCXvr8srLQhOHwECM9ptJh6r6IxPs.pQDAEnX6l43by', '$2a$10$5t0xqdEySHgCXvr8srLQhOHwECM9ptJh6r6IxPs.pQDAEnX6l43by',
    'vasil@mail.com',  "Vasily", "Mask", "ROLE_USER"),
    (106, 'ID202011814170', '$2a$10$5t0xqdEySHgCXvr8srLQhOHwECM9ptJh6r6IxPs.pQDAEnX6l43by', '$2a$10$5t0xqdEySHgCXvr8srLQhOHwECM9ptJh6r6IxPs.pQDAEnX6l43by',
    'oksana@mail.com',  "Oksana", "Pekun", "ROLE_USER"    
);

insert into faculty(faculty_id, name) values
	(101, 'IT'),
    (102, 'Mechanical'),
    (103, 'Philosophy'),
    (104, 'Physical Education'
);

insert into name_of_lesson(lesson_id, name) values
	(101, 'Computer Science'),
    (102, 'Maths'),
    (103, 'Ukrainian language'),
    (104, 'Ukrainian literature '),    
    (105, 'English'),
    (106, 'Biology'),
    (107, 'Physical education'    
);
