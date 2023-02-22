CREATE TABLE IF NOT EXISTS studentgroup (
  id VARCHAR(255) NOT NULL PRIMARY KEY,
  namegroup VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS student (
  id VARCHAR(255) NOT NULL PRIMARY KEY,
  firstname VARCHAR(255) NOT NULL,
  lastname VARCHAR(255) NOT NULL,
  age INTEGER NOT NULL,
  ts TIMESTAMP WITHOUT TIME ZONE NOT NULL,
  id_group VARCHAR(255) NOT NULL,
  FOREIGN KEY (id_group) REFERENCES studentgroup(id)
);

CREATE TABLE IF NOT EXISTS subject (
  id VARCHAR(255) NOT NULL PRIMARY KEY,
  namesubject VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS lecturer (
  id VARCHAR(255) NOT NULL PRIMARY KEY,
  firstname VARCHAR(255) NOT NULL,
  lastname VARCHAR(255) NOT NULL,
  age INTEGER NOT NULL,
  subject_id VARCHAR(255) NOT NULL,
  FOREIGN KEY (subject_id) REFERENCES subject(id)
);

CREATE TABLE IF NOT EXISTS rating (
  id VARCHAR(255) NOT NULL PRIMARY KEY,
  id_student VARCHAR(255) NOT NULL,
  subject_id VARCHAR(255) NOT NULL,
  points INTEGER NOT NULL,
  FOREIGN KEY (id_student) REFERENCES student(id),
  FOREIGN KEY (subject_id) REFERENCES subject(id)
);

insert into public.studentgroup (id, namegroup)
values ('mk3a7953-578a-488d-9768-51986a806e4e', 'MORTALKOMBAT'),
('av764da1-75bd-4a08-b07d-16a40dd1398f', 'AVENGERS'),
('inj5e066-76a0-49bf-b008-59a2bbb12d10','INJUSTICE');

insert into public.student (id, firstname, lastname, age, ts, id_group)
values ('student1-b150-11ed-b9d9-0800200c9a11', 'Johnny', 'Cage', 21,'2020-10-05 14:01:10','mk3a7953-578a-488d-9768-51986a806e4e'),
('student2-b150-11ed-b9d9-0800200c9a22', 'Sonya', 'Blade', 19,'2020-10-06 15:01:10','mk3a7953-578a-488d-9768-51986a806e4e'),
('student3-b150-11ed-b9d9-0800200c9a33', 'Liu', 'Kang', 20,'2020-10-06 16:01:10','mk3a7953-578a-488d-9768-51986a806e4e'),
('student4-b150-11ed-b9d9-0800200c9a44', 'Thor', 'Odinson', 987,'2021-08-10 12:01:10','av764da1-75bd-4a08-b07d-16a40dd1398f'),
('student5-b150-11ed-b9d9-0800200c9a55', 'Tony', 'Stark', 43,'2021-08-10 11:01:10','av764da1-75bd-4a08-b07d-16a40dd1398f'),
('student6-b150-11ed-b9d9-0800200c9a66', 'Bruce', 'Banner', 37,'2021-08-11 10:01:10','av764da1-75bd-4a08-b07d-16a40dd1398f'),
('student7-b150-11ed-b9d9-0800200c9a77', 'Clark', 'Kent', 37,'2022-06-03 12:01:10','inj5e066-76a0-49bf-b008-59a2bbb12d10'),
('student8-b150-11ed-b9d9-0800200c9a88', 'Bruce', 'Wayne', 48,'2022-06-04 18:01:10','inj5e066-76a0-49bf-b008-59a2bbb12d10');

insert into public.subject (id, namesubject)
values ('subject1-b152-11ed-b9d9-0800200c9a11', 'shooting'),
('subject2-b152-11ed-b9d9-0800200c9a22', 'magic'),
('subject3-b152-11ed-b9d9-0800200c9a33', 'blacksmithing'),
('subject4-b152-11ed-b9d9-0800200c9a44', 'flying'),
('subject5-b152-11ed-b9d9-0800200c9a55', 'dragonology'),
('subject6-b152-11ed-b9d9-0800200c9a66', 'force');

insert into public.lecturer (id, firstname, lastName, age, subject_id)
values ('lectur11-b152-11ed-b9d9-0800200c9a11', 'Roland', 'Deschain', 39, 'subject1-b152-11ed-b9d9-0800200c9a11'),
('lectur22-b152-11ed-b9d9-0800200c9a22', 'Raistlin', 'Majere', 28, 'subject2-b152-11ed-b9d9-0800200c9a22'),
('lectur33-b152-11ed-b9d9-0800200c9a33', 'Feanor', 'Noldor', 3280, 'subject3-b152-11ed-b9d9-0800200c9a33'),
('lectur44-b152-11ed-b9d9-0800200c9a44', 'Kaladin', 'Stormblessed', 23, 'subject4-b152-11ed-b9d9-0800200c9a44'),
('lectur55-b152-11ed-b9d9-0800200c9a55', 'Rand', 'alThor', 20, 'subject5-b152-11ed-b9d9-0800200c9a55'),
('lectur66-b152-11ed-b9d9-0800200c9a66','Darth', 'Vader', 46, 'subject6-b152-11ed-b9d9-0800200c9a66');

insert into public.rating (id, id_student, subject_id, points)
values ('rating11-b152-11ed-b9d9-0800200c9a11', 'student1-b150-11ed-b9d9-0800200c9a11', 'subject1-b152-11ed-b9d9-0800200c9a11', 2),
('rating12-b152-11ed-b9d9-0800200c9a12', 'student1-b150-11ed-b9d9-0800200c9a11', 'subject2-b152-11ed-b9d9-0800200c9a22', 2),
('rating13-b152-11ed-b9d9-0800200c9a13', 'student1-b150-11ed-b9d9-0800200c9a11', 'subject3-b152-11ed-b9d9-0800200c9a33', 2),
('rating14-b152-11ed-b9d9-0800200c9a14', 'student1-b150-11ed-b9d9-0800200c9a11', 'subject4-b152-11ed-b9d9-0800200c9a44', 2),
('rating15-b152-11ed-b9d9-0800200c9a15', 'student1-b150-11ed-b9d9-0800200c9a11', 'subject5-b152-11ed-b9d9-0800200c9a55', 2),
('rating16-b152-11ed-b9d9-0800200c9a16', 'student1-b150-11ed-b9d9-0800200c9a11', 'subject6-b152-11ed-b9d9-0800200c9a66', 3),
('rating21-b152-11ed-b9d9-0800200c9a21', 'student2-b150-11ed-b9d9-0800200c9a22', 'subject1-b152-11ed-b9d9-0800200c9a11', 3),
('rating22-b152-11ed-b9d9-0800200c9a22', 'student2-b150-11ed-b9d9-0800200c9a22', 'subject2-b152-11ed-b9d9-0800200c9a22', 3),
('rating23-b152-11ed-b9d9-0800200c9a23', 'student2-b150-11ed-b9d9-0800200c9a22', 'subject3-b152-11ed-b9d9-0800200c9a33', 3),
('rating24-b152-11ed-b9d9-0800200c9a24', 'student2-b150-11ed-b9d9-0800200c9a22', 'subject4-b152-11ed-b9d9-0800200c9a44', 3),
('rating25-b152-11ed-b9d9-0800200c9a25', 'student2-b150-11ed-b9d9-0800200c9a22', 'subject5-b152-11ed-b9d9-0800200c9a55', 3),
('rating26-b152-11ed-b9d9-0800200c9a26', 'student2-b150-11ed-b9d9-0800200c9a22', 'subject6-b152-11ed-b9d9-0800200c9a66', 4),
('rating31-b152-11ed-b9d9-0800200c9a31', 'student3-b150-11ed-b9d9-0800200c9a33', 'subject1-b152-11ed-b9d9-0800200c9a11', 4),
('rating32-b152-11ed-b9d9-0800200c9a32', 'student3-b150-11ed-b9d9-0800200c9a33', 'subject2-b152-11ed-b9d9-0800200c9a22', 4),
('rating33-b152-11ed-b9d9-0800200c9a33', 'student3-b150-11ed-b9d9-0800200c9a33', 'subject3-b152-11ed-b9d9-0800200c9a33', 4),
('rating34-b152-11ed-b9d9-0800200c9a34', 'student3-b150-11ed-b9d9-0800200c9a33', 'subject4-b152-11ed-b9d9-0800200c9a44', 4),
('rating35-b152-11ed-b9d9-0800200c9a35', 'student3-b150-11ed-b9d9-0800200c9a33', 'subject5-b152-11ed-b9d9-0800200c9a55', 4),
('rating36-b152-11ed-b9d9-0800200c9a36', 'student3-b150-11ed-b9d9-0800200c9a33', 'subject6-b152-11ed-b9d9-0800200c9a66', 5),
('rating41-b152-11ed-b9d9-0800200c9a41', 'student4-b150-11ed-b9d9-0800200c9a44', 'subject1-b152-11ed-b9d9-0800200c9a11', 5),
('rating42-b152-11ed-b9d9-0800200c9a42', 'student4-b150-11ed-b9d9-0800200c9a44', 'subject2-b152-11ed-b9d9-0800200c9a22', 5),
('rating43-b152-11ed-b9d9-0800200c9a43', 'student4-b150-11ed-b9d9-0800200c9a44', 'subject3-b152-11ed-b9d9-0800200c9a33', 4),
('rating44-b152-11ed-b9d9-0800200c9a44', 'student4-b150-11ed-b9d9-0800200c9a44', 'subject4-b152-11ed-b9d9-0800200c9a44', 5),
('rating45-b152-11ed-b9d9-0800200c9a45', 'student4-b150-11ed-b9d9-0800200c9a44', 'subject5-b152-11ed-b9d9-0800200c9a55', 5),
('rating46-b152-11ed-b9d9-0800200c9a46', 'student4-b150-11ed-b9d9-0800200c9a44', 'subject6-b152-11ed-b9d9-0800200c9a66', 6),
('rating51-b152-11ed-b9d9-0800200c9a51', 'student5-b150-11ed-b9d9-0800200c9a55', 'subject1-b152-11ed-b9d9-0800200c9a11', 6),
('rating52-b152-11ed-b9d9-0800200c9a52', 'student5-b150-11ed-b9d9-0800200c9a55', 'subject2-b152-11ed-b9d9-0800200c9a22', 6),
('rating53-b152-11ed-b9d9-0800200c9a53', 'student5-b150-11ed-b9d9-0800200c9a55', 'subject3-b152-11ed-b9d9-0800200c9a33', 6),
('rating54-b152-11ed-b9d9-0800200c9a54', 'student5-b150-11ed-b9d9-0800200c9a55', 'subject4-b152-11ed-b9d9-0800200c9a44', 6),
('rating55-b152-11ed-b9d9-0800200c9a55', 'student5-b150-11ed-b9d9-0800200c9a55', 'subject5-b152-11ed-b9d9-0800200c9a55', 6),
('rating56-b152-11ed-b9d9-0800200c9a56', 'student5-b150-11ed-b9d9-0800200c9a55', 'subject6-b152-11ed-b9d9-0800200c9a66', 7),
('rating61-b152-11ed-b9d9-0800200c9a61', 'student6-b150-11ed-b9d9-0800200c9a66', 'subject1-b152-11ed-b9d9-0800200c9a11', 7),
('rating62-b152-11ed-b9d9-0800200c9a62', 'student6-b150-11ed-b9d9-0800200c9a66', 'subject2-b152-11ed-b9d9-0800200c9a22', 7),
('rating63-b152-11ed-b9d9-0800200c9a63', 'student6-b150-11ed-b9d9-0800200c9a66', 'subject3-b152-11ed-b9d9-0800200c9a33', 6),
('rating64-b152-11ed-b9d9-0800200c9a64', 'student6-b150-11ed-b9d9-0800200c9a66', 'subject4-b152-11ed-b9d9-0800200c9a44', 7),
('rating65-b152-11ed-b9d9-0800200c9a65', 'student6-b150-11ed-b9d9-0800200c9a66', 'subject5-b152-11ed-b9d9-0800200c9a55', 7),
('rating66-b152-11ed-b9d9-0800200c9a66', 'student6-b150-11ed-b9d9-0800200c9a66', 'subject6-b152-11ed-b9d9-0800200c9a66', 8),
('rating71-b152-11ed-b9d9-0800200c9a71', 'student7-b150-11ed-b9d9-0800200c9a77', 'subject1-b152-11ed-b9d9-0800200c9a11', 8),
('rating72-b152-11ed-b9d9-0800200c9a72', 'student7-b150-11ed-b9d9-0800200c9a77', 'subject2-b152-11ed-b9d9-0800200c9a22', 8),
('rating73-b152-11ed-b9d9-0800200c9a73', 'student7-b150-11ed-b9d9-0800200c9a77', 'subject3-b152-11ed-b9d9-0800200c9a33', 5),
('rating74-b152-11ed-b9d9-0800200c9a74', 'student7-b150-11ed-b9d9-0800200c9a77', 'subject4-b152-11ed-b9d9-0800200c9a44', 8),
('rating75-b152-11ed-b9d9-0800200c9a75', 'student7-b150-11ed-b9d9-0800200c9a77', 'subject5-b152-11ed-b9d9-0800200c9a55', 8),
('rating76-b152-11ed-b9d9-0800200c9a76', 'student7-b150-11ed-b9d9-0800200c9a77', 'subject6-b152-11ed-b9d9-0800200c9a66', 9),
('rating81-b152-11ed-b9d9-0800200c9a81', 'student8-b150-11ed-b9d9-0800200c9a88', 'subject1-b152-11ed-b9d9-0800200c9a11', 9),
('rating82-b152-11ed-b9d9-0800200c9a82', 'student8-b150-11ed-b9d9-0800200c9a88', 'subject2-b152-11ed-b9d9-0800200c9a22', 9),
('rating83-b152-11ed-b9d9-0800200c9a83', 'student8-b150-11ed-b9d9-0800200c9a88', 'subject3-b152-11ed-b9d9-0800200c9a33', 9),
('rating84-b152-11ed-b9d9-0800200c9a84', 'student8-b150-11ed-b9d9-0800200c9a88', 'subject4-b152-11ed-b9d9-0800200c9a44', 9),
('rating85-b152-11ed-b9d9-0800200c9a85', 'student8-b150-11ed-b9d9-0800200c9a88', 'subject5-b152-11ed-b9d9-0800200c9a55', 9),
('rating86-b152-11ed-b9d9-0800200c9a86', 'student8-b150-11ed-b9d9-0800200c9a88', 'subject6-b152-11ed-b9d9-0800200c9a66', 10);