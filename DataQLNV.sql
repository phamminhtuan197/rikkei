-- create database
DROP DATABASE IF EXISTS TestingSystem;
CREATE DATABASE TestingSystem;
USE TestingSystem;

-- create table 1: Department
DROP TABLE IF EXISTS Department;
CREATE TABLE Department(
	DepartmentID 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    DepartmentName 			NVARCHAR(30) NOT NULL UNIQUE KEY
);

-- create table 2: Posittion
DROP TABLE IF EXISTS Position;
CREATE TABLE `Position` (
	PositionID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    PositionName			ENUM('Dev','Test','ScrumMaster','PM') NOT NULL UNIQUE KEY
);


-- create table 3: Account
DROP TABLE IF EXISTS `Account`;
CREATE TABLE `Account`(
	AccountID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Email					VARCHAR(50) NOT NULL UNIQUE KEY, -- Cannot update this field
    UserName				VARCHAR(50) NOT NULL UNIQUE KEY, -- Cannot update this field
    FullName				NVARCHAR(50) NOT NULL,
    DepartmentID			TINYINT UNSIGNED NOT NULL,
    PositionID				TINYINT UNSIGNED NOT NULL,
    CreateDate				DATETIME DEFAULT NOW(), -- Cannot update this field
    PathImage VARCHAR(100) UNIQUE KEY,
    `Password` VARCHAR(800),
	`status` TINYINT DEFAULT 0,  -- 0: Not Active, 1: Active
	`Role` 	ENUM('Admin','Manager','User' ) NOT NULL DEFAULT 'User',
    CONSTRAINT fk_DepartmentID FOREIGN KEY(DepartmentID) REFERENCES Department(DepartmentID),
	CONSTRAINT fk_PositionID FOREIGN KEY(PositionID) REFERENCES `Position`(PositionID)
);


/*============================== INSERT DATABASE =======================================*/
/*======================================================================================*/
-- Add data Department
INSERT INTO Department(DepartmentName) 
VALUES
						('Marketing'	),
						('Sale'			),
						('Bảo vệ'		),
						('Nhân sự'		),
						('Kỹ thuật'		),
						('Tài chính'	),
						('Phó giám đốc'	),
						('Giám đốc'		),
						('Thư kí'		),
						('Bán hàng'		);
    
-- Add data position
INSERT INTO Position	(`PositionName`	) 
VALUES 					('Dev'			),
						('Test'			),
                        ('PM'			),
						('ScrumMaster'	);


-- Add data Account
INSERT INTO `Account`( Email							, Username			, FullName				, DepartmentID	, PositionID, CreateDate, `Password`, `status`,`Role`)
VALUES 				('haidang29productions@gmail.com'	, 'dangblack'		,'Dang Nguyen Hai'		, 1				, 1			, '2020-03-05', '$2a$10$BeqYk3.ZXyYSQAMG0GJ7EuYAsD8niqj/2/bO3.Iy1lYX1s1DLG3kO', 1, 'Admin'),
					('account1@gmail.com'				, 'quanganh'		,'Anh Tong Quang'		, 2				, 1			, '2020-03-05', '$2a$10$BeqYk3.ZXyYSQAMG0GJ7EuYAsD8niqj/2/bO3.Iy1lYX1s1DLG3kO', 1, 'Manager'),
                    ('account2@gmail.com'				, 'vanchien'		,'Chien Nguyen Van'		, 3				, 2			, '2020-03-07', '$2a$10$BeqYk3.ZXyYSQAMG0GJ7EuYAsD8niqj/2/bO3.Iy1lYX1s1DLG3kO', 1, 'User'),
                    ('account3@gmail.com'				, 'cocoduongqua'	,'Do Duong'				, 4				, 3			, '2020-03-08', '$2a$10$BeqYk3.ZXyYSQAMG0GJ7EuYAsD8niqj/2/bO3.Iy1lYX1s1DLG3kO', 1, 'User'),
                    ('account4@gmail.com'				, 'doccocaubai'		,'Thang Nguyen Chien'	, 5				, 3			, '2020-03-10', '$2a$10$BeqYk3.ZXyYSQAMG0GJ7EuYAsD8niqj/2/bO3.Iy1lYX1s1DLG3kO', 1, 'User'),
                    ('dapphatchetngay@gmail.com'		, 'khabanh'			,'Kha Ngo Ba'			, 6				, 2			, NOW(), '$2a$10$BeqYk3.ZXyYSQAMG0GJ7EuYAsD8niqj/2/bO3.Iy1lYX1s1DLG3kO', 1, 'User'),
                    ('songcodaoly@gmail.com'			, 'huanhoahong'		,'Huan Bui Xuan'		, 7				, 1			, NOW(), '$2a$10$BeqYk3.ZXyYSQAMG0GJ7EuYAsD8niqj/2/bO3.Iy1lYX1s1DLG3kO', 1, 'User'),
                    ('sontungmtp@gmail.com'				, 'tungnui'			,'Tung Nguyen Thanh'	, 8				, 1			, '2020-04-07', '$2a$10$BeqYk3.ZXyYSQAMG0GJ7EuYAsD8niqj/2/bO3.Iy1lYX1s1DLG3kO', 1, 'User'),
                    ('duongghuu@gmail.com'				, 'duongghuu'		,'Huu Duong Van'		, 9				, 2			, '2020-04-07', '$2a$10$BeqYk3.ZXyYSQAMG0GJ7EuYAsD8niqj/2/bO3.Iy1lYX1s1DLG3kO', 1, 'User'),
                    ('tuanpm@gmail.com'					, 'tuanpm'			,'Pham Minh Tuan'		, 10			, 3			, '2020-04-09', '$2a$10$BeqYk3.ZXyYSQAMG0GJ7EuYAsD8niqj/2/bO3.Iy1lYX1s1DLG3kO', 1, 'User');

SELECT * FROM Department;
SELECT * FROM Position;
SELECT * FROM `Account`;